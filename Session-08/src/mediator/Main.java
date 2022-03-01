package mediator;

public class Main {
    public static void main(String[] args) {
        ComponentA cA = new ComponentA();
        ComponentB cB = new ComponentB();

        ForwardingMediator fm = new ForwardingMediator(cA, cB);
        BounceBackMediator bbm = new BounceBackMediator(cA, cB);

        System.out.println("A/B Events with a forwarding mediator:");
        cA.mediator = fm;
        cB.mediator = fm;
        cA.eventA("A event");
        cB.eventB("B event");

        System.out.println("A/B Events with a bounce-back mediator:");
        cA.mediator = bbm;
        cB.mediator = bbm;
        cA.eventA("A event");
        cB.eventB("B event");

    }
}
