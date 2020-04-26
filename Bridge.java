public class Sorter {
    private SortImple sortImple;

    public Sorter(SortImple sortImple) {
        this.sortImple = sortImple;
    }

    public void sort(Object obj[]) {
        sortImple.sort(obj);
    }
}

public abstract class SortImple {
    public abstract void sort(Object obj[]);
}

public class QuickSorter extends SortImple {
    public void sort(Object obj[]) {
        // クイックソートで obj[] をソートする
        // ...
    }
}

public class BubbleSorter extends SortImple {
    public void sort(Object obj[]) {
        // バブルソートで obj[] をソートする
        // ...
    }
}

public class TimerSorter extends Sorter {
    public TimerSorter(SortImple sortImple) {
        super(sortImple);
    }

    public void timerSort(Object obj[]) {
        long start = System.currentTimeMillis();
        sort(obj);
        long end = System.currentTimeMillis();
        System.out.println("time:" + (end - start));
    }
}