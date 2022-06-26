package koz.executor;

public class Selector<T> {
    private final T[] selectable;

    public Selector(T[] selectable) {
        this.selectable = selectable;

        setIndex(index);
    }

    private int index = 0;
    public int getIndex() {
        return index;
    }
    public T setIndex(int _index) throws IllegalArgumentException {
        if (_index >= selectable.length || _index < 0)
            throw new IllegalArgumentException("Error index");

        index = _index;
        return get();
    }

    public T next() {
        if (++index >= selectable.length) index = selectable.length - 1;

        return get();
    }
    public T back() {
        if (--index < 0) index = 0;

        return get();
    }
    public T home() {
        setIndex(0);

        return get();
    }
    public T get() {
        return selectable[index];
    }
}
