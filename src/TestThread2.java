/**
 * 创建线程方法2
 */
public class TestThread2 implements Runnable {
    @Override
    public void run() {
        //run方法线程体
        for(int i=0;i<20;i++){
            System.out.println("线程1");
        }
    }

    public static void main(String[] args) {
        TeatThread1 t1=new TeatThread1();
        Thread thread=new Thread(t1);
        thread.start();
        for(int i=0;i<20;i++){
            System.out.println("main线程");
        }
    }
}
