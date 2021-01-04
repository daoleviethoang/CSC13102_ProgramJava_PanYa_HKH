package PanyaCore;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
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
    public void add(Ingredient i) {
        list.add(i);
    }
    public void delete(String id) {
        for(int i = list.size() - 1; i >= 0 ;i++) {
            if (list.get(i).getId().compareTo(id) == 0) {
                list.remove(i);
            }
        }
    }
    public void update(Ingredient in) {
        for(int i = list.size() - 1; i >= 0 ;i++) {
            if (list.get(i).getId().compareTo(in.getId()) == 0) {
                list.get(i).setName(in.getName());
                list.get(i).setQuantity(in.getQuantity());
                list.get(i).setUnit(in.getUnit());
                list.get(i).setPrice(in.getPrice());
                list.get(i).setNote(in.getNote());

            }
        }
    }
    public void importIngre(String id, BigDecimal q) {
        for(int i = list.size() - 1; i >= 0 ;i++) {
            if (list.get(i).getId().compareTo(id) == 0) {
                list.get(i).setQuantity(q);
            }
        }
    }
    public List<Ingredient> search(String text) {
        List<Ingredient> result = new ArrayList<Ingredient>();
        String[] part_text = text.split(" ");               //lấy từng từ trong text
        for(int i = 0; i < list.size(); i++) {              //xét từng ingredient
            for(int j = 0; j < part_text.length; j++){      //xem có từ nào trong name hay ko?
                if(list.get(i).getName().contains(part_text[j])){
                    result.add(list.get(i));
                }
            }
        }
        return result;
    }
}
