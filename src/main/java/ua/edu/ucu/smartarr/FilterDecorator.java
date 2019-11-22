package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private MyPredicate predicate;
    public FilterDecorator(SmartArray smartArray, MyPredicate pred){
        super(smartArray);
        predicate = pred;
        deleteNonPredicate();
    }

    private void deleteNonPredicate() {
        int res_size = size();
        Object[] arr = toArray();
        for (int i = 0; i < size(); i++) {
            if (!predicate.test(arr[i])) {
                arr[i] = null;
                res_size -= 1;
            }
        }
        Object[] res = new Object[res_size];
        int cur_index = 0;
        for (int i = 0; i < size(); i++) {
            if (arr[i] != null) {
                res[cur_index] = arr[i];
                cur_index++;
            }
        }
        SmartArray result = returnCopy();
        result.setArr(res);
        smartArray = result;
        //return result;
        //setArr(res);
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
        return smartArray.operationDescription() + "FilterDecorator\n";
    }

    @Override
    public SmartArray returnCopy() {
        return smartArray.returnCopy();
    }

}
