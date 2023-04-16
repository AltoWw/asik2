public class MyArrayList {
    private Object[] elements;
    private int size;

    public  MyArrayList() {
        elements = new Object[10];
        size = 0;
    }


    public int size() {
        return size;
    }

    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

}
