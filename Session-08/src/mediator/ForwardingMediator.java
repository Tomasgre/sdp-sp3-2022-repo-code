package mediator;

public class ForwardingMediator implements Mediator {
    public ComponentA componentA;
    public ComponentB componentB;

    public ForwardingMediator(ComponentA cA, ComponentB cB) {
        this.componentA = cA;
        this.componentB = cB;
    }

    @Override
    public void notify(Component component, String params) {
        if (component == componentA) {
            componentB.responseB("forwarded " + params);
        } else if (component == componentB) {
            componentA.responseA("forwarded " + params);
        }
    }
}
