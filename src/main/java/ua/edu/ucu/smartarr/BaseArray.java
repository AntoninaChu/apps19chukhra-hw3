package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray{
    private Object[] arr;

    @Override
    public void setArr(Object[] arr) {
        this.arr = arr;
    }

    public BaseArray(Object[] arr) {
        this.arr = arr;
    }

    @Override
    public Object[] toArray() {
        int arrSize = size();
        Object[] result = new Object[arrSize];
        for (int i = 0; i < arrSize; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    @Override
    public String operationDescription() {
        return " ";
    }

    @Override
    public int size() {
        return arr.length;
    }

    public void setValue(int index) {
        if (index >= size() && index < 0){
            throw new IndexOutOfBoundsException();
        }
        arr[index] = 0;
    }

    @Override
    public BaseArray returnCopy() {
        return new BaseArray(toArray());
    }
}
