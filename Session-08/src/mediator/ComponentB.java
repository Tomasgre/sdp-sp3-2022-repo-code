package mediator;

public class ComponentB extends Component {
    public Mediator mediator;

    public void triggerB(String event) {
        System.out.println("Component B triggered: " + event);
        handleB(event);
        mediator.mediate(this, event + " from B");
    }

    public void handleB(String event) {
        System.out.println("Component B handles: " + event);
    }
}
