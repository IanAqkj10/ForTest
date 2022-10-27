package ClassDemo;

class X {
    Y y = new Y();

    public X() {
        System.out.print("ClassDemo.X");
    }
}

class Y {
    public Y() {
        System.out.print("ClassDemo.Y");
    }
}

public class Z extends X {
    Y y = new Y();

    public Z() {
        System.out.print("ClassDemo.Z");
    }

//    public static void main(String[] args) {
//        ArrayList<ClassDemo.Person> list = new ArrayList<>();
//        System.out.println(CollUtil.isEmpty(list));
//
//    }
}