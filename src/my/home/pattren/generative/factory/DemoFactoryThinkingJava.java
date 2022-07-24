package my.home.pattren.generative.factory;

public class DemoFactoryThinkingJava {
    public static void main(String[] args) {
        serviceConsumer(ServiceAImpl.factory);

    }

    public static void serviceConsumer(ServiceFactory factory) {
        Service service = factory.getService();
        service.methodA();
        service.methodB();
    }
}

interface Service {
    void methodA();

    void methodB();
}

interface ServiceFactory {
    Service getService();
}

class ServiceAImpl implements Service {

    public static ServiceFactory factory = ServiceAImpl::new;


    private ServiceAImpl() {
    } //TODO также можем закрыть доступ к конструтору классы и получать объекты только через фабрику

    @Override
    public void methodA() {
        System.out.println("Service A method A");
    }

    @Override
    public void methodB() {
        System.out.println("Service A  method B");

    }
}

class ServiceBImpl implements Service {

    public static ServiceFactory factory = ServiceBImpl::new;

    private ServiceBImpl() {
    } //TODO также можем закрыть доступ к конструтору классы и получать объекты только через фабрику

    @Override
    public void methodA() {
        System.out.println("Service B method A");
    }

    @Override
    public void methodB() {
        System.out.println("Service B method B");

    }
}