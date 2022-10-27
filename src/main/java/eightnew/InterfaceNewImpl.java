package eightnew;

public class InterfaceNewImpl implements InterfaceNew , InterfaceNew1{
    public static void main(String[] args) {
        InterfaceNewImpl interfaceNew = new InterfaceNewImpl();
        interfaceNew.def();
        InterfaceNew i1 = new InterfaceNewImpl();
        InterfaceNew1 i2 = new InterfaceNewImpl();
        i1.def();
        i1.def2();
        i2.def();
    }

    @Override
    public void def() {
        InterfaceNew1.super.def();
    }

    @Override
    public void f() {
    }
}
