import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public static boolean lemonadeChange(int[] bills) {
        int num5=0;
        int num10=0;
        for(int bill:bills){
            if(bill==5){
                num5++;
            }else if(bill==10) {
                num10++;
                if (num5 > 0) {
                    num5--;
                } else return false;
            }else {
                if(num5==0) return false;
                else {
                    if(num10>0){
                        num10--;
                        num5--;
                    }else if(num5>=3){
                        num5-=3;
                    }else return false;
                }
            }
        }
        return true;
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> nodes=new ArrayList<>();
        nodes.add(root.val);
        for(int i=0;i<nodes.size();i++){

        }

        return result;
    }
    public int findContentChildren(int[] g, int[] s) {
        int result=0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0,j=0;
        while(i<g.length && j<s.length){
            if(g[i]<=s[j]){
                i++;j++;
                result++;
            }else{
                j++;
            }
        }
        return result;
    }
    public static int lengthOfLongestSubstring(String s) {
        /*if(s.length()==1 || s.length()==0) return s.length();
        Map<Character,Integer> result=new HashMap<>();
        Map<Character, Integer> temp=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(temp.containsKey(s.charAt(i))){
                i=temp.get(s.charAt(i))+1;
                if(temp.size()>=result.size()){
                    result.clear();
                    result.putAll(temp);
                }
                temp.clear();
                temp.put(s.charAt(i),i);
            }else {
                temp.put(s.charAt(i),i);
            }
        }
        return result.size()>=temp.size()?result.size():temp.size();*/
        /*优化1
        if(s.length()==1 || s.length()==0) return s.length();
        int result=0;
        Map<Character, Integer> temp=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(temp.containsKey(s.charAt(i))){
                i=temp.get(s.charAt(i))+1;
                if(temp.size()>=result){
                    result=temp.size();
                }
                temp.clear();
                temp.put(s.charAt(i),i);
            }else {
                temp.put(s.charAt(i),i);
            }
        }
        return result>=temp.size()?result:temp.size();*/
        if(s.length()==1 || s.length()==0) return s.length();
        int result=0;
        int left=0;
        Map<Character, Integer> temp=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(temp.containsKey(s.charAt(i))){
                if(i-temp.get(s.charAt(i))==1){
                    if(temp.size()>=result){
                        result=temp.size();
                    }
                    temp.clear();
                    temp.put(s.charAt(i),i);
                    left=i;
                }else{
                    //i=temp.get(s.charAt(i))+1;
                    if(temp.size()>=result){
                        result=temp.size();
                    }
                    //temp.clear();
                    temp.put(s.charAt(i),i);
                }

            }else {
                temp.put(s.charAt(i),i);
            }
        }
        return result>=temp.size()?result:temp.size();
    }
    public static boolean isIsomorphic(String s, String t) {
        Map<Character,Character> dict=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(dict.containsKey(s.charAt(i))){
                if(dict.get(s.charAt(i))!=t.charAt(i)) return false;
            }else if(dict.containsValue(t.charAt(i))) return false;
            else {
                dict.put(s.charAt(i),t.charAt(i));
            }
        }
        return true;
    }
    public static String longestPalindrome(String s) {
        //动态规划
        String result="";
        int len=s.length();
        boolean[][] dp=new boolean[len][len];
        for(int l=0;l<len;l++){
            for(int i=0;i+l<len;i++){
                if(l==0){
                    dp[i][i+l]=true;
                }else if(l==1 ){
                    dp[i][i+l]=s.charAt(i)==s.charAt(i+l);
                }else{
                    dp[i][i+l]=dp[i+1][i+l-1] && s.charAt(i)==s.charAt(i+l);
                }
                if(dp[i][i+l] && l+1>result.length()){
                    result=s.substring(i,i+l+1);
                }
            }
        }
        return result;
    }
    public String longestPalindrome1(String s) {
        //中心扩散
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        //递归
        List<Integer> result=new ArrayList<>();
        if(root!=null)
            middleTraversal(result,root);
        return result;
    }

    private void middleTraversal(List<Integer> result, TreeNode root) {
        //递归
        if(root.left==null && root.right==null){
            result.add(root.val);
        }else if(root.left!=null && root.right!=null){
            middleTraversal(result,root.left);
            result.add(root.val);
            middleTraversal(result,root.right);
        }else if(root.left==null){
            result.add(root.val);
            middleTraversal(result,root.right);
        }else {
            middleTraversal(result,root.left);
            result.add(root.val);
        }
    }
    public List<Integer> inorderTraversal1(TreeNode root) {
        //非递归
        List<Integer> result=new ArrayList<>();
        Deque<TreeNode> stack=new LinkedList<>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.addLast(root);
                root=root.left;
            }
            root=stack.pollLast();
            result.add(root.val);
            root=root.right;

        }
        return result;
    }
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> re=new ArrayList<>();
        if(s.length()<3) return re;

        char c=s.charAt(0);
        int i=1,start=0,end=0;
        while(i<s.length()){
            if(s.charAt(i)==c){
                end=i;

            }else{
                if(end-start>=2){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(start);
                    temp.add(end);
                    re.add(temp);

                }
                start=i;
                end=i;
                c=s.charAt(i);
            }
            i++;
        }
        return re;
    }
    public static int findCircleNum(int[][] isConnected) {
        Map<Integer,Integer> record=new HashMap<>();
        int result=0;
        for(int i=0;i<isConnected.length;i++){
            record.put(i,-1);
        }
        for(int city:record.keySet()){
            if(record.get(city)==-1){
                Deque<Integer> shen=new LinkedList<>();
                result++;
                shen.addLast(city);
                while(!shen.isEmpty()){
                    int targetcity=shen.poll();
                    record.put(targetcity,result);
                    for(int j=0;j<isConnected.length;j++){
                        if(j!=targetcity && isConnected[targetcity][j]==1 && record.get(j)==-1){
                            shen.addLast(j);
                            record.put(j,result);
                        }
                    }
                }
            }
        }
        return result;
    }
    public int[][] transpose(int[][] A) {
        int n=A.length;
        int m=A[0].length;
        int[][] result=new int[m][n];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                result[j][i]=A[i][j];
            }
        }
        return result;
    }
    public ListNode[] listOfDepth(TreeNode tree) {
        //结点值不唯一时没有实现，因为层级是按结点值为key值存储的
        List<List<Integer>> result=new ArrayList<>();
        Deque<TreeNode> queue=new LinkedList<>();
        Map<Integer,Integer> nodeLevel=new HashMap<>();
        queue.addLast(tree);
        nodeLevel.put(tree.val,0);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(result.size()==nodeLevel.get(node.val)){
                List<Integer> temp=new ArrayList<>();
                temp.add(node.val);
                result.add(temp);
            }else{
                result.get(nodeLevel.get(node.val)).add(node.val);
            }
            if(node.left!=null){
                queue.addLast(node.left);
                nodeLevel.put(node.left.val,nodeLevel.get(node.val)+1);
            }
            if(node.right!=null){
                queue.addLast(node.right);
                nodeLevel.put(node.right.val,nodeLevel.get(node.val)+1);
            }
        }
        int n=result.size();
        ListNode[] r=new ListNode[n];
        for(int i=0;i<n;i++){
            ListNode root=new ListNode(result.get(i).get(0));
            if(result.get(i).size()>0){
                ListNode p=root;
                for(int j=1;j<result.get(i).size();j++){
                    ListNode temp=new ListNode(result.get(i).get(j));
                    p.next=temp;
                    p=temp;
                }
            }
            r[i]=root;

        }
        return r;
    }
    public static List<String> summaryRanges(int[] nums) {
        List<String> re=new ArrayList<>();
        if(nums.length==0){
            return re;
        }else  if(nums.length==1){
            String s=String.valueOf(nums[0]);
            re.add(s);
            return re;
        }else{
            int start=nums[0];
            int end=start;
            String s=String.valueOf(start);
            for(int i=1;i<nums.length;i++){
                if(nums[i]==end+1){
                    end=nums[i];
                }else{
                    if(start==end){
                        //String s=String.valueOf(start);
                        re.add(s);
                    }else {
                        s+="->"+ end;
                        re.add(s);
                    }
                    start=nums[i];
                    end=start;
                    s=String.valueOf(start);
                }
            }
            if(start==end){
                s=String.valueOf(start);
                re.add(s);
            }else {
                s= start +"->"+ end;
                re.add(s);
            }
            return re;
        }

    }
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs.size() == 0) {
            return s;
        }

        // 第 1 步：将任意交换的结点对输入并查集
        int len = s.length();
        UnionFind unionFind = new UnionFind(len);
        for (List<Integer> pair : pairs) {
            int index1 = pair.get(0);
            int index2 = pair.get(1);
            unionFind.union(index1, index2);
        }

        // 第 2 步：构建映射关系
        char[] charArray = s.toCharArray();
        // key：连通分量的代表元，value：同一个连通分量的字符集合（保存在一个优先队列中）
        Map<Integer, PriorityQueue<Character>> hashMap = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            int root = unionFind.find(i);
