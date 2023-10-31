
public class Main
{

    public static void main(String[] args)
    {
        double a = 3.14;
        double b = 2.26;
        System.out.println("min" + (a < b ? a : b));
        System.out.println((true && false) || (true && !false));
        int a1 = 2; //010
        int b1 = 5; //101
        System.out.println("a1 && b1: " + (a1 & b1)); //(*)
        System.out.println("a1 || b1: " + (a1 | b1)); //(+)
        System.out.println("a1 XOR b1: " + (a1 ^ b1)); //(XOR)
        System.out.println(Integer.toBinaryString(~b1));
        // 010 -> 2;
        // ~5 = 11111111111111111111111111111010 =
        // 01111111111111111111111111111010 + 10000000000000000000000000000000
        //+2147483642  - 2147483648 = -6
        System.out.println("~b1" + (~b1));

        System.out.println("b1 >> a1: " + (b1 >> a1));
        System.out.println("b1 >>> a1: " + (b1 >>> a1));
        System.out.println("a1 << b1: " + (a1 << b1));
    }
}