// Интерфейс для устройства с интерфейсом Jack
interface JackDevice {
    void playAudio();
}

// Класс устройства с интерфейсом Jack
class Headphones implements JackDevice {
    @Override
    public void playAudio() {
        System.out.println("Playing audio through Jack.");
    }
}

// Интерфейс для устройства с интерфейсом USB
interface USBDevice {
    void playSound();
}

// Класс адаптера для устройства с интерфейсом Jack, преобразующий его к интерфейсу USB
class JackToUSBAdapter implements USBDevice {
    private JackDevice device;

    public JackToUSBAdapter(JackDevice device) {
        this.device = device;
    }

    @Override
    public void playSound() {
        device.playAudio();
    }
}

// Класс компьютера
class Computer {
    void connect(USBDevice usbDevice) {
        usbDevice.playSound();
    }
}

// Пример использования
public class Main {
    public static void main(String[] args) {
        // Создаем устройство с интерфейсом Jack
        JackDevice headphones = new Headphones();

        // Создаем адаптер для устройства с интерфейсом Jack, чтобы оно работало с USB
        USBDevice usbAdapter = new JackToUSBAdapter(headphones);

        // Создаем компьютер
        Computer computer = new Computer();

        // Подключаем устройство к компьютеру через адаптер
        computer.connect(usbAdapter);
    }
}
