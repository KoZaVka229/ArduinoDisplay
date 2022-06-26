package koz.executor;

public class CommandNotSupportsException extends RuntimeException {
    public CommandNotSupportsException(Command command, IExecutor executor) {
        super(String.format(
                "Команда \"%s\" не поддерживается выполнителем \"%s\"",
                command.name(),
                executor.getClass().getSimpleName())
        );
    }
    public CommandNotSupportsException(String message) {
        super(message);
    }
}
