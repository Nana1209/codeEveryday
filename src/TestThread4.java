import java.util.concurrent.*;

public class TestThread4 implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        System.out.println("xiancheng"+Thread.currentThread().getName());
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestThread4 t1=new TestThread4();
        TestThread4 t2=new TestThread4();
        TestThread4 t3=new TestThread4();
//        创建执行服务 线程池
        ExecutorService ser= Executors.newFixedThreadPool(3);
//        提交执行：
        Future<Boolean> result1=ser.submit(t1);
        Future<Boolean> result2=ser.submit(t2);
        Future<Boolean> result3=ser.submit(t3);
//        获取结果
        boolean r1=result1.get();
        boolean r2=result2.get();
        boolean r3=result3.get();
//        关闭服务
        ser.shutdownNow();
    }
}
