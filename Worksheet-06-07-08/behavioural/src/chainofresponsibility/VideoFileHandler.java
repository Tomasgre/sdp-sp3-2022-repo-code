package chainofresponsibility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VideoFileHandler implements Handler {
  String handlerName;
  private final List<String> acceptedFileTypes = new ArrayList<>(Arrays.asList("video"));
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
    if(acceptedFileTypes.contains(file.getFileType())){
      System.out.println("Process and saving " + file.getFileType()
              + " file... by " + handlerName);
    } else if (nextHandler != null){
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
