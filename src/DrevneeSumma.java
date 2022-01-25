import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class DrevneeSumma {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
            FileWriter fileWriter = new FileWriter("output.txt");
            fileWriter.write(parseString(parseInt(parseArray(bufferedReader.readLine())) +
                    parseInt(parseArray(bufferedReader.readLine()))));
            fileWriter.flush();
            fileWriter.close();
        }

        public static ArrayList<Integer> parseArray(String string) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            StringTokenizer stringTokenizer = new StringTokenizer(string);
            while(stringTokenizer.hasMoreTokens()) {
                arrayList.add(parseIntRate(stringTokenizer.nextToken()));
            }
            return arrayList;
        }
        public static int parseIntRate(String string) {
            int a = 0;
            for (int i = 0; i < string.length(); i++) {
                if(string.charAt(i) == 46){
                    a += 1;
                    continue;
                }
                if(string.charAt(i) == 124){
                    a += 5;
                }
            }
            return a;
        }
        public static int parseInt(ArrayList<Integer> arrayList) {
            int a = 0;
            int counter = 0;
            Collections.reverse(arrayList);
            for (int i = 0; i < arrayList.size(); i++) {
                a += arrayList.get(i) * Math.pow(20, counter++);
            }
            return a;
        }
        public static String parseIntRate(int a) {
            if(a == 0)
                return "*";
            String string = "";
            int numberOfUnits = a % 5;
            int numberOfLines = a / 5;
            for (int i = 0; i < numberOfUnits; i++) {
                string += ".";
            }
            for (int i = 0; i < numberOfLines; i++) {
                string += "|";
            }
            return string;
        }
        public static String parseString (int a ) {
            if(a == 0){
                return "*";
            }
            int counter = 0;
            String string = "";
            while (a/(int) Math.pow(20,counter) !=0){
                counter ++;
            }
            counter--;
            for (int i = counter; i >= 0; i--) {
                string += parseIntRate(a / (int) Math.pow(20 , i)) + " ";
                a -= (int) (a/ Math.pow(20 , i))*Math.pow(20 , i);
            }
            return string.substring(0, string.length() - 1);
        }
}
