package src;

public class Promise<T> {
    private PromiseCallback<T> promiseCallback;
    private boolean fulfilled = false;

    public Promise(PromiseCallback<T> promiseCallback) {
        this.promiseCallback = promiseCallback;
    }

    public Promise then(Settle<T> settle) {
        if (promiseCallback != null) {
            Settle<T> _fulfillment = new Settle<T>() {
                @Override
                public void fulfill(T result) {
                    if(!fulfilled) {
                        settle.fulfill(result);
                        fulfilled = true;
                    }
                }

                @Override
                public void reject(Error error) {
                    if(!fulfilled) {
                        settle.reject(error);
                        fulfilled = true;
                    }
                }
            };
            promiseCallback.callback(_fulfillment);
        }
        return this;
    }
}
