package sorting;

public class LongProcessor extends DataProcessor<Long> {

    public LongProcessor() {
        super.type = DataType.LONG;
        super.naturalComparator = Long::compareTo;
    }

    @Override
    public void readData() {
        while (scanner.hasNext()) {
            String input = "";
            try {
                input = scanner.next().trim();
                data.add(Long.parseLong(input));
            } catch (Exception ignored) {
                System.out.println("\"" + input + "\" is not a long. It will be skipped.");
            }
        }
    }
}
