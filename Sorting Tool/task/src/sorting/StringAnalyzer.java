package sorting;

import java.util.Optional;

public class StringAnalyzer implements AnalyzeStrategy<String> {
    @Override
    public void analyze(DataProcessor<String> dataProcessor) {
        Optional<String> optionalMax = dataProcessor.getData().stream().max((l1, l2) -> {
            if (l1.length() > l2.length()) {
                return 1;
            } else if (l1.length() < l2.length()) {
                return -1;
            } else {
                return l1.compareToIgnoreCase(l2);
            }
        });
        if (optionalMax.isPresent()) {
            dataProcessor.setMax(optionalMax.get());
            dataProcessor.setMaxCount((int) dataProcessor.getData().stream().filter(l -> l.equals(optionalMax.get())).count());
            dataProcessor.setMaxPercent();
        }
    }
}
