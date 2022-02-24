package chainofresponsibility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AudioFileHandler implements Handler {

    private final List<String> acceptedFileTypes = new ArrayList<>(Arrays.asList("audio"));
    String handlerName;
    Handler nextHandler;

    public AudioFileHandler(String text_handler) {
        this.handlerName = text_handler;
    }

    @Override
    public void setHandler(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void process(File file) {
        processFile(file, acceptedFileTypes, handlerName, nextHandler);
    }

    static void processFile(File file, List<String> acceptedFileTypes, String handlerName, Handler nextHandler) {
        if (acceptedFileTypes.contains(file.fileType())) {
            System.out.println("Process and saving " + file.fileType()
                + " file... by " + handlerName);
        } else if (nextHandler != null) {
            System.out.println(handlerName + " forwards request to "
                + nextHandler.getHandlerName());
            nextHandler.process(file);
        } else {
            System.out.println("File not supported");
        }
    }

    @Override
    public String getHandlerName() {
        return handlerName;
    }
}
