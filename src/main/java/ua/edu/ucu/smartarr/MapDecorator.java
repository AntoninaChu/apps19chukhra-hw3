package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    MyFunction function;
    public MapDecorator(SmartArray smartArray, MyFunction f) {
        super(smartArray);
        function = f;
        representsObjects();
    }

    private void representsObjects() {
        Object[] arr = toArray();
        Object[] res = new Object[arr.length];
        for (int i = 0; i < size(); i++) {
            res[i] = function.apply(arr[i]);
        }
        SmartArray result = returnCopy();
        result.setArr(res);
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
        return smartArray.operationDescription() + "MapDecorator\n";
    }

    @Override
    public SmartArray returnCopy() {
        return smartArray.returnCopy();
    }
}
