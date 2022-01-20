import java.util.*;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {

        Supplier<Integer> supplier = new Supplier<Integer> () {
            @Override
            public Integer get() {
                return 42;
            }
        };

        Supplier<Integer> supplier2 = () -> 42;

        System.out.println(supplier.get());

        Consumer<Integer> consumer = i -> System.out.println("I consumed " + i);

        consumer.accept(99);

        BiConsumer<Integer, String> consumer2 = (i, s) -> System.out.println("I consumed " + i + " and " + s);

        consumer2.accept(55, "hello");

        //Function<String, Integer> f = s -> s.length();
        Function<String, Integer> f = String::length;
        Function<Integer, String> toString = i -> i.toString();
        UnaryOperator<Integer> square = x -> x * x;
        BiFunction<Integer, Integer, Integer> add = Integer::sum;

        BiFunction<String, String, String> concat = String::concat;
        BiFunction<String, String, String> concat2 = (x, y) -> x + y;
        //"abc".concat("def");
        // Note that we can use :: for both static and instance methods
        UnaryOperator<String> toUpper = String::toUpperCase;
        UnaryOperator<Integer> negate = x -> -x;

        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<String> startsWithO = s -> s.startsWith("o");

        List<Integer> al = Arrays.asList(5,3,4,2,1);
        Comparator<Integer> c = (x, y) -> {
            if (x > y) {
                return 1;
            } else if (x == y) {
                return 0;
            } else {
                return -1;
            }
        };
        al.sort(c);
        System.out.println(al);
    }
}
