package three;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Outline {

    public static void main(String... args) { // varargs alternative to String[]

        List<String> strs0 = Arrays.asList("a", "bb", "ccc", "dd", "e");

        System.out.println(strs0);

        Supplier<Stream<Integer>> streamSupplier = () ->
                strs0
                        .stream()
                        .peek(s -> System.out.println("Peeker 1: I am peeking at " + s))
                        .filter(s -> !s.contains("c"))
                        .map(s -> s + "?")
                        .peek(s -> System.out.println("Peeker 2: I am peeking at " + s))
                        .map(s -> s.length())
                        .peek(i -> System.out.println("Peeker 3: I am peeking at " + i))
                        .map(i -> i + 1);

        Stream<Integer> stream4 =
                streamSupplier
                        .get()
                        .filter(i -> i != 42);

        Stream<Integer> stream5 =
                streamSupplier
                        .get()
                        .map(i -> i + 3);

    /* Normally we wouldn't work with non-terminal streams like this, but
    rather create the streams and apply the terminal operation all in one place in the code. */

        List<Integer> list2 = stream4.toList();
        System.out.println(list2);

        list2 = stream5.toList();
        System.out.println(list2);


        streamSupplier.get().forEach(s -> System.out.println(s));

        List<Integer> list4 =
                streamSupplier
                        .get()
                        .collect(Collectors.toList());

    }
}