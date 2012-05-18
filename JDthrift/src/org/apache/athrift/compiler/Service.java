package org.apache.athrift.compiler;

import java.util.ArrayList;

public class Service {
    private String name;
    String extendService;
    ArrayList<Function> functionList = new ArrayList<Function>();
    public void setName(String name) {
        this.name = name;
    }
    public void setExtendService(String extendService) {
        this.extendService = extendService;
    }
    public void setFunctionList(ArrayList<Function> functionList) {
        this.functionList = functionList;
    }
    public String getName() {
        return name;
    }
    public String getExtendService() {
        return extendService;
    }
    public ArrayList<Function> getFunctionList() {
        return functionList;
    }
}
