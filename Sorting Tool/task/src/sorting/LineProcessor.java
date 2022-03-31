package sorting;

public class LineProcessor extends DataProcessor<String> {

    public LineProcessor() {
        super.type = DataType.LINE;
        super.naturalComparator = (l1, l2) -> {
            if (l1.compareToIgnoreCase(l2) == 0) {
                return Integer.compare(l1.length(), l2.length());
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
