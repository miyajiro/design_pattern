public class Yumichan {
    /** 通常の由実ちゃんを表す */
    private static final int STATE_ORDINARY = 0;

    /** 機嫌の悪い由実ちゃんを表す */
    private static final int STATE_IN_BAD_MOOD = 1;

    /** 由実ちゃんの状態を表すプロパティ */
    private int state = -1;

    /**
     * 由実ちゃんの状態を変更するメソッド
     * 
     * @param state
     */
    public void changeState(int state) {
        this.state = state;
    }

    /**
     * 朝のあいさつを返すメソッド
     * 
     * @return
     */
    public String morningGreet() {
        if (state == STATE_ORDINARY) {
            return "おっす!";
        } else if (state == STATE_IN_BAD_MOOD) {
            return "おお";
        } else {
            return "・・・";
        }
    }

    /**
     * 寒いときの防寒具を取得するメソッド
     * 
     * @return
     */
    public String getProtectionForCold() {
        if (state == STATE_ORDINARY) {
            return "走る";
        } else if (state == STATE_IN_BAD_MOOD) {
            return "ももひきをはく";
        } else {
            return "・・・";
        }
    }
}

public class StatePatternYumichan {

    /** 由実ちゃんの状態を表すプロパティ */
    private State state = null;

    /**
     * 由実ちゃんの状態を変更するメソッド
     * 
     * @param state
     */
    private void changeState(State state) {
        this.state = state;
    }

    /**
     * 朝のあいさつを返すメソッド
     * 
     * @return
     */
    public String morningGreet() {
        return this.state.morningGreet();
    }

    /**
     * 寒いときの対策を取得するメソッド
     * 
     * @return
     */
    public String getProtectionForCold() {
        return this.state.getProtectionForCold();
    }
}

/**
 * 由実ちゃんの状態を表すクラスが実装すべきインタフェース
 */

interface State {
    /**
     * 朝のあいさつを返すメソッドを定義する
     */
    public String morningGreet();

    /**
     * 寒いときの対策を返すメソッドを定義する
     */
    public String getProtectionForCold();
}

class BadMoodState implements State {
    /**
     * 朝のあいさつです。機嫌の悪いときは、ぶっきらぼうに応えます。
     */
    public String morningGreet() {
        return "おお";
    }

    /**
     * 冬の防寒方法です。機嫌の悪いときはももひきをはきます。
     */
    public String getProtectionForCold() {
        return "ももひき";
    }
}

class OrdinaryState implements State {
    /**
     * 朝のあいさつです。通常は、男らしく応えます。
     */
    public String morningGreet() {
        return "おっす！";
    }

    /**
     * 冬の防寒方法です。走るようです。
     */
    public String getProtectionForCold() {
        return "走る";
    }
}