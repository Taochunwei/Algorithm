/**
 * @author Taochunwei
 * @date 2019/8/6 - 15:22
 */

public class mian3 {
    //归并排序

    public static void main(String[] args) {
        Integer[] arr;
        SortTestHelper<Integer> s=new SortTestHelper<Integer>();
//
        Sort<Integer> sort=new Sort<Integer>();
        arr=s.generateRandomArray(10000,0,10);

        Integer[] arr2=s.copyarr(arr);
        Integer[] arr3=s.copyarr(arr);
        Integer[] arr4=s.copyarr(arr);

        //插入排序适合近乎有序的数组
        System.out.println(s.test(arr3));
        sort.InsertSort(arr3,arr3.length);
        System.out.println(s.test(arr3));

        System.out.println(s.test(arr4));
        sort.mergeSort(arr4,arr4.length);
        System.out.println(s.test(arr4));

        System.out.println(s.test(arr));
        sort.quickSort(arr,arr.length);
        System.out.println(s.test(arr));

        System.out.println(s.test(arr2));
        sort.quickSort3Ways(arr2,arr2.length);
        System.out.println(s.test(arr2));


//        System.out.println(s.test(arr2));
//        mergeSort(arr2,arr2.length);
//        System.out.println(s.test(arr2));
    }
}
