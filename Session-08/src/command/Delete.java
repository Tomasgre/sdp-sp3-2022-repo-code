package command;

public class Delete implements Command {

    private File file;

    public Delete(File f) {
        this.file = f;
    }

    @Override
    public void execute() {
        System.out.println("Executing command: delete file " + file.getName() + "...");
        file.delete();
    }
}
