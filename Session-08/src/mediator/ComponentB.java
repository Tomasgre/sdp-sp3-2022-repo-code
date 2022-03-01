package mediator;

public class ComponentB extends Component {
    public Mediator mediator;

    public void eventB(String event) {
        responseB(event);
        mediator.notify(this, event);
    }

    public void responseB(String event) {
        System.out.println("Component B responds to " + event);
    }
}
