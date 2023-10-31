package MyStack;

import java.lang.reflect.Array;

public class MyStack
{
    private final int capacity;
    private int top;
    private final int[] values;
    public MyStack(int i)
    {
        capacity = i;
        top = -1;
        values = new int[capacity];
    }
    public boolean isEmpty()
    {
        return top == -1;
    }
    public boolean isFull()
    {
        return top == capacity -1;
    }
    public void push(int i)
    {
        if(isFull())
        {
            System.out.println("Stack is full");
            return;
        }
        top++;
        values[top] = i;
    }
    public int pop()
    {
        if(!isEmpty())
        {
            top--;
            return values[top+1];
        }
        System.out.println("Stack is empty");
        return 0;
    }
    public void print()
    {
        if(!isEmpty())
            for(int i = 0; i <= top; i++)
                System.out.println("[" + i + "]: " + values[i]);
    }

}
