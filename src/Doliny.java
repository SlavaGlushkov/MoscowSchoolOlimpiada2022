import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Doliny {
    static int[] array;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("input.txt"));
        int tests = scanner.nextInt();
        for (int i = 0; i < tests; i++) {
            VershinyVpadyny.glubineyshiy = 0;
            VershinyVpadyny.vysochaichiy = 0;
            int points = scanner.nextInt();
            array = new int[points];
            //NavigableMap<Integer,Boolean> map = new TreeMap<>();
            for (int j = 0; j < points; j++) {
                array[j] = scanner.nextInt();
            }
            ArrayList<VershinyVpadyny> vershiny = new ArrayList<>();
            ArrayList<VershinyVpadyny> vpadyny = new ArrayList<>();
            for (int j = 1; j < array.length - 1; j++) {
                if (array[j] > array[j-1] && array[j] > array[j + 1])
                    vershiny.add(new VershinyVpadyny(true,j));
                if (array[j] < array[j-1] && array[j] < array[j + 1])
                    vpadyny.add(new VershinyVpadyny(false,j));
            }
            System.out.println(VershinyVpadyny.vysochaichiy + " " + VershinyVpadyny.glubineyshiy);
        }
    }
    static class VershinyVpadyny {
        boolean vershina;
        int coordinate;
        int vysota;
        static int vysochaichiy = 0;
        static int glubineyshiy = 0;

        public VershinyVpadyny(boolean vershina, int coordinate) {
            this.vershina = vershina;
            this.coordinate = coordinate;
            this.vysota = vysota(vershina,coordinate);
            if (vershina && this.vysota > vysochaichiy)
                vysochaichiy = this.vysota;
            if(!vershina && this.vysota > glubineyshiy)
                glubineyshiy = this.vysota;
        }

        int vysota(boolean vershina, int coordinate) {
            int couterLeft = 1, counterRight = 1, iteratorLeft = coordinate - 2, iteratorRight = coordinate + 2;
            if (vershina){
                while (true){
                    if (iteratorLeft != - 1 && array[iteratorLeft] < array[iteratorLeft + 1]) {
                        couterLeft++;
                        iteratorLeft--;
                    }
                    else
                        break;
                }
                while (true){
                    if (iteratorRight != array.length && array[iteratorRight] < array[iteratorRight - 1]) {
                        counterRight++;
                        iteratorRight++;
                    }
                    else
                        break;
                }
                return Math.min(couterLeft, counterRight);
            }
            else {
                while (true){
                    if (iteratorLeft != -1 && array[iteratorLeft] > array[iteratorLeft + 1] ) {
                        couterLeft++;
                        iteratorLeft--;
                    }
                    else
                        break;
                }
                while (true){
                    if (iteratorRight != array.length && array[iteratorRight] > array[iteratorRight - 1]  ) {
                        counterRight++;
                        iteratorRight++;
                    }
                    else break;
                }
                return Math.min(couterLeft, counterRight);
            }
        }
    }
}
