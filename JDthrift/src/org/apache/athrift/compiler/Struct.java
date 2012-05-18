package org.apache.athrift.compiler;

import java.util.ArrayList;

public class Struct {
    private String name;
    private ArrayList<Field> fieldList = new ArrayList<Field>();
    public void setName(String theName) {
        this.name = theName;
    }
    public void setFieldList(ArrayList<Field> theFieldList) {
        this.fieldList = theFieldList;
    }
    public String getName() {
        return name;
    }
    public ArrayList<Field> getFieldList() {
        return fieldList;
    }
}
