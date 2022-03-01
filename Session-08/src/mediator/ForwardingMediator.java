package mediator;

public class ForwardingMediator implements Mediator {

    private ComponentA componentA;
    private ComponentB componentB;

    public ForwardingMediator(ComponentA cA, ComponentB cB) {
        this.componentA = cA;
        this.componentB = cB;
    }

    @Override
    public void mediate(Component component, String params) {
        if (component == componentA) {
            componentB.handleB("forwarded " + params);
        } else if (component == componentB) {
            componentA.handleA("forwarded " + params);
        } else {
            System.out.println("Unidentified component");
        }
    }
}
