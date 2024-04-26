import java.util.ArrayList;
import java.util.List;

// Общий интерфейс компонентов.
interface FileComponent {
    void print(String indent);
}

// Простой компонент - файл.
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

    public void remove(FileComponent component) {
        children.remove(component);
    }

    public void print(String indent) {
        System.out.println(indent + name);
        for (FileComponent component : children) {
            component.print(indent + "\t");
        }
    }
}

// Клиентский код
public class Main {
    public static void main(String[] args) {
        // Создание файлов и папок
        FileComponent file1 = new File("file1.txt");
        FileComponent file2 = new File("file2.txt");

        Folder folder1 = new Folder("Folder 1");
        folder1.add(file1);

        Folder folder2 = new Folder("Folder 2");
        folder2.add(file2);

        Folder root = new Folder("Root");
        root.add(folder1);
        root.add(folder2);

        // Вывод структуры дерева файлов и папок
        root.print("");
    }
}