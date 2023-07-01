public class Emotion {
    private EmotionType emotionType;
    private int neutral;
    private int happy;
    private int sad;
    private int disgust;
    private int anger;
    private int fear;
    private int surprise;

    Emotion (int neutral, int happy, int sad, int disgust, int anger, int fear, int surprise) {
        this.neutral = neutral;
        this.happy = happy;
        this.sad = sad;
        this.disgust = disgust;
        this.anger = anger;
        this.fear = fear;
        this.surprise = surprise;
    }
    public int getNeutral() {
        return neutral;
    }
    public int getHappy() {
        return happy;
    }
    public int getSad() {
        return sad;
    }
    public int getDisgust() {
        return disgust;
    }
    public int getAnger() {
        return anger;
    }
    public int getFear() {
        return fear;
    }
    public int getSurprise() {
        return surprise;
    }
    public void showStatus() {
        System.out.println("neutral: " + neutral);
        System.out.println("happy: " + happy);
        System.out.println("sad: " + sad);
        System.out.println("disgust: " + disgust);
        System.out.println("anger: " + anger);
        System.out.println("fear: " + fear);
        System.out.println("surprise: " + surprise);
    }
    public void applyEffect(EmotionType emotionType, int effectAmount) {
        switch (emotionType) {
            case NEUTRAL:
                neutral += effectAmount;
                break;
            case HAPPY:
                happy += effectAmount;
                break;
            case SAD:
                sad += effectAmount;
                break;
            case DISGUST:
                disgust += effectAmount;
                break;
            case ANGER:
                anger += effectAmount;
                break;
            case FEAR:
                fear += effectAmount;
                break;
            case SURPRISE:
                surprise += effectAmount;
                break;
        }
    }
    // which emotion is the highest?
    public EmotionType compareEmotions() {
        if (happy > sad && happy > disgust && happy > anger && happy > fear && happy > surprise) {
            emotionType = EmotionType.HAPPY;
            return EmotionType.HAPPY;
        } else if (sad > happy && sad > disgust && sad > anger && sad > fear && sad > surprise) {
            emotionType = EmotionType.SAD;
            return EmotionType.SAD;
        } else if (disgust > happy && disgust > sad && disgust > anger && disgust > fear && disgust > surprise) {
            emotionType = EmotionType.DISGUST;
            return EmotionType.DISGUST;
        } else if (anger > happy && anger > sad && anger > disgust && anger > fear && anger > surprise) {
            emotionType = EmotionType.ANGER;
            return EmotionType.ANGER;
        } else if (fear > happy && fear > sad && fear > disgust && fear > anger && fear > surprise) {
            emotionType = EmotionType.FEAR;
            return EmotionType.FEAR;
        } else if (surprise > happy && surprise > sad && surprise > disgust && surprise > anger && surprise > fear) {
            emotionType = EmotionType.SURPRISE;
            return EmotionType.SURPRISE;
        } else {
            emotionType = EmotionType.NEUTRAL;
            return EmotionType.NEUTRAL;
        }
    }
}

enum EmotionType {
    NEUTRAL, HAPPY, SAD, DISGUST, ANGER, FEAR, SURPRISE
}
