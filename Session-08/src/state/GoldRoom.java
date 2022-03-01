package state;

public class GoldRoom extends Room {

    public GoldRoom(Context context) {
        super(context, "Everything here is made of gold. You feel rich.");
    }

    @Override
    public void goNorth() {
        System.out.println("You head back to the White room.");
        Context.currentRoom = Context.whiteRoom;
    }
}
