package my.home.pattren.generative.builder;
/**
 * Представьте сложный объект, требующий кропотливой пошаговой инициализации множества полей и вложенных объектов.
 * Код инициализации таких объектов обычно спрятан внутри монструозного конструктора с десятком параметров.
 * Либо ещё хуже — распылён по всему клиентскому коду.
 *
 *
 * При использовании паттерна Строитель нет необходимости создать множество конструкторов
 * для каждого из вариантов сборки сложного объекта
 */


public class DemoBuilder {
    public static void main(String[] args) {
        Person person = new PersonBuilderImpl().setName("Dima").setAge(13).build();
        Person person2 = new PersonBuilderImpl().setAge(27).build();
        System.out.println(person + "\n" + person2);

    }
}

class Person {
    private String name;
    private String surName;
    private String password;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}

interface PersonBuilder {
    PersonBuilder setName(String name);

    PersonBuilder setSurName(String surName);

    PersonBuilder setPassword(String password);

    PersonBuilder setAge(int age);

    Person build();
}

class PersonBuilderImpl implements PersonBuilder {
    Person person = new Person();

    @Override
    public PersonBuilder setName(String name) {
        person.setName(name);
        return this;
    }

    @Override
    public PersonBuilder setSurName(String surName) {
        person.setSurName(surName);
        return this;
    }

    @Override
    public PersonBuilder setPassword(String password) {
        person.setPassword(password);
        return this;
    }

    @Override
    public PersonBuilder setAge(int age) {
        person.setAge(age);
        return this;
    }

    @Override
    public Person build() {
        return person;
    }
}