package sorting;

public enum DataType {
    LONG("numbers", "greatest number", " "),
    LINE("lines", "longest line", "\n"),
    WORD("words", "longest word", " ");

    private final String totalToPrint;
    private final String maxToPrint;
    private final String separator;

    DataType(String totalToPrint, String maxToPrint, String separator) {
        this.totalToPrint = totalToPrint;
        this.maxToPrint = maxToPrint;
        this.separator = separator;
    }

    public String getTotalToPrint() {
        return totalToPrint;
    }

    public String getMaxToPrint() {
        return maxToPrint;
    }

    public String getSeparator() {
        return separator;
    }
}
