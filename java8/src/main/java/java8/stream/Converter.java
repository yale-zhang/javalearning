package java8.stream;
@FunctionalInterface
public interface Converter<F,T> {
    T convert(F from);
}


