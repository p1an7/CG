package Math;

public class Main {
    public static void main(String[] args) {
        Vector2 v2a = new Vector2(1, 2);
        Vector2 v2b = new Vector2(3, 4);
        System.out.println("Vector2 Addition: " + v2a.add(v2b));
        System.out.println("Vector2 Dot Product: " + v2a.dot(v2b));

        Vector3 v3a = new Vector3(1, 2, 3);
        Vector3 v3b = new Vector3(4, 5, 6);
        System.out.println("Vector3 Addition: " + v3a.add(v3b));
        System.out.println("Vector3 Cross Product: " + v3a.cross(v3b));

        Vector4 v4a = new Vector4(1, 2, 3, 4);
        Vector4 v4b = new Vector4(5, 6, 7, 8);
        System.out.println("Vector4 Addition: " + v4a.add(v4b));
        System.out.println("Vector4 Dot Product: " + v4a.dot(v4b));
    }
}