package sorting;

import java.util.*;
import java.util.stream.Collectors;

public abstract class DataProcessor<T> {

    static final Scanner scanner = new Scanner(System.in);
    final ArrayList<T> data = new ArrayList<>();
    private ArrayList<T> naturalSortedData;
    Comparator<T> naturalComparator;
    private final Comparator<T> counterComparator = (d1, d2) -> {
        long d1Count = data.stream().filter(d -> d.equals(d1)).count();
        long d2Count = data.stream().filter(d -> d.equals(d2)).count();
        if (d1Count > d2Count) {
            return 1;
        } else if (d1Count < d2Count) {
            return -1;
        } else {
            return naturalComparator.compare(d1, d2);
        }
    };
    TreeMap<T, Integer> countSortedDataMap = new TreeMap<>(counterComparator);
    DataType type;

    abstract void readData();

    void naturalSort() {
        naturalSortedData = data.stream().sorted(naturalComparator).collect(Collectors.toCollection(ArrayList::new));
    }

    void createCountSortedDataMap() {
        for (var d : naturalSortedData) {
            if (countSortedDataMap.containsKey(d)) {
                countSortedDataMap.replace(d, countSortedDataMap.get(d) + 1);
            } else {
                countSortedDataMap.put(d, 1);
            }
        }
    }

    int getSize() {
        return data.size();
    }

    void printSortAnalysis(String sortingType) {
        switch (sortingType) {
            case "natural" -> {
                naturalSort();
                System.out.print("Total " + type.getTotalToPrint() + ": " + data.size() + "\n" + "Sorted data:" + getNaturalSortedDataAsString());
            }
            case "byCount" -> {
                naturalSort();
                createCountSortedDataMap();
                System.out.print("Total " + type.getTotalToPrint() + ": " + data.size() + "\n" + getCountSortedDataMapAsString());
            }
        }
    }

    public String getNaturalSortedDataAsString() {
        StringBuilder out = new StringBuilder();
        for (var d : naturalSortedData) {
            out.append(type.getSeparator()).append(d).append(type.getSeparator());
        }
        return out.toString();
    }

    public String getCountSortedDataMapAsString() {
        StringBuilder out = new StringBuilder();
        for (var entry : countSortedDataMap.entrySet()) {
            out.append(entry.getKey()).append(": ").append(entry.getValue()).append(" time(s), ").append((int) (((double) entry.getValue() / (double) getSize()) * 100)).append("%\n");
        }
        return out.toString();
    }
}
