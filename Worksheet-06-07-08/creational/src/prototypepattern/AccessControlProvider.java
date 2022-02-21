package prototypepattern;

import java.util.Hashtable;
import java.util.Map;

public class AccessControlProvider {
  private static Map<String, AccessControl> map = new Hashtable<>();
  static {
    System.out.println("Fetching data from external resources and creating access control objects...");
    AccessControl user = new AccessControl();
    user.setAccess("DO_WORK"); // default access
    user.setLevel("USER");
    map.put("USER", user);

    AccessControl manager = new AccessControl();
    manager.setAccess("GENERATE/READ REPORTS"); // default access
    manager.setLevel("MANAGER");
    map.put("MANAGER", manager);
  }

  public static AccessControl getAccessControlObject(String controlLevel)  {
    try {
      return map.get(controlLevel).clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return null;
  }

}
