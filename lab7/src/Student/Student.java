package Student;

public class Student
{
    private String name;
    private String surname;
    private int age;
    private String group;
    public Student(String name_, String surname_, int age_, String group_)
    {
        name= name_;
        surname = surname_;
        age = age_;
        group = group_;
    }

    public void swap(Student student)
    {
        String name_tmp = student.name;
        String surname_tmp = student.surname;
        int age_tmp = student.age;
        String group_tmp = student.group;

        student.name = this.name;
        student.surname = this.surname;
        student.age = this.age;
        student.group = this.group;

        this.name = name_tmp;
        this.surname = surname_tmp;
        this.age = age_tmp;
        this.group = group_tmp;
    }

    public void print()
    {
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Age: " + age);
        System.out.println("Group: " + group);
        System.out.println();
    }

}
