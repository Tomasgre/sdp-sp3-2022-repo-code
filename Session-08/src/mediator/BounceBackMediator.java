package mediator;

public class BounceBackMediator implements Mediator {

    private ComponentA componentA;
    private ComponentB componentB;

    public BounceBackMediator(ComponentA cA, ComponentB cB) {
        this.componentA = cA;
        this.componentB = cB;
    }

    @Override
    public void mediate(Component component, String params) {
        if (component == componentA) {
            componentA.handleA(params + " returned to sender");
        } else if (component == componentB) {
            componentB.handleB(params + " returned to sender");
        } else {
            System.out.println("Unidentified component");
        }
    }
}
