package mediator;

public class BounceBackMediator implements Mediator {
    public ComponentA componentA;
    public ComponentB componentB;

    public BounceBackMediator(ComponentA cA, ComponentB cB) {
        this.componentA = cA;
        this.componentB = cB;
    }

    @Override
    public void notify(Component component, String params) {
        if (component == componentA) {
            componentA.responseA(params + " returned to sender");
        } else if (component == componentB) {
            componentB.responseB(params + " returned to sender");
        }
    }
}
