package org.apache.athrift.service;

import java.util.HashMap;

import org.apache.athrift.compiler.ConstType;
import org.apache.athrift.compiler.Service;
import org.apache.athrift.compiler.Struct;
import org.apache.athrift.compiler.ThriftDescriptor;
import org.apache.athrift.compiler.Typedef;
import org.apache.athrift.service.type.ExceptionType;
import org.apache.athrift.service.type.ThriftConstant;
import org.apache.athrift.service.type.TypedefBaseType;
import org.apache.athrift.service.type.struct.ThriftStruct;

public class ThriftServicesParser {
    private HashMap theServiceHMap = new HashMap();
    private HashMap theStructHMap = new HashMap();
    private HashMap theTypedefsHMap = new HashMap();
    private HashMap theEnumHMap = new HashMap();
    private HashMap theConstantHMap = new HashMap();
    private HashMap theExceptionHMap = new HashMap();
    
    public ThriftServicesParser()
    {
        
    }
    
    public void generateServices(ThriftDescriptor theOneThriftDescriptorParm)
    {
        try
        {
            for (int i = 0; i < theOneThriftDescriptorParm.getTypedefsList().size(); i++)
            {
                Typedef tmpOneTypedef = theOneThriftDescriptorParm.getTypedefsList().get(i);
                TypedefBaseType tmpNewTypedef =
                        new TypedefBaseType(tmpOneTypedef, this);
                theTypedefsHMap.put(tmpNewTypedef.getName(),
                        tmpNewTypedef);
                ServiceCatalog.getInstance().getTypedefsHMap_WithFilePrefix()
                    .put(theOneThriftDescriptorParm.getThriftName()+"."+tmpNewTypedef.getName(),
                        tmpNewTypedef);
            }
            
            for (int i = 0; i < theOneThriftDescriptorParm.getConstantList().size(); i++)
            {
                ConstType tmpConstType = theOneThriftDescriptorParm.getConstantList().get(i);
                ThriftConstant tmpConstant =
                    new ThriftConstant(tmpConstType, this);
                theConstantHMap.put(tmpConstant.getName(), tmpConstant);
                ServiceCatalog.getInstance().getConstantHMap_WithFilePrefix()
                    .put(theOneThriftDescriptorParm.getThriftName()+"."+tmpConstant.getName(), tmpConstant);
            }
            
            for (int i = 0; i < theOneThriftDescriptorParm.getEnumList().size(); i++)
            {
                org.apache.athrift.compiler.Enum tmpEnumType =
                    theOneThriftDescriptorParm.getEnumList().get(i);
                generateEnum(tmpEnumType, theOneThriftDescriptorParm.getThriftName());
            }
            
            for (int i = 0; i < theOneThriftDescriptorParm.getStructList().size(); i++)
            {
                Struct tmpOneStruct = theOneThriftDescriptorParm.getStructList().get(i);
                generateStruct(tmpOneStruct, theOneThriftDescriptorParm.getThriftName());
            }
            
            for (int i = 0; i < theOneThriftDescriptorParm.getExceptionList().size(); i++)
            {
                Struct tmpExceptionType = theOneThriftDescriptorParm.getExceptionList().get(i);
                generateException(tmpExceptionType, theOneThriftDescriptorParm.getThriftName());
            }
            
            for (int i = 0; i < theOneThriftDescriptorParm.getServiceList().size(); i++)
            {
                Service tmpService = theOneThriftDescriptorParm.getServiceList().get(i);
                generateService(tmpService, theOneThriftDescriptorParm.getThriftName());
            }
            
            System.out.println("struct size: "+theStructHMap.size());
            System.out.println("service size: "+theServiceHMap.size());
            
            for (Object tmpStruct: theStructHMap.values())
            {
                System.out.println(tmpStruct);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    private void generateStruct(Struct theOneStructParm, String thriftNameParm) throws Exception
    {
        ThriftStruct tmpNewStruct = new ThriftStruct(theOneStructParm, this);
        theStructHMap.put(tmpNewStruct.getName(), tmpNewStruct);
        ServiceCatalog.getInstance().getStructHMap_WithFilePrefix()
            .put(thriftNameParm+"."+tmpNewStruct.getName(), tmpNewStruct);
    }
    
    private void generateService(Service theServiceParm, String thriftNameParm) throws Exception
    {
        ThriftService tmpNewService =
                new ThriftService(theServiceParm, this);
        theServiceHMap.put(tmpNewService.getName(), tmpNewService);
        ServiceCatalog.getInstance().getServiceHMap_WithFilePrefix().put(
            thriftNameParm+"."+tmpNewService.getName(), tmpNewService);
    }
    
    private void generateException(Struct theExceptionTypeParm, String thriftNameParm)
        throws Exception
    {
        ExceptionType tmpNewException = new ExceptionType(theExceptionTypeParm, this);
        theExceptionHMap.put(tmpNewException.getName(), tmpNewException);
        ServiceCatalog.getInstance().getExceptionHMap_WithFilePrefix().put(
            thriftNameParm+"."+tmpNewException.getName(), tmpNewException);
    }

    private void generateEnum(org.apache.athrift.compiler.Enum tmpEnumType,
            String thriftNameParm) throws Exception
    {
        org.apache.athrift.service.type.ThriftEnum tmpNewEnum =
            new org.apache.athrift.service.type.ThriftEnum(tmpEnumType, this);
        theEnumHMap.put(tmpNewEnum.getName(), tmpNewEnum);
        ServiceCatalog.getInstance().getEnumHMap_WithFilePrefix().put(
            thriftNameParm+"."+tmpNewEnum.getName(), tmpNewEnum);
    }
    
    public HashMap getTheServiceHMap() {
        return theServiceHMap;
    }

    public HashMap getTheStructHMap() {
        return theStructHMap;
    }

    public HashMap getTheTypedefsHMap() {
        return theTypedefsHMap;
    }

    public HashMap getTheEnumHMap() {
        return theEnumHMap;
    }

    public HashMap getTheConstantHMap() {
        return theConstantHMap;
    }

    public HashMap getTheExceptionHMap() {
        return theExceptionHMap;
    }
}
