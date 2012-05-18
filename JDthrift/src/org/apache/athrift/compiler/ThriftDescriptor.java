package org.apache.athrift.compiler;

import java.util.ArrayList;
import java.util.HashMap;

public class ThriftDescriptor {
    private String thriftName;
    private ArrayList serviceList = new ArrayList();
    private ArrayList structList = new ArrayList();
    private ArrayList typedefsList = new ArrayList();
    private ArrayList enumList = new ArrayList();
    private ArrayList constantList = new ArrayList();
    private ArrayList exceptionList = new ArrayList();
    private ArrayList includeList = new ArrayList();
    
    public ArrayList<String> getIncludeList() {
        return includeList;
    }

    public ArrayList<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(ArrayList serviceList) {
        this.serviceList = serviceList;
    }

    public ArrayList<Struct> getStructList() {
        return structList;
    }

    public void setStructList(ArrayList structList) {
        this.structList = structList;
    }

    public ArrayList<Typedef> getTypedefsList() {
        return typedefsList;
    }

    public void setTypedefsList(ArrayList typedefsList) {
        this.typedefsList = typedefsList;
    }

    public ArrayList<Enum> getEnumList() {
        return enumList;
    }

    public void setEnumList(ArrayList enumList) {
        this.enumList = enumList;
    }

    public ArrayList<ConstType> getConstantList() {
        return constantList;
    }

    public void setConstantList(ArrayList constantList) {
        this.constantList = constantList;
    }

    public ArrayList<Struct> getExceptionList() {
        return exceptionList;
    }

    public void setExceptionList(ArrayList exceptionList) {
        this.exceptionList = exceptionList;
    }

    public void setIncludeList(ArrayList includeList) {
        this.includeList = includeList;
    }

    public String getThriftName() {
        return thriftName;
    }

    public void setThriftName(String thriftName) {
        this.thriftName = thriftName;
    }
}
