/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practical.pkg3;

/**
 *
 * @author Sylvia Tan
 */
public class ArraySet<T> implements SetInterface<T> {

    T[] setArray;
    private int numberOfElements;
    private static final int DEFAULT_CAPACITY = 5;

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public ArraySet() {
        this(DEFAULT_CAPACITY);
    }

    public ArraySet(int capacity) {
        setArray = (T[]) new Object[capacity];
        numberOfElements = 0;
    }

    @Override
    public boolean add(T newElement) {
        //Since it is a set
        //add newElement should not have existed in the setArray
        for (int i = 0; i < numberOfElements; i++) {
            if (setArray[i].equals(newElement)) {
                return false;
            }
        }

        //cannot add if the array is full
        if (isArrayFull()) {
            doubleArray();
        }

        //ready to add
        setArray[numberOfElements] = newElement;
        numberOfElements++;
        return true;
    }

    @Override
    public boolean remove(T anElement) {
        //if the array is empty
        //if anElement does not exist
        if (isEmpty()) {
            return false;
        }

        for (int i = 0; i < numberOfElements; i++) {
            if (setArray[i].equals(anElement)) {
                //shift all elements up
                removeGap(i);
                numberOfElements--;
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {

        String output = "";
        for (int i = 0; i < numberOfElements; i++) {
            output += setArray[i] + " ";
        }

        output += "\n";
        return output;
    }

    @Override
    public boolean isEmpty() {
        return numberOfElements < 0;
    }

    private boolean isArrayFull() {
        return numberOfElements == setArray.length;
    }

    private void doubleArray() {
        T[] temp = setArray;
        int capacity = temp.length;

        setArray = (T[]) new Object[2 * capacity];

        System.arraycopy(temp, 0, setArray, 0, capacity);
    }

    private void removeGap(int index) {
        for (int i = index; i < numberOfElements - 1; i++) {
            setArray[i] = setArray[i + 1];
        }
    }

    @Override
    public void union(SetInterface anotherSet) {
        // make sure another set is an instance of arrayset
        if (anotherSet instanceof ArraySet) {
            ArraySet aSet = (ArraySet) anotherSet;

            for (int i = 0; i < aSet.numberOfElements; i++) {
                add((T) aSet.setArray[i]);
            }
        }
    }

    @Override
    public SetInterface intersection(SetInterface anotherSet) {

        SetInterface<T> tmp = new ArraySet<>();

        if (anotherSet instanceof ArraySet) {
            ArraySet aSet = (ArraySet) anotherSet;

            for (int i = 0; i < numberOfElements; i++) {
                boolean found = false;
                for (int j = 0; j < aSet.numberOfElements && !found; j++) {
                    if (setArray[i].equals(aSet.setArray[j])) {
                        found = true;
                        tmp.add((T) aSet.setArray[j]);
                    }
                }
            }
        }

        return tmp;
    }

    @Override
    public boolean checkSubset(SetInterface anotherSet) {
        if (anotherSet instanceof ArraySet) {
            ArraySet aSet = (ArraySet) anotherSet;
            if (this.numberOfElements < aSet.numberOfElements) {
                return false;
            }

            for (int i = 0; i < aSet.numberOfElements; i++) {
                boolean found = false;
                for (int j = 0; j < aSet.numberOfElements && !found; j++) {
                    if(setArray[j].equals(aSet.setArray[i]))
                        found = true;
                }
                if(!found) return false;
            }
            
        }
        return true;
    }
    
    public int size() {
        return numberOfElements;
    }
    public int length() {
        return setArray.length;
    }
}
