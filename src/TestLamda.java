public class TestLamda {
    //2.静态内部类
    static class Love2 implements ILove{
        @Override
        public void love(String target) {
            System.out.println("I Love you"+target);
        }
    }
    public static void main(String[] args) {
        //2.局部内部类
        class Love3 implements ILove{
            @Override
            public void love(String target) {
                System.out.println("I Love you"+target);
            }
        }
        ILove ilove=new Love1();
        ilove.love("nana1");

        ilove=new Love2();
        ilove.love("nana2");

        ilove=new Love3();
        ilove.love("nana3");

        //4. 匿名内部类
        ilove=new ILove() {
            @Override
            public void love(String target) {
                System.out.println("I Love you"+target);
            }
        };
        ilove.love("nana4");
        //5. Lamda表达式
        ilove=(String target) ->{
            System.out.println("I Love you"+target);
        };
        //简化1：去掉参数类型
        ilove=(target) ->{
            System.out.println("I Love you"+target);
        };
        //简化2：去掉括号
        ilove=target->{
            System.out.println("I Love you"+target);
        };
        //简化3：去掉花括号
        ilove=target->System.out.println("I Love you"+target);

        ilove.love("nana7");
    }
}
interface ILove{
    void love(String target);
}
//1.接口实现（函数式接口）
class Love1 implements ILove{
    @Override
    public void love(String target) {
        System.out.println("I Love you"+target);
    }
}