public class TestHashOpen {
    public static void main(String[] args) {
        HashO hash = new HashO(5);

        int[] keys = {10, 15, 20, 25, 30, 35, 40};
        String[] names = {"Ana", "Luis", "Juan", "Luz", "Rosa", "Katy", "Leo"};

        for (int i = 0; i < keys.length; i++) {
            hash.insert(new Register(keys[i], names[i]));
        }

        hash.printTable();

        System.out.println("\nBuscando clave 25:");
        System.out.println(hash.search(25));

        System.out.println("\nEliminando clave 15:");
        hash.delete(15);
        hash.printTable();
    }
}