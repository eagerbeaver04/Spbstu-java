package MyStack;

import java.util.Arrays;

public class MyStack<T>
{
    private int length = 0;
    private T[] values;
    public MyStack(int i)
    {
        length = i;
        values = (T[]) new Object[i];
    }
    public boolean isEmpty()
    {
        return values.length == 0;
    }
    public void push(T i)
    {
        if(length == values.length)
            values = Arrays.copyOf(values, 2 * values.length);

        values[length] = i;
        length++;
    }
    public T pop()
    {
        if(!isEmpty())
        {
            length--;
            T tmp = values[length];
            values[length] = null;
            return tmp;
        }
        System.out.println("Stack is empty");
        return null;
    }
    public void print()
    {
        if(!isEmpty())
            for(int i = 0; i < length; i++)
                System.out.println("[" + i + "]: " + values[i]);
    }

}
