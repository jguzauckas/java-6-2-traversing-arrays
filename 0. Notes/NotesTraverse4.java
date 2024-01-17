public class NotesTraverse4 {
    public static void main(String[] args) {
        int[] ints = new int[50];
        for (int i = 0; i < ints.length; i++) {
            ints[i] += i + 1;
            System.out.println(ints[i]);
        }
    }
}
