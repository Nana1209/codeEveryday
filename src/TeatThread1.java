import java.util.*;

public class TeatThread1 extends Thread{
    @Override
    public void run() {
        //run方法线程体
        for(int i=0;i<20;i++){
            System.out.println("线程1");
        }
    }

    public static void main(String[] args) {
        TeatThread1 t1=new TeatThread1();
        t1.start();
        for(int i=0;i<20;i++){
            System.out.println("main线程");
        }
        Map<Integer,String> record=new HashMap<>();
        record.put(1,"a");
        record.put(2,"b");
        for(Map.Entry<Integer,String> en:record.entrySet()){
            System.out.printf(en.getKey()+en.getValue());
        }
        Iterator<Map.Entry<Integer, String>> it = record.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer, String> en = it.next();
            System.out.printf( en.getKey() + en.getValue());

        }
        List<Integer> list=Arrays.asList(1,2,3);
        list.forEach(a-> System.out.println(a));
        list.stream().forEach((a)->{
            System.out.println(a);
        });
        

    }
}
