import Student.Student;
public class Main
{
    public static void main(String[] args)
    {
        Student st1 = new Student("Mikhail", "Markov", 19, "5030102/10201" );
        Student st2 = new Student("Vasya", "Pupkin", 40, "3");
        System.out.println("st1: ");st1.print();
        System.out.println("st2: ");st2.print();
        st1.swap(st2);
        System.out.println("former st1: ");st1.print();
        System.out.println("former st2: ");st2.print();

    }
}