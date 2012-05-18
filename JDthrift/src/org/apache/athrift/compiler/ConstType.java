package org.apache.athrift.compiler;

public class ConstType {
    private String name;
    private FieldType fieldType;
    private ConstValue constValue;
    public void setName(String name) {
        this.name = name;
    }
    public void setFieldType(FieldType fieldType) {
        this.fieldType = fieldType;
    }
    public void setConstValue(ConstValue constValue) {
        this.constValue = constValue;
    }
    public String getName() {
        return name;
    }
    public ConstValue getConstValue() {
        return constValue;
    }
    public FieldType getFieldType() {
        return fieldType;
    }
}
