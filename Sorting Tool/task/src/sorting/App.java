package sorting;

public class App {
    private App() {
    }

    static void start(String[] args) {
        sort(args);
//        if (args.length == 0) {
//            processData(DataType.WORD);
//        } else {
//            for (var arg : args) {
//                if (arg.equalsIgnoreCase("-sortIntegers")) {
//                    sortIntegers();
//                    return;
//                }
//            }
//
//        }
    }

    private static void sortIntegers() {
        DataProcessor<Long> dataProcessor = new LongProcessor();
        dataProcessor.readData();
        dataProcessor.analyzeMaxElement();
        System.out.print("Total " + dataProcessor.getType().getTotalToPrint() + ": " + dataProcessor.getSize() + ".\n" + "Sorted data: ");
        dataProcessor.getData().forEach(d -> System.out.print(d + " "));
    }

    private static void processData(DataType dataType) {
        switch (dataType) {
            case LONG -> {
                DataProcessor<Long> dataProcessor = new LongProcessor();
                dataProcessor.readData();
                dataProcessor.analyzeMaxElement();
                dataProcessor.printMaxAnalysis();
            }
            case LINE -> {
                DataProcessor<String> dataProcessor = new LineProcessor();
                dataProcessor.readData();
                dataProcessor.analyzeMaxElement();
                dataProcessor.printMaxAnalysis();
            }
            case WORD -> {
                DataProcessor<String> dataProcessor = new WordProcessor();
                dataProcessor.readData();
                dataProcessor.analyzeMaxElement();
                dataProcessor.printMaxAnalysis();
            }
        }
    }

    private static void sort(String[] args) {
        DataType dataType = DataType.LONG;
        String sortingType = "natural";
        int readStep = 2;
        for (int i = 0; i < args.length; i += readStep) {
            if (args[i].equalsIgnoreCase("-sortingType") && (args.length - 1 > i && !(args[i + 1].startsWith("-")))) {
                sortingType = args[i + 1];
            } else if (args[i].equalsIgnoreCase("-sortingType") && ((args.length - 1 == i) || (args[i + 1].startsWith("-")))) {
                readStep = 1;
            }
            if (args[i].equalsIgnoreCase("-dataType") && (args.length - 1 > i && !(args[i + 1].startsWith("-")))) {
                dataType = DataType.valueOf(args[i + 1].toUpperCase());
            }
        }
        sortUtility(dataType, sortingType);
    }

    private static void sortUtility(DataType dataType, String sortingType) {
        switch (dataType) {
            case LONG -> {
                DataProcessor<Long> dataProcessor = new LongProcessor();
                dataProcessor.readData();
                dataProcessor.printSortAnalysis(sortingType);
                System.exit(0);
            }
            case LINE -> {
                DataProcessor<String> dataProcessor = new LineProcessor();
                dataProcessor.readData();
                dataProcessor.printSortAnalysis(sortingType);
                System.exit(0);
            }
            case WORD -> {
                DataProcessor<String> dataProcessor = new WordProcessor();
                dataProcessor.readData();
                dataProcessor.printSortAnalysis(sortingType);
                System.exit(0);
            }
        }
    }
}
