//Task 1

import java.util.LinkedHashMap;

public class Task_1 {
    public static void main(String[] args){
        String[] wordsList={"каждый", "охотник", "желает", "знать", "где", "сидит", "фазан",
                            "каждый", "охотник",           "знать",        "сидит", "фазан",
                            "каждый"};
        for (String word: wordsList)
            System.out.print(word+" ");
        System.out.println();
        System.out.println();

        LinkedHashMap<String, Integer> wordsMap=new LinkedHashMap<String, Integer>();
        for (String word: wordsList){
            int count=wordsMap.getOrDefault(word, 0);
            wordsMap.put(word, count+1);
        }

        for (String word: wordsMap.keySet())
            System.out.println(word+"\t"+wordsMap.get(word));
    }
}
