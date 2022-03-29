package sorting;

import java.util.Objects;

public class LongAnalyzer implements AnalyzeStrategy<Long> {
    @Override
    public void analyze(DataProcessor<Long> dataProcessor) {
        var optionalMax = dataProcessor.getData().stream().max(Long::compareTo);
        if (optionalMax.isPresent()) {
            dataProcessor.setMax(optionalMax.get());
            dataProcessor.setMaxCount((int) dataProcessor.getData().stream().filter(n -> Objects.equals(n, optionalMax.get())).count());
            dataProcessor.setMaxPercent();
        }
    }
}