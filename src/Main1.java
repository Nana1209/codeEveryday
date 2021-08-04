import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main1 {
    static int[] f;
    static void init(int n){
        f=new int[n];
        for (int i = 0; i < n; i++) {
            f[i]=i;
        }
    }
    static int find(int x){
        while(f[x]!=x){
            f[x]=f[f[x]];
            x=f[x];
        }
        return x;
    }
    static void union(int x,int y){
        f[find(x)]=find(y);
    }
    static boolean isConnected(int x,int y){
        return  find(x)==find(y);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] p=new int[n];
        for(int i=0;i<n;i++) {
            p[i] = sc.nextInt();
        }
        init(n+1);
        int m=sc.nextInt();
        Set<Integer> record =new HashSet<>();
        for (int i = 0; i < m; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            union(a,b);
        }
        int[] temp=new int[n];
        for (int i = 0; i < n; i++) {
            temp[i]=p[i];
        }
        Arrays.sort(temp);
        int ans=0;
        boolean flag=true;
        for (int i = 0; i < n; i++) {
            if(!isConnected(p[i],temp[i]) && p[i]!=temp[i]){
                ans++;
                union(p[i],temp[i]);
                flag=false;
            }
        }
        if(flag){
            System.out.println("YES");
        }else{
            System.out.println("NO");
            System.out.println(ans);
        }
    }
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int groupnum=sc.nextInt();
//        for(int i=0;i<groupnum;i++){
//            int n=sc.nextInt();
//            int maxindex=0;
//            double min= Double.MAX_VALUE;
//            for(int j=0;j<n;j++){
//                int x1= sc.nextInt();
//                int y1= sc.nextInt();
//                int x2= sc.nextInt();
//                int y2= sc.nextInt();
//                int s= sc.nextInt();
//                double price=s*(Math.sqrt((double)((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1))));
//                double temp=price/Math.abs(x2-x1);
//                if(temp<=min){
//                    maxindex=j;
//                    min=temp;
//                }
//            }
//            System.out.println(maxindex+1);
//        }
//        String s=sc.nextLine();
//    }
}
