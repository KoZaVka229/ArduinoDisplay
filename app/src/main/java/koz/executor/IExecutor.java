package koz.executor;

public interface IExecutor {
    void execute(Command command, Object ...args) throws NoArgumentsException, ClassCastException;
}
