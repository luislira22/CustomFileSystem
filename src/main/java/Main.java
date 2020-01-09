public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("root", null);
        Directory usr = new Directory("usr", root);
        File cfg = new File("cfg", usr, 10);

        System.out.println(root.getContents());
        System.out.println(usr.getContents());
    }
}
