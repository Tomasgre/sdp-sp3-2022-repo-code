package composite;

import java.util.List;

public class Folder implements FileSystemObject {
    private String name;
    private List<FileSystemObject> contents;

    @Override
    public void delete() {
        for (FileSystemObject o : contents) {
            o.delete();
        }
        // delete this folder
    }

    @Override
    public void display() {

        System.out.println("Directory: " + name);

        for (FileSystemObject o : contents) {
            o.display();
        }

    }
}
