package lambdas;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.*;

public class Examples {

    /**
     * Returns {@link Supplier} that always supply "Hello"
     *
     * @return a string supplier
     */
    public static Supplier<String> helloSupplier() {
        return () -> "Hello";
    }

    /**
     * Return a {@link Function} that accepts {@link String} and returns that string repeated n time,
     * where n is passed as function argument
     *
     * @return function that repeats Strings
     */
    public static BiFunction<String, Integer, String> stringMultiplier() {
        return String::repeat;
    }

    /**
     * Returns a {@link Function} that converts a {@link BigDecimal} number into a {@link String} that start
     * with a dollar sign and then gets a value
     *
     * @return function that converts adds dollar sign
     */
    public static Function<BigDecimal, String> toDollarStringFunction() {
        return x -> "$" + x;
    }

    /**
     * Receives two parameter that represent a range and returns a {@link Predicate<String>} that
     * verifies if string length is in the specified range. E.g. min <= length < max
     *
     * @param min min length
     * @param max max length
     * @return a string predicate
     */
    public static Predicate<String> lengthInRangePredicate(int min, int max) {
        return str -> str.length() >= min && str.length() < max;
    }

    /**
     * Returns a {@link Supplier} of random integers
     *
     * @return int supplier
     */
    public static IntSupplier randomIntSupplier() {
        return () -> ThreadLocalRandom.current().nextInt();
    }

    /**
     * Returns {@link IntUnaryOperator} that calculates an integer square
     *
     * @return square operation
     */
    public static IntUnaryOperator intSquareOperation() {
        return i -> i * i;
    }

    /**
     * Returns a {@link ToIntFunction<String>} that converts string to integer.
     *
     * @return string to int converter
     */
    public static ToIntFunction<String> stringToIntConverter() {
        return Integer::parseInt;
    }

    /**
     * Receives int parameter n, and returns a {@link Supplier} that supplies {@link IntUnaryOperator}
     * that is a function f(x) = n * x
     *
     * @param n a multiplier
     * @return a function supplier
     */
    public static Supplier<IntUnaryOperator> nMultiplySupplier(int n) {
        return () -> value -> value * n;
    }

    // Most of these generate an AIC or Anonymous Inner Class

    /**
     * Returns a {@link UnaryOperator} that accepts str to str function and returns the same
     * function composed with trim
     *
     * @return function that composes functions with trim() function
     */
    public static UnaryOperator<Function<String, String>> composeWithTrimFunction() {
        return strFunc -> strFunc.compose(String::trim);
    }

    public static Supplier<Supplier<Supplier<String>>> notMuchPoint() {
        return () -> () -> () -> "Some string";
    }

    public static void main(String[] args) {
//        Supplier<IntUnaryOperator> example = Examples.nMultiplySupplier(5);
//        IntUnaryOperator iuo = example.get();
//        System.out.println(iuo.getClass());
//        System.out.println(iuo.applyAsInt(9));

        UnaryOperator<Function<String, String>> composeWithTrimFunction = Examples.composeWithTrimFunction();
        Function<String, String> toLowerWithTrim = composeWithTrimFunction.apply(String::toLowerCase);
        assert ("hi".equals(toLowerWithTrim.apply(" Hi ")));

        Function<String, String> repeat = composeWithTrimFunction.apply(s -> s.repeat(5));
        assert ("hihihihihi".equals(repeat.apply(" Hi    ")));

        Supplier<Supplier<Supplier<String>>> ex = Examples.notMuchPoint();
        assert ("Some string".equals(ex.get().get().get()));
    }

    class X { //named inner class

    }
}
