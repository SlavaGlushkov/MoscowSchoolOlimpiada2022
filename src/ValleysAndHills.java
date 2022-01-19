import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ValleysAndHills {
    StreamTokenizer streamTokenizer;
    FileWriter fileWriter;
    public static void main(String[] args) throws IOException {
            new ValleysAndHills().run();
    }
    void run() throws IOException {
        streamTokenizer = new StreamTokenizer(new FileReader("input.txt"));
        fileWriter = new FileWriter("output.txt");
        int numberOfAttempts = nextInt();
        for (int i = 0; i < numberOfAttempts; i++) {
            solve();
        }
        fileWriter.flush();
        fileWriter.close();
    }
    void solve() throws IOException {
        int [] array = new int[nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = nextInt();
        }
        ArrayList<Integer> indexesOfValleys = new ArrayList<>();
        ArrayList<Integer> indexesOfHilles = new ArrayList<>();
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] > array[i-1] && array[i] > array[i+1])
                indexesOfHilles.add(i);
            if (array[i] < array[i-1] && array[i] < array[i+1])
                indexesOfValleys.add(i);
        }
        fileWriter.write(counterOfHills(array,indexesOfHilles) + " ");
        fileWriter.write(counterOfValleys(array, indexesOfValleys) + "\n");
    }
    int nextInt() throws IOException {
        streamTokenizer.nextToken();
        return (int) streamTokenizer.nval;
    }
    int counterOfValleys(int [] array, ArrayList<Integer> arrayList){
        int counter = 0, coounterMax = 0, index;
        for (int i = 0; i < arrayList.size(); i++) {
            index = arrayList.get(i);
            try {
                while (true) {
                    if (array[index - counter] < array[index - counter - 1] && array[index + counter] < array[index + counter + 1]) {
                        counter++;
                    } else {
                        coounterMax = Math.max(coounterMax, counter);
                        counter = 0;
                        break;
                    }
                }
            }
            catch (ArrayIndexOutOfBoundsException e){
                if (index + counter + 1 > array.length) {
                    try {
                        while (true) {
                            if (array[index - counter] < array[index - counter - 1]) {
                                counter++;
                            } else {
                                coounterMax = Math.max(coounterMax, counter);
                                counter = 0;
                                break;
                            }
                        }
                    }
                    catch (ArrayIndexOutOfBoundsException e1) {
                        coounterMax = Math.max(coounterMax, counter);
                        counter = 0;
                    }
                }
            }
        }
        return coounterMax;
    }
    int counterOfHills(int [] array, ArrayList<Integer> arrayList){
        int counter = 0, coounterMax = 0, index;
        for (int i = 0; i < arrayList.size(); i++) {
            index = arrayList.get(i);
            try {
                while (true) {
                    if (array[index - counter] > array[index - counter - 1] && array[index + counter] > array[index + counter + 1]) {
                        counter++;
                    } else {
                        coounterMax = Math.max(coounterMax, counter);
                        counter = 0;
                        break;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                coounterMax = Math.max(coounterMax, counter);
                counter = 0;
            }
        }
        return coounterMax;
    }
}
