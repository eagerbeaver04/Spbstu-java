package Wrapper;

public class Wrapper<Type>
{
    private Type data;
    public Wrapper(Type a) {
        data = a;
    }
    public Type getData()
    {
        return data;
    }
    public void swap(Wrapper<Type> obj2)
    {
        Type tmp = data;
        data = obj2.data;
        obj2.data = tmp;
    }
}
