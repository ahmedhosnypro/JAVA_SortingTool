package sorting;

import java.util.*;

public abstract class DataProcessor<T> {

    static final Scanner scanner = new Scanner(System.in);
    ArrayList<T> data = new ArrayList<>();
    DataType type;
    T max;
    int maxCount;
    int maxPercent;
    Comparator<T> comparator;

    abstract void readData();

    void sortData() {
        if (Objects.nonNull(comparator)){
            data.sort(comparator);
        }
    }

    int getSize() {
        return data.size();
    }

    public List<T> getData() {
        return data;
    }

    public T getMax() {
        return max;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public DataType getType() {
        return type;
    }

    public int getMaxPercent() {
        return maxPercent;
    }

    public Comparator<T> getComparator() {
        return comparator;
    }

    public void setMax(T max) {
        this.max = max;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public void setMaxPercent() {
        maxPercent = (int) (((double) maxCount / (double) getSize()) * 100);
    }
}
