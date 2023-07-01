import java.util.ArrayList;

public class ReplyNode {
    private String text;
    private int selectionNum;
    private ReplyNode nextReply;
    private ArrayList<MySelection> mySelectionList = new ArrayList<MySelection>();

    public ReplyNode(String text, ReplyNode nextReply) {
        this.text = text;
        this.nextReply = nextReply;
    }
    public void bond(MySelection selection) {
        mySelectionList.add(selection);
    }
    public void setSelectionNum(String num) {
        this.selectionNum = Integer.parseInt(num);
    }
    public MySelection findMySelection() {
        return mySelectionList.get(selectionNum);
    }
    public void talk() {
        System.out.println(text);
    }
    public boolean isMySelectionListEmpty() {
        return mySelectionList.isEmpty();
    }
    public boolean isMySelectionListOutOfRange(String num) {
        int index = Integer.parseInt(num);
        return index >= mySelectionList.size();
    }
    public void showMySelectionList() { // 선택지를 보여줍니다.
        for (int i = 0; i < mySelectionList.size(); i++) {
            System.out.println(mySelectionList.get(i));
        }
    }
    public ReplyNode getNextReply() {
        return nextReply;
    }

    public void show() {

        MySelection mySelection = findMySelection();
        System.out.print("player : ");
        mySelection.show(); // 자신의 선택을 보여줍니다.
        mySelection.applyEffect(); // 선택이 가지고있는 효과를 적용합니다.
        nextReply = mySelection.getNextReply();
        System.out.println("");
        System.out.print("=> ");
        nextReply.talk(); // 선택에 대한 응답을 보여줍니다.

    }
}

