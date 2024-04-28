/*
Программа создает иерархическую структуру файлов и папок, добавляет их в дерево, а затем выводит эту структуру на экран.
 */

import java.util.ArrayList;
import java.util.List;

// Общий интерфейс компонентов.
/*
Служит абстракцией, которая позволяет клиентскому коду работать с компонентами дерева единообразно, независимо от их конкретного типа.
 */
interface FileComponent {
    void print(String indent);
}

// Простой компонент - файл.
/*
Служит простым строительным блоком в структуре дерева файлов и папок
и может использоваться вместе с папками (Folder) для создания иерархической структуры файловой системы
 */
class File implements FileComponent {
    private String name;

    public File(String name) {
        this.name = name;
    }

    public void print(String indent) {
        System.out.println(indent + name);
    }
}

// Компонент-контейнер - папка.
/*
Позволяет создавать структуру дерева папок и файлов, где каждая папка может содержать другие папки и файлы.
Метод print обеспечивает вывод на экран иерархической структуры этого дерева с использованием отступов для понятного представления иерархии.
 */
class Folder implements FileComponent {
    private String name;
    private List<FileComponent> children;

    public Folder(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void add(FileComponent component) {
        children.add(component);
    }

    public void print(String indent) {
        System.out.println(indent + name);
        for (FileComponent component : children) {
            component.print(indent + "\t");
        }
    }
}

// Клиентский код
/*
Каждая папка и файл выводятся на экран с учетом своего местоположения в иерархии, что позволяет видеть структуру дерева файлов и папок.
При этом вложенные элементы сдвигаются относительно родительских элементов для наглядности иерархии.
 */
public class Main {
    public static void main(String[] args) {
        // Создание файлов и папок
        FileComponent file1 = new File("file1.txt");
        FileComponent file2 = new File("file2.txt");

        // Добавление файлов в папки:
        Folder folder1 = new Folder("Folder 1");
        folder1.add(file1);

        Folder folder2 = new Folder("Folder 2");
        folder2.add(file2);

        // Создание структуры дерева:
        Folder root = new Folder("Root");
        root.add(folder1);
        root.add(folder2);

        // Вывод структуры дерева файлов и папок
        root.print("");
    }
}