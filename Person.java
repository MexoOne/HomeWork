//Task 1

public class Person {
    private String fio;
    private String job;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Person(String _fio, String _job, String _email,
                  String _phone, int _salary, int _age) {
        fio = _fio;
        job = _job;
        email = _email;
        phone = _phone;
        salary = _salary;
        age = _age;
    }

    public void info(){
        System.out.println("FIO: " + fio + ", job: " + job);
        System.out.println("E-mail: " + email + ", phone: " + phone);
        System.out.println("Salary: " + salary + ". Age: " + age);
    }
}
