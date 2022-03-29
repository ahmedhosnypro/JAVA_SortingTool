package sorting;

public class WordProcessor extends DataProcessor<String> {

    public WordProcessor() {
        super.type = DataType.WORD;
    }

    @Override
    public void readData() {
        while (scanner.hasNext()) {
            data.add(scanner.next().trim());
        }
    }
}
