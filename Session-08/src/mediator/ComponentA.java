package mediator;

public class ComponentA extends Component {
    public Mediator mediator;
    // ^ public - don't do this :-)

    // extra data for the component

    // "Trigger" and "Handle" look like they could be part of an interface for
    // the Component class, but in general they could be any methods.

    // The point is, this object interacts with others purely through the Mediator!

    public void triggerA(String event) {
        System.out.println("Component A triggered: " + event);
        handleA(event);
        mediator.mediate(this, event + " from A");
    }

    public void handleA(String event) {
        System.out.println("Component A handles: " + event);
    }
}
