
class Cassidy extends Id{

    public Cassidy(Emotion emotion, String defaultText) {
        super(emotion, defaultText);
        emotionIsChanged();
        setDialogTree();
    }
    
    public Cassidy(int neutral, int happy, int sad, int disgust, int anger, int fear, int surprise, String defaultText) {
        super(neutral, happy, sad, disgust, anger, fear, surprise, defaultText);
        emotionIsChanged();
        setDialogTree();

    }

    public void setDialogTree() {
        switch(emotionType) {
            case NEUTRAL:
                setNeutralDialogTree();
                break;
            // case HAPPY:
            //     setHappyDialogTree();
            //     break;
            // case SAD:
            //     setSadDialogTree();
            //     break;
            // case DISGUST:
            //     setDisgustDialogTree();
            //     break;
            // case ANGER:
            //     setAngerDialogTree();
            //     break;
            // case FEAR:
            //     setFearDialogTree();
            //     break;
            // case SURPRISE:
            //     setSurpriseDialogTree();
            //     break;
            default :
                setNeutralDialogTree();
                break;
        }
    }

    public void emotionIsChanged() {
        switch(emotion.compareEmotions()) {
            case NEUTRAL:
                System.out.println("Cassidy's emotion is Neutral.");
                emotionType = EmotionType.NEUTRAL;
                break;
            case HAPPY:
                System.out.println("Cassidy's emotion is Happy.");
                emotionType = EmotionType.HAPPY;
                break;
            case SAD:
                System.out.println("Cassidy's emotion is Sad.");
                emotionType = EmotionType.SAD;
                break;
            case DISGUST:
                System.out.println("Cassidy's emotion is Disgust.");
                emotionType = EmotionType.DISGUST;
                break;
            case ANGER:
                System.out.println("Cassidy's emotion is Anger.");
                emotionType = EmotionType.ANGER;
                break;
            case FEAR:
                System.out.println("Cassidy's emotion is Fear.");
                emotionType = EmotionType.FEAR;
                break;
            case SURPRISE:
                System.out.println("Cassidy's emotion is Surprise.");
                emotionType = EmotionType.SURPRISE;
                break;
            default :
                emotionType = EmotionType.NEUTRAL;
                break;
        }
    }

    public void setNeutralDialogTree() {
        ReplyNode answer0 = new ReplyNode("[Neutral 50] All right, then.", null);
        root.bond(new MySelection("0. I've heard enough. Let's move on.", answer0, emotion, EmotionType.NEUTRAL, 0));
        ReplyNode answer1 = new ReplyNode("[Neutral 50] {Teasing} What no music? {Sarcastic} I'll hold the tears 'til I'm gone. ", null);
        root.bond(new MySelection("1. It's time for us to part ways.", answer1, emotion, EmotionType.NEUTRAL, 0));

                ReplyNode answer10 = new ReplyNode("[Neutral 50] All right, then. ", null);
                answer1.bond(new MySelection("0. I've heard enough. Let's move on.", answer10, emotion, EmotionType.NEUTRAL, 0));


                ReplyNode answer11 = new ReplyNode("[Neutral 50] " + randomString("Don't be playing with my heart now, gets me pissed.", 
                                                                                  "You {emph} sure now? All right.", 
                                                                                  "Either shoot or don't, but don't be wishing and washing about it.", 
                                                                                  "{Mutters} You're like a switchblade stuck on flick.", 
                                                                                  "{Told to stay or go} Going to give a lightswitch a run for its money. Click click click.") + " ", null);
                answer1.bond(new MySelection("1. On second thought, stick with me for a little longer.", answer11, emotion, EmotionType.NEUTRAL, 0));

                ReplyNode answer12 = new ReplyNode("[Anger 10] " + randomString("{Slight sass, told to leave} Fine then.", 
                                                                                "{Slight sass, told to leave} I'll get out of your hair, then.") + " ", null);
                answer1.bond(new MySelection("2. Yes, I'm sure.", answer12, emotion, EmotionType.ANGER, 10));

        ReplyNode answer2 = new ReplyNode("[Anger 10]" + "Got no time or answers for you. {Snorts} Ask a drifter in need of a few caps, they'll give you all the answers you need.", null);
        root.bond(new MySelection("2. Wanted to ask some questions about the outpost.", answer2, emotion, EmotionType.ANGER, 10));

        ReplyNode answer3 = new ReplyNode(randomString("{Irritated} Where? Like Vegas? Chewed and spit enough friends out. East? Get put in one of Caesar's little \"camps?\" No thanks.",
                                                       "Head back West? I already know the Big Circle and everyone in it - 'cept now I go back there, ruined.",
                                                       "{Thinking} Never really realized how small the Mojave's getting nowadays, hard to find a place to go to that's worthwhile."), null);
        root.bond(new MySelection("3. There's other places to go.", answer3, emotion, EmotionType.ANGER, 10));
    }
}