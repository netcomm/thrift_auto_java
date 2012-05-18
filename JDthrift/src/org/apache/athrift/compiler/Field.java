package org.apache.athrift.compiler;

public class Field {
    private String fieldID;
    private String fieldReq;
    private FieldType fieldType;
    private String name;
    private ConstValue defaultValue;
    public void setFieldID(String fieldID) {
        this.fieldID = fieldID;
    }
    public void setFieldReq(String fieldReq) {
        this.fieldReq = fieldReq;
    }
    public void setFieldType(FieldType fieldType) {
        this.fieldType = fieldType;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDefaultValue(ConstValue defaultValue) {
        this.defaultValue = defaultValue;
    }
    public String getFieldID() {
        return fieldID;
    }
    public String getFieldReq() {
        return fieldReq;
    }
    public FieldType getFieldType() {
        return fieldType;
    }
    public String getName() {
        return name;
    }
    public ConstValue getDefaultValue() {
        return defaultValue;
    }
}
