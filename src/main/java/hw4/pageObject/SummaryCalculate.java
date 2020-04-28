package hw4.pageObject;

import java.util.ArrayList;
import java.util.List;

public class SummaryCalculate {

    public SummaryCalculate() {

    }

    public String summaryCalc(List<String> numbers) {
        List<Integer> ints = new ArrayList<>();
        for (String number : numbers) {
            ints.add(Integer.parseInt(number));
        }
        return String.valueOf(ints.stream().mapToInt(Integer::intValue).sum());
    }
}
