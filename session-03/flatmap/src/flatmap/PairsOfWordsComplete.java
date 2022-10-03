package flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// video of this at https://www.youtube.com/watch?v=BxQTxtfcuzY&ab_channel=StealthnessCoding 

public class PairsOfWordsComplete {

    static List<String> verbs = Arrays.asList("ran", "walked", "stood", "crawled");
    static List<String> pronouns = Arrays.asList("he", "she", "they");
    static List<String> adverbs = Arrays.asList("home", "away");

    public static void main(String[] args) {
        part1();
        part2();
        part3();
        part4();
    }

    private static void part1() {
        System.out.println(verbs);
        System.out.println(pronouns);
        System.out.println(adverbs);

        //  [ran, walked, stood, crawled]
        //  [he, she, they]
        //  [home, away]
    }

    private static void part2() {

        // This using map
        var output = pronouns.stream().map(pronoun -> {
            return verbs.stream()
                    .map(verb -> Arrays.asList(verb, pronoun))
                    .collect(Collectors.toList());
        }).collect(Collectors.toList());

        System.out.println(output);
        // The output as a nested array structure
        // [[[ran, he], [walked, he], [stood, he], [crawled, he]], [[ran, she], [walked, she], [stood, she], ...

//      Below is equivalent to the above without a code block and return
//        output = pronouns.stream()
//                .map((pronoun -> verbs.stream()
//                        .map(verb -> Arrays.asList(pronoun, verb))
//                        .collect(Collectors.toList())))
//                .collect(Collectors.toList());
    }

    private static void part3() {

        // Now we use flatmap to flatten the output from part 2
        var output = pronouns.stream().flatMap(pronoun -> {
            return verbs.stream()
                    .map(verb -> Arrays.asList(verb, pronoun));
                    // Note we are not Collecting
        }).collect(Collectors.toList());

        System.out.println(output);
        // The output is no longer nested is a flatten array structure
        // [[ran, he], [walked, he], [stood, he], [crawled, he], [ran, she], [walked, she], [stood, she], ...

        //Below is equivalent to the above without a code block and return
        //var output1 = pronouns.stream()
        //        .flatMap(pronouns -> verbs.stream()
        //                .map(verb -> Arrays.asList(pronouns, verb)))
        //        .collect(Collectors.toList());

    }

    private static void part4() {

        // now lets lists of [pronoun, verb, adverb]

        var output = pronouns.stream()
                .flatMap(pronouns -> verbs.stream()
                        .flatMap(verb -> adverbs.stream()
                                .map(adverb -> Arrays.asList(pronouns, verb, adverb))))
                .collect(Collectors.toList());

        System.out.println(output);
        // [[he, ran, home], [he, ran, away], [he, walked, home], [he, walked, away], [he, stood, home], ...

        output.forEach(item -> {
            // there are better ways to do this, but I did not want to distract from flatmap example
            System.out.println(item.get(0) + " " + item.get(1) + " "+ item.get(2));
        });
        //        he ran home
        //        he ran away
        //        he walked home


    }
}
