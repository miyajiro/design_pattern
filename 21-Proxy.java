//先生インターフェース
public interface Teacher {
    public void question1();

    public void question2();

    public void question3();
}

// 山田先生クラス(本人オブジェクト)
public class Yamada implements Teacher {

    public void question1() {
        System.out.print("～～解答1～～");
    }

    public void question2() {
        System.out.print("～～解答2～～");
    }

    public void question3() {
        System.out.print("～～解答3～～");
    }

}

// 藤原先生クラス(代理人オブジェクト)
public class Fujiwara implements Teacher {
    private Teacher yamada = new Yamada();

    public void question1() {
        System.out.println("それは「～～解答1～～」です。");
    }

    public void question2() {
        System.out.println("それは「～～解答2～～」です。");
    }

    public void question3() {
        Calendar now = Calendar.getInstance();
        if (Calendar.AM == now.get(Calendar.AM_PM)) {
            // 午前中は山田先生に聞く
            System.out.print("答えは「");
            yamada.question3();
            System.out.println("」となります。");
        } else {
            // 午後からは返答を明日にする
            System.out.println("明日、返答します。");
        }
    }

}

// 生徒クラス(クライアント)
public class Student {

    public static void main(String[] args) {
        Teacher fujiwara = new Fujiwara();

        // 質問1
        fujiwara.question1();
        // 質問2
        fujiwara.question2();
        // 質問3
        fujiwara.question3();

    }
}