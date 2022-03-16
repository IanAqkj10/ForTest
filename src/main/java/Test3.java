/**
 * @author:IanJ
 * @date:2021/7/2 15:38
 */
public class Test3 implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("线程执行了...");
        }
    }

    public static void main(String[] args) {
        Test3 test3 = new Test3();

        Thread thread = new Thread(test3);
        thread.start();
        System.out.println("1231241414");
    }
}
