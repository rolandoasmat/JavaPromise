package src;

import src.Promise;

class Main {
    public static void main(String[] args) {
        // Create the promise
        Promise<Double> promise = new Promise<Double>(new PromiseCallback<Double>() {
            @Override
            public void callback(Settle<Double> settle) {
                // Do work to either resolve or reject
                Double result = new Double(4.04);

                // Sample resolve
                settle.fulfill(result);

                // Sample reject
                settle.reject(new Error("Could not compute"));
            }
        });

        // Use the promise
        promise.then(new Settle<Double>() {
            @Override
            public void fulfill(Double result) {
                // Got the result!
                System.out.println("Promise fulfilled! with result:\n" + result);
            }
            @Override
            public void reject(Error error) {
                // Got an error :(
                System.out.println("Promise fulfilled! with error:\n" + error.getMessage());
            }
        });
    }
}