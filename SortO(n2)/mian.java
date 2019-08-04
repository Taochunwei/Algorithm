/**
 * @author Taochunwei
 * @date 2019/7/22 - 21:18
 */
import java.util.ArrayList;
public class mian {
    //选择排序
    public static void selectionSort(int arr[],int n){
        long starttime=System.nanoTime();
        for (int i = 0; i <n ; i++) {
            int MinIndex=i;
            for (int j = i+1; j < n; j++) {
                if(arr[j]<arr[MinIndex])
                    MinIndex=j;
            }
            int temp=arr[i];
            arr[i]=arr[MinIndex];
            arr[MinIndex]=temp;
        }
        long endtime=System.nanoTime();
        System.out.println("The selectionSort takes:  "+(endtime-starttime)/1000000000.0);
    }
    //插入排序
    public static void InsertSort(int arr[],int n){
        long starttime=System.nanoTime();

        for (int i = 1; i < arr.length; i++) {
            int temp=arr[i];
            int j;
            for(j=i;j>0&&arr[j-1]>temp;j--){
                arr[j]=arr[j-1];
            }
            arr[j]=temp;
        }

        long endtime=System.nanoTime();
        System.out.println("The InsertSort takes:  "+(endtime-starttime)/1000000000.0);
    }
    //希尔排序
    public static void shellSort(int[] arr){
        long starttime=System.nanoTime();
        int number=arr.length/2;
        while (number>=1){
            for (int i = 1; i < arr.length; i+=number) {
                int temp=arr[i];
                int j;
                for(j=i;j>0&&arr[j-1]>temp;j--){
                    arr[j]=arr[j-1];
                }
                arr[j]=temp;
            }
            number=number/2;
        }
        long endtime=System.nanoTime();
        System.out.println("The shellSort takes:  "+(endtime-starttime)/1000000000.0);
        }





    public static void main(String[] args) {
        int[] arr;
        SortTestHelper s=new SortTestHelper();

        arr=s.generateRandomArray(10000,0,100);
        int[] arr2=s.copyarr(arr);
        int[] arr3=s.copyarr(arr);
        //测试选择排序
        System.out.println(s.test(arr));
        selectionSort(arr,arr.length);
        System.out.println(s.test(arr));

        System.out.println();
        //s.printarr(arr);  //输出生成的随机数组
        //测试插入排序
        System.out.println(s.test(arr2));
        InsertSort(arr2,arr2.length);
        System.out.println(s.test(arr2));

        System.out.println();
        //测试希尔排序
        System.out.println(s.test(arr3));
        shellSort(arr3);
        System.out.println(s.test(arr3));
        //System.out.println();  //输出排序好的随机数组
        //s.printarr(arr);
    }
}
