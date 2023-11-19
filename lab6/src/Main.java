import MyStack.MyStack;

public class Main
{
    public static void main(String[] args)
    {
        MyStack<Integer> inst  = new MyStack<Integer>(1);
        System.out.println("Base constructor");
        inst.print();
        System.out.println("Pushing...");
        for (int index = 0; index < 10; index += 1)
            inst.push(index);

        inst.print();
        int b = inst.pop();
        System.out.println("Deleted element: " + b);
        inst.print();
    }
}