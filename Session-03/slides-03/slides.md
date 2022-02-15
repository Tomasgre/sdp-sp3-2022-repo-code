## Streams Overview

+ Use `Stream`s to extract values from a `Collection`, like an `Iterator` but with a much richer interface.

+ Allow you to do functional programming in Java.

+ This means you can process them by applying a chain of functions: E.g. `filter`, then `map`, then `limit`, then `sort`, ...

+ The values get transformed (or dropped) as they are "pushed through" this pipeline of operations.

+ These operations are "non-terminal operations"; they extend the pipeline, but they do not produce a result at the end.

+ To do that, we can apply a "terminal operation". A common example is to collect all the values coming through and put them in a `List`.

## Creation

+ Note that IntelliJ itself encourages you to work with stream! The autocomplete for a collection `c` will show you methods like
```
+ c.stream().filter(
c.stream().map(
etc.
```
+ As this suggests, you can extract a stream from a collection using `c.stream()`


## Non-terminal Operations

+ `.filter(my_predicate)`

+ `.peek(my_consumer)`

+ `.limit(how_many)`

+ `.map(my_function)`

+ `.distinct()`

+ Make a new stream from an existing one. The new stream will have this operation added to the pipeline.
+ Remember that "streams are lazy" -- no work will get done until a terminal operation is applied (see below).
+ "Use once": Note that when you extend a stream, e.g. `stream2 = stream1.limit(3)`, you are not allowed to "re-use" the old reference `stream1` to create other streams -- an Error would be thrown. (try it -- live coding)
+ If you want to "reuse" a section of your stream... you can't. You need to create a new stream!

All in one example (live coding):

```
List<String> strs = Arrays.asList("a", "bb", "ccc", "dd", "e");
List<Integer> ints = str
	.stream()
	.filter(s -> !s.contains("e"))
	.peek(System.out::println)
	.limit(3)
	.distinct()
	.map(s -> s.toString())
```

## Terminal Operations

+ `.forEach(my_function)`
+ `count()`
+ `reduce` (see below)
+ `collect` (see below)

## Reduction

Three overloaded methods:

+ `reduce(accumulator)`
+ `reduce(identitity, accumulator)`
+ `reduce(identitity, accumulator, combiner)`

See picture!

## Collectors

+ Terminal operation: `s.collect(my_collector)`

+ `Collector`s are objects that "collect a stream of values into a container".
+ A `Collector` implements a process of supplying, accumulating, combining (and "finishing") a stream of values into a container.
+ Usually, rather than make your own `Collector`, it's convenient to use the static methods in the `Collectors` class.
  E.g. `my_stream.collect(Collectors.toList())`
+ Have a look at the `Collector` / `Collectors` documentation, and the auto-complete suggestions. But for this course, I don't think you need to worry about creating your own.

## Parallel

+ There are also intermediate operations `.parallel()` and `.sequential()` telling Java that it can(not) parallelise all the stream operations.

+ This means multiple threads can process the values in the same way, which *can* be more efficient if the benefits of parallel execution outweigh the overheads.

+ In a parallel stream, we cannot be sure the elements will be processed in the same order they arrive.

+ java.util.stream package documentation: "When the terminal operation is initiated, the stream pipeline is executed sequentially or in parallel depending on the mode of the stream on which it is invoked."

## Primitive Streams

+ Note that some stream classes are designed specially for primitives, e.g. `IntStream`, `DoubleStream`.

+ (Just like the functional interfaces in java.util.function, e.g. `IntUnaryOperator`.)

+ Reminder: This is because primitives are not objects, so as usual, we can't use them as generic type parameters. We can't have `List<int>` and we can't have `Stream<int>` either.

+ However, we can convert them into the "boxed" generic versions, e.g. `Stream<Integer>`, `Stream<Double>`, by calling `.boxed()`. (You can now use the resulting streams with the generic `Stream` interface.)

+ But before you do that, note these primitive streams could have useful helper methods. E.g. `IntStream` has range, which is similar to Python range, and terminal operations `average`, `max`, `sum` etc.

+ Look at their methods with autocomplete! E.g. type:
```
IntStream s;
s.
```
And see what comes up. Or see the official Java 17 docs.


# Notes on Streams Questions

+ If you get stuck on a question, don't spend too long on it -- ask for help, and try other questions.

2. It's very easy to do this using the count method, but the question asks you to use reduce instead.

If you get stuck, here is more guidance. Reduce (the three-argument version) needs you to provide three arguments: an **identity**, an **accumulator**, and a **combiner**.
In this example, these are very simple, once you understand how reduce works.
+ The result of the count should be an Integer; so this is the generic type parameter U in the reduce method.
+ We "accumulate" a Dish with a count, simply by returning the incremented count: (count+1). To combine two counts (e.g. if we have several threads counting dishes in parallel), we would add the counts together.
+ The identity for this process is the initial count, 0.
+ The result of the reduction is the total count of the dishes.

Some of the reduce methods produce `Optional<T>`. This is because we can only get a result T if the stream is non-empty, otherwise we get nothing. You can call get to extract the value from an Optional (it will raise an Exception if there is no value, but you don't need to handle that possibility in this worksheet.)

4. I took the iterators of both lists and then zipped them together manually, by going through one of the iterators. (I'm not sure if this can be done with streams -- TBC)

6. Hint: use the `forEach` method of streams

10. This only makes sense if we search for the given lower-case letters before we make it all upper-case.

You can copy-paste and then change the code suitably... but maybe better to define a separate static function.

12. hint: use `generate`, and `Math.random`

13. A direct way to do this is to create your own supplier to generate the values. Note that you can't use a lambda for the supplier due to the internal state; You could use a suitable anonymous class with an internal state. But there is a more convenient "mathematical" solution to this problem: we can construct the stream step-by-step, starting with IntStream.range to generate values (0, 1, ..., n), and mapping a few suitable functions to transform these values into the required ones. You might want to use boxed() to turn the IntStream into a Stream<Integer> before you can produce a List<Integer>.

14. Suggested ways: Two ways can use the reduce method overloads, either by "reducing" pairs of integers by adding them, or by accumulating sums. Another way is to exploit the functions (like sum) that are available to the specialised IntStream class (used to represent streams of primitive int values). You can convert a Stream<Integer> into an IntStream using mapToInt, with a trivial "map" function. (The reverse conversion uses boxed.)

16. "Lazy" means that "intermediate operations on Streams do not do any work, until a terminal operation is applied". I.e. we can apply several operations (like filtering and mapping) and produce a new Stream, but the applied functions will only get called when we apply a terminal operation (like count or toList or findFirst).

To show that intermediate operations are lazy, you can apply a few to a stream, where one of the operations (e.g. mapping a suitable function) should display something when it acts. Store the resulting "intermediate" stream in a Stream<T> variable. At this point, you should see that nothing has been displayed. Then apply a terminal operation. Only then should you see something displayed as the stream is processed.

19. Either do a reduction, or use Collectors.joining. (Note that in this case, you could even use String.join.)
