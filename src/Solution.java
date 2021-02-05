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
    public static void main(String[] args) throws Exception {
        System.out.println(findMaxAverage(new int[]{0,4,0,3,2},1));
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
