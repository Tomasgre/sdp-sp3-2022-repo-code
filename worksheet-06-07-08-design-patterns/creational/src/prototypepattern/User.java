package prototypepattern;

public class User {
    private String userName;
    private String userLevel;
    private AccessControl userAccessControl;

    public User(String userName, String userLevel, AccessControl userAccessControl) {
        this.userName = userName;
        this.userLevel = userLevel;
        this.userAccessControl = userAccessControl;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLevel() {
        return this.userLevel;
    }

    public void setLevel(String level) {
        this.userLevel = level;
    }

    public AccessControl getAccessControl() {
        return this.userAccessControl;
    }

    public void setAccessControl(AccessControl accessControl) {
        this.userAccessControl = accessControl;
    }

    @Override
    public String toString() {
        return
            "Name: " + this.getUserName() + ", Level: " + this.getLevel()
                + ", " + this.getAccessControl().toString();
    }
}