
//先生クラス
import java.util.List;

public abstract class Teacher {
    List students = null;

    public abstract void visit(Home studentHome);

    public abstract void visit(TanakaHome studentHome);

    public abstract void visit(SuzukiHome studentHome);

    public List getStudentList() {
        return students;
    }

}

public class RookieTeacher extends Teacher {
    List students = null;

    public RookieTeacher(List students) {
        this.students = students;
    }

    public void visit(Home studentHome) {
        System.out.println("こんにちは");
    }

    public void visit(TanakaHome studentHome) {
        studentHome.praisedChild();
    }

    public void visit(SuzukiHome studentHome) {
        studentHome.reprovedChild();
    }
}

// 家庭クラス
public abstract class Home {
    public abstract Object praisedChild();

    public abstract Object reprovedChild();
}

// 受け入れインタフェース
public interface TeacherAcceptor {
    public void accept(Teacher teacher);
}

// 鈴木さんの家庭
public class SuzukiHome extends Home implements TeacherAcceptor {
    public Object praisedChild() {
        System.out.println("あら、先生ったらご冗談を");
        return new Tea();
    }

    public Object reprovedChild() {
        System.out.println("うちの子に限ってそんなことは・・・。");

        return null;
    }

    /**
     * 訪問者を受け入れるメソッド
     */
    public void accept(Teacher teacher) {
        teacher.visit(this);
    }
}