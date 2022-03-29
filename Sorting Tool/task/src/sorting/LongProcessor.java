package sorting;

public class LongProcessor extends DataProcessor<Long> {

    public LongProcessor() {
        super.type = DataType.LONG;
    }

    @Override
    public void readData() {
        while (scanner.hasNext()) {
            data.add(Long.parseLong(scanner.next().trim()));
        }
    }

    @Override
    public DataType getType() {
        return type;
    }
}
