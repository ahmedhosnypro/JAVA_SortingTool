package sorting;

public class WordProcessor extends DataProcessor<String> {

    public WordProcessor() {
        super.type = DataType.WORD;
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
            data.add(scanner.next().trim());
        }
    }
}
