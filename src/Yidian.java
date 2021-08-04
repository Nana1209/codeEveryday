import java.util.*;

public class Yidian {
    public static int countMaxActivity (ArrayList<ArrayList<String>> timeSchedule) {
        // write code here
        int[][] record=new int[timeSchedule.size()][2];
        for(int i=0;i<timeSchedule.size();i++){
            String start=timeSchedule.get(i).get(0);
            String[] starttime=start.split(":");
            int st=Integer.parseInt(starttime[0])*60+Integer.parseInt(starttime[1]);
            String end=timeSchedule.get(i).get(1);
            String[] endtime=end.split(":");
            int et=Integer.parseInt(endtime[0])*60+Integer.parseInt(endtime[1]);
            record[i][0]=st;
            record[i][1]=et;
        }
        Arrays.sort(record,(a,b)->a[0]-b[0]);
        Deque<Integer> stack=new LinkedList<>();
        stack.addLast(record[0][1]);
        for (int i = 1; i < record.length; i++) {
            int endtemp=stack.getLast();
            if(record[i][0]<=endtemp && record[i][1]<=endtemp){
                stack.removeLast();
                stack.addLast(record[i][1]);
            }else if(record[i][0]>=endtemp){
                stack.addLast(record[i][1]);
            }
        }
        return stack.size();
    }
    public int findMin (int[][] mapArray) {
        // write code here
        if(mapArray.length==0) return 0;
        int m=mapArray.length,n=mapArray[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for (int j = 0; j < n; j++) {
                if(i==0 && j==0){
                    dp[i][j]=mapArray[0][0];
                }else if(i==0){
                    dp[i][j]=dp[i][j-1]+mapArray[i][j];
                }else if(j==0){
                    dp[i][j]=dp[i-1][j]+mapArray[i][j];
                }else{
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+mapArray[i][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
    public static int[] max_version (String[][] version_list) {
        // write code here
        int[] ans=new int[version_list.length];
        int i=0;
        for(String[] ver:version_list){
            ans[i++]=versionCompare(ver[0],ver[1]);
        }
        return ans;
    }
    public static int versionCompare(String v1,String v2){
        String[] v1s=v1.split("\\.");
        String[] v2s=v2.split("\\.");
        int index=0;
        while(index<v1s.length && index<v2s.length){
            if(Integer.parseInt(v1s[index])<Integer.parseInt(v2s[index])){
                return 2;
            }else if(Integer.parseInt(v1s[index])>Integer.parseInt(v2s[index])){
                return 1;
            }else{
                index++;
            }
        }
        if(index==v1s.length && index== v2s.length){
            return 1;
        }else if(index==v1s.length){
            return 2;
        }else{
            return 1;
        }
    }
    public static void main(String[] args) {
        /*String s="0.1.0";
        String[] re=s.split('.');
        System.out.println(re.length);*/
        ArrayList<ArrayList<String>> record=new ArrayList<>();
        ArrayList<String> temp=new ArrayList<>();
        temp.add("10:00");
        temp.add("12:00");
        record.add(temp);
        ArrayList<String> temp1=new ArrayList<>();
        temp1.add("03:00");
        temp1.add("11:30");
        record.add(temp1);
        ArrayList<String> temp2=new ArrayList<>();
        temp2.add("11:30");
        temp2.add("14:00");
        record.add(temp2);
        System.out.println(countMaxActivity(record));

    }
}
