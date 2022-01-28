package three;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Outline {

    public static String f1(String c, List<String> l) {
        Stream<String> str =
                l
                        .stream()
                        .map(s -> {
                            System.out.println("Upper-casing " + s);
                            return s.toUpperCase();
                        })
                        .filter(s -> s.contains(c))
                        .filter(s -> s.length() < 4);
        System.out.println("About to get the result...");
        return str
                .findFirst()
                .get();

    }

    public static List<Double> rands(int size) {
        return Stream
                .generate(Math::random)
                .limit(size)
                .toList();
    }

    public static List<Integer> steps(int start, int step, int size) {
        return IntStream
                .range(0, size)
                .map(s -> s * step)
                .map(s -> s + start)
                .boxed()
                .toList();
    }


    public static void main(String... args) { // varargs alternative to String[]

        // What does flatmap do?
        // Stream.flatMap() helps in converting Stream<Collection<T>> to Stream<T>.
        // for example:
        // Before flattening :  [[1,2,3],[4,5],[6,7,8,9]]
        // After flattering :   [1,2,3,4,5,6,7,8,9]

    /*
    List<String> pronouns = Arrays.asList("He", "She", "They");
    List<String> verbs = Arrays.asList("run", "jump", "walk", "crawl");
    var result = pronouns.stream() // first stream is pronoun that is why its first
            .flatMap(pronoun-> verbs.stream()
                    .map(verb -> List.of(verb, pronoun)))
            // ["He", "run"] ["He", "jump"],...
            // ["She", "run"] ["She", "jump"],...
            // ["They", "run"] ["They", "jump"],...
            // [ [...] [...] [...]
            // NOT [ [ [] []..] [[]..[]..]..]
            .collect(Collectors.toList());

    result.stream().forEach(item -> System.out.println(item + " "));
    */

        List<String> pronouns = Arrays.asList("He", "She", "They", "I");

        System.out.println(pronouns);

        pronouns
                .stream()
                .peek(pronoun -> System.out.println("Peek 1: I'm peeking at " + pronoun))
                .filter((String pronoun) -> !pronoun.contains("e"))
                .map(pronoun -> pronoun.length())
                .peek(length -> System.out.println("Peek 2: I'm peeking at " + length))
                .map(length -> length * 2)
                .collect(Collectors.toList()); // basically identical to .toList()



        // Reduction:

        var s = Stream.of(1,2,3,4,5)
                .reduce(0, (a, b) -> a + b);

        // (0, 1) -> (0 + 1) = 1
        // (1, 2) -> (1 + 2) = 3
        // (3, 3) -> (3 + 3) = 6
        // (6, 4) -> (6 + 4) = 10
        // (10, 5) -> (10 + 5) = 15

        var s2 = Stream.of(1,2,3,4,5)
                .reduce(1, (a, b) -> a * b);

        // (1, 1) -> (1 * 1) = 1
        // (1, 2) -> (1 * 2) = 2
        // (2, 3) -> (2 * 3) = 6
        // (6, 4) -> (6 * 4) = 24
        // (24, 5) -> (24 * 5) = 120

        var s3 = Stream.of(2.0, 3.0, 4.0, 5.0)
                .reduce(1.0, (a, b) -> a / b);


        var s4 = Stream.of(2)
                .reduce((a, b) -> a + b);

        assert s4.isEmpty() == false && s4.get() == 2;

        var s5 = Stream.of(2, 3, 4, 5)
                .reduce((a, b) -> a + b);

        assert s4.isEmpty() == false && s4.get() == 14;


        var s6 = Stream.<Integer>empty()
                .reduce((a, b) -> a + b);
        assert s4.isEmpty() == true;

        // [1, 2, 3, 4] --> "1, 2, 3, 4"

        var s7 = Stream.of(1,2,3,4)
                .reduce("hello",
                        (string, i) -> string + "..." + i.toString() + "!",
                        (string1, string2) -> string1 + string2);

        System.out.println("Reduction gives: " + s7);

        var s8 = Stream.of(1,2,3,4)
                .reduce("",
                        (string, i) -> string.isEmpty() ? i.toString() : string + ", " + i.toString(),
                        (string1, string2) -> string1 + string2);

        System.out.println("Second reduction gives: " + s8);


    }
}


