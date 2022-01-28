import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

public class GoldenMiddleDifferentAlgos {
    public static void main(String[] args) throws IOException {
        int array [] = getArray();
        int goldenMiddleArray[] = new int[1000000];
        //Первый алгоритм
        long currentTime = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            goldenMiddleArray[i] = array[i];
            bubbleSort(goldenMiddleArray,i);
        }
        System.out.println(System.currentTimeMillis() - currentTime);
        //Второй алгоритм
        long currentTime2 = System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - currentTime2);
        //Третий алгоритм
        long currentTime3 = System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - currentTime3);
        //Четвертый алгоритм
        long currentTime4 = System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - currentTime4);
    }
    static int[] getArray() throws IOException {
        StreamTokenizer streamTokenizer = new StreamTokenizer(new FileReader("C:\\Users\\user\\IdeaProjects\\MoscowSchoolOlimpiada2022\\inputG.txt"));

        int [] array = new int[1000000];
        for (int i = 0; i < array.length; i++) {
            streamTokenizer.nextToken();
            array[i] = (int) streamTokenizer.nval;
        }
        return array;
    }
    static int [] bubbleSort(int[] array, int index) {
        boolean sorted = false;
        int temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < index; i++) {
                if (array[i] > array[i+1]) {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    sorted = false;
                }
            }
        }
        return array;
    }
}
