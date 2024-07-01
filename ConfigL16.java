public interface ConfigL16{
    String URL="https://www.mts.by/";

    String PHONE_TEXT = "297777777";
    String PHONE_EXP="375"+PHONE_TEXT;

    double SUM_NUM= 50.0 + 100.0*Math.random();
    String SUM_TEXT = String.format("%.2f", SUM_NUM).replace(',','.');

    String SH_FILE = "D:/screenshot.png";

    DriverConfig CHROME_CONFIG =new DriverConfig(){
        void init (){
            timeout=10;
            period=300;
            params.add("--disable-http2");
        }
    };
}
