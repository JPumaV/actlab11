public class Register {
    int key;
    String name;

    public Register(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public int getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "(" + key + ", " + name + ")";
    }
}