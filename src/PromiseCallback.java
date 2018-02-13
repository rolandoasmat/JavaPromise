package src;

public interface PromiseCallback<T> {
    void callback(Settle<T> settle);
}