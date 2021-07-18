public class HungrySingle {
    private HungrySingle() {
    }
    private final static  HungrySingle HUNGRY=new HungrySingle();
    public static HungrySingle getInstance(){
        return HUNGRY;
    }
}
