import java.util.ArrayList;

public class MyStack<E> implements Stack<E> {
    private ArrayList<E> list;
    
    // Constructor creates ArrayList for stack
    public MyStack() {
        list = new ArrayList<E>();
    }
    
    // Checks if stack is empty via ArrayList
    public boolean isEmpty() {
        return list.size() == 0;
    }
    
    // Add elements (push) on the top of the stack
    //    Add to the end of the list
    public void push(E element) {
        list.add(element);
    }
    
    // Remove top element (pop) from the stack
    //   Element at the end of the list
    public E pop() {
        E val = peek();
        list.remove(list.size() - 1);
        return val;
    }
    
    // Look at top element in the stack
    //    Last element in list
    public E peek() {
        return list.get(list.size() - 1);
    }
}