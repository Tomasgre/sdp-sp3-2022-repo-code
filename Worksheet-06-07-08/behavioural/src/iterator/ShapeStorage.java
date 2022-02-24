package iterator;

public class ShapeStorage {

    private final int MAX_NUM_SHAPES = 5;
    Shape[] shapeStorage = new Shape[MAX_NUM_SHAPES];
    private int index = 0;

    public void addShape(String shapeName) {
        shapeStorage[index++] = new Shape(index, shapeName);
    }

    public Shape[] getShapes() {
        return shapeStorage;
    }
}