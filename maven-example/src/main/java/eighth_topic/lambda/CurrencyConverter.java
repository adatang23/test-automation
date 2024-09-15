package eighth_topic.lambda;

public interface CurrencyConverter<T, R> {
    R convert(T payment);
}
