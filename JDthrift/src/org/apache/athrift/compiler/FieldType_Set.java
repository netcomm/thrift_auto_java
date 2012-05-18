package org.apache.athrift.compiler;

public class FieldType_Set extends FieldType {
    FieldType type;

    public void setType(FieldType type) {
        this.type = type;
    }

    public FieldType getType() {
        return type;
    }
    
    public String getTypeDescr() {
        return "set";
    }
}
