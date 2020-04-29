/*
    Not on Leetcode 
    
    Reference:
    https://makeinjava.com/create-implement-stack-using-array-java-example/
*/

public class ImplementStackUsingArray {

    private int[] array;
    int size;
    int index=0;

    public ImplementStackUsingArray(int size) {
        this.size = size;
        array = new int[size];
    }

    public void push(int x) {
        array[index] = x;
        index++;
    }

    public int pop() {
        index--;
        return array[index];

    }

    public int peek() {
        return array[index-1];
    }

    public int size() {
        return index;
    }

    public boolean isEmpty() {
        if (index==0){
            return true;
        }else{
            return false;
        }
    }

    public boolean isFull() {
        if (index==size){
            return true;
        }else{
            return false;
        }
    }
}
