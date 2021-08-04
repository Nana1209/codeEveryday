package designPattern;

import java.util.concurrent.ConcurrentHashMap;

public class HungrySingleton {
    private static final HungrySingleton instance=new HungrySingleton();
    private HungrySingleton(){}
    public static HungrySingleton getInstance(){
        return instance;


    }
}
