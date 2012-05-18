package org.apache.athrift.compiler;

import java.util.ArrayList;

public class Enum {
    private String name;
    private ArrayList itemList = new ArrayList();
    public void setName(String name) {
        this.name = name;
    }
    public void setItemList(ArrayList itemList) {
        this.itemList = itemList;
    }
    public String getName() {
        return name;
    }
    public ArrayList getItemList() {
        return itemList;
    }
}
