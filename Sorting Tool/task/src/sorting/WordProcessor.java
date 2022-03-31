package sorting;

public class WordProcessor extends DataProcessor<String> {

    public WordProcessor() {
        super.type = DataType.WORD;
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
            data.add(scanner.next().trim());
        }
    }
}
