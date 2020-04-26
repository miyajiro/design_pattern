public class Human {

    public String name;
    public int height = -1;
    public int weight = -1;
    public int age = -1;

    public Human(String name, int height, int weight, int age) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.age = age;
    }
}

public interface Comparator {
    public int compare(Human h1, Human h2);
}

public class AgeComparator implements Comparator {
    public int compare(Human h1, Human h2) {
        if (h1.age > h2.age) {
            return 1;
        } else if (h1.age == h2.age) {
            return 0;
        } else {
            return -1;
        }
    }
}

public class MyClass {
    private Comparator comparator = null;

    public MyClass(Comparator comparator) {
        this.comparator = comparator;
    }

    public int compare(Human h1, Human h2) {
        return comparator.compare(h1, h2);
    }
}
