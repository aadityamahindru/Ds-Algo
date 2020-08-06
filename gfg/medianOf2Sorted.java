import java.util.*;

public class Main {

    public static void main(String[] args) {

        // write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr1[] = new int[n];
        int arr2[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }
        System.out.println(getMedian(arr1,arr2,0,n-1,0,n-1));
    }
    public static int getMedian(int a[],int b[],int st1,int ed1,int st2,int ed2){
        if(ed1-st1+1==2||ed2-st2+1==2){
            return (Math.max(a[st1],b[st2])+Math.min(a[ed1],b[ed2]))/2;
        }
        int m1=median(a,st1,ed1);
        int m2=median(b,st2,ed2);
        int mid1=(st1+ed1)/2;
        int mid2=(st2+ed2)/2;
        if(m1==m2){
            return m1;
        }else if(m1>m2){
            return getMedian(a,b,st1,mid1,mid2,ed2);
        }else{
            return getMedian(a,b,mid1,ed1,st2,mid2);
        }
    }
    public static int median(int arr[],int st,int ed){
        int n=ed-st+1;
        if(n%2==0){
            return (arr[st+n/2]+arr[st+(n-1)/2])/2;
        }else{
            return arr[st+n/2];
        }
    }
}