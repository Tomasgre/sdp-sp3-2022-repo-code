package prototypepattern;

public class TestPrototypePattern {
    public static void main(String[] args) {
        AccessControl userAccessControl = AccessControlProvider.getAccessControlObject("USER");
        User user = new User("User A", "USER Level", userAccessControl);

        System.out.println("************************************");
        System.out.println(user);

        userAccessControl = AccessControlProvider.getAccessControlObject("USER");
        user = new User("User B", "USER Level", userAccessControl);
        System.out.println("Changing access control of: " + user.getUserName());
        user.getAccessControl().setAccess("READ REPORTS");
        System.out.println(user);

        System.out.println("************************************");

        AccessControl managerAccessControl = AccessControlProvider.getAccessControlObject("MANAGER");
        user = new User("User C", "MANAGER Level", managerAccessControl);
        System.out.println(user);
    }

  /*
  Fetching data from external resources and creating access control objects...
  ************************************
  Name: User A, Level: USER Level, Access Control Level:USER, Access: DO_WORK
  Changing access of: User B
  Name: User B, Level: USER Level, Access Control Level:USER, Access: READ REPORTS
  ************************************
  Name: User C, Level: MANAGER Level, Access Control Level:MANAGER, Access: GENERATE/READ REPORTS
   */
}