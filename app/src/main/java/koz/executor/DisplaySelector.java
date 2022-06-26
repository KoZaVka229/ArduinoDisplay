package koz.executor;


public class DisplaySelector<T> extends Selector<T> {
    private final IDisplay<T> display;

    public DisplaySelector(T[] selectable, IDisplay<T> display) {
        super(selectable);

        this.display = display;
    }

    @Override
    public T setIndex(int _index) throws IllegalArgumentException {
        T r = super.setIndex(_index);
        display(r);

        return r;
    }

    @Override
    public T next() {
        T r = super.next();
        display(r);

        return r;
    }

    @Override
    public T back() {
        T r = super.back();
        display(r);

        return r;
    }

    @Override
    public T home() {
        T r = super.home();
        display(r);

        return r;
    }

    private void display(T result) {
        display.display(result);
    }
}
