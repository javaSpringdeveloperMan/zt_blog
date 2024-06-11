/**
 * @description:
 * @className: 11
 * @author: liuShun
 * @create: 2024/5/23 16:44
 */
public class SanJiaoXing {

    public static void main(String[] args) {
        int n = 5;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
