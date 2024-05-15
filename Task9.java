public class Task9 {
    public static void main(String[] arg0){
        boolean res;
        res=isLeapYear(1996);
        System.out.println(res);
        res=isLeapYear(1999);
        System.out.println(res);
        res=isLeapYear(2000);
        System.out.println(res);
        res=isLeapYear(1900);
        System.out.println(res);
    }

    public static boolean isLeapYear(int y){
        if (y % 4 ==0) {
            if (y % 100 == 0)
                return (y % 400) == 0;
            return true;
        }
        return false;
    }
}
