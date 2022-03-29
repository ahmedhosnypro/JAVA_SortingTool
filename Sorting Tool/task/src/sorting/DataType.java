package sorting;

public enum DataType {
    LONG("numbers", "greatest number"),
    LINE("lines", "longest line"),
    WORD("words", "longest word");

    private final String totalToPrint;
    private final String maxToPrint;

    DataType(String totalToPrint, String maxToPrint) {
        this.totalToPrint = totalToPrint;
        this.maxToPrint = maxToPrint;
    }

    public String getTotalToPrint() {
        return totalToPrint;
    }

    public String getMaxToPrint() {
        return maxToPrint;
    }
}
