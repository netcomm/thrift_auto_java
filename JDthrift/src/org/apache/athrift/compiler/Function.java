package org.apache.athrift.compiler;

import java.util.ArrayList;

public class Function {
    private boolean isOneWay = false;
    private FieldType functionType;
    private String name;
    private ArrayList<Field> argsList = new ArrayList<Field>();
    private ThrowType throwType;
    public void setOneWay(boolean isOneWay) {
        this.isOneWay = isOneWay;
    }
    public void setFunctionType(FieldType functionType) {
        this.functionType = functionType;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setThrowType(ThrowType throwType) {
        this.throwType = throwType;
    }
    public void setArgsList(ArrayList<Field> argsList) {
        this.argsList = argsList;
    }
    public boolean isOneWay() {
        return isOneWay;
    }
    public FieldType getFunctionType() {
        return functionType;
    }
    public String getName() {
        return name;
    }
    public ArrayList<Field> getArgsList() {
        return argsList;
    }
    public ThrowType getThrowType() {
        return throwType;
    }
}
