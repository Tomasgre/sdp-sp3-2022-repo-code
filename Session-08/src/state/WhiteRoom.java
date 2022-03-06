package state;

public class WhiteRoom extends Room {

    public WhiteRoom(Context context) {
        super(context,
    "Everything in this room is white. There is a door to the South and a passage to the North.");
    }

    @Override
    public void goNorth() {
        System.out.println("You head through the passage.");
        Context.currentRoom = Context.blackRoom;
    }

    @Override
    public void goSouth() {
        // if (Context.playerHas("White key"))
        //      System.out.println("You unlock the door and step through.");
                Context.currentRoom = Context.goldRoom;
        // else
        //      System.out.println("The door is locked.);
        //      // no change to current room
    }
}
