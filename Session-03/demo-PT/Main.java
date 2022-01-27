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



        // What does flatmap do?
        // Stream.flatMap() helps in converting Stream<Collection<T>> to Stream<T>.
        // for example:
        // Before flattening :  [[1,2,3],[4,5],[6,7,8,9]]
        // After flattering :   [1,2,3,4,5,6,7,8,9]




    }
}


