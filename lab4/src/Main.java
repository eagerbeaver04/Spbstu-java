
public class Main
{
    public static void main(String[] args)
    {
        int i = 5;
        short s = 4;
        byte b = 12;
        char c = 'M';
        switch(i)
        {
            case 1 -> System.out.println("i = 1");
            case 5 -> System.out.println("i = 4");
            default -> System.out.println("no number for int i in switch");
        }
        switch(s)
        {
            case 1 -> System.out.println("s = 1");
            case 5 -> System.out.println("s = 5");
            default -> System.out.println("no number for short s in switch");
        }
        switch(b)
        {
            case 12 -> System.out.println("b = 12");
            case 5 -> System.out.println("b = 5");
            default -> System.out.println("no number for byte b in switch");
        }
        switch(c)
        {
            case 'm' -> System.out.println("c = m");
            case 'M' -> System.out.println("c = M");
            default -> System.out.println("no symbol for char c in switch");
        }
    }
}