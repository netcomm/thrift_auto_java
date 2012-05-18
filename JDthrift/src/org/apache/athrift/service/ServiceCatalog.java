package org.apache.athrift.service;

import java.util.HashMap;

public class ServiceCatalog {
    private static ServiceCatalog theService = new ServiceCatalog();
    
    private ServiceCatalog()
    {
        
    }
    
    public static ServiceCatalog getInstance()
    {
        return theService;
    }
    
    private HashMap serviceHMap_WithFilePrefix = new HashMap();
    private HashMap structHMap_WithFilePrefix = new HashMap();
    private HashMap typedefsHMap_WithFilePrefix = new HashMap();
    private HashMap enumHMap_WithFilePrefix = new HashMap();
    private HashMap constantHMap_WithFilePrefix = new HashMap();
    private HashMap exceptionHMap_WithFilePrefix = new HashMap();

    public static ServiceCatalog getTheService() {
        return theService;
    }

    public static void setTheService(ServiceCatalog theService) {
        ServiceCatalog.theService = theService;
    }

    public HashMap getServiceHMap_WithFilePrefix() {
        return serviceHMap_WithFilePrefix;
    }

    public void setServiceHMap_WithFilePrefix(HashMap serviceHMap_WithFilePrefix) {
        this.serviceHMap_WithFilePrefix = serviceHMap_WithFilePrefix;
    }

    public HashMap getStructHMap_WithFilePrefix() {
        return structHMap_WithFilePrefix;
    }

    public void setStructHMap_WithFilePrefix(HashMap structHMap_WithFilePrefix) {
        this.structHMap_WithFilePrefix = structHMap_WithFilePrefix;
    }

    public HashMap getTypedefsHMap_WithFilePrefix() {
        return typedefsHMap_WithFilePrefix;
    }

    public void setTypedefsHMap_WithFilePrefix(HashMap typedefsHMap_WithFilePrefix) {
        this.typedefsHMap_WithFilePrefix = typedefsHMap_WithFilePrefix;
    }

    public HashMap getEnumHMap_WithFilePrefix() {
        return enumHMap_WithFilePrefix;
    }

    public void setEnumHMap_WithFilePrefix(HashMap enumHMap_WithFilePrefix) {
        this.enumHMap_WithFilePrefix = enumHMap_WithFilePrefix;
    }

    public HashMap getConstantHMap_WithFilePrefix() {
        return constantHMap_WithFilePrefix;
    }

    public void setConstantHMap_WithFilePrefix(HashMap constantHMap_WithFilePrefix) {
        this.constantHMap_WithFilePrefix = constantHMap_WithFilePrefix;
    }

    public HashMap getExceptionHMap_WithFilePrefix() {
        return exceptionHMap_WithFilePrefix;
    }

    public void setExceptionHMap_WithFilePrefix(HashMap exceptionHMap_WithFilePrefix) {
        this.exceptionHMap_WithFilePrefix = exceptionHMap_WithFilePrefix;
    }
    
}
