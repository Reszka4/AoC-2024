// TODO: Finish second part of AoC Day 2
import java.io.*;
import java.util.*;

class Program {

    public static void main(String[] args) throws FileNotFoundException {
        int counter = 0;
        int index = 0;
        int outcome;
        ArrayList<ArrayList<Integer>> nestedList = new ArrayList<>();
        File file = new File("Data.txt");

        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] numbers = line.split(" ");

            nestedList.add(new ArrayList<>());

            for (String numStr : numbers) {
                nestedList.get(index).add(Integer.parseInt(numStr));
            }

            index++;
        }

        for (int i = 0; i < nestedList.size(); i++) {
            outcome = 1; // Base outcome 1 == line is safe
            for (int j = 1; j < nestedList.get(i).size(); j++) {
                if (
                    (nestedList.get(i).get(0) < nestedList.get(i).get(1) &&
                        nestedList.get(i).get(j - 1) <
                        nestedList.get(i).get(j)) ||
                    (nestedList.get(i).get(0) > nestedList.get(i).get(1) &&
                        nestedList.get(i).get(j - 1) > nestedList.get(i).get(j))
                ) {
                    if (
                        Math.abs(
                                (nestedList.get(i).get(j - 1) -
                                    nestedList.get(i).get(j))
                            ) >
                            3 ||
                        Math.abs(
                            (nestedList.get(i).get(j - 1) -
                                nestedList.get(i).get(j))
                        ) <
                        1
                    ) outcome = 0;
                } else {
                    outcome = 0;
                }
            }
            counter += outcome;
        }

        System.out.println(counter);

        scanner.close();
    }
}
