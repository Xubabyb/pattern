package my.home.pattren.generative.factory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Проблема заключается в жесткой зависимости в коде, там где необходимо мы создаем объект через new и если понадобиться
 * добавить новый функионал нужно лопатить код добаляе проверки какой именно создавать объект (пример логистического центра
 * с авто перевозками и при расширении до морских и железнодорожных перевозок, нужно проверять какой объект создавать (машину корабль поезд))
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Паттерн Фабричный метод предлагает создавать объекты не напрямую, используя оператор new,
 * а через вызов особого фабричного метода. Не пугайтесь, объекты всё равно будут создаваться при помощи new,
 * но делать это будет фабричный метод.
 * <p>
 * На первый взгляд, это может показаться бессмысленным: мы просто переместили вызов конструктора из одного конца программы в другой.
 * Но теперь вы сможете переопределить фабричный метод в подклассе, чтобы изменить тип создаваемого продукта.
 * <p>
 * Чтобы эта система заработала, все возвращаемые объекты должны иметь общий интерфейс.
 * Подклассы смогут производить объекты различных классов, следующих одному и тому же интерфейсу.
 */
public class DemoFactory {
    private static Dialog dialog;

    public static void main(String[] args) {
        configure();
        runBusinessLogic();
    }

    /**
     * Приложение создаёт определённую фабрику в зависимости от конфигурации или
     * окружения.
     */
    static void configure() {
        if (System.getProperty("os.name").equals("Windows 10")) {
            dialog = new WindowsDialog();
        } else {
            dialog = new HtmlDialog();
        }
    }

    /**
     * Весь остальной клиентский код работает с фабрикой и продуктами только
     * через общий интерфейс, поэтому для него неважно какая фабрика была
     * создана.
     */
    static void runBusinessLogic() {
        dialog.renderWindow();
    }

}

interface Button {
    void render();

    void onClick();
}

class HtmlButton implements Button {

    public void render() {
        System.out.println("<button>Test Button</button>");
        onClick();
    }

    public void onClick() {
        System.out.println("Click! Button says - 'Hello World!'");
    }
}

class WindowsButton implements Button {
    JPanel panel = new JPanel();
    JFrame frame = new JFrame();
    JButton button;

    public void render() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Hello World!");
        label.setOpaque(true);
        label.setBackground(new Color(235, 233, 126));
        label.setFont(new Font("Dialog", Font.BOLD, 44));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.getContentPane().add(panel);
        panel.add(label);
        onClick();
        panel.add(button);

        frame.setSize(320, 200);
        frame.setVisible(true);
        onClick();
    }

    public void onClick() {
        button = new JButton("Exit");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                System.exit(0);
            }
        });
    }
}

abstract class Dialog {

    public void renderWindow() {
        // ... остальной код диалога ...

        Button okButton = createButton();
        okButton.render();
    }

    /**
     * Подклассы будут переопределять этот метод, чтобы создавать конкретные
     * объекты продуктов, разные для каждой фабрики.
     */
    public abstract Button createButton();
}
class HtmlDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}