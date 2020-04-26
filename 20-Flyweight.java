import java.util.HashMap;
import java.util.Map;

/**
 * 人文字を管理するクラス。 Singleton とする。
 */
public class HumanLetterFactory {
    /**
     * 人文字のマップ
     */
    Map<String, HumanLetter> map = new HashMap<String, HumanLetter>();

    /**
     * Singleton の生成
     */
    private static HumanLetterFactory singleton = new HumanLetterFactory();

    /**
     * Singleton パターン
     */
    private HumanLetterFactory() {
    }

    /**
     * インスタンスを取得するメソッド 唯一のインスタンスが返される。
     * 
     * @return singleton
     */
    public HumanLetterFactory getInstance() {
        return singleton;
    }

    /**
     * 人文字を取得するメソッド。 すでに持っているものであれば、map から返す。 map に持っていないものは生成して map
     * への登録を行った後に返り値として返す。
     *
     * @param letter
     * @return humanLetter
     */
    public synchronized HumanLetter getHumanLetter(String letter) {
        HumanLetter humanLetter = map.get(letter);
        if (humanLetter == null) {
            humanLetter = new HumanLetter(letter);
            map.put(letter, humanLetter);
        }
        return humanLetter;
    }

}

/**
 * 人文字を作成して出力するクラス。
 */
public class Main {
    /**
     * 人文字を作成するメイン関数
     * 
     * @param args
     */
    public static void main(String args[]) {
        HumanLetterFactory humanLetterFactory = HumanLetterFactory().getInstance();
        takeAPhoto(humanLetterFactory.getHumanLetter("あ"));
        takeAPhoto(humanLetterFactory.getHumanLetter("い"));
        takeAPhoto(humanLetterFactory.getHumanLetter("は"));
        takeAPhoto(humanLetterFactory.getHumanLetter("あ"));
        takeAPhoto(humanLetterFactory.getHumanLetter("い"));
        takeAPhoto(humanLetterFactory.getHumanLetter("よ"));
        takeAPhoto(humanLetterFactory.getHumanLetter("り"));
        takeAPhoto(humanLetterFactory.getHumanLetter("も"));
        takeAPhoto(humanLetterFactory.getHumanLetter("あ"));
        takeAPhoto(humanLetterFactory.getHumanLetter("お"));
        takeAPhoto(humanLetterFactory.getHumanLetter("い"));
    }

    /**
     * 写真を撮るメソッド
     * 
     * @param letter
     */
    private static void takeAPhoto(HumanLetter letter) {
        System.out.println(letter.getLetter());
    }

}