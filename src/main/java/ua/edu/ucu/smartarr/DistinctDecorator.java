package ua.edu.ucu.smartarr;
import ua.edu.ucu.Student;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        deleteEquals();
    }

    private void deleteEquals() {
        int res_size = size();
        Object[] arr = toArray();
        for (int i = 0; i < size(); i++) {
            if (arr[i] != null) {
                for (int j = i + 1; j < size(); j++) {
                    if (equals(arr[i],arr[j])) {
                        arr[j] = null;
                        res_size -= 1;
                    }
                }
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

    private boolean equals(Object first, Object second) {
        if (first instanceof Student && second instanceof Student) {
            if (((Student) first).getGPA() == ((Student) second).getGPA() &&
            ((Student) first).getName() == ((Student) second).getName() &&
            ((Student) first).getSurname() == ((Student) second).getSurname() &&
            ((Student) first).getYear() == ((Student) second).getYear()){
                return true;
            }
        } else {
            return first.equals(second);
        }
        return false;
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
        return smartArray.operationDescription() + "DistinctDecorator\n";
    }

    @Override
    public SmartArray returnCopy() {
        return smartArray.returnCopy();
    }
}
