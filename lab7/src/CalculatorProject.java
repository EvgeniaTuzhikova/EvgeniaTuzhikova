import java.util.HashMap;
import java.util.Map;

// Интерфейс команды
interface Command {
    void execute();
}

// Реализация фиксированных кнопок для цифр
class NumberCommand implements Command {
    private int number;

    public NumberCommand(int number) {
        this.number = number;
    }

    @Override
    public void execute() {
        System.out.println("Нажата цифра: " + number);
    }
}

// Реализация фиксированных кнопок для арифметических операций
class ArithmeticCommand implements Command {
    private String operation;

    public ArithmeticCommand(String operation) {
        this.operation = operation;
    }

    @Override
    public void execute() {
        System.out.println("Выполняется операция: " + operation);
    }
}

// Реализация кнопок с настраиваемыми функциями
class CustomCommand implements Command {
    private String action;

    public CustomCommand(String action) {
        this.action = action;
    }

    @Override
    public void execute() {
        System.out.println("Выполняется действие: " + action);
    }
}

// Класс клавиатуры калькулятора
class CalculatorKeyboard {
    private Map<String, Command> buttons = new HashMap<>();

    // Установка команды на кнопку
    public void setButtonCommand(String button, Command command) {
        buttons.put(button, command);
    }

    // Нажатие кнопки
    public void pressButton(String button) {
        Command command = buttons.get(button);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Кнопка \"" + button + "\" не назначена.");
        }
    }
}

// Основной класс для тестирования
public class CalculatorProject {
    public static void main(String[] args) {
        CalculatorKeyboard keyboard = new CalculatorKeyboard();

        // Установка фиксированных функций
        keyboard.setButtonCommand("1", new NumberCommand(1));
        keyboard.setButtonCommand("2", new NumberCommand(2));
        keyboard.setButtonCommand("+", new ArithmeticCommand("+"));
        keyboard.setButtonCommand("-", new ArithmeticCommand("-"));

        // Установка настраиваемых функций
        keyboard.setButtonCommand("A", new CustomCommand("Запуск функции A"));
        keyboard.setButtonCommand("B", new CustomCommand("Запуск функции B"));

        // Тестирование клавиатуры
        keyboard.pressButton("1");
        keyboard.pressButton("+");
        keyboard.pressButton("A");
        keyboard.pressButton("B");
        keyboard.pressButton("X"); // Кнопка без команды
    }
}