package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {

    MyComparator comparator;
    public SortDecorator(SmartArray smartArray, MyComparator c) {
        super(smartArray);
        comparator = c;
        sortElements();
    }

    private void sortElements() {
        Object[] arr = toArray();
        Arrays.sort(arr, comparator);

        SmartArray result = returnCopy();
        result.setArr(arr);
        smartArray = result;
        //return result;
        //setArr(arr);
    }

    @Override
    public void setArr(Object[] arr) {
        smartArray.setArr(arr);
    }

    @Override
    public Object[] toArray() {
        return smartArray.toArray();
    }

    @Override
    public int size() {
        return smartArray.size();
    }

    @Override
    public String operationDescription() {
        return smartArray.operationDescription() + "SortDecorator\n";
    }

    @Override
    public SmartArray returnCopy() {
        return smartArray.returnCopy();
    }
}
