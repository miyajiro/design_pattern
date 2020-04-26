public abstract class Responsible {
    private Responsible next = null;
    private String responsiblePerson = null;

    public Responsible(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public Responsible setNext(Responsible next) {
        this.next = next;
        return next;
    }

    public final void putQuestion(Question question) {
        if (beAbleToJudge(question)) {
            judge(question);
        } else if (next != null) {
            next.putQuestion(question);
        } else {
            System.out.println("誰にも判断できませんでした。やってみなさい。");
        }
    }

    protected abstract boolean beAbleToJudge(Question question);

    protected abstract void judge(Question question);
}

public class ClassTeacher extends Responsible {
    private Level responsibleLevel = new Level(2);

    public ClassTeacher(String responsiblePerson) {
        super(responsiblePerson);
    }

    protected boolean beAbleToJudge(Question question) {
        if (question.level.lessThan(responsibleLevel)) {
            return true;
        }
        return false;
    }

    protected void judge(Question question) {
        // ・・・・
    }
}

public class Main {
    public static void main(String args[]) {
        Responsible nakagawa = new Student("中川雄介");
        Responsible rookie = new ClassTeacher("新人先生");
        Responsible veteran = new ChiefTeacher("ベテラン先生");
        Responsible staffMeeting = new StaffMeeting("職員会議");
        nakagawa.setNext(rookie).setNext(veteran).setNext(staffMeeting);
        nakagawa.judge(new Question("おやつはいくらまで？", new Level(1)));
        nakagawa.judge(new Question("携帯電話持って行ってよい？", new Level(3)));
    }
}