public class MySelection {
    private String text;
    private ReplyNode nextReply;
    protected Emotion emotion;
    EmotionType emotionType;
    int effectAmount;

    public MySelection(String text, ReplyNode nextReply, Emotion emotion, EmotionType emotionType, int effectAmount) {
        this.text = text;
        this.nextReply = nextReply;
        this.emotion = emotion;
        this.emotionType = emotionType;
        this.effectAmount = effectAmount;
    }
    public void show() {
        System.out.println(text);
    }
    public ReplyNode getNextReply() {
        return nextReply;
    }
    public String toString() {
        return text;
    }
    public void applyEffect() {
        emotion.applyEffect(emotionType, effectAmount);
    }
}