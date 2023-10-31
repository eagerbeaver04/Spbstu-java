import MyStack.MyStack;

public class Main
{
    public static void main(String[] args)
    {
        MyStack inst  = new MyStack(5);
        inst.print();
        int i =0;
        while(!inst.isFull())
        {
            inst.push(i);
            i++;
        }
        inst.print();
        int b= inst.pop();
        System.out.println("Deleted element: " + b);
        inst.print();
    }
}