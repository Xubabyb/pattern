package my.home.pattren.generative.prototype;

/**
 * Решает проблему создания копии объекта без привязки к классу объекта
 * Объект сам знает как создать свою копию
 * РЕализует общий интерфейс для всех объектов поддерживающий копирование
 * (Речь про Cloneable и метод Object clone(), хотя можем написать и свой собственный интерфейс)
 * <p>
 * Метод клонирования работает через конструктор.
 * Возможно использовать еще хранилище прототипов. Надо объект кнопка , достали объект из хранилища создали с него копию и отдали в работу
 */
public class DemoPrototype {
    public static void main(String[] args) {


    ButtonSimple buttonSimple = new ButtonSimple();
    buttonSimple.color="red";
    buttonSimple.value="delete";
    buttonSimple.size=6;

    ButtonSimple buttonSimpleCopy = buttonSimple.copy();
}}

interface Copyable {
    Object copy();
}

class ButtonSimple implements Copyable {
    String color;
    String value;
    int size;

    public ButtonSimple() {
    }

    public ButtonSimple(ButtonSimple buttonSimple) {
        if (buttonSimple != null) {
            this.value = buttonSimple.value;
            this.size = buttonSimple.size;
            this.color = buttonSimple.color;
        }

    }

    @Override
    public ButtonSimple copy() {
        return new ButtonSimple(this);
    }
}