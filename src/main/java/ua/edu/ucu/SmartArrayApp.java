package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {
        SmartArray sa = new BaseArray(students);
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                final int year = 2;
                final int gpa = 4;
                return ((Student)t).getYear() == year && ((Student)t).getGPA() >= gpa;
            }
        };
        MyFunction f = new MyFunction() {
            @Override
            public Object apply(Object t) {
                String res = "";
                res += ((Student)t).getSurname();
                res += " ";
                res += ((Student)t).getName();
                return (Object) res;
            }
        };
        MyComparator c = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Student) o1).getSurname().compareTo(
                        ((Student) o2).getSurname());
            }
        };
        sa = new DistinctDecorator(sa);
        sa = new FilterDecorator(sa, pr);
        sa = new SortDecorator(sa, c);
        sa = new MapDecorator(sa, f);

        Object[] result = sa.toArray();
        // Hint: to convert Object[] to String[] - use the following code
        //Object[] result = studentSmartArray.toArray();
        //return Arrays.copyOf(result, result.length, String[].class);
        return Arrays.copyOf(result, result.length, String[].class);
    }
}
