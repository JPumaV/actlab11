public class TestHash {
    public static void main(String[] args) {
        HashC hash = new HashC(10);

        int[] keys = {34, 3, 7, 30, 11, 8, 7, 23, 41, 16, 34};
        String[] names = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};

        for (int i = 0; i < keys.length; i++) {
            hash.insert(new Register(keys[i], names[i]));
        }

        System.out.println("\nDespués de insertar:");
        hash.printTable();

        hash.delete(30);
        System.out.println("\nDespués de eliminar clave 30:");
        hash.printTable();

        Register r = hash.search(23);
        System.out.println("\nResultado de búsqueda de clave 23:");
        System.out.println(r != null ? r : "No encontrado");
    }
}