import java.util.LinkedList;

public class HashO {
    private LinkedList<Register>[] table;
    private int size;

    public HashO(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++)
            table[i] = new LinkedList<>();
    }

    private int hash(int key) {
        return key % size;
    }

    public void insert(Register r) {
        int index = hash(r.getKey());
        table[index].add(r);
    }

    public Register search(int key) {
        int index = hash(key);
        for (Register r : table[index]) {
            if (r.getKey() == key)
                return r;
        }
        return null;
    }

    public void delete(int key) {
        int index = hash(key);
        table[index].removeIf(r -> r.getKey() == key);
    }

    public void printTable() {
        System.out.println("\nTabla Hash con Encadenamiento:");
        for (int i = 0; i < size; i++) {
            System.out.print(i + ": ");
            System.out.println(table[i]);
        }
    }
}