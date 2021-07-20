import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool {
    public static void main(String[] args) {
        //1.创建服务，创建线程池
        ExecutorService service= Executors.newFixedThreadPool(10);
        service.execute(new MyThread());
        //2.关闭连接
        service.shutdown();
    }
}
class MyThread implements Runnable{
    @Override
    public void run() {
//        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName());

    }
}