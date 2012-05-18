package org.apache.athrift.compiler;

public class FieldType_HMap extends FieldType {
    FieldType keyType;
    FieldType valueType;
    public void setKeyType(FieldType keyType) {
        this.keyType = keyType;
    }
    
    public void setValueType(FieldType valueType) {
        this.valueType = valueType;
    }

    public FieldType getKeyType() {
        return keyType;
    }

    public FieldType getValueType() {
        return valueType;
    }
    
    public String getTypeDescr() {
        return "map";
    }
}
