import java.io.*;
import java.util.*;

public class Program {

    public static void main(String[] args) throws FileNotFoundException {
        long output = 0;
        long counter = 0;
        File file = new File("Data.txt");

        ArrayList<Long> list1 = new ArrayList<>();
        ArrayList<Long> list2 = new ArrayList<>();

        Scanner sc = new Scanner(file);

        while (sc.hasNextLong()) {
            list1.add(sc.nextLong());
            list2.add(sc.nextLong());
        }

        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                //System.out.println(
                //     // list1.get(i).toString() +
                //     // " == " +
                //     // list2.get(j).toString() +
                //     // " -> " +
                //     // (list1.get(i) == list2.get(j))
                // );

                if (list1.get(i).equals(list2.get(j))) {
                    counter++;
                    System.out.println(true);
                }
            }
            //System.out.println(list1.get(i));
            //System.out.println(counter);
            //System.out.println("---------");
            output += list1.get(i) * counter;
            //System.out.println(output);
            counter = 0;
        }

        sc.close();

        System.out.println(output);
    }
}
