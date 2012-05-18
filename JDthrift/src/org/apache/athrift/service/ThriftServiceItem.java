package org.apache.athrift.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.apache.athrift.compiler.Field;
import org.apache.athrift.compiler.FieldType;
import org.apache.athrift.compiler.Function;
import org.apache.athrift.compiler.ThrowType;
import org.apache.athrift.service.type.BaseType;
import org.apache.athrift.service.type.TypeFactory;
import org.apache.athrift.service.type.struct.Item;
import org.apache.athrift.service.type.struct.ThriftStruct;

public class ThriftServiceItem {
    private String name;
    private ThriftStruct argsStruct = new ThriftStruct();
    private ArrayList theThrowExceptions = new ArrayList();
    private BaseType retType;
    private int argsAutoIdxMax = 0;
    private int exceptionAutoIdxMax = 0;
    
    public ThriftServiceItem(Function oneFunctionParm,
            ThriftServicesParser theThriftServicesParserParm) throws Exception
    {
        name = oneFunctionParm.getName();
        FieldType tmpFieldType = oneFunctionParm.getFunctionType();
        if (tmpFieldType != null)
        {
            retType = TypeFactory.generateOneType(
                tmpFieldType, theThriftServicesParserParm);
        }
        
        generateExceptionsDetail(oneFunctionParm.getThrowType(),
                theThriftServicesParserParm);
        
        generateArgsDetail(oneFunctionParm.getArgsList(), theThriftServicesParserParm);
    }
    
    private void generateArgsDetail(ArrayList<Field> argsListParm,
        ThriftServicesParser theThriftServicesParserParm) throws Exception
    {
        LinkedHashMap<Integer, Item> tmpArgs = new LinkedHashMap<Integer, Item>();
        
        for (int i = 0; i < argsListParm.size(); i++)
        {
            Field tmpOneField = argsListParm.get(i);
            String tmpIdx = tmpOneField.getFieldID();
            int tmpIdxInt = 0;
            if (tmpIdx != null)
            {
                tmpIdxInt = Integer.parseInt(tmpIdx.substring(0, tmpIdx.length() - 1));
            }
            else
            {
                argsAutoIdxMax--;
                tmpIdxInt = argsAutoIdxMax;
            }
            
            Item tmpOneItem =
                new Item(tmpIdxInt, tmpOneField,
                        theThriftServicesParserParm);
            tmpArgs.put(tmpOneItem.getIdx(), tmpOneItem);
        }
        
        argsStruct.setName(name+"_args");
        argsStruct.setTheItems(tmpArgs);
    }
    
    private void generateExceptionsDetail(ThrowType theThrowTypeParm,
            ThriftServicesParser theThriftServicesParserParm) throws Exception
    {
        if (theThrowTypeParm != null)
        {
            ArrayList<Field> tmpList = theThrowTypeParm.getFieldList();
            for (int i = 0; i < tmpList.size(); i++)
            {
                Field tmpOneField = tmpList.get(i);
                
                String tmpIdx = tmpOneField.getFieldID();
                int tmpIdxInt = 0;
                if (tmpIdx != null)
                {
                    tmpIdxInt = Integer.parseInt(tmpIdx.substring(0, tmpIdx.length() - 1));
                }
                else
                {
                    exceptionAutoIdxMax--;
                    tmpIdxInt = exceptionAutoIdxMax;
                }
                
                theThrowExceptions.add(new Item(tmpIdxInt, tmpOneField,
                    theThriftServicesParserParm));
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setTheThrowExceptions(ArrayList theThrowExceptions) {
        this.theThrowExceptions = theThrowExceptions;
    }

    public void setRetType(BaseType retType) {
        this.retType = retType;
    }

    public ThriftStruct getArgsStruct() {
        return argsStruct;
    }

    public ArrayList<Item> getTheThrowExceptions() {
        return theThrowExceptions;
    }

    public BaseType getRetType() {
        return retType;
    }
}
