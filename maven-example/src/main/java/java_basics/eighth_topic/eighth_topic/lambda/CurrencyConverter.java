package java_basics.eighth_topic.eighth_topic.lambda;

public interface CurrencyConverter<T, R> {
    R convert(T payment);
}
