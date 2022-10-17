package recursivedatastructures;

import com.sun.net.httpserver.Headers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Helper;

interface LibraryOfBooks {
    int count();

    //double totalPrice();
    LibraryOfBooks allBeforeCertainYear(int year);

    //LibraryOfBooks sortByPrice();
    String toString();

    int countHelper(int acc);
}

public class Example {
    public static void main(String[] args) {
        var b = new Book("a title", "an author", 2001, 19.75);
        System.out.println(b);
    }
}

@Data
@AllArgsConstructor
class Book {
    private String title;
    private String author;
    private int year;
    private double price;

    public boolean before(int year) {
        return this.year < year;
    }
}

class EmptyNode implements LibraryOfBooks {
    public int count() {
        return 0;
    }

    public int countHelper(int acc) {
        return acc;
    }

    public String toString() {
        return "";
    }

    public LibraryOfBooks allBeforeCertainYear(int year) {
        return new EmptyNode();
    }
}

@AllArgsConstructor
class ElementNode implements LibraryOfBooks {
    private Book data;
    private LibraryOfBooks remainder;

    //public int count() { return 1 + remainder.count();}

    public int count() {
        return countHelper(0);
    }

    public int countHelper(int acc) {
        return remainder.countHelper(1 + acc);
    }

    public String toString() {
        return "(" + data.toString() + ")" + remainder.toString();
    }

    public LibraryOfBooks allBeforeCertainYear(int year) {
        if (data.before(year)) {
            return new ElementNode(this.data, this.remainder.allBeforeCertainYear(year));
        } else {
            return this.remainder.allBeforeCertainYear(year);
        }
    }
}
