import java.util.*;

public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int size=2;
        int [] result=new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    result[0]=i;
                    result[1]=j;
                }
            }
        }
        return result;
    }
    public int[] twoSum1(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }
    public static int[] sortByBits(int[] arr) {
        Arrays.sort(arr);
        int sum;
        //int[] result=new int[arr.length];
        HashMap<Integer, Object> bitsrecord = new HashMap<Integer, Object>();
        for(int num :arr){
            int numtemp=num;
            sum=0;
            while(numtemp!=0){
                if(numtemp%2==1){
                    sum++;
                }
                numtemp=numtemp/2;
            }
            if(bitsrecord.containsKey(sum)){
                ArrayList<Integer> temp= (ArrayList<Integer>) bitsrecord.get(sum);
                temp.add(num);
                bitsrecord.put(sum,temp);
            }else{
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(num);
                bitsrecord.put(sum,temp);
            }
        }
        ArrayList<Integer> keyset = new ArrayList<> (bitsrecord.keySet());
        Collections.sort(keyset);
        ArrayList<Integer> result=new ArrayList<>();
        for(int account:keyset){
            result.addAll((ArrayList<Integer>)bitsrecord.get(account));
        }
        int[] r=result.stream().mapToInt(Integer::valueOf).toArray();
        return r;
    }
    public int findMinArrowShots(int[][] points){
        if(points.length==0) return 0;
        int result=0;
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] >= point2[1]) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        int pos=points[0][1];
        result++;
        for(int[] bo:points){
            if(bo[0]>pos){
                pos=bo[1];
                result++;
            }

        }
        return result;
    }
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        ArrayList<TreeNode> nodelist=new ArrayList<>();
        int index=0;
        nodelist.add(root);
        while(nodelist.get(index).left!=null && nodelist.get(index).right!=null){
            nodelist.add(nodelist.get(index).left);
            nodelist.add(nodelist.get(index).right);
            index++;
        }
        if(nodelist.get(index).left!=null){
            nodelist.add(nodelist.get(index).left);
        }
        return  nodelist.size();

    }
    public static String sortString(String s) {
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        StringBuffer ret = new StringBuffer();
        while (ret.length() < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (num[i] > 0) {
                    ret.append((char) (i + 'a'));
                    num[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (num[i] > 0) {
                    ret.append((char) (i + 'a'));
                    num[i]--;
                }
            }
        }
        return ret.toString();

    }
    public static int reversePairs(int[] nums) {
        if(nums.length<2) return 0;
        int re=0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] > (long)2*nums[j]) {
                    re++;
                }
            }
        }
        return re;
    }
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for(int i=A.length-1;i>=2;i--){
            if(A[i - 1] + A[i - 2] > A[i]){
                return A[i - 1] + A[i - 2] + A[i];
            }
        }
        return 0;
    }
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        return null;
    }
    public static int[] kInArraytoMax(int[] nums, int k){

        int[] result=new int[k];
        if(nums.length==0 || k==0) return result;
        int top=-1;
        int drop=0;//丢弃数字的个数
        //result[top]=nums[0];//结果数组，单调栈
        int dropnums=nums.length-k;
        for(int i=0;i< nums.length;i++){
            while(top>=0 && drop<dropnums && result[top]<nums[i] ){
                top--;
                drop++;
            }
            if(top<k-1){
                top++;
                result[top]=nums[i];
            }else{
                drop++;
            }
        }
        return result;
    }
    public static void main(String[] args) throws Exception {
        int[] re=kInArraytoMax(new int[]{6,1,9,1,1,2},3);
        for(int i=0;i<re.length;i++){
            System.out.println(re[i]);
        }

        /*for(int i :sortByBits(new int[]{1024,512,256,128,64,32,16,8,4,2,1})){
            System.out.println(i);
        }*/
        /*System.out.println(sortString("aaaabbbbcccc"));*/
        /*int[] nums={2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        System.out.println(reversePairs(nums));*/
        /*int[] nums={3,2,4};
        System.out.println(twoSum(nums,6)[0]);
        System.out.println(twoSum(nums,6)[1]);*/
    }

}
