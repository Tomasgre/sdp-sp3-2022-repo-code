# Lambdas

+ Not a new capability. Just nice new syntax.

+ It's a convenient way to create *anonymous class instances* when you just need to implement one function.

+ Lambdas are convenient because they leave out boilerplate and types. Java infers the types for you.

---

+ Reminder: An anonymous class is a particular implementation of an interface or an abstract class, which appears in just one place in your code and isn't big or important enough to deserve its own class.)

+ A "functional" interface is an interface consisting of a single function.

---

# Example One: Functional Interface

Implemented using anonymous class (can think of this as creating an un-named class that implements NumericTest)


```
@FunctionalInterface
interface NumericTest {
	boolean test(int n);
}
...
// Without anonymous class:
class EvenTest implements NumericTest {
    @Override
    boolean test(int n) {return n % 2 == 0;}
}
NumericTest even = new EvenTest();
// or EvenTest even = ...

// With anonymous class:		
NumericTest even = new NumericTest() {
	@Override
	public boolean test(int n) {
		return n % 2 == 0;
		}
	};
```

---

# Example Two: Abstract Class

Implemented using anonymous class (can think of this as creating an un-named subclass of Customer)


```
abstract class Eater {
	private String name;
	private int appetite;
	...
	abstract void eat(String s);
	}

...

// Without anonymous class:
class HumanEater extends Eater {
  @Override
  void eat(String s) {
    System.out.println("Human says " + s + " is yum");
  }
}
Eater hungryThing = new HumanEater(); 

// With anonymous class:
Eater hungryThing = new Eater() {
	@Override
	public void eat(String s) {
		System.out.println(s + " was delicious");
		}
	};
```

---

# Example One: Functional Interface

Implemented using lambda

```
interface NumericTest {
	boolean test(int n);
}
...		
NumericTest even = n -> n % 2 == 0;
```
		
---

# Example Two: Abstract Class

Implemented using lambda

```
2.
abstract class Eater {
	private String name;
	private int appetite;
	...
	abstract void eat(String s);
	}

Eater hungryGuy = s -> {
	System.out.println(s + " was delicious");
	};
```

---

+ Lambdas are only useful for "Simple" methods: the implementation either
    1. Doesn't refer to any variables outside the function; OR
    2. Only refers to outside variables that never get re-assigned, so those variables always point to the same object. (The variables are "effectively final".)

+ But note that a lambda can still *call methods* on these outside variables. But you can't replace the variable's contents with something else.

+ Does your editor show you when a variable is re-assigned in your code? e.g. IntelliJ underlines variables which are re-assigned.

---

# OK example: Lambda Referring to Outside Variables

```
interface NumericTest {
	boolean test(int n);
}
...		
List<Integer> accepted = new ArrayList();
    Predicate<Integer> acceptOnce = n -> {
      if (accepted.contains(n)) {
        return false;
      } else {
        accepted.add(n);
        return true;
      }
    };
```

+ This lambda is fine, because "accepted" always refers to the same ArrayList object.

---

# Not OK example: Lambda Referring to Outside Variables

```
int theValue = 42;
NumericTest acceptTheValue = n -> n == theValue;

This is allowed, only if theValue is never re-set in your code. If you set it again somewhere...
theValue = 43;
```

... then the compiler will complain about the lambda.

---

# Comparators

+ Second worksheet is mostly about sorting and Comparators.

+ Useful to keep in mind:

"Convert your values into Integers/Characters/Booleans/etc, and you can compare them as Integers/Characters/Booleans/etc."

+ Some classes implement Comparable: Integer, Character, Boolean

+ Use this to your advantage if your comparison is related to two values of this type!

+ (Remember that java will convert primitive ints, chars etc... into these, as needed)

---

e.g.

Sort strings according to how many "e"s there are:

```
class C {
	public static int countEs(String s) {
		...
	}
}

...
String[] strings = new String[] {"a", "ff", "bbb", "eeee", "ccccc", "dddddd"};
Arrays.sort(s, Comparator.comparing(C::countEs))
```

