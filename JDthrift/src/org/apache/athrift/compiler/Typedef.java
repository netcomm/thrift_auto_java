package org.apache.athrift.compiler;

public class Typedef {
    private String name;
    private FieldType fieldType;
    public void setName(String name) {
        this.name = name;
    }
    public void setFieldType(FieldType fieldType) {
        this.fieldType = fieldType;
    }
    public String getName() {
        return name;
    }
    public FieldType getFieldType() {
        return fieldType;
    }
}
