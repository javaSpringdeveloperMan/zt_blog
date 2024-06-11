/**
 * @description:
 * @className: 1111
 * @author: liuShun
 * @create: 2024/5/24 11:12
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = new int[1000];
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[j] = i;
                i++;
            }
        }
        //        for (int item : arr) {
        //            System.out.println(item);
        //        }
        int num = 60;
        int[] arr1 = new int[4];
        for (int i = 3; i < arr.length; i++) {
            if (arr[i] + arr[i - 1] + arr[i - 2] == num && arr[i] - arr[i - 1] == 1 && arr[i - 1] - arr[i - 2] == 1) {
                arr1 = new int[]{arr[i - 2], arr[i - 1], arr[i], num};
            }
            num++;
        }
        System.out.println("得到的四个数字:");
        for (int item1 : arr1) {
            System.out.print(item1 + "\t");
        }
    }
}
