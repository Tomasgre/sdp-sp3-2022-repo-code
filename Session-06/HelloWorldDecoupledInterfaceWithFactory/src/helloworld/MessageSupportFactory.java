package helloworld;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public final class MessageSupportFactory {

  private static MessageSupportFactory instance = null;

  static {
    instance = new MessageSupportFactory();
  }

  private MessageRenderer renderer = null;
  private MessageProvider provider = null;

  private MessageSupportFactory() {
    Properties props = new Properties();

    try {
      try (var fis = new FileInputStream("bean.properties")) {
        props.load(fis);
      } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }

      // get the implementation classes
      String rendererClass = props.getProperty("renderer.class");
      String providerClass = props.getProperty("provider.class");

      renderer = (MessageRenderer) Class.forName(rendererClass)
        .getDeclaredConstructor().newInstance();
      provider = (MessageProvider) Class.forName(providerClass)
        .getDeclaredConstructor().newInstance();
    }  catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    } catch (InvocationTargetException e) {
      throw new RuntimeException(e);
    } catch (InstantiationException e) {
      throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    } catch (NoSuchMethodException e) {
      throw new RuntimeException(e);
    }
  }

  public static MessageSupportFactory getInstance() {
    return instance;
  }

  public MessageRenderer getMessageRenderer() {
    return renderer;
  }

  public MessageProvider getMessageProvider() {
    return provider;
  }

}