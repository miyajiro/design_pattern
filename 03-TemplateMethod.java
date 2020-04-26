abstract class WoodCutPrint {
    public abstract void draw(Cuttable hanzai);

    public abstract void cut(Cuttable hanzai);

    public abstract void print(Cuttable hanzai);

    public void createWoodCutPrint() {
        Wood hanzai = new Wood(); // Wood クラスは、Cuttable インタフェースを実装している
        draw(hanzai);
        cut(hanzai);
        print(hanzai);
    }
}

class TanakasWoodCutPrint extends WoodCutPrint {
    public void draw(Cuttable hanzai) {
        System.out.println("hanzai にマジックを使って大好きな女の子の絵を描く");
    }

    public void cut(Cuttable hanzai) {
        System.out.println("彫刻刀を使って細部まで丁寧に hanzai を彫る");
    }

    public void print(Cuttable hanzai) {
        System.out.println("版画インクと馬簾を使って豪快にプリントする");
    }
}

public class Main {
    public static void main(String args[]) {

    }
}