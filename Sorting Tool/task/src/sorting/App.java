package sorting;

public class App {
    private App() {
    }

    static void start(String[] args) {
        if (args.length == 0) {
            processWords();
        } else {
            for (var arg : args) {
                if (arg.equalsIgnoreCase("-sortIntegers")) {
                    sortIntegers();
                    return;
                }
            }
            if (args[0].equalsIgnoreCase("-dataType")) {
                String dataType = args[1];
                switch (dataType) {
                    case "long" -> processLongs();
                    case "line" -> processLine();
                    case "word" -> processWords();
                }
            }
        }
    }

    private static void processLongs() {
        DataProcessor<Long> dataProcessor = new LongProcessor();
        Analyzer<Long> analyzer = new Analyzer<>();
        dataProcessor.readData();
        analyzer.setStrategy(new LongAnalyzer());
        analyzer.analyze(dataProcessor);
        System.out.println("Total " + dataProcessor.getType().getTotalToPrint() + ": " + dataProcessor.getSize() + ".\n"
                + "The " + dataProcessor.getType().getMaxToPrint() + ": " + dataProcessor.getMax()
                + " (" + dataProcessor.getMaxCount() + " time(s), " + dataProcessor.getMaxPercent() + "%).");
    }

    private static void sortIntegers() {
        DataProcessor<Long> dataProcessor = new LongProcessor();
        dataProcessor.readData();
        dataProcessor.sortData();
        System.out.print("Total " + dataProcessor.getType().getTotalToPrint() + ": " + dataProcessor.getSize() + ".\n"
                + "Sorted data: ");
        dataProcessor.getData().forEach(d -> System.out.print(d + " "));
    }

    private static void processLine() {
        DataProcessor<String> dataProcessor = new LineProcessor();
        Analyzer<String> analyzer = new Analyzer<>();
        dataProcessor.readData();
        analyzer.setStrategy(new StringAnalyzer());
        analyzer.analyze(dataProcessor);
        System.out.println("Total " + dataProcessor.getType().getTotalToPrint() + ": " + dataProcessor.getSize() + ".\n"
                + "The " + dataProcessor.getType().getMaxToPrint() + ":\n" + dataProcessor.getMax() + "\n"
                + "(" + dataProcessor.getMaxCount() + " time(s), " + dataProcessor.getMaxPercent() + "%).");
    }

    private static void processWords() {
        DataProcessor<String> dataProcessor = new WordProcessor();
        Analyzer<String> analyzer = new Analyzer<>();
        dataProcessor.readData();
        analyzer.setStrategy(new StringAnalyzer());
        analyzer.analyze(dataProcessor);
        System.out.println("Total " + dataProcessor.getType().getTotalToPrint() + ": " + dataProcessor.getSize() + ".\n"
                + "The " + dataProcessor.getType().getMaxToPrint() + ": " + dataProcessor.getMax()
                + " (" + dataProcessor.getMaxCount() + " time(s), " + dataProcessor.getMaxPercent() + "%).");
    }
}
