package sorting;

public class LineProcessor extends DataProcessor<String> {

    public LineProcessor() {
        super.type = DataType.LINE;
    }

    @Override
    public void readData() {
        while (scanner.hasNext()) {
            data.add(scanner.nextLine().trim());
        }
    }
}
