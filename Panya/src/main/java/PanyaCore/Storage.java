package PanyaCore;

import java.util.ArrayList;
import java.util.List;

/**
 * Object Storage quản lý nhà kho trong phần mềm Pan-ya
 */
public class Storage {
    int capacity = 0;
    List<Ingredient> list = new ArrayList<Ingredient>();

    Storage() {
        this.capacity = 0;
    }

    /**
     * Constructor cho một object Storage
     * 
     * @param cap dung tích tối đa của nhà kho
     * @param l   List<Ingredient> là một danh các nguyên liệu (Ingredient) hiện có
     * @throws NullPointerException khi l <code>null</code>
     * @see PanyaCore.Ingredient
     */
    Storage(int cap, List<Ingredient> l) throws NullPointerException {
        this.capacity = cap;
        try {
            this.list = new ArrayList<>(l);
        } catch (NullPointerException e) {
            throw e;
        }
    }

    Storage(Storage s) {
        this.capacity = s.getCapacity();
        this.list = new ArrayList<>(s.getList());
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
        this.list = new ArrayList<>(list);
    }

}
