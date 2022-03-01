package state;

public class Context {

    public static Context theContext = new Context();

    public static WhiteRoom whiteRoom = new WhiteRoom(theContext);
    public static BlackRoom blackRoom = new BlackRoom(theContext);
    public static GoldRoom goldRoom = new GoldRoom(theContext);

    public static Room currentRoom = whiteRoom;

    // Further context: E.g. could have list of player items; or counting number of steps taken

    private Context() {}

    public void goNorth() {
        currentRoom.goNorth();
    }

    public void goSouth() {
        currentRoom.goSouth();
    }
}
