package other;

import java.util.List;
/**
 * Created by Aidar Aibekov, special for Zensoft Test Assignment
 * This static class help us to get last and first element in array
 */
public final class FirstLastInArray {

    public FirstLastInArray() {
    }

    public static <T> T getFirst(List<T> list) {
        return list != null && !list.isEmpty() ? list.get(0) : null;
    }

    public static <T> T getLast(List<T> list) {
        return list != null && !list.isEmpty() ? list.get(list.size() - 1) : null;
    }
}