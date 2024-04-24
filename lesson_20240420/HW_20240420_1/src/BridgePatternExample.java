// Интерфейс устройства
/*
Определяет общий интерфейс для всех устройств, которыми можно управлять с помощью пультов.
Он содержит методы для получения и установки состояния (включено/выключено, громкость, канал).
 */
interface Device {
    boolean isEnabled();
    void enable();
    void disable();
    int getVolume();
    void setVolume(int percent);
    int getChannel();
    void setChannel(int channel);
}

/*
Классы Tv и Radio:
Реализуют интерфейс Device для конкретных устройств - телевизора и радио соответственно.
Они имеют свои собственные переменные состояния (включено/выключено, громкость, канал) и методы для их изменения.
 */
// Класс ТВ, реализующий устройство
class Tv implements Device {
    private boolean enabled = false;
    private int volume = 50;
    private int channel = 1;

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void enable() {
        enabled = true;
    }

    @Override
    public void disable() {
        enabled = false;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int percent) {
        if (percent >= 0 && percent <= 100) {
            volume = percent;
        }
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }
}

// Класс радио, реализующий устройство
class Radio implements Device {
    private boolean enabled = false;
    private int volume = 30;
    private int channel = 100;

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void enable() {
        enabled = true;
    }

    @Override
    public void disable() {
        enabled = false;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int percent) {
        if (percent >= 0 && percent <= 100) {
            volume = percent;
        }
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }
}

// Класс пультов
/*
Это базовый класс для пультов, который имеет ссылку на устройство (Device), которым он управляет.
Он содержит методы для базового управления устройством, такие как включение/выключение, регулировка громкости и изменение канала.
 */
class Remote {
    protected Device device;

    public Remote(Device device) {
        this.device = device;
    }

    public void togglePower() {
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }

    public void volumeDown() {
        device.setVolume(device.getVolume() - 10);
    }

    public void volumeUp() {
        device.setVolume(device.getVolume() + 10);
    }

    public void channelDown() {
        device.setChannel(device.getChannel() - 1);
    }

    public void channelUp() {
        device.setChannel(device.getChannel() + 1);
    }
}

// Расширение класса пультов
/*
Это расширение класса Remote, которое добавляет дополнительные функции, такие как режим "без звука" (mute).
 */
class AdvancedRemote extends Remote {
    public AdvancedRemote(Device device) {
        super(device);
    }

    public void mute() {
        device.setVolume(0);
    }
}

// Пример использования
public class BridgePatternExample {
    public static void main(String[] args) {
        // Создаем ТВ и пульт для него
        Tv tv = new Tv();
        Remote remote = new Remote(tv);

        System.out.println("TV control:");
        remote.togglePower();
        System.out.println("TV is on: " + tv.isEnabled());
        remote.volumeUp();
        System.out.println("Volume: " + tv.getVolume());
        remote.channelUp();
        System.out.println("Channel: " + tv.getChannel());

        // Создаем радио и продвинутый пульт для него
        Radio radio = new Radio();
        AdvancedRemote advancedRemote = new AdvancedRemote(radio);

        System.out.println("\nRadio control:");
        advancedRemote.togglePower();
        System.out.println("Radio is on: " + radio.isEnabled());
        advancedRemote.volumeDown();
        System.out.println("Volume: " + radio.getVolume());
        advancedRemote.mute();
        System.out.println("Radio muted, volume: " + radio.getVolume());
    }
}
