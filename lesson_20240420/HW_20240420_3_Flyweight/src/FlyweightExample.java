import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

// Интерфейс Легковеса, определяющий метод для отображения точки.
/*
Служит абстракцией для всех конкретных классов, реализующих функциональность отображения точек.
 */
interface Point {
    void draw(int x, int y);
}

// Конкретный класс Легковеса, представляющий точку.
/*
Конкретная реализация интерфейса Point. Класс реализует метод draw, который выводит информацию о точке на экран.
Каждый объект PointImpl представляет собой легковес,
который может быть использован множеством точек с одинаковыми цветом и размером без дублирования общих данных.
 */
class PointImpl implements Point {
    private Color color;
    private int size;

    public PointImpl(Color color, int size) {
        this.color = color;
        this.size = size;
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("Drawing point at (" + x + ", " + y + ") with color " + color + " and size " + size);
    }
}

// Фабрика Легковесов для создания и хранения экземпляров Легковесов.
/*
Обеспечивает централизованное создание и хранение экземпляров легковесов (точек),
что позволяет избежать создания дублирующихся объектов и экономить память.
 */
class PointFactory {
    private static final Map<Color, Point> pointMap = new HashMap<>();

    public static Point getPoint(Color color, int size) {
        Point point = pointMap.get(color);
        /*
        Если экземпляр с заданным цветом еще не создан, метод создает новый экземпляр PointImpl с указанным цветом и размером,
        добавляет его в карту pointMap, а затем возвращает созданный экземпляр:
         */
        if (point == null) {
            point = new PointImpl(color, size);
            pointMap.put(color, point);
        }
        return point;
    }
}

// Клиентский код, использующий Легковесы для отображения точек.
public class FlyweightExample {
    public static void main(String[] args) {
        // Получаем экземпляр точки с цветом RED и размером 5:
        Point point1 = PointFactory.getPoint(Color.RED, 5);
        point1.draw(1, 2);  // Отображаем точку с координатами (1, 2)

        // Получаем еще один экземпляр точки с теми же параметрами:
        Point point2 = PointFactory.getPoint(Color.RED, 5); // Получаем точку с теми же параметрами
        point2.draw(3, 4);  // Отображаем точку с координатами (3, 4)

        // Точки используют один и тот же объект PointImpl, но координаты разные.
    }
}
