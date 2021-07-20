import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class StreamTest {
    public static void main(String[] args) {
        User u1=new User(1,"a");
        User u2=new User(2,"b");
        User u3=new User(3,"c");
        User u4=new User(4,"d");
        User u5=new User(5,"e");
        User u6=new User(6,"f");
        List<User> list= Arrays.asList(u1,u2,u5,u3,u4,u6);
        list.stream()
                .filter((u)->{return u.id>2;})
                .map((u)->{return u.name.toUpperCase();})
                .sorted((uu1,uu2)->{return uu2.compareTo(uu1);})
                .limit(2)
                .forEach(System.out::println);

    }
}
class User{
    int id;
    String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}