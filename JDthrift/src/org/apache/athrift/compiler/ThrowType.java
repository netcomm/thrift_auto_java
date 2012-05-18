package org.apache.athrift.compiler;

import java.util.ArrayList;

public class ThrowType {
    private ArrayList<Field> fieldList = new ArrayList<Field>();

    public void setFieldList(ArrayList<Field> fieldList) {
        this.fieldList = fieldList;
    }

    public ArrayList<Field> getFieldList() {
        return fieldList;
    }
}
