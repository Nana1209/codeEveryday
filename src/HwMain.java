import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HwMain {
    static class Mylog{
        Date t;
        String pid;
        String tid;
        String content;

        public Mylog(String s){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            String time=s.substring(0,23);
            try {
                t=sdf.parse(time);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String[] ssplit=s.split(" ");
            pid=ssplit[2];
            tid=ssplit[3];
            content=ssplit[4]+" "+ssplit[5]+" "+ssplit[6];
        }

        public Date getT() {
            return t;
        }

        public void setT(Date t) {
            this.t = t;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void print(){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            System.out.println(sdf.format(t) + " " + pid + " " + tid + " " + content);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Map<String, Set<String>> record=new HashMap<>();
        List<Mylog> logs=new ArrayList<>();
        while(sc.hasNext()){
            String line=sc.nextLine();
            Mylog log=new Mylog(line);

            if(record.containsKey(log.getTid())){
                if(!record.get(log.getTid()).contains(log.getContent())){
                    logs.add(log);
                    record.get(log.getTid()).add(log.getContent());
                }
            }else{
                Set<String> threadContents=new HashSet<>();
                threadContents.add(log.getContent());
                record.put(log.getTid(),threadContents);
                logs.add(log);
            }
        }
        Collections.sort(logs, Comparator.comparing(Mylog::getT));
        for(Mylog log:logs){
            log.print();
        }
    }
}
