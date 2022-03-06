package prototypepattern;

public class AccessControl implements Prototype {
    private String access;
    private String level;

    @Override
    public AccessControl clone() throws CloneNotSupportedException {
        AccessControl clonedAccessControl = null;
        clonedAccessControl = (AccessControl) super.clone();
        return clonedAccessControl;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Access Control Level:" + level + ", Access: " + access;
    }
}
