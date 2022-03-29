package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class DataProcessor<T> {

    static final Scanner scanner = new Scanner(System.in);
    ArrayList<T> data = new ArrayList<>();
    DataType type;
    T max;
    int maxCount;
    int maxPercent;

    abstract void readData();

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

    public void setMax(T max) {
        this.max = max;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public void setMaxPercent() {
        maxPercent = (int) (((double) maxCount / (double) getSize()) *100);
    }
}
