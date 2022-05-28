package diydi;

public class SpecializedTextService implements TextService {

    @Override
    public String doSomethingWithText(String text) {
        return getClass().getName() + ": " + text;
    }

    @Override
    public String doSomethingElseWithText(String text) {
        return getClass().getName() + ": " + text;
    }
}
