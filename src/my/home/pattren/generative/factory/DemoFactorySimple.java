package my.home.pattren.generative.factory;

public class DemoFactorySimple {
    public static void main(String[] args) {

        DeveloperFactory factory = getFactory("java");
        Developer developer = factory.createDeveloper();
        developer.writeCode();

    }

    public static DeveloperFactory getFactory(String type) {

        return switch (type) {
            case "java" -> new JavaDeveloperFactory();
            case "c++" -> new CppDeveloperFactory();
            default -> null;
        };
    }

}

interface Developer {
    void writeCode();
}

class JavaDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("write java code .....");
    }
}

class CppDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("write c++ code ...");
    }
}

interface DeveloperFactory {
    Developer createDeveloper();
}

class JavaDeveloperFactory implements DeveloperFactory {
    @Override
    public Developer createDeveloper() {
        return new JavaDeveloper();
    }
}

class CppDeveloperFactory implements DeveloperFactory {

    @Override
    public Developer createDeveloper() {
        return new CppDeveloper();
    }
}