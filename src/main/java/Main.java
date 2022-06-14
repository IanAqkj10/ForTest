import org.junit.Test;

import java.util.ArrayList;

/**
 * @Description:
 * @author:ljh
 * @date:2022/5/3 15:04
 */

public class Main {
    public static void main(String[] args) {
        Tc tc = new Tc("a",123);
        Tc tc1 = new Tc("b",12343);
        Tc tc2 = new Tc("c",342);

        Tc tc3 = new Tc("d",12314);

        ArrayList<Tc> tcs = new ArrayList<>();
        ArrayList<Tc> tcs2 = new ArrayList<>();
        tcs.add(tc);
        tcs.add(tc1);
        tcs.add(tc2);
        tcs2.add(tc);
        tcs2.add(tc2);
        tcs2.add(tc1);
        ArrayList<Tc> tcs3= new ArrayList<>();
        tcs3.add(tc3);


    }


    @Test
    public void ttt(){
       int a =1;
       int b = a++;
        System.out.println(b);

    }

    //0表示d1=d2,1表示d1大于d2, -1表示d1<d2
    public static int compare(double d1, double d2) {
        if (d1 < d2)
            return -1;
        if (d1 > d2)
            return 1;
        long thisBits = Double.doubleToLongBits(d1);
        long anotherBits = Double.doubleToLongBits(d2);

        return (thisBits == anotherBits ? 0 :
                (thisBits < anotherBits ? -1 :
                        1));
    }


    @Test
    public void tetttt() {
       int a  = 10 ;
       int b = 6 ;
        System.out.println(b%a);
        //嘿嘿
        //哈哈哈
        //喜喜

    }



}