/**
 * @author Taochunwei
 * @date 2019/7/22 - 21:36
 */
import java.util.Random;
public class SortTestHelper<E extends Comparable> {
    //生成随机数组int[]
    public Integer[] generateRandomArray(int n,int rangL,int rangR){
        if(rangL>=rangR)
            throw new IllegalArgumentException("Error");

        Random random=new Random();
        Integer[] ret=new Integer[n];
        for (int i = 0; i <n; i++) {
            ret[i]=(int)(rangL+(rangR-rangL)*random.nextFloat());
        }
        return ret;
    }
//生成一个近乎随机的Integer数组
    public Integer[] generateNearlyRandomArray(int n,int swaptime){
        Integer[] ret=new Integer[n];
        Random random=new Random();
        for (int i = 0; i <n ; i++) {
            ret[i]=i;
        }
        for (int i = 0; i < swaptime; i++) {
            int a=random.nextInt(n-1);
            int b=random.nextInt(n-1);
            int temp=ret[a];
            ret[a]=ret[b];
            ret[b]=temp;
        }
        return ret;
    }

//检测数组是否排序完成
    public boolean test(E[] arr){
        for (int i = 1; i <arr.length ; i++) {
            if(arr[i].compareTo(arr[i-1])<0)
                return false;
        }
        return true;
    }

//拷贝数组
    public Integer[] copyarr(Integer[] arr){
        Integer[] ret=new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ret[i]=arr[i];
        }
        return ret;
    }

//输出函数
    public void printarr(E[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"   ");
        }
        System.out.println();
    }


}
