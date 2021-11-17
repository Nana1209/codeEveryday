import java.util.*;

public class HwMain1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String stringList=sc.nextLine();
        Map<String, Set<String>> record=new HashMap<>();
        List<HwMain.Mylog> logs=new ArrayList<>();
        while(sc.hasNext()){
            String line=sc.nextLine();
            HwMain.Mylog log=new HwMain.Mylog(line);

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
        Collections.sort(logs, Comparator.comparing(HwMain.Mylog::getT));
        for(HwMain.Mylog log:logs){
            log.print();
        }
    }
}
