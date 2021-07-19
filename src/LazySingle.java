import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class LazySingle {
    private LazySingle() {
        synchronized (LazySingle.class){
            if(LAZYMAN!=null){
                throw new RuntimeException("不要使用反射破坏单例");
            }
        }
    }
    private static LazySingle LAZYMAN;
    public static LazySingle getInstance(){
        if(LAZYMAN==null){
            synchronized (LazySingle.class){
                if(LAZYMAN==null){
                    LAZYMAN=new LazySingle();
                }
            }
        }
        return LAZYMAN;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        LazySingle instance=LazySingle.getInstance();
        Constructor<LazySingle> declaredConstructor=LazySingle.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        LazySingle instance2=declaredConstructor.newInstance();
        System.out.println(instance2);
        System.out.println(instance);
    }
}
