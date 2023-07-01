import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Id {
    ReplyNode root;
    ReplyNode currentNode;
    Emotion emotion;
    EmotionType emotionType;

    public void talk() {
        Scanner scanner = new Scanner(System.in);
        emotion.showStatus();
        currentNode.talk();

        while (true) {
            if (currentNode.isMySelectionListEmpty()) { // 더 이상 선택지가 없을 때 루트로 돌아갑니다.
                currentNode = root;
                continue;
            } 
            System.out.println("Please input the number of your selection.");
            System.out.println("==========================================");
            currentNode.showMySelectionList(); // 선택지를 보여줍니다.
            System.out.println("==========================================");

            String num = scanner.nextLine();

            if (currentNode.isMySelectionListOutOfRange(num)) { // 키가 선택지의 범위를 벗어났을 때
                System.out.println("\n\nERROR : There is no conversation for the keyword.\n\n");
                continue;
            }

            currentNode.setSelectionNum(num);
            currentNode.show();
            currentNode = currentNode.getNextReply(); // 다음 대화로 넘어갑니다.

            if (num.equals("0")) {
                emotion.showStatus();
                break;
            }
        }
    }

    Id (int neutral, int happy, int sad, int disgust, int anger, int fear, int surprise, String defaultText) {
        emotion = new Emotion(neutral, happy, sad, disgust, anger, fear, surprise);
        root = new ReplyNode(defaultText, null);
        currentNode = root;
    }
    Id (Emotion emotion, String defaultText) {
        this.emotion = emotion;
        root = new ReplyNode(defaultText, null);
        currentNode = root;
    }
    public String randomString (String ... strs) {
        List<String> list = new ArrayList<String>();
        for (String str : strs) {
            list.add(str);
        }
        int random = (int) (Math.random() * list.size()); 
        return list.get(random);
    }
    public abstract void emotionIsChanged();

}
