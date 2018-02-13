package src;

public interface Settle<T> {
    void fulfill(T result);
    void reject(Error error);
}