package chainofresponsibility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VideoFileHandler implements Handler {
    private final List<String> acceptedFileTypes = new ArrayList<>(Arrays.asList("video"));
    String handlerName;
    Handler nextHandler;

    public VideoFileHandler(String text_handler) {
        this.handlerName = text_handler;
    }

    @Override
    public void setHandler(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void process(File file) {
        AudioFileHandler.processFile(file, acceptedFileTypes, handlerName, nextHandler);
    }

    @Override
    public String getHandlerName() {
        return handlerName;
    }
}
