package lectures.lecture6;

import lombok.SneakyThrows;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class ListUtils {
    @SneakyThrows
    public static <T> void forEachWithDelay(List<T> list, int delay, Consumer<T> consumer) {
        for (T value : list) {
            Thread.sleep(delay);
            consumer.accept(value);
        }
    }

    public static <T> int countDuplicate(T value, List<T> list) {
        return Collections.frequency(list, value);
    }

    public static <T> int countDuplicate(T value, List<T> list, Equalator<T> equalator) {

        int counter = 0;

        for (T t : list) {
            if (equalator.equals(t, value)) {
                counter++;
            }

        }
        return counter;
    }
}
