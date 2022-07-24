package my.home.something.count;

import java.util.Comparator;

public class Person {
    private static int ID;

    private int account = ++ID;

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public static int getID() {
        return ID;
    }

    public static void main(String[] args) {
        Comparator<Person> comparator = (Person p1, Person p2) -> p1.getAccount() - p2.getAccount();
        Person person = new Person();
        Person person2 = new Person();
        Person person3 = new Person();

        System.out.println(person.getAccount() + " " + person.getClass().getSimpleName() + " " + person2.getAccount() + " " + Person.getID());

    }
}
