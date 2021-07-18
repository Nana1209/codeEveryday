/**
 * 	代理模式：
 * 	代理对象可以做真实对象做不了的事情
 * 真实对象可以做别的事
 */
public class StaticProxy {
    public static void main(String[] args) {

        new Thread(){
            @Override
            public void run() {
                System.out.println("我爱你");
            }
        }.start();
        new WeddingOrg(new You()).marry();
        WeddingOrg wo=new WeddingOrg(new You());
        wo.marry();
    }
}
interface Marry{
    void marry();
}
//真是角色
class You implements Marry{
    @Override
    public void marry() {
        System.out.println("我要结婚啦");
    }
}
//代理
class WeddingOrg implements Marry{
    private Marry target;

    public WeddingOrg(Marry target) {
        this.target = target;
    }

    @Override
    public void marry() {
        before();
        target.marry();
        after();
    }

    private void after() {
        System.out.println("布置场地");
    }

    private void before() {
        System.out.println("清理场地");
    }
}