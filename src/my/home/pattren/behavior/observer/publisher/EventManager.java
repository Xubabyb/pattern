package my.home.pattren.behavior.observer.publisher;

import my.home.pattren.behavior.observer.listeners.EventListener;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    Map<String, List<EventListener>> listeners = new HashMap<>();

    /**
     * Приходит массив операций которые происходят в классе имеющем ссылку на этот менеджер событий (Editor),
     * эти опреции станут ключами в мапе,
     * а качестве значений будут добавлены слушатели которые будут слушать эти операции
     */
    public EventManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    /**
     * Метод будет вызываться при каждой операции в Editor,
     * по ключу доставать список слушателей и вызывать у них метод апдейт
     */
    public void notify(String eventType, File file) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener : users) {
            listener.update(eventType, file);
        }
    }
}
