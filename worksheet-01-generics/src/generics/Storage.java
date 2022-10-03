package generics;

class Storage<T extends Object> {
  private T x;

  public void setValue(T value) {
    x = value;
  }

  public T getValue() {
    return x;
  }
}
