/**
 * 模拟龟兔赛跑
 */
public class Race implements Runnable{
    private static String winner;
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            //模拟兔子休息
            if(Thread.currentThread().getName()=="兔子" && i%10==0){
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //判断比赛是否结束
            Boolean flag=gameOver(i);
            if(flag){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"--跑了"+i+"米");
        }
    }

    /**
     * 判断是否有胜利者
     * @return
     */
    public boolean gameOver(int steps){
        if(winner!=null){
            return true;
        }else{
            if(steps>=99){
                winner=Thread.currentThread().getName();
                System.out.println("胜利者是"+winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race r=new Race();
        new Thread(r,"兔子").start();
        new Thread(r,"乌龟").start();
    }
}
