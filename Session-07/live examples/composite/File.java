package composite;

public class File implements FileSystemObject {

    private String name;

    @Override
    public void delete() {
        // delete it
    }

    @Override
    public void display() {
        System.out.println(name);
    }
}
