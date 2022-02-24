package memento;

public class Originator {
    CareTaker careTaker;
    private double x;
    private double y;
    private String lastUndoSavepoint;

    public Originator(double x, double y, CareTaker careTaker) {
        this.careTaker = careTaker;
        this.x = x;
        this.y = y;
        createSavepoint("INITIAL");
        setOriginatorState("INITIAL");
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void createSavepoint(String savepointName) {
        this.careTaker.saveMemento(new Memento(this.x, this.y), savepointName);
        setOriginatorState(savepointName);
    }

    public void undo() {
        Memento m = this.careTaker.getMemento(this.lastUndoSavepoint);
        this.x = m.getX();
        this.y = m.getY();
    }

    public void undo(String savepointName) {
        Memento m = this.careTaker.getMemento(savepointName);
        this.x = m.getX();
        this.y = m.getY();
        setOriginatorState(savepointName);
    }

    public void undoAll() {
        this.careTaker.clearSavepoints();
    }

    private void setOriginatorState(String savepointName) {
        this.lastUndoSavepoint = savepointName;
    }

    @Override
    public String toString() {
        return "X: " + x + ", Y: " + y;
    }
}