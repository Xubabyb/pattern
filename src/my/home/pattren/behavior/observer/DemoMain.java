package my.home.pattren.behavior.observer;

import my.home.pattren.behavior.observer.editor.Editor;
import my.home.pattren.behavior.observer.listeners.EmailNotificationListener;
import my.home.pattren.behavior.observer.listeners.LogOpenListener;

public class DemoMain {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        editor.events.subscribe("save", new LogOpenListener("/path/to/log/file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
