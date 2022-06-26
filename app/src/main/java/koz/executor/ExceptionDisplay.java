package koz.executor;

public class ExceptionDisplay implements IDisplay<Exception> {
    private final IPrinter printer;
    public ExceptionDisplay(IPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void display(Exception obj) {
        printer.print(obj.getClass().getSimpleName());
        printer.println(obj.getMessage());
    }
}
