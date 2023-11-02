import Triple.Triple;

public class Main
{
    public static void print(Triple<?> instance)
    {
        try
        {
            System.out.println("Min: " + instance.min());
            System.out.println("Max: " + instance.max());
            System.out.println("Mean: " + instance.mean());
        }
        catch (RuntimeException e)
        {
            System.out.println("Exeption: " + e.getMessage());
        }
    }

    public static void main(String[] args)
    {

        Triple<Integer> inst1 = new Triple<>(1, 2, 3);
        inst1.setSecond(10);
        print(inst1);

        Triple<String> inst2 = new Triple<>("A", "b", "C");
        inst2.setFirst("0");
        print(inst2);
    }
}