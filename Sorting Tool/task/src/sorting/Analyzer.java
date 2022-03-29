package sorting;

public class Analyzer <T>{
    private AnalyzeStrategy<T> strategy;

    public void analyze(DataProcessor<T> dataProcessor) {
        strategy.analyze(dataProcessor);
    }

    public void setStrategy(AnalyzeStrategy<T> strategy) {
        this.strategy = strategy;
    }
}
