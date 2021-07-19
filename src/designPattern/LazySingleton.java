package designPattern;

public class LazySingleton {
    //保证 instance 在所有线程中同步
    private static volatile LazySingleton instance=null;
    //用private避免外部构造实例
    private LazySingleton(){

    }
    //getInstance 方法前加同步
    public static synchronized  LazySingleton getInstance (){
        if(instance==null){
            instance=new LazySingleton();
            return instance;
        }else {
            return instance;
        }
    }
}
