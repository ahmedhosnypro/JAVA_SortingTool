package sorting;

import java.util.Optional;

public class StringAnalyzer implements AnalyzeStrategy<String> {
    @Override
    public void analyze(DataProcessor<String> dataProcessor) {
        Optional<String> optionalMax = dataProcessor.getData().stream().max(dataProcessor.getComparator());
        if (optionalMax.isPresent()) {
            dataProcessor.setMax(optionalMax.get());
            dataProcessor.setMaxCount((int) dataProcessor.getData().stream().filter(l -> l.equals(optionalMax.get())).count());
            dataProcessor.setMaxPercent();
        }
    }
}
