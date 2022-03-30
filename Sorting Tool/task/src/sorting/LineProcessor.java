package sorting;

public class LineProcessor extends DataProcessor<String> {

    public LineProcessor() {
        super.type = DataType.LINE;
        super.comparator = (l1, l2) -> {
            if (l1.length() > l2.length()) {
                return 1;
            } else if (l1.length() < l2.length()) {
                return -1;
            } else {
                return l1.compareToIgnoreCase(l2);
            }
        };
    }

    @Override
    public void readData() {
        while (scanner.hasNext()) {
            data.add(scanner.nextLine().trim());
        }
    }
}
