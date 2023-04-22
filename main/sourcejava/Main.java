package sourcejava;


import java.util.Arrays;
import java.util.Comparator;

public class Main {
    Comparator<String> stringToNumberComparator = (left, right) -> {
        int val = 0;
        if(left.charAt(0) == '-' && right.charAt(0) != '-'){
            return -1;
        }
        else if(right.charAt(0) == '-' && left.charAt(0) != '-'){
            return 1;
        } else {
            String leftPreDecimal = (left.contains(".")) ? left.substring(0, left.indexOf(".")) : left;
            String rightPreDecimal = (right.contains(".")) ? right.substring(0, right.indexOf(".")) : right;
            if(leftPreDecimal.length() > rightPreDecimal.length()){
                val =  1;
            } else if (leftPreDecimal.length() < rightPreDecimal.length()){
                val =  -1;
            } else {
                val = left.compareTo(right);
            }
        }
        return (left.charAt(0) == '-' && right.charAt(0) == '-') ? -val : val;
    };

    public String[] sortStringsAsNumbers(String[] arrayToSort) {
        Arrays.sort(arrayToSort, stringToNumberComparator);
        return arrayToSort;
    }
}
