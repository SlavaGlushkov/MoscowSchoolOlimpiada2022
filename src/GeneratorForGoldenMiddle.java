import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GeneratorForGoldenMiddle {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("inputG.txt");
        fileWriter.write(1000000 + "\n");
        new Random().ints(1000000, Integer.MIN_VALUE, Integer.MAX_VALUE).forEach(n -> {
            try {
                fileWriter.write(n + " ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        fileWriter.flush();
        fileWriter.close();
    }
}
