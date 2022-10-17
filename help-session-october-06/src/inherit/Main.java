package inherit;

public class Main {
  public static void main(String... args) {
    TeachingAssistant t = new TAImpl();
    // if I want to use an alternative implementation then
    // I need to edit the source code!!!!
    t = new TAAltImpl();
  }
}

interface Academic {
}

interface Professor extends Academic {
} // single inheritance

interface Student {
}

interface ResearchStudent extends Student {
}

interface TeachingAssistant extends Academic, ResearchStudent {
} // multiple inheritance

class TAImpl implements TeachingAssistant {

}

class TAAltImpl implements TeachingAssistant {

}