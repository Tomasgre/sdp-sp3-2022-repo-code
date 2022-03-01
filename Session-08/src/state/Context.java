package state;

public class Context {
    // (Everything here is more-or-less a singleton... but it's not essential)

    public static Context theContext = new Context();

    public static WhiteRoom whiteRoom = new WhiteRoom(theContext);
    public static BlackRoom blackRoom = new BlackRoom(theContext);
    public static GoldRoom goldRoom = new GoldRoom(theContext);

    // A better implementation might create a collection of rooms (?)

    public static Room currentRoom = whiteRoom;

    // Further context: E.g. could have list of player items; or counting number of steps taken

    // Could have methods for picking up items, but it's more complicated

    private Context() {}

    public void goNorth() {
        currentRoom.goNorth();
    }

    public void goSouth() {
        currentRoom.goSouth();
    }
}
