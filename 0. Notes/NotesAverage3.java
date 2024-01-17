public class NotesAverage3 {
    public static void main(String[] args) {
        int[] ages = new int[] {26, 25, 24, 26, 27, 32, 31, 26, 24, 25, 31, 28};
        int sum = 0;
        for (int i = 0; i < ages.length; i++) {
            sum += ages[i];
        }
        double average = (double) sum / ages.length;
        System.out.println(average);
    }
}
