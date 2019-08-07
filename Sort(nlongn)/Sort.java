import java.util.Random;

/**
 * @author Taochunwei
 * @date 2019/8/7 - 9:30
 */
public class Sort<E extends Comparable> {
    private void swap(E[] arr,int i,int j){
        E temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    //插入排序
    //插入排序适合近乎有序的数组
    public  void InsertSort(E[] arr,int n){
        long starttime=System.nanoTime();

        for (int i = 1; i < arr.length; i++) {
             E temp=arr[i];
            int j;
            for(j=i;j>0&&arr[j-1].compareTo(temp)>0;j--){
                arr[j]=arr[j-1];
            }
            arr[j]=temp;
        }

        long endtime=System.nanoTime();
        System.out.println("The InsertSort takes:  "+(endtime-starttime)/1000000000.0);
    }
    //优化使用的插入排序
    private   void InsertSort(E[] arr,int l,int n){

        for (int i = l+1; i <=n; i++) {
            E temp=arr[i];
            int j;
            for(j=i;j>0&&arr[j-1].compareTo(temp)>0;j--){
                arr[j]=arr[j-1];
            }
            arr[j]=temp;
        }
    }
    //希尔排序
    public void shellSort(E[] arr){
        long starttime=System.nanoTime();
        int number=arr.length/2;
        while (number>=1){
            for (int i = 1; i < arr.length; i+=number) {
                E temp=arr[i];
                int j;
                for(j=i;j>0&&arr[j-1].compareTo(temp)>0;j--){
                    arr[j]=arr[j-1];
                }
                arr[j]=temp;
            }
            number=number/2;
        }
        long endtime=System.nanoTime();
        System.out.println("The shellSort takes:  "+(endtime-starttime)/1000000000.0);
    }
    //归并排序
    public void mergeSort(Integer[] arr,int n)//一个数组和数组的个数
    {
        long starttime=System.nanoTime();
        mergeSort(arr,0,n-1);
        long endtime=System.nanoTime();
        System.out.println("The mergeSort takes:  "+(endtime-starttime)/1000000000.0);
    }

    private void mergeSort(Integer[] arr,int l,int r)//arr[l……r]进行排序
    {
        if(l>=r)
            return;
        int mid=l+(r-l)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        if(arr[mid].compareTo(arr[mid+1])>0)
            merge(arr,l,mid,r);
    }
    //将arr的[l,mid]和[mid+1,r]进行归并
    private void merge(Integer[]arr,int l,int mid,int r){
        Integer aux[]=new Integer[r-l+1];


        for(int i=l;i<=r;i++){
            aux[i-l]=arr[i];
        }
        int i=l,j=mid+1;
        for(int k=l;k<=r;k++){
            if(i>mid){
                arr[k]=aux[j-l];
                j++;
            }
            else if(j>r){
                arr[k]=aux[i-l];
                i++;
            }
            else if((aux[i-l]).compareTo((aux[j-l]))<0){
                arr[k]=aux[i-l];
                i++;
            }
            else{
                arr[k]=aux[j-l];
                j++;
            }
        }

    }



    //快速排序
    public void quickSort(E[] arr,int n){
        long starttime=System.nanoTime();
        quickSort(arr,0,n-1);
        long endtime=System.nanoTime();
        System.out.println("The quickSort takes:  "+(endtime-starttime)/1000000000.0);
    }
    //对arr[r....l]的这一部分进行排序
    private void quickSort(E[] arr,int l,int r){
        if(r-l<=15){
            InsertSort(arr,l,r);
            return;
        }

        int p=partition(arr,l,r);
        quickSort(arr,l,p-1);
        quickSort(arr,p+1,r);
    }
    //返回值为p，[l....p-1]为小于arr[p],arr[p+1.....r]小于arr[p]
    private int partition(E[] arr,int l,int r){
        Random random = new Random();//默认构造方法
        int swap=random.nextInt((r-l))+l;
        E temp0=arr[swap];
        arr[swap]=arr[l];
        arr[l]=temp0;

        E v=arr[l];
        //arr[l+1...p-1]<v,arr[p+1...i)>v
        int j=l;
        //arr[l+1...j]<V,  arr[j+1....i)>=v
        for(int i=l+1;i<=r;i++){
            if(arr[i].compareTo(v)<0)
            {
                E temp=arr[j+1];
                arr[j+1]=arr[i];
                arr[i]=temp;
                j++;
            }
        }
        arr[l]=arr[j];
        arr[j]=v;
        return j ;
    }

    private int partition2(E[] arr,int l,int r){
        Random random = new Random();//默认构造方法
        int swap=random.nextInt((r-l))+l;
        E temp0=arr[swap];
        arr[swap]=arr[l];
        arr[l]=temp0;
        E v=arr[l];
//arr[l+1...i)<=v,  arr(j...r]>=v
        int i=l+1,j=r;
        while (true){
            while (i<=r&&arr[i].compareTo(v)<0) i++;
            while (j>=l+1&&arr[j].compareTo(v)>0) j--;
            if(i>j) break;
            E tij=arr[i];
            arr[i]=arr[j];
            arr[j]=tij;
            i++;
            j--;
        }
        E tij1=arr[i];
        arr[i]=arr[j];
        arr[j]=tij1;
        return j;
    }


    //三路排序（适合有大量重复元素的数组）
    public void quickSort3Ways(E[] arr,int n){
        long starttime=System.nanoTime();
        quickSort3Ways(arr,0,n-1);
        long endtime=System.nanoTime();
        System.out.println("quickSort3Ways takes:   "+(endtime-starttime)/1000000000.0+" s");
    }
    //三路快速排序处理 arr[l....r]
    //将arr[l...r]分为<v,==v,>v 的三个部分
    //递归对<v,和 >v 两个部分继续进行三路快速排序
    private void quickSort3Ways(E[] arr,int l,int r){
        if(r-l<=15){
            InsertSort(arr,l,r);
            return;
        }
        Random random=new Random();
        int swap=random.nextInt(r-l)+l;

        //partition
        E temp=arr[l];  arr[l]=arr[swap];   arr[swap]=arr[l];//交换arr[l]和arr[swap]
        E v=arr[l];

        int lt=l;//arr[l+1......lt]<v
        int gt=r+1;//arr[gt....r]>v
        int i=l+1;//arr[lt+1....i)==v
        while(i<gt){
            if(arr[i].compareTo(v)<0){
                swap(arr,lt+1,i);
                lt++;
                i++;
            }else if(arr[i].compareTo(v)>0){
                swap(arr,i,gt-1);
                gt--;
            }else{
                i++;
            }
        }
        swap(arr,l,lt);

        quickSort3Ways(arr,l,lt-1);
        quickSort3Ways(arr,gt,r);
    }


}
