interface IteratorPatern<T>{
    boolean hasNext();
    T next();
    void clear();
}

class StringListIterator implements IteratorPatern<String>{
    private String[] array;
    private int position = 0;

    public StringListIterator(String[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        boolean result =  position<array.length;
        if (result==false){
            clear();
        }
        return result;
    }

    @Override
    public String next() {
        if (this.hasNext()){
            return array[position++];//2
        }
        return null;
    }

    @Override
    public void clear() {
        position = 0;
    }
}

public class Main {
    public static void main(String[] args) {
        String[] array = {"Farid","Abdullayev" };
        StringListIterator stringListIterator = new StringListIterator(array);

        while (stringListIterator.hasNext()){
            String item = stringListIterator.next();
            System.out.println(item);
        }

        while (stringListIterator.hasNext()){
            String item = stringListIterator.next();
            System.out.println(item);
        }

        while (stringListIterator.hasNext()){
            String item = stringListIterator.next();
            System.out.println(item);
        }

        while (stringListIterator.hasNext()){
            String item = stringListIterator.next();
            System.out.println(item);
        }

        while (stringListIterator.hasNext()){
            String item = stringListIterator.next();
            System.out.println(item);
        }

        while (stringListIterator.hasNext()){
            String item = stringListIterator.next();
            System.out.println(item);
        }
    }
}