public class Main {

    //varargs allows for 0 to many inputs ex: int... String... char... instead of int[] String[] char[]

    public static void main(String... args) {
        System.out.println("Hello, World!");

        String[] splitStrings = "Hello, World!".split(" ");
        printText(splitStrings);

        System.out.println("_".repeat(20));
        printText("hello!");
        System.out.println("_".repeat(20));
        printText();
        System.out.println("_".repeat(20));
    }
    private static void printText(String... splitStrings) {
        for (String s : splitStrings) {
            System.out.println(s);
        }
    }
}