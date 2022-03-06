package command;

public class File {

    private String name;

    public String getName() {
        return name;
    }

    public File(String name) {
        this.name = name;
    }


    public void copyTo(String destination) {
        System.out.println("Copied " + name + " to " + destination);
    }

    public void delete() {
        System.out.println("Deleted file " + name);
    }
}
