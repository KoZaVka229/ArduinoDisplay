package koz.executor;

public class NoArgumentsException extends RuntimeException {
    public NoArgumentsException() {
        super("Аргументов не хватает");
    }
    public NoArgumentsException(String message) {
        super(message);
    }
}
