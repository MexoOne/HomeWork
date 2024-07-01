import java.util.ArrayList;
import java.util.List;

public class DriverConfig {
    int period;
    int timeout;
    List<String> params;
    DriverConfig(){
        params=new ArrayList<>();
        init();
    }
    void init(){
        timeout=5;
        period=500;
    }
}
