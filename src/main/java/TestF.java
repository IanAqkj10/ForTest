/**
 * @author:IanJ
 * @date:2021/7/2 15:57
 */
public class TestF {

    private TestF() {
    }

    private static TestF instance = null;

    private static TestF getInstance() {
        if (instance == null) {
            synchronized (TestF.class) {
                if (instance == null) {
                    instance = new TestF();
                }
            }
        }
        return instance;
    }


    public static void main(String[] args) {

        TestF instance = TestF.getInstance();

        System.out.println(instance);
    }
}
