//Task_2, main, Phonebook class demo

public class Task_2 {
    static Phonebook phonebook;

    public static void main(String[] args){
        phonebook=new Phonebook();

        phonebook.add("Иванов", "+79991112233");
        phonebook.add("Иванов", "+79991112244");
        phonebook.add("Иванов", "+79991112255");
        phonebook.add("Петров", "+79997776655");
        phonebook.add("Сидоров", "+79998888888");
        phonebook.add("Сидоров", "+79998888888");

        printPhones("Иванов");
        printPhones("Петров");
        printPhones("Сидоров");
        printPhones("Васечкин");
    }

    public static void printPhones(String name){
        String[] phones=phonebook.get(name);
        if (phones.length>0) {
            System.out.println(" === " + name + " === ");
            for (String phone: phones)
                System.out.println("\t"+phone);
            System.out.println();
        } else
            System.out.println("Нет номеров для записи '" + name + "'");
    }
}
