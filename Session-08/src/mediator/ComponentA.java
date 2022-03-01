package mediator;

public class ComponentA extends Component {
    public Mediator mediator;

    public void eventA(String event) {
        responseA(event);
        mediator.notify(this, event);
    }

    public void responseA(String event) {
        System.out.println("Component A responds to " + event);
    }
}
