// Интерфейс, который определяет общие операции для реального объекта и его заместителя.
interface Image {
    void display();
}

// Конкретный класс реального объекта.
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + filename);
    }
}

// Заместитель, который контролирует доступ к реальному объекту.
class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

// Пример использования
public class ProxyPatternExample {
    public static void main(String[] args) {
        // Создаем объект-заместитель
        Image image = new ProxyImage("test.jpg");

        // Изображение будет загружено только при вызове display()
        image.display();

        // Изображение не будет загружено снова, так как оно уже было загружено ранее
        image.display();
    }
}

