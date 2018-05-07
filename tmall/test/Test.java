import java.util.Scanner;

/**
 * @Author: Jaye
 * @Description:
 * @Date:Created in 14:33 2018/5/4
 * @Modify By:
 */
public class Test {

//    static {
//
//        cnt = 6;
//        System.out.println("cnt = 6");
//    }
//    static int cnt = 100;
//    public static void main(String[] args){
//        System.out.println(cnt);
//    }
//    static {
//        cnt /= 2;
//        System.out.println("cnt: "+cnt);
//    }
    public static void main(String[] args){
//        int j = 0;
//        for (int i = 0; i < 10; i++) {
//            j = j++;
//        }
//        String s = "abc";
//        int j = s.length();
//        int i = "abc".length();
//        System.out.println(i);
//        System.out.println(j);
//        Scanner in = new Scanner(System.in);
//        if (in.hasNext()){
//            String s1 = in.next();
//            System.out.println(s1);
//        }
//        in.close();
        int i = 1;
        if (i++ == 2) {
            System.out.println(i);
            System.out.println(true);
        } else {
            System.out.println(i);
            System.out.println(false);
        }

        int num = 32;
        System.out.println(num >> 32);
    }
}
