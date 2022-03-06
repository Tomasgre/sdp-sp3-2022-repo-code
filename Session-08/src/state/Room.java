package state;

public class Room {
    protected Context context;
    protected String description;

    public Room(Context context, String description) {
        this.context = context;
        this.description = description;
    }

    // Override some of these methods:
    public void goNorth() {
        System.out.println("You can't go that way.");
    }

    public void goSouth() {
        System.out.println("You can't go that way.");
    }
}
