class Student {
    private String name;
    private int sex; // 男の子:1 女の子:2

    public Student(String name, int sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public int getSex() {
        return sex;
    }
}

class StudentList {
    protected Student[] students;
    private int last = 0;

    public StudentList() {
    }

    public StudentList(int studentCount) {
        this.students = new Student[studentCount];
    }

    public void add(Student student) {
        students[last] = student;
        last++;
    }

    public Student getStudentAt(int index) {
        return students[index];
    }

    public int getLastNum() {
        return last;
    }
}

abstract class Teacher {
    protected StudentList studentList;

    public abstract void createStudentList();

    public abstract void callStudents();
}

class MyTeacher extends Tescher {
    private StudentList studentList;

    @Override
    public void createStudentList() {
        studentList = new StudentList(5);
        studentList.add(new Student("赤井亮太", 1));
        studentList.add(new Student("赤羽里美", 2));
        studentList.add(new Student("岡田美央", 2));
        studentList.add(new Student("西森俊介", 1));
        studentList.add(new Student("中ノ森玲菜", 2));
    }

    @Override
    public void callStudents() {
        Iterator itr = studentList.iterator();
        while (itr.hasNext()) {
            System.out.println(((Student) itr.next()).getName());
        }
    }
}

interface Aggregate {
    public Iterator iterator();
}

public interface Iterator {
    public boolean hasNext();

    public Object next();
}

class MyStudentList extends StudentList implements Aggregate {
    public MyStudentList() {
        super();
    }

    public MyStudentList(int studentCount) {
        super(studentCount);
    }

    public Iterator iterator() {
        return new MyStudentListIterator(this);
    }
}

class MyStudentListIterator implements Iterator {
    private MyStudentList myStudentList;
    private int index;

    public MyStudentListIterator(MyStudentList list) {
        this.myStudentList = list;
        this.index = 0;
    }

    public boolean hasNext() {
        if (myStudentList.getLastNum() > index) {
            return true;
        } else {
            return false;
        }
    }

    public Student next() {
        Student s = myStudentList.getStudentAt(index);
        index++;
        return s;
    }
}

public class Main {
    public static void main(String args[]) {
        Teacher you = new MyTeacher();
        you.createStudentList();
        you.callStudents();
    }
}
