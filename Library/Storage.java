package Library;
import java.util.*;
public class Storage{
    int capacity;
    List<Ingredient> list = new ArrayList<Ingredient>();
    Storage()
    {
        capacity = 0;
    }
    Storage(int cap, List<Ingredient> l)
    {
        this.capacity = cap;
        this.list = l;
    }
    Storage(Storage s)
    {
        this.capacity = s.getCapacity();
        this.list = s.getList();
    }
    public int getCapacity() {
        return capacity;
    }
    public List<Ingredient> getList() {
        return list;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setList(List<Ingredient> list) {
        this.list = list;
    }
}