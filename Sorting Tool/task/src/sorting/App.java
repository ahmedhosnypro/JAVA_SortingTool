package sorting;

public class App {
    private App() {
    }

    static void sort(String[] args) {
        DataType dataType = DataType.LONG;
        String sortingType = "natural";
        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("-")) {
                if (!args[i].equalsIgnoreCase("-sortingType") && !args[i].equalsIgnoreCase("-dataType")) {
                    System.out.println("\"" + args[i] + "\" is not a valid parameter. It will be skipped.");
                } else {
                    if (args[i].equalsIgnoreCase("-sortingType")) {
                        if (args.length - 1 > i && !(args[i + 1].startsWith("-"))) {
                            sortingType = args[++i];
                        } else {
                            System.out.println("No sorting type defined!");
                            System.exit(0);
                        }
                    } else if (args[i].equalsIgnoreCase("-dataType")) {
                        if (args.length - 1 > i && !(args[i + 1].startsWith("-"))) {
                            dataType = DataType.valueOf(args[++i].toUpperCase());
                        } else {
                            System.out.println("No data type defined!");
                            System.exit(0);
                        }
                    }
                }
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