//            if (hashMap.containsKey(root)) {
//                hashMap.get(root).offer(charArray[i]);
//            } else {
//                PriorityQueue<Character> minHeap = new PriorityQueue<>();
//                minHeap.offer(charArray[i]);
//                hashMap.put(root, minHeap);
//            }
            // 上面六行代码等价于下面一行代码，JDK 1.8 以及以后支持下面的写法
            hashMap.computeIfAbsent(root, key -> new PriorityQueue<>()).offer(charArray[i]);
        }

        // 第 3 步：重组字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int root = unionFind.find(i);
            stringBuilder.append(hashMap.get(root).poll());
        }
        return stringBuilder.toString();
    }
    /*public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,String> emails=new HashMap<>();
        List<List<String>> result=new ArrayList<>();
        for(int i=0;i<accounts.size();i++){
            boolean contained=false;
            for(int j=1;j<accounts.get(i).size();j++){

                if(emails.containsKey(accounts.get(i).get(j))){
                    String name=accounts.get(i).get(0);
                    for(int p=0;p<result.size();p++){
                        if(result.get(p).get(0).equals(name)){
                            for(int q=1;q<result.get(p).size();q++){
                                if(result.get(p).get(q).equals(accounts.get(i).get(j))){
                                    result.get(p)
                                }
                            }
                        }
                    }
                    continue;
                }else{
                    emails.put(accounts.get(i).get(j),accounts.get(i).get(0));
                }
            }
            result.add(accounts.get(i));
        }
    }*/
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<(n-1)){
            return -1;
        }
        UnionFind uf=new UnionFind(n);
        Map<Integer,Integer> cons=new HashMap<>();
        for(int i=0;i<connections.length;i++){
            uf.union(connections[i][0],connections[i][1]);
        }
        for(int i=0;i<n;i++){
            if(!cons.containsKey(uf.find(i))){
                cons.put(uf.find(i),1);
            }
        }
        return cons.size()-1;
    }
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length<2){
            return nums.length;
        }
        int pre=nums[0];
        int re=1;
        int asc=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>pre){
                asc++;

            }else{
                re=asc>=re?asc:re;
                asc=1;
            }
            pre=nums[i];
        }
        re=asc>=re?asc:re;
        return re;
    }
    public int regionsBySlashes(String[] grid) {
        int N=grid.length;
        UnionFind uf =new UnionFind(4*N*N);
        for(int i=0;i<N;i++){
            char[] row = grid[i].toCharArray();
            for(int j=0;j<N;j++){
                int index=(i*N+j)*4;
                if(row[j]=='/'){
                    uf.union(index+0,index+3);
                    uf.union(index+1,index+2);
                }else if(row[j]=='\\'){
                    uf.union(index+0,index+1);
                    uf.union(index+3,index+2);
                }else{
                    uf.union(index+0,index+1);
                    uf.union(index+2,index+1);
                    uf.union(index+3,index+2);
                }
                if(j<N-1){
                    uf.union((i*N+j)*4+1,(i*N+j+1)*4+3);
                }
                if(i<N-1){
                    uf.union((i*N+j)*4+2,((i+1)*N+j)*4);
                }
            }
        }
        Map<Integer,Integer> cons=new HashMap<>();
        for(int i=0;i<4*N*N;i++){
            if(!cons.containsKey(uf.find(i))){
                cons.put(uf.find(i),1);
            }
        }
        return cons.size();
    }
    public static int numEquivDominoPairs(int[][] dominoes) {
        /*Map<Integer,Integer> dos=new HashMap<>();
        for(int i =0;i<dominoes.length;i++){
            int key=dominoes[i][0]<=dominoes[i][1]?dominoes[i][0]*10+dominoes[i][1]:dominoes[i][1]*10+dominoes[i][0];
            if(!dos.containsKey(key)){
                dos.put(key,1);
            }else {
                dos.put(key,dos.get(key)+1);
            }
        }
        int sum=0;
        for(int i :dos.keySet()){
            if(dos.get(i)>=2){
                sum+=dos.get(i)*(dos.get(i)-1)/2;
            }
        }
        return sum;*/
        Map<Integer,Integer> dos=new HashMap<>();
        int sum=0;
        for(int i =0;i<dominoes.length;i++){
            int key=dominoes[i][0]<=dominoes[i][1]?dominoes[i][0]*10+dominoes[i][1]:dominoes[i][1]*10+dominoes[i][0];
            if(!dos.containsKey(key)){
                dos.put(key,1);

            }else {
                sum+=dos.get(key);
                dos.put(key,dos.get(key)+1);
            }
        }
        return sum;
    }
    public static int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind uf=new UnionFind(n);
        int re=0;
        for(int i=0;i<edges.length;i++){
            if(edges[i][0]==3){
                if(uf.find(edges[i][1]-1)==uf.find(edges[i][2]-1)){
                    re++;
                }else {
                    uf.union(edges[i][1]-1,edges[i][2]-1);
                }
            }
        }
        int[] p=new int[n];
        System.arraycopy(uf.getParent(),0,p,0,n);
        UnionFind uf1=new UnionFind(p);
        for(int i=0;i<edges.length;i++){
            if(edges[i][0]==1){
                if(uf.find(edges[i][1]-1)==uf.find(edges[i][2]-1)){
                    re++;
                }else {
                    uf.union(edges[i][1]-1,edges[i][2]-1);
                }
            }else if(edges[i][0]==2){
                if(uf1.find(edges[i][1]-1)==uf1.find(edges[i][2]-1)){
                    re++;
                }else {
                    uf1.union(edges[i][1]-1,edges[i][2]-1);
                }
            }
        }
        int pa=uf.find(0);
        int pa1=uf1.find(0);
        for(int i=0;i<n;i++){
            if(uf.find(i)!=pa || uf1.find(i)!=pa1){
                re=-1;
            }
        }
        return re;


    }
    public int pivotIndex(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int leftsum=0;
        for(int i=0;i<nums.length;i++){
            if(2*leftsum+nums[i]==sum){
                return i;
            }else{
                leftsum+=nums[i];
            }
        }
        return -1;
    }
    public static int minimumEffortPathdp(int[][] heights) {
        return effortMoveto(0,0,heights.length-1,heights[0].length-1,heights);
    }
    public static int effortMoveto(int si, int sj, int ei, int ej, int[][] heights){
        if(si==ei && Math.abs(sj-ej)==1 || sj==ej && Math.abs(si-ei)==1){
            return Math.abs(heights[si][sj]-heights[ei][ej]);
        }else{
            int up=0,down=0,left=0,right=0;
            List<Integer> l=new ArrayList<>();
            if(ei>0){
                up=effortMoveto(si,sj,ei-1,ej,heights)>Math.abs(heights[ei-1][ej]-heights[ei][ej])?effortMoveto(si,sj,ei-1,ej,heights):Math.abs(heights[ei-1][ej]-heights[ei][ej]);
                l.add(up);
            }
            if(ei<heights.length-1){
                down=effortMoveto(si,sj,ei+1,ej,heights)>Math.abs(heights[ei+1][ej]-heights[ei][ej])?effortMoveto(si,sj,ei+1,ej,heights):Math.abs(heights[ei+1][ej]-heights[ei][ej]);
                l.add(down);
            }
            if(ej>0){
                left=effortMoveto(si,sj,ei,ej-1,heights)>Math.abs(heights[ei][ej-1]-heights[ei][ej])?effortMoveto(si,sj,ei,ej-1,heights):Math.abs(heights[ei][ej-1]-heights[ei][ej]);
                l.add(left);
            }
            if(ej<heights[0].length-1){
                right=effortMoveto(si,sj,ei,ej+1,heights)>Math.abs(heights[ei][ej+1]-heights[ei][ej])?effortMoveto(si,sj,ei,ej+1,heights):Math.abs(heights[ei][ej+1]-heights[ei][ej]);
                l.add(right);
            }
            return Collections.min(l);
        }
    }
    public int minimumEffortPath(int[][] heights) {
        List<int[]> edges=new ArrayList<>();
        int n=heights.length;
        int m=heights[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int index=i*m+j;
                if(i>0){
                    int[] edge=new int[3];
                    edge[0]=index-m;
                    edge[1]=index;
                    edge[2]=Math.abs(heights[i][j]-heights[i-1][j]);
                    edges.add(edge);
                }
                if(j>0){
                    int[] edge=new int[3];
                    edge[0]=index-1;
                    edge[1]=index;
                    edge[2]=Math.abs(heights[i][j]-heights[i][j-1]);
                    edges.add(edge);
                }
            }

        }
        Collections.sort(edges, new Comparator<int[]>() {
            public int compare(int[] edge1, int[] edge2) {
                return edge1[2] - edge2[2];
            }
        });
        UnionFind uf=new UnionFind(n*m);
        int r=0;
        for(int[] edge:edges){
            r=edge[2];
            uf.union(edge[0],edge[1]);
            if(uf.connected(0,n*m-1)){
                return r;
            }
        }
        return r;


    }
    public int numSimilarGroups(String[] strs) {
        UnionFind uf=new UnionFind(strs.length);
        for(int i=0;i<strs.length-1;i++){
            for(int j=i+1;j<strs.length;j++){
                if(uf.find(i)!=uf.find(j)){
                    if(isSimilar(strs[i],strs[j])){
                        uf.union(i,j);
                    }
                }
            }
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            int fa=uf.find(i);
            if(!map.containsKey(fa)){
                map.put(fa,1);
            }
        }
        return map.size();
    }
    public boolean isSimilar(String str1,String str2){
        int sum=0;
        List<Character> cs=new ArrayList<>();
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)!=str2.charAt(i)){
                sum++;
                if(sum==3) return false;
                cs.add(str1.charAt(i));
                cs.add(str2.charAt(i));
            }
        }
        if(sum==0) return true;
        if(cs.get(0)==cs.get(3) && cs.get(1)==cs.get(2)){
            return true;
        }else{
            return false;
        }
    }
    public int[] fairCandySwap(int[] A, int[] B) {
        Map<Integer,Integer> map=new HashMap<>();
        int sumA=0,sumB=0;
        for(int b : B){
            map.put(b,1);
            sumB+=b;
        }
        for(int a:A){
            sumA+=a;
        }
        for(int a:A){
            int aa=(sumB-sumA)/2+a;
            if(map.containsKey(aa)){
                return new int[]{a,aa};
            }
        }
        return null;
    }
    public String replaceSpace(String s) {
        return s.replace(" ","%20");
    }
    public int characterReplacement(String s, int k) {
        int[] records=new int[26];
        int left=0,right=0;
        int n=s.length();
        int maxn=0;
        while(right<n){
            records[s.charAt(right)-'A']++;
            maxn=Math.max(records[s.charAt(right)],maxn);
            if(right-left+1-maxn>k){
                records[s.charAt(left++)-'A']--;
            }
            right++;
        }
        return right-left;
    }
    public static double findMaxAverage(int[] nums, int k) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        int sumtemp=sum;
        for(int i=k,j=0;i<n;i++,j++){
            sumtemp=sumtemp+nums[i]-nums[j];
            sum=sumtemp>=sum?sumtemp:sum;
        }
        return (double)sum/k;
    }
    public int equalSubstring(String s, String t, int maxCost) {
        int right=0,left=0;
        int n=s.length();
        int cost=0;
        while(right<n){
            if(cost+Math.abs(s.charAt(right)-t.charAt(right))<=maxCost){
                cost+=Math.abs(s.charAt(right)-t.charAt(right));
                right++;
            }else{
                cost=cost+Math.abs(s.charAt(right)-t.charAt(right))-Math.abs(s.charAt(left)-t.charAt(left));
                right++;left++;
            }
        }
        return right-left;
    }
    public static int maxScore(int[] cardPoints, int k) {
        int sumtemp=0,min=0,n=cardPoints.length;
        int sum=0;
        int left=0,right=n-k;
        for(int i=0;i<right;i++){
            sumtemp+=cardPoints[i];
        }
        min=sumtemp;
        sum=sumtemp;
        while(right<n){
            sum+=cardPoints[right];
            sumtemp=sumtemp-cardPoints[left]+cardPoints[right];
            min=sumtemp<=min?sumtemp:min;
            left++;
            right++;
        }
        return sum-min;
    }
    public int maxScoreInArea(int[] cardPoints, int k,int start,int end){
        if(k>1){
            if(cardPoints[start]>cardPoints[end]){
                return cardPoints[start]+maxScoreInArea(cardPoints,k-1,start+1,end);
            }
        }
        return 0;
    }
    public boolean checkPossibility(int[] nums) {
        int n=nums.length;
        int numtemp=nums[0];
        int k=1;
        for(int i=0;i<n;i++){
            if(nums[i]<numtemp){
                k--;
                if(k<0) return false;
            }
            numtemp=nums[i];
        }
        return true;
    }
    public int subarraysWithKDistinct(int[] A, int K) {
        return mostSubarrays(A,K)-mostSubarrays(A,K-1);
    }

    public int mostSubarrays(int[] a, int k) {
        int n=a.length;
        int[] pre=new int[n+1];
        int left=0,right=0;
        int count=0;
        int re=0;
        while(right<n){
            if(pre[a[right]]==0){
                count++;
            }
            pre[a[right]]++;
            right++;
            while(count>k){

                pre[a[left]]--;
                if(pre[a[left]]==0){
                    count--;
                }
                left++;
            }
            re+=right-left;

        }
        return re;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> re=new ArrayList<>();
        if(rowIndex>4){
            if((rowIndex+1)%2==0){
                int n=rowIndex/2;
                for(int i=0;i<=n;i++){
                    re.add(yanghuiAngle(rowIndex,i));
                }
                for(int i=n;i>=0;i++){
                    re.add(re.get(i));
                }
            }else{
                int n=rowIndex/2;
                for(int i=0;i<=n;i++){
                    re.add(yanghuiAngle(rowIndex,i));
                }
                for(int i=n-1;i>=0;i++){
                    re.add(re.get(i));
                }
            }
        }else{
            for(int i=0;i<=rowIndex;i++){
                re.add(yanghuiAngle(rowIndex,i));
            }
        }

        return re;
    }

    private static Integer yanghuiAngle(int rowIndex, int i) {
        if(rowIndex<2 || i==0 || i==rowIndex){
            return 1;
        }else{
            return yanghuiAngle(rowIndex-1,i)+yanghuiAngle(rowIndex-1,i-1);
        }
    }
    public int minSwapsCouples(int[] row) {
        int n=row.length/2;
        UnionFind uf=new UnionFind(n);
        for(int i=0;i<n;i++){
            int n1=row[i*2]/2;
            int n2=row[i*2+1]/2;
            if(n1!=n2){
                uf.union(n1,n2);
            }
        }
        Map<Integer,Integer> count=new HashMap<>();
        for(int i=0;i<n;i++){
            int f=uf.find(i);
            if(count.containsKey(f)){
                count.put(f,count.get(f)+1);
            }else{
                count.put(f,0);
            }

        }
        int re=0;
        for(int i:count.keySet()){
            re+=count.get(i);
        }
        return  re;
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[Math.abs(nums[i])-1]=-Math.abs(nums[Math.abs(nums[i])-1]);
        }
        List<Integer> re=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                re.add(i+1);
            }
        }
        return re;
    }
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int re=0;
        for(int i=0;i<nums.length-1;i=i+2){
            re+=nums[i];
        }
        return re;
    }
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int n=nums.length;
        int m=nums[0].length;
        if(n*m != r*c){
            return nums;
        }else{
            int[][] re =new int[r][c];
            int ir=0,ic=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    re[ir][ic]=nums[i][j];
                    if(ir==r-1){
                        ir=0;
                        ic++;
                    }else{
                        ir++;
                    }
                }
            }
            return re;
        }
    }
    public int longestOnes(int[] A, int K) {
        int n=A.length;
        int l=0,r=0;
        int zero=0;
        int re=0;
        while(r<n){
            if(A[r]==0){
                zero++;
            }
            while(zero>K){
                if(A[l]==0){
                    zero--;
                }
                l++;

            }
            r++;
            re=Math.max(re,r-l);
        }
        return re;

    }
    public int findShortestSubArray(int[] nums) {
        int n=nums.length;
        Map<Integer,List<Integer>> record=new HashMap<>();
        for(int i=0;i<n;i++){
            if(record.containsKey(nums[i])){
                List<Integer> recordtemp=record.get(nums[i]);
                recordtemp.add(i);
                record.put(nums[i],recordtemp);
            }else{
                List<Integer> recordtemp=new ArrayList<>();
                recordtemp.add(i);
                record.put(nums[i],recordtemp);
            }
        }
        int mostnum=record.get(nums[0]).size();
        int min=n;
        for(int num:record.keySet()){
            List<Integer> temp=record.get(num);
            if(temp.size()>mostnum){
                mostnum=temp.size();
                min=temp.get(mostnum-1)-temp.get(0)+1;
            }else if(temp.size()==mostnum){
                int length=temp.get(mostnum-1)-temp.get(0)+1;
                min=length<=min?length:min;
            }
        }
        return min;
    }
    public int longestSubarray(int[] nums, int limit) {
        int n=nums.length;
        int left=0,right=0;
        TreeMap<Integer,Integer> record=new TreeMap<>();
        int re=0;
        while (right<n){
            record.put(nums[right],record.getOrDefault(nums[right],0)+1);
            right++;
            while(record.lastKey()-record.firstKey()>limit){
                record.put(nums[left],record.get(nums[left])-1);
                if(record.get(nums[left])==0){
                    record.remove(nums[left]);
                }
                left++;
            }
            re=Math.max(re,right-left);
        }
        return re;
    }
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        for(int i=0;i<n;i++){
            int num=matrix[0][i];
            int index=1;
            while(index<m && index+i<n){
                if(matrix[index][i+index]!=num) return false;
                index++;
            }
        }
        for(int j=1;j<m;j++){
            int num=matrix[j][0];
            int index=0;
            while(index<n && index+j<m){
                if(matrix[index+j][index]!=num) return false;
                index++;
            }
        }
        return true;
    }
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int n=customers.length;
        int sumnormal=0;
        for(int i=0;i<n;i++){
            sumnormal+=grumpy[i]==0?customers[i]:0;
        }
        for(int i=0;i<X;i++){
            sumnormal+=grumpy[i]==1?customers[i]:0;
        }
        int temp=sumnormal;
        for(int left=1,right=X;right<n;left++,right++){
            temp-=grumpy[left-1]==1?customers[left-1]:0;
            temp+=grumpy[right]==1?customers[right]:0;
            /*if(grumpy[left-1]==1){
                temp-=customers[left-1];
            }
            if(grumpy[right]==1){
                temp+=customers[right];
            }*/
            sumnormal=Math.max(sumnormal,temp);
        }
        return sumnormal;

    }
    public static int[][] flipAndInvertImage(int[][] A) {
        int m=A.length;
        int n=A[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n/2;j++){
                int temp=A[i][j];
                A[i][j]=Math.abs(A[i][n-1-j]-1);
                A[i][n-1-j]=Math.abs(temp-1);
            }
            if(n%2==1){
                A[i][n/2]=Math.abs(A[i][n/2]-1);
            }
        }
        return A;

    }
    public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> re=new ArrayList<>();
        for(String p:puzzles){
            Map<Character,Integer> record=new HashMap<>();
            for(int i=0;i<p.length();i++){
                record.put(p.charAt(i),0);
            }
            int sum=0;
            for(String word:words){
                boolean containF=false;
                boolean containA=true;
                for(int i=0;i<word.length();i++){
                    if(!record.containsKey(word.charAt(i))) {
                        containA=false;
                        break;
                    }else{
                        containF=word.charAt(i)==p.charAt(0)?true:containF;
                    }
                }
                if(containF && containA) sum++;
            }
            re.add(sum);
        }
        return re;
    }
    public int longestSubstring(String s, int k) {
        int n=s.length();
        Map<Character,Integer> record=new HashMap<>();
        int left=0,right=0;
        while(right<n){

        }
        return 0;
    }
    public boolean isMonotonic(int[] A) {
            boolean inc = true, dec = true;
            int n = A.length;
            for (int i = 0; i < n - 1; ++i) {
                if (A[i] > A[i + 1]) {
                    inc = false;
                }
                if (A[i] < A[i + 1]) {
                    dec = false;
                }
            }
            return inc || dec;

    }
    public int[] countBits(int num) {
        int[] re=new int[num+1];
        int high=0;
        re[0]=0;
        for(int i=1;i<=num;i++){
            high=(i&(i-1))==0?i:high;
            re[i]=re[i-high]+1;
        }
        return re;
    }
    public static int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]=1;
        for(int i=1;i<nums.length;i++){
            int max=1;
            for(int j=0;j<i;j++){
                max=(nums[j]<nums[i] && (dp[j]+1)>=max)?dp[j]+1:max;
            }
            dp[i]=max;
        }
        int re=dp[0];
        for(int i=0;i<dp.length;i++){
            re=dp[i]>=re?dp[i]:re;
        }
        return re;
    }
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int[] dp=new int[envelopes.length];
        dp[0]=1;
        int re=dp[0];
        for(int i=1;i<envelopes.length;i++){
            int max=1;
            for(int j=0;j<i;j++){
                max=(envelopes[j][0]!=envelopes[i][0] && envelopes[j][1]<envelopes[i][1] && (dp[j]+1)>=max)?dp[j]+1:max;
            }
            dp[i]=max;
            re=dp[i]>=re?dp[i]:re;
        }
        return re;
    }
    public int[] nextGreaterElements(int[] nums) {
        if(nums.length<=1){
            int[] re=new int[]{-1};
            return re;
        }
        int[] numsort=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            numsort[i]=nums[i];
        }
        Arrays.sort(numsort);
        if(numsort[0]==numsort[nums.length-1]){
            int[] re=new int[nums.length];
            for(int i=0;i<nums.length;i++){
                re[i]=-1;
            }
            return  re;
        }
        Map<Integer,Integer> record=new HashMap<>();
        for(int i=1;i<numsort.length;i++){
            int index=i-1;
            while(numsort[i]==numsort[index]){
                i++;
            }
            record.put(numsort[index],numsort[i]);

        }
        record.put(numsort[nums.length-1],-1);
        int[] re=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            re[i]=record.get(nums[i]);

        }
        return re;
    }
    public static int minCut(String s) {
        int n=s.length();
        boolean[][] ishuiwen=new boolean[s.length()][s.length()];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                ishuiwen[i][j]=true;
        }
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                ishuiwen[i][j]=s.charAt(i)==s.charAt(j) && ishuiwen[i+1][j-1];
            }
        }
        int[] cuttimes=new int[n];
        for(int i=0;i<n;i++){
            if(ishuiwen[0][i]){
                cuttimes[i]=0;
            }else{
                int min=Integer.MAX_VALUE;
                for(int j=0;j<i;j++){
                    if(ishuiwen[j+1][i]){
                        min=Math.min(min,cuttimes[j]+1);
                    }
                }
                cuttimes[i]=min;
            }
        }
        return cuttimes[n-1];
    }
    public static String removeDuplicates(String S) {
        StringBuffer stack=new StringBuffer();
        int top=-1;
        for(int i=0;i<S.length();i++){
            if(top>=0 && S.charAt(i)== stack.charAt(top)){
                stack.deleteCharAt(top--);
            }else {
                stack.append(S.charAt(i));
                top++;
            }
        }

        return  stack.toString();
    }
    public static int calculate(String s) {
        Deque<Integer> stack=new LinkedList<>();
        stack.addFirst(1);
        int sigh=stack.getFirst();
        int i=0,n=s.length();
        int re=0;
        while(i<n){
            if(s.charAt(i)==' '){
                i++;
            }else if(s.charAt(i)=='+'){
                sigh=stack.getFirst();
                i++;
            }else if(s.charAt(i)=='-'){
                sigh=-stack.getFirst();
                i++;
            }else if(s.charAt(i)=='('){
                stack.addFirst(sigh);
                i++;
            }else if(s.charAt(i)==')'){
                stack.removeFirst();
                i++;
            }else{
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                re+=sigh*num;
            }
        }
        return re;
    }
    public static int calculate1(String s) {
        int n=s.length();
        Deque<Integer> stack=new LinkedList<>();
        Deque<Integer> sigh=new LinkedList<>();
        sigh.addFirst(1);
        int i=0;
        while(i<n){
            if(s.charAt(i)==' '){
                i++;
            }else if(s.charAt(i)=='+'){
                sigh.addFirst(1);
                i++;
            }else if(s.charAt(i)=='-'){
                sigh.addFirst(-1);
                i++;
            }else if(s.charAt(i)=='*'){
                int num=stack.removeFirst();
                i++;
                while(i<n && s.charAt(i)==' '){
                    i++;
                }
                int temp=s.charAt(i)-'0';
                i++;
                while(i<n && Character.isDigit(s.charAt(i))){
                    temp=temp*10+s.charAt(i)-'0';
                    i++;
                }
                num*=temp;
                stack.addFirst(num);

            }else if(s.charAt(i)=='/'){
                int num=stack.removeFirst();
                i++;
                while(i<n && s.charAt(i)==' '){
                    i++;
                }
                int temp=s.charAt(i)-'0';
                i++;
                while(i<n && Character.isDigit(s.charAt(i))){
                    temp=temp*10+s.charAt(i)-'0';
                    i++;
                }
                num/=temp;
                stack.addFirst(num);
            }else{
                int num=s.charAt(i)-'0';
                i++;
                while(i<n && Character.isDigit(s.charAt(i))){
                    num=num*10+s.charAt(i)-'0';
                    i++;
                }
                stack.addFirst(num);
            }
        }
        int sum=0;
        while(!stack.isEmpty()){
            sum+=(stack.removeFirst()*sigh.removeFirst());
        }
        return sum;
    }
    public static int majorityElement(int[] nums) {
        Map<Integer,Integer> record=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(record.containsKey(nums[i])){
                record.put(nums[i],record.get(nums[i])+1);
            }else{
                record.put(nums[i],1);
            }
        }
        for(int num:record.keySet()){
            if(record.get(num)>n/2){
                return record.get(num);
            }
        }
        return 0;
    }
    public static boolean isValidSerialization(String preorder) {
        Deque<Integer> stack=new LinkedList<>();
        String[] nodes=preorder.split(",");
        stack.addFirst(1);
        for(String node:nodes){
            if(stack.isEmpty()) return false;
            int times = stack.removeFirst();
            if(times-1!=0){
                stack.addFirst(times-1);
            }
            if(!node.equals("#")){
                    stack.addFirst(2);
            }
        }
        boolean re=true;
        for(int i:stack){
            if(i!=0){
                re=false;
                break;
            }
        }
        return re;
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        /*List<Integer> re=new ArrayList<>();
        int i=0,j=0;
        int right=matrix[0].length-1;
        int left=0;
        int up=0;
        int down=matrix.length-1;
        while(up<=down || left<=right){
            if(i==up){
                while(j<right){
                    re.add(matrix[i][j]);
                    j++;
                }
                up++;
                *//*j=right;
                i++;*//*
            }else if(j==right){
                while(i<down){
                    re.add(matrix[i][j]);
                    i++;
                }
                right--;
                *//*i=down;
                j--;*//*
            }else if(i==down){
                while(j>left){
                    re.add(matrix[i][j]);
                    j--;
                }
                down--;
                *//*j=left;
                i--;*//*
            }else if(j==left){
                while(i>up){
                    re.add(matrix[i][j]);
                    i--;
                }
                left++;
                *//*i=up;
                j++;*//*
            }
        }
        if(re.size()<matrix.length*matrix[0].length)
            re.add(matrix[i][j]);
        return re;*/
        LinkedList<Integer> result = new LinkedList<>();
        if(matrix==null||matrix.length==0) return result;
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int numEle = matrix.length * matrix[0].length;
        while (numEle >= 1) {
            for (int i = left; i <= right && numEle >= 1; i++) {
                result.add(matrix[top][i]);
                numEle--;
            }
            top++;
            for (int i = top; i <= bottom && numEle >= 1; i++) {
                result.add(matrix[i][right]);
                numEle--;
            }
            right--;
            for (int i = right; i >= left && numEle >= 1; i--) {
                result.add(matrix[bottom][i]);
                numEle--;
            }
            bottom--;
            for (int i = bottom; i >= top && numEle >= 1; i--) {
                result.add(matrix[i][left]);
                numEle--;
            }
            left++;
        }
        return result;
    }
    public int[][] generateMatrix(int n) {
        int[][] re=new int[n][n];
        int zong=n*n;
        int num=1;
        int l=0,r=n-1,u=0,d=n-1;
        while (num<=zong){
            for(int i=l;i<=r;i++){
                re[u][i]=num++;
            }
            u++;
            for(int i=u;i<=d;i++){
                re[i][r]=num++;
            }
            r--;
            for(int i=r;i>=l;i--){
                re[d][i]=num++;
            }
            d--;
            for(int i=d;i>=u;i--){
                re[i][l]=num++;
            }
            l++;
        }
        return re;
    }
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> record=new HashMap<>();
        for(int num:nums){
            record.put(num,record.getOrDefault(num,0)+1);
        }
        int[][] times=new int[record.size()][2];
        int index=0;
        for(int num:record.keySet()){
            times[index][0]=num;
            times[index][1]=record.get(num);
            index++;
        }
        Arrays.sort(times,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return a[1]-b[1];
            }});
        int[] re=new int[k];
        for(int i=0;i<k;i++){
            re[i]=times[i][0];
        }
        return re;
    }
    public String frequencySort(String s) {
        HashMap<Character,Integer> record=new HashMap<>();
        for(int i=0;i<s.length();i++){
            record.put(s.charAt(i),record.getOrDefault(s.charAt(i),0)+1);
        }
        List<Character>[] buckets=new List[s.length()+1];
        for(Character c:record.keySet()){
            int times=record.get(c);
            if(buckets[times]==null){
                buckets[times]=new ArrayList<>();
            }
            buckets[times].add(c);
        }
        StringBuilder re=new StringBuilder();
        for(int i=s.length();i>0;i--){
            List<Character> temp=buckets[i];
            if(temp!=null){
                for(Character c:temp){
                    for(int j=0;j<i;j++){
                        re.append(c);
                    }

                }

            }
        }
        return  re.toString();
    }
    public static int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int l = 1, h = x/2+1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int sqrt = x / mid;
            if (sqrt == mid) {
                return mid;
            } else if (mid > sqrt) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return h;
    }
    public char nextGreatestLetter(char[] letters, char target) {
        int size=letters.length;
        int l=0,r=size-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(letters[m]<=target){
                l=m+1;
            }else{
                r=m-1;
            }
        }
        return l<size?letters[l]:letters[0];
    }
    public static int climbStairs(int n) {
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=nums[0];
        if(n<2) return dp[n-1];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[n-1];
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[][] dp=new int[m][n];
        dp[0][0]=grid[0][0];
        if(m<2 && n<2) return dp[0][0];
        if(n>1)
            dp[0][1]=grid[0][0]+grid[0][1];
        if(m>1)
            dp[1][0]=grid[0][0]+grid[1][0];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i>0 && j>0){
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
                }else if(j>0){
                    dp[i][j]=dp[i][j-1]+grid[i][j];
                }else if(i>0){
                    dp[i][j]=dp[i-1][j]+grid[i][j];
                }

            }
        }
        return dp[m-1][n-1];
    }
    public static int integerBreak(int n) {
        int[] dp=new int[n+1];
        dp[2]=1;
        dp[1]=1;
        for(int i=3;i<=n;i++){
            int max=0;
            for(int j=1;j<i;j++){
                max=Math.max(max,dp[i-j]*j);
            }
            dp[i]=max;
        }
        return dp[n];
    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode pre=null,cur=head;
        ListNode temp1=null,temp2=null;
        int count=1;
        while(cur!=null){
            if(count==left-1) temp1=cur;
            ListNode next=cur.next;
            if(count<=right && count>=left){
                if(count==left) temp2=cur;
                cur.next=pre;
                pre=cur;
                if(count==right){
                    temp1.next=cur;
                    temp2.next=next;
                    break;
                }
            }

            cur=next;
            count++;
        }
        return head;
    }
    public static int numSquares(int n) {
        int[] dp=new int[n+1];
        dp[1]=1;
        for(int i=1;i<=n;i++){
            if((int)Math.sqrt(i)*(int)Math.sqrt(i)==i){
                dp[i]=1;
            }else{
                int min=n;
                for(int j=1;j<i;j++){
                    if((int)Math.sqrt(j)*(int)Math.sqrt(j)==j)
                        min=Math.min(dp[i-j]+1,min);
                }
                dp[i]=min;
            }
        }
        return dp[n];
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    //TODO
    }
    public static boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder,0,postorder.length);
    }
    public static boolean verifyPostorder(int[] postorder,int left,int right) {
        if(left==right-1 || left==right) return true;
        int index=left;
        while(postorder[right-1]>postorder[index]){
            index++;
        }
        for(int i=index;i<right-1;i++){
            if(postorder[i]<postorder[right-1]){
                return false;
            }
        }
        return verifyPostorder(postorder,left,index) && verifyPostorder(postorder,index,right-1);
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int sum=1;
        int rightRecord=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=rightRecord){
                sum++;
                rightRecord=intervals[i][1];
            }
        }
        return intervals.length-sum;
    }
    public int numDistinct(String s, String t) {
        int m=s.length(),n=t.length();
        if(m<n) return 0;
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            dp[i][n]=1;
        }
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(s.charAt(i)==t.charAt(j)){
                    dp[i][j]=dp[i+1][j]+dp[i+1][j+1];
                }else{
                    dp[i][j]=dp[i+1][j];
                }
            }
        }
        return dp[0][0];
    }
    public static  int evalRPN(String[] tokens) {
        Deque<Integer> stack=new LinkedList<>();
        for(int i=0;i<tokens.length;i++){
            if(isNumber(tokens[i])){
                stack.addFirst(Integer.parseInt(tokens[i]));
            }else{
                int n1=stack.removeFirst();
                int n2=stack.removeFirst();
                int num=0;
                switch(tokens[i]){
                    case "+":
                        num=n2+n1;
                        break;
                    case "-":
                        num=n2-n1;
                        break;
                    case "*":
                        num=n2*n1;
                        break;
                    case "/":
                        num=n2/n1;
                        break;
                    default:
                }
                stack.addFirst(num);
            }
        }
        return stack.peek();
    }
    public static boolean isNumber(String str){
        String reg = "^-?[0-9]+(.[0-9]+)?$";
        return str.matches(reg);
    }
    public static  int longestPalindromeLength(String s) {
        Map<Character,Integer> record =new HashMap<>();
        for(int i=0;i<s.length();i++){
            record.put(s.charAt(i),record.getOrDefault(s.charAt(i),0)+1);

        }
        int sum=0;
        Iterator<Map.Entry<Character,Integer>> it=record.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Character,Integer> cc=it.next();
            int times=cc.getValue();
            if(times%2==0){
                sum+=times;
                it.remove();
            }else{
                sum+=times-1;
            }
        }
        /*for(char c:record.keySet()){
            int times=record.get(c);
            if(times%2==0){
                sum+=times;
                record.remove(c);
            }else{
                sum+=times-1;
            }
        }*/
        if(!record.isEmpty()) sum++;
        return sum;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue=new PriorityQueue<>((x,y)->x.val<=y.val?-1:1);
        for(ListNode node:lists){
            if(node!=null)
                queue.add(node);
        }
        ListNode head=new ListNode(0);
        ListNode p=head;
        while (!queue.isEmpty()){
            ListNode temp=queue.poll();
            p.next=temp;
            p=p.next;
            if(temp.next!=null){
                queue.add(temp.next);
            }
        }
        return head.next;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int m=matrix.length,n=matrix[0].length;
        PriorityQueue<int[]> queue=new PriorityQueue<>((x,y)->matrix[x[0]][x[1]]<=matrix[y[0]][y[1]]?-1:1);
        for(int i=0;i<m;i++){
            if(n>0)
                queue.add(new int[]{i,0});
        }
        int sum=0;
        int num=0;
        while(sum<=k){
            int[] temp=queue.poll();
            num=matrix[temp[0]][temp[1]];
            sum++;
            if(temp[1]+1<n){
                queue.add(new int[]{temp[0],temp[1]+1});
            }
        }
        return num;

    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        isSearched=new int[numCourses];
        stack=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            edges.add(new ArrayList<>());
        }
        for(int[] edge:prerequisites){
            edges.get(edge[1]).add(edge[0]);
        }
        for(int i=0;i<numCourses;i++){
            if(isSearched[i]==0){
                isSearched[i]=1;
                if(!dfs(i)) return false;
            }

        }
        return true;
    }
    Deque<Integer> stack;
    int[] isSearched;//未搜索过为0
    List<List<Integer>> edges=new ArrayList<>();

    /**
     * 拓扑排序
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        isSearched=new int[numCourses];
        stack=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            edges.add(new ArrayList<>());
        }
        for(int[] edge:prerequisites){
            edges.get(edge[1]).add(edge[0]);
        }
        for(int i=0;i<numCourses;i++){
            if(isSearched[i]==0){
                isSearched[i]=1;
                if(!dfs(i)) return new int[]{};
            }

        }
        int[] re=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            re[i]=stack.removeFirst();
        }
        return re;
    }

    private boolean dfs(int node) {
            for(int i:edges.get(node)){
                if(isSearched[i]==1) return false;
                else if(isSearched[i]==0){
                    isSearched[i]=1;
                    if(!dfs(i)) return false;
                }
            }
            isSearched[node]=2;
            stack.addFirst(node);
            return true;


    }
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode slow=head;
        ListNode fast=head.next;
        while(slow!=null && fast!=null){
            if(slow==fast) return true;
            else{
                slow=slow.next;
                if(fast.next!=null)
                    fast=fast.next.next;
                else fast=null;
            }
        }
        return false;
    }
    public static boolean find132pattern(int[] nums) {
        // int n=nums.length;
        // for(int i=0;i<n-2;i++){
        //     for(int k=n-1;k>=i;k--){
        //         if(nums[i]<nums[k]){
        //             int j=i+1;
        //             while(j<k){
        //                 if(nums[k]<nums[j]){
        //                     return true;
        //                 }
        //                 j++;
        //             }
        //         }
        //     }
        // }
        // return false;
        if(nums.length<3) return false;
        int min=nums[0];
        TreeMap<Integer,Integer> right=new TreeMap<>();
        for(int i=1;i<nums.length;i++){
            right.put(nums[i],right.getOrDefault(nums[i],0)+1);
        }
        for(int i=1;i<nums.length;i++){
            if(right.get(nums[i])==1)
                right.remove(nums[i]);
            else{
                right.put(nums[i],right.get(nums[i])-1);
            }
            if(min<nums[i]-1){

                if(right.subMap(min+1,nums[i]).size()!=0){
                    return true;
                }
            }
            min=Math.min(min,nums[i]);
        }
        return false;

    }
    public static int[] findRedundantConnection(int[][] edges) {
        int n=edges.length+1;
        int[] parent =new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int i=0;i<n-1;i++){
            int[] edge=edges[i];
            if(find(parent,edge[0])==find(parent,edge[1])){
                return edge;
            }else{
                union(parent,edge[0],edge[1]);
            }
        }
        return null;
    }
    public static void union(int[] parent,int n1,int n2){
        parent[find(parent,n1)]=find(parent,n2);
    }
    public static int find(int[] parent,int n){
        if(parent[n]==n) return n;
        else{
            return find(parent,parent[n]);
        }
    }
    public static int findRepeatNumber(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[Math.abs(nums[i])]>=0){
                nums[Math.abs(nums[i])]=0-nums[Math.abs(nums[i])];
            }else{
                return Math.abs(nums[i]);
            }
        }
        return 0;
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return getHead(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    public static TreeNode getHead(int[] preorder,int preleft,int preright,int[] inorder,int inleft,int inright){
        if(preleft==preright){
            return new TreeNode(preorder[preleft]);
        }else{
            TreeNode head=new TreeNode(preorder[preleft]);
            for(int i=inleft;i<=inright;i++){
                if(inorder[i]==preorder[preleft]){
                    if(i==inleft){
                        head.right=getHead(preorder,preleft+1,preright,inorder,inleft+1,inright);
                    }else if(i==inright){
                        head.left=getHead(preorder,preleft+1,preright,inorder,inleft,inright-1);
                    }else{
                        head.left=getHead(preorder,preleft+1,preleft+i-inleft,inorder,inleft,i-1);
                        head.right=getHead(preorder,preleft+i-inleft+1,preright,inorder,i+1,inright);
                    }
                }
            }
            return head;
        }
    }
    public static int minArray(int[] numbers) {
        int n=numbers.length;
        int l=0,r=n-1;
        while(l<r){
            int m=l+(r-l)/2;
            if(numbers[l]==numbers[r]){
                l++;
            }
            else if(numbers[m]>numbers[r]){
                l=m+1;
            }else{
                r=m;
            }
        }
        return numbers[l];
    }
    public static  boolean exist(char[][] board, String word) {
        int m=board.length;
        if(m==0) return false;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(hasPath(board,i,j,word)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean hasPath(char[][] board,int ir,int ic,String word){
        if(board[ir][ic]!=word.charAt(0)){
            return false;
        }else if(word.length()==1){
            board[ir][ic]=' ';
            return true;
        }else{
            board[ir][ic]=' ';
            boolean up=false;
            boolean down=false;
            boolean left=false;
            boolean right=false;
            if(ir>0){
                up=hasPath(board,ir-1,ic,word.substring(1));
            }
            if(ir<board.length-1){
                down=hasPath(board,ir+1,ic,word.substring(1));
            }
            if(ic>0){
                left=hasPath(board,ir,ic-1,word.substring(1));
            }
            if(ic<board[0].length-1){
                right=hasPath(board,ir,ic+1,word.substring(1));
            }
            return up || down || left || right;
        }
    }
    public static int movingCount(int m, int n, int k) {
        int sum=0;
        boolean issmall=true;
        for(int i=0;i<n;i++){
            int shi=i/10;
            int ge=i-shi*10;
            if(shi+ge<=k){
                if(i<m){
                    sum+=i+1;
                }else{
                    sum+=m;
                }

            }else{
                issmall=false;
                break;
            }
        }
        if(issmall && m>n){
            for(int i=n;i<m;i++){
                int shi=i/10;
                int ge=i-shi*10;
                if(shi+ge<=k){
                    sum+=n;
                }
                else{
                    issmall=false;
                    break;
                }
            }
            if(issmall){
                for(int i=1;i<n;i++){
                    int shi=i/10;
                    int shim=(m-1)/10;
                    int ge=i-shi*10+(m-1)-shim*10;
                    if(shi+ge+shim<=k){
                        sum+=n-i;
                    }
                    else{
                        issmall=false;
                        break;
                    }
                }
            }


        }
        return sum;
    }

    /**
     * 快速幂 转化为二进制来缩减运算步骤
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null || B==null) return false;
        Deque<TreeNode> stack=new LinkedList<>();
        stack.addFirst(A);
        TreeNode tempnode=stack.removeFirst();
        while(!stack.isEmpty() || tempnode!=null){
            if(tempnode==null) {
                tempnode=stack.removeFirst();
            }
            if(tempnode.val==B.val){
                if(equals(tempnode,B)){
                    return true;
                }
            }
            if(tempnode.right!=null){
                stack.addFirst(tempnode.right);
            }
            tempnode=tempnode.left;
        }
        return false;
    }
    public static boolean equals(TreeNode A,TreeNode B){
        Deque<TreeNode> stackB=new LinkedList<>();
        stackB.addFirst(B);
        Deque<TreeNode> stackA=new LinkedList<>();
        stackA.addFirst(A);
        TreeNode tempnodeb=stackB.removeFirst();
        TreeNode tempnodea=stackA.removeFirst();
        while(!stackB.isEmpty() || tempnodeb!=null){
            if(tempnodeb==null ) {
                tempnodeb=stackB.removeFirst();
                tempnodea=stackA.removeFirst();
            }else if(tempnodea==null && tempnodeb!=null){
                return false;
            }
            if(tempnodeb.val!=tempnodea.val){
                return false;
            }
            if(tempnodeb.right!=null && tempnodea.right!=null){
                stackB.addFirst(tempnodeb.right);
                stackA.addFirst(tempnodea.right);
            }else if(tempnodeb.right!=null && tempnodea.right==null){
                return false;
            }
            tempnodeb=tempnodeb.left;
            tempnodea=tempnodea.left;
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        //System.out.println(evalRPN(new String[]{"-1","6","+"}));
        String s="dg";
        TreeNode n1=new TreeNode(-2);
        TreeNode n2=new TreeNode(1);
        TreeNode n3=new TreeNode(1);
        n1.left=n2;
        n1.right=n3;
        TreeNode n4=new TreeNode(-2);
        TreeNode n5=new TreeNode(1);
        n4.left=n5;

        System.out.println(isSubStructure(n4,n1));

//        System.out.println(maxNumEdgesToRemove(4,new int[][]{{3,1,2},{3,2,3},{1,1,4},{2,1,4}}));

        //v(ers?|ersion)?[0-9.]+-?(alpha|beta|rc)([0-9.]?|[0-9.]+[0-9]+)
        /*Pattern pattern1 = Pattern.compile("v(ers?|ersion)?[0-9.]+(-?(alpha|beta|rc)([0-9.]+\\+?[0-9]?|[0-9]?))?");
        Matcher m1 = pattern1.matcher("v1.1-alpha "); // 获取 matcher 对象
        if(m1.find()){
            System.out.println(m1.group());
        }*/
        //System.out.println(longestPalindrome("paper"));
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
