public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        var c = int.class;
        var c1 = String.class;
        var c2 = boolean.class;
        var c3 = byte.class;
        //System.out.println(c3);
        var c6 = Class.forName("[B");
        System.out.println(c6);
        byte[][] c7 = {{0,1,2,3}};
        //var c7 = new Byte[5][5];
        System.out.println(c7.getClass());
    }
}
