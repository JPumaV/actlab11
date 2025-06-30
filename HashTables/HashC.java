public class HashC {
    private Register[] table;
    private boolean[] deleted;
    private int size;

    public HashC(int size) {
        this.size = size;
        table = new Register[size];
        deleted = new boolean[size];
    }

    private int hash(int key) {
        return key % size;
    }

    public void insert(Register r) {
        int index = hash(r.getKey());
        int start = index;

        while (table[index] != null && !deleted[index] && table[index].getKey() != r.getKey()) {
            index = (index + 1) % size;
            if (index == start) {
                System.out.println("Tabla llena. No se pudo insertar " + r);
                return;
            }
        }

        table[index] = r;
        deleted[index] = false;
    }

    public Register search(int key) {
        int index = hash(key);
        int start = index;

        while (table[index] != null) {
            if (!deleted[index] && table[index].getKey() == key) {
                return table[index];
            }
            index = (index + 1) % size;
            if (index == start) break;
        }
        return null;
    }

    public void delete(int key) {
        int index = hash(key);
        int start = index;

        while (table[index] != null) {
            if (!deleted[index] && table[index].getKey() == key) {
                deleted[index] = true;
                System.out.println("Eliminado lógicamente: " + key);
                return;
            }
            index = (index + 1) % size;
            if (index == start) break;
        }
        System.out.println("No se encontró clave para eliminar: " + key);
    }

    public void printTable() {
        System.out.println("Tabla Hash:");
        for (int i = 0; i < size; i++) {
            System.out.print(i + ": ");
            if (table[i] != null && !deleted[i])
                System.out.println(table[i]);
            else if (deleted[i])
                System.out.println("[eliminado]");
            else
                System.out.println("[vacío]");
        }
    }
}