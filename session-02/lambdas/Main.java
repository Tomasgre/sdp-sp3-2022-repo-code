import java.util.*;
import java.util.function.*;

public class Main {

    private static class Cycle implements Supplier<Integer> {
        int max, count = 0;
        public Cycle(int max) {
            this.max = max;
        }
        public Integer get() {
            count = (count >= max) ? 0 : (count + 1);
            return count;
        }
    }


    public static void main(String[] args) {

        NumericTest even = n -> n % 2 == 0;
        NumericTest is42 = n -> n == 42;



        // Functions (1 argument)
        Function<String, Integer> length = str -> str.length();
        length = String::length;

        Function<Integer, String> toString = i -> i.toString();
        // toString = Integer::toString .... :-(


        // Unary operators
        UnaryOperator<String> toUpper = str -> str.toUpperCase();
        toUpper = String::toUpperCase;

        UnaryOperator<Integer> negate = i -> -i;
        UnaryOperator<Integer> next = i -> i + 1;

        assert negate.apply(5) == -5;
        assert next.apply(5) == 6;

        // Bi-functions (2 arguments)
        BiFunction<String, Integer, String> substring = (s, i) -> s.substring(i);
        substring = String::substring;

        BiFunction<List<String>, String, Boolean> contains = (list, s) -> list.contains(s);
        contains = List::contains;


        // Binary operators
        BinaryOperator<Integer> add = (int1, int2) -> int1 + int2;
        BinaryOperator<String> concat = (str1, str2) -> str1.concat(str2);
        concat = String::concat;


        // Predicates
        Predicate<Integer> isEven = i -> i % 2 == 0;
        Predicate<Integer> isTwoDigits = i -> (i > 9 && i < 100);
        Predicate<String> startsWithE = s -> s.startsWith("E");

        assert isEven.test(3) == false;

        // Suppliers
        Supplier<Double> randomDouble = () -> Math.random();
        //randomDouble = Math::random;
        Supplier<Integer> get42 = () -> 42;

        assert get42.get() == 42;

        // Idea is to encourage "functional programming" with immutable data.
        // You CAN have "stateful lambdas", but you SHOULDN'T!
        Supplier<Integer> cycle5 = new Cycle(5);

        // Consumers
        List<Integer> theList = new ArrayList<Integer>();
        Consumer<Integer> addToList = i -> theList.add(i);
        Consumer<String> printer = s -> System.out.println(s);

        printer.accept("hello world");



        // Comparators and sorting

        Comparator<Integer> lessThan = (i, j) -> {
            if (i < j) {
                return -1;
            } else if (i == j) {
                return 0;
            } else {
                return 1;
            }
        };

        // lessThan = Integer::compareTo;

        Comparator<String> shorterThan = (s1, s2) -> {
            if (s1.length() < s2.length()) {
                return -1;
            } else if (s1.length() == s2.length()) {
                return 0;
            } else {
                return 1;
            }
        };

        Comparator<String> longerThan = shorterThan.reversed();

        // Better: use built in compare methods
        lessThan = (i1, i2) -> Integer.compare(i1, i2);
        //lessThan = Integer::compareTo;

        //shorterThan = (s1, s2) -> Integer.compare(s1.length(), s2.length());

        shorterThan = Comparator.comparing(s -> s.length());
        //shorterThan = Comparator.comparing(String::length);

        Comparator<String> compareFirstCharacter = Comparator.comparing(s -> s.charAt(0));



        String[] strings = {"a", "ff", "bbb", "eeee", "ccccc", "dddddd"};

        List<String[]> clones = new ArrayList<>();

        for(int i = 0; i < 2; i++)
            clones.add(strings.clone());

        // Natural ordering
        Arrays.sort(clones.get(0));
        // (*) Actually equivalent to: Arrays.sort(clones.get(0), Comparator.naturalOrder());

        // Explicit Comparator
        Arrays.sort(clones.get(1), longerThan);



        for(String[] s : clones) {
            System.out.println(Arrays.asList(s));
        }


    }
}
