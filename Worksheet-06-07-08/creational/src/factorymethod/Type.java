package factorymethod;

public enum Type {
    VASE, BOWL, CUP, PLATE;

    @Override
    public String toString() {
        switch (this) {
            case VASE: return "Vase";
            case BOWL: return "Bowl";
            case CUP: return "Cup";
            case PLATE: return "Plate";
            default: return null;
        }
    }
}
