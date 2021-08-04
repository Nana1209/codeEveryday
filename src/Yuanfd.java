import java.util.*;

public class Yuanfd {
    public static int boxCount(String s){
        /*int ans=0;
        Deque<Character> stack=new LinkedList<>();
        Deque<Integer> numstack=new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='['){
                numstack.addLast(0);
            }else if(s.charAt(i)==']'){
                int temp=1;
                if(i<s.length()-1 && s.charAt(i+1)>='2' && s.charAt(i+1)<='9'){
                    temp=Integer.parseInt(String.valueOf(s.charAt(i+1)));
                    i++;
                }
                numstack.addLast(numstack.removeLast()+temp);
                ans+=numstack.getLast();

            }
        }*/
//        return ans;
        return boxCount(s,0,s.length()-1);
    }
    public static int boxCount(String s,int start,int end){
        if(start>end) return 0;
        int ans=0;
        int left=start;
        while(left<=end){
            if(s.charAt(left)=='['){
                int right=left+1;
                while(s.charAt(right)!=']'){
                    right++;
                }
                int boxtemp=boxCount(s,left+1,right-1);
                int times=1;
                left=right+1;
                if(right+1<=end && s.charAt(right+1)>='2' && s.charAt(right+1)<='9'){
                    times=s.charAt(right+1)-'0';
                    left++;
                }
                ans=boxtemp*times+times;


            }
        }
        return ans;
    }
    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//
//        String s=sc.nextLine();

        System.out.println(boxCount("[][[][][]2]3"));

        /*Scanner sc=new Scanner(System.in);

        String snum=sc.nextLine();
        String[] sns=snum.split(" ");
        int[] nums=new int[sns.length];
        int[] numsSorted=new int[sns.length];
        List<Integer> ans=new ArrayList<>();
        for (int i = 0; i < sns.length; i++) {
            nums[i]=Integer.parseInt(sns[i]);
            numsSorted[i]=Integer.parseInt(sns[i]);
        }
        Arrays.sort(numsSorted);
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=numsSorted[i]){
                ans.add(i+1);
            }
        }
        System.out.println(ans.get(0)+" "+ans.get(1));*/
    }
}
