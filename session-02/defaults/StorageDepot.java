import javax.naming.OperationNotSupportedException;

public interface StorageDepot<T> {

    public void add(T t);

    // Re-use of other methods:
    default public void addAll(Iterable<T> iter) {
        for(T t : iter) {
            add(t);
        }
    }

    // Default implementation of optional methods:
    default public void remove(T t) throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }
}
