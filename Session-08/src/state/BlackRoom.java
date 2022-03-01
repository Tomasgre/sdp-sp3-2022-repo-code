package state;

public class BlackRoom extends Room {

    public BlackRoom(Context context) {
        super(context, "Everything in this room is black. There is a passage South.");
    }

    @Override
    public void goSouth() {
        System.out.println("You head through the passage.");
        Context.currentRoom = Context.whiteRoom;
    }
}
