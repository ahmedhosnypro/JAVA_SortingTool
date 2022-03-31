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
    T max;
    int maxCount;
    int maxPercent;


    abstract void readData();

    void sort(String sortingType) {
        switch (sortingType) {
            case "natural" -> naturalSort();
            case "byCount" -> createCountSortedDataMap();
        }
    }

    void naturalSort() {
        naturalSortedData = data.stream()
                .sorted(naturalComparator)
                .collect(Collectors.toCollection(ArrayList::new));
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

    public ArrayList<T> getData() {
        return data;
    }

    int getSize() {
        return data.size();
    }

    public Comparator<T> getNaturalComparator() {
        return naturalComparator;
    }

    public Comparator<T> getCounterComparator() {
        return counterComparator;
    }

    public DataType getType() {
        return type;
    }

    public void setMaxPercent() {
        maxPercent = (int) (((double) maxCount / (double) getSize()) * 100);
    }

    void analyzeMaxElement() {
        naturalSort();
        max = naturalSortedData.get(naturalSortedData.size() - 1);
        maxCount = (int) getData().stream().filter(n -> Objects.equals(n, max)).count();
        setMaxPercent();
    }

    void printMaxAnalysis() {
        System.out.println("Total " + type.getTotalToPrint() + ": " + data.size() + ".\n"
                + "The " + type.getMaxToPrint() + ":"
                + type.getSeparator() + max + type.getSeparator()
                + "(" + maxCount + " time(s), " + maxPercent + "%).");
    }

    void printSortAnalysis(String sortingType) {
        switch (sortingType) {
            case "natural" -> {
                naturalSort();
                System.out.print("Total " + type.getTotalToPrint() + ": " + data.size() + "\n"
                        + "Sorted data:" + getNaturalSortedDataAsString());
            }
            case "byCount" -> {
                naturalSort();
                createCountSortedDataMap();
                System.out.print("Total " + type.getTotalToPrint() + ": " + data.size() + "\n"
                        + getCountSortedDataMapAsString());
            }
        }
    }

    public String getDataAsString() {
        StringBuilder out = new StringBuilder();
        for (var d : data) {
            out.append(type.getSeparator()).append(d).append(type.getSeparator());
        }
        return out.toString();
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
            out.append(entry.getKey())
                    .append(": ")
                    .append(entry.getValue())
                    .append(" time(s), ")
                    .append((int) (((double) entry.getValue() / (double) getSize()) * 100))
                    .append("%\n");
        }
        return out.toString();
    }
}
