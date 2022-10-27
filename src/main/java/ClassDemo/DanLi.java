package ClassDemo;

/**
 * @Description: 单例双边检测  懒汉式
 * @author:ljh
 * @date:2022/8/4 15:28
 */

public class DanLi {

    private static volatile DanLi DANLI = null;//volatile预防在多线程下防止指令重排 ，如果线程二在判断为不为空对象后访问，有可能访问到还没初始完成的对象

    private DanLi() {

    }

    public static DanLi getDanLi() {
        if (DANLI == null) {
            synchronized (DanLi.class) {
                if (DANLI == null) {
                    DANLI = new DanLi();
                }
            }
        }

        return DANLI;
    }

}