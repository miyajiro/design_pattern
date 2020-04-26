class Taro {
    public void enjoyWithAllClassmate() {
        System.out.println("みんなで楽しむ");
    }
}

interface Chairperson {
    public void organizeClass();
}

class NewTaro extends Taro implements Chairperson {
    public void organizeClass() {
        enjoyWithAllClassmate();
    }
}

public class Hanako implements Chairperson {
    private Taro taro;

    public Hanako() {
        taro = new Taro();
    }

    public void organizeClass() {
        taro.enjoyWithAllClassmate();
    }
}

public class Teacher {
    public static void main(String args[]) {
        Chairperson chairperson = new Hanako();
        chairperson.organizeClass();
    }
}

public class Main {
    public static void main(String args[]) {

    }
}