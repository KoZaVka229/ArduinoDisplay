package koz;

public class StaticMethods {
    public static <T> boolean notInBounds(T[] array, int i) {
        return i < 0 || i >= array.length;
    }
}
