//Task_2, Phonebook class

import java.util.HashMap;
import java.util.HashSet;

public class Phonebook {
    protected HashMap<String, HashSet<String>> book;

    public Phonebook(){
        book=new HashMap<>();
    }

    public void add(String name, String phone){
        if (book.containsKey(name)){
            book.get(name).add(phone);
        } else {
            HashSet<String> val=new HashSet<String>();
            val.add(phone);
            book.put(name, val);
        }
    }

    public String[] get(String name){
        HashSet<String> vals=book.get(name);
        if (vals == null)
            return new String[0];
        else
            return vals.toArray(new String[1]);
    }
}
