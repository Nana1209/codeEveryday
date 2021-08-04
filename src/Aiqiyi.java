import java.util.*;

public class Aiqiyi {
    public static float increaseMax(int[] nums,int k){
        float ans=0f;
        float sum=0f;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        float preAvg=sum/k;
        int left=0,right=k;
        while(right<nums.length){
            sum+=nums[right];
            sum-=nums[left];
            float avgTemp=sum/k;
            ans=Math.max((avgTemp-preAvg)/preAvg,ans);
            preAvg=avgTemp;
            right++;
            left++;
        }
        return ans;
    }
    public static int[] solution(int[] input){
//        if(input)
        Set<Integer> fullLake=new HashSet<>();
        Deque<Integer> subQueue=new LinkedList<>();
        int[] ans=new int[input.length];
        for (int i = 0; i < input.length; i++) {
            if(input[i]==0){
                subQueue.addLast(i);

            }else{
                ans[i]=-1;
                if(fullLake.contains(input[i])){
                    if(subQueue.size()!=0){
                        int index=subQueue.removeFirst();
                        ans[index]=input[i];
                        fullLake.remove(input[i]);
                    }else{
                        return new int[0];
                    }
                }
//                else{
                    fullLake.add(input[i]);
//                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        if(s.length()<=2){
            System.out.println("[]");
            return;
        }
        String[] numstr=s.substring(1,s.length()-1).split(",");
//        String[] =inputs[0].split(",");
        int[] nums=new int[numstr.length];
        for (int i = 0; i < numstr.length; i++) {
            nums[i]=Integer.parseInt(numstr[i]);
        }

        int[] ans=solution(nums);
        if(ans.length==0){
            System.out.println("[]");
        }else{
            System.out.print('[');
            int i=0;
            for (; i < ans.length-1; i++) {
                System.out.print(ans[i]+",");
            }
            System.out.print(ans[i] + "]");
        }

    }
}
