package diydi;

public class TextClassFactory {

    public TextService getTextClass() {
        return new SpecializedTextService();
    }
}