+ The function C::countEs extracts an integer from each string.
+ Integers are comparable, so Comparator.comparing can use the Integer.compareTo method to do comparisons between the resulting integers. It can then sort the original String array according to these comparisons.

+ You can optionally provide the Comparator that should to be used (but here we don't, because Integers are already Comparable):
```
Arrays.sort(s, Comparator.comparing(C::countEs), myComparator);
```
---

# Generic methods

+ Example syntax for a method which takes a generic type parameter A:
```
public <A> Result method(Param1 c, Param2 d)
```
Where Result, Param1, Param2 are some types that will probably refer to A, e.g. `List<A>`.

+ You'll define several methods like this in the second worksheet.

+ Note that we can define such generic methods in any class, not only ones with generic type parameters `MyClass<A>`.
  The parameter A is inferred or provided whenever this method gets used.

---

# How to use generic methods?

```
B b = <A>method1(...) // explicit: provide A (yuck)
B b = something.<A>method2(...)
B b = SomeClass.<A>method3(...)

B b = method1(...) // Implicit: infer A
B b = something.method2(...)
B b = SomeClass.method3(...)
```
---

+ I recommend you (try to) understand generics and wildcards when you read a method declaration,
  because it can help you to understand its behaviour a bit better.

Two versions of the same example, with/without wildcards:

1. Hard (About as complicated as generics get):
```
static <T,U extends Comparable<? super U>> Comparator<T> Comparator.comparing(Function<? super T,? extends U> keyExtractor)
```
2. Easier, but less useful version would be:
```
static <T,U extends Comparable<U>> Comparator<T> Comparator.comparing(Function<T,U> keyExtractor)
```
+ If it helps, compare these general versions with example usage, like the one we saw:
```
Arrays.sort(s, Comparator.comparing(C::countEs))
```
(T = String, U = Integer)

---

# Some Suggestions for the second worksheet

+ To sort a String[] object in different ways, try cloning it several times into an ArrayList or a 2D array, and sort each clone differently. For example:
```
String[] strings = new String[] {"a", "ff", "bbb", "eeee", "ccccc", "dddddd"};
ArrayList<String[]> copies = new ArrayList();
    for (int i = 0; i < 5; i++) {
      copies.add(strings.clone());
    }
...
Arrays.sort(copies.get(0), comparator0);
Arrays.sort(copies.get(1), comparator1);
...
```

+ You can convert an array into a List using Arrays.toList, or List.of:
```
List<String> stringList = Arrays.asList(strings);
List<String> stringList2 = List.of(string1, string2, string3); // or List.of(your_array)
```
Note that you get (an implementation of) List, not an ArrayList.

+ Or use constructor of ArrayList, passing in a collection:
```
ArrayList<String> a = new ArrayList(List.of(your_stuff))
```

---

# Learn to use IntelliJ efficiently!

+ Useful keyboard shortcuts:

+ Key Promoter plug-in: Tells you if there's a key command for something you do often

+ Cmd + Shift + A: Show you a searchable index of all the key commands.

+ Cmd + Down: Show you the definition of the code under the cursor.
+ F1 (possibly Fn + F1 on your Mac) to view some documentation about the code under the cursor
+ (This can be useful if you are trying to understand any of IntelliJ's automatic suggestions)
+ Ctrl + Shift + R to run this class's main method.

+ Alt + Enter to auto-fix the red code (or show you the options).
+ Cmd + Alt + [/] move the cursor to the start or end of the current code block.

+ Good idea: Go to Preferences/Settings, then `Editor > General > Code Completion`, scroll to "Parameter Info", and tick "Show parameter name hints on completion".

---

# Live Templates

+ Type "main" and see what IntelliJ does for you...

This is an example of one of the live templates.

+ Create your own Live Templates to save time typing...

E.g. "print" -> System.out.println

---
