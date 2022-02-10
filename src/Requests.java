import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Requests {
    public static void main(String[] args) {
        ArrayList<Request> arrayList = new ArrayList<>();
        arrayList.add(new Request(13, 12));
        arrayList.add(new Request(5, 6));
        for (Request a: arrayList
             ) {
            System.out.println(a.endTime);
        }
        arrayList.sort(Request.comparator);
        for (Request a: arrayList
        ) {
            System.out.println(a.endTime);
        }

    }
    static class  Request {
        int startTime, endTime;

        public Request(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        static final Comparator<Request> comparator = Comparator.comparingInt((Request o) -> o.endTime);
    }
}
