package org.apache.athrift.service.type;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.athrift.compiler.ConstValue;
import org.apache.athrift.service.ThriftServicesParser;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;

public class ThriftEnum extends BaseType{
    private String name;
    private HashMap theMap = new HashMap();
    private int curMasterValue = -1;
    private int value = 0;
    
    public ThriftEnum(org.apache.athrift.compiler.Enum theEnumTypeParm,
            ThriftServicesParser theThriftServicesParserParm) throws Exception
    {
        name = theEnumTypeParm.getName();
        ArrayList tmpList = theEnumTypeParm.getItemList();
        for (int i = 0; i < tmpList.size(); i++)
        {
            String[] tmpOneStrs = (String[])tmpList.get(i);
            generateOneItem(tmpOneStrs[0], tmpOneStrs[1]);
        }
    }
    
    private void generateOneItem(String nameParm, String valueParm)
    {
        String tmpName = nameParm;
        int tmpValue = 0;
        if (valueParm != null)
        {
            String tmpSetValue = valueParm;
            int tmpHexPosi = tmpSetValue.indexOf("0x");
            if (tmpHexPosi != -1)
            {
                tmpSetValue = tmpSetValue.replace("0x", "");
                tmpValue = Integer.parseInt(tmpSetValue, 16);
            }
            else
            {
                tmpValue = Integer.parseInt(tmpSetValue);
            }
            
            if (tmpValue > curMasterValue)
            {
                curMasterValue = tmpValue;
            }
        }
        else
        {
            curMasterValue++;
            tmpValue = curMasterValue;
        }
        
        theMap.put(tmpName, tmpValue);
    }

    public String getName() {
        return name;
    }
    
    public String getTypeDescr() {
        return "enum";
    }
    
    public byte getTType()
    {
        return org.apache.thrift.protocol.TType.I32;
    }
    
    public int getEnumValue(String itemNameParm)
    {
        return (Integer)theMap.get(itemNameParm);
    }
    
    public Object getValue()
    {
        return value;
    }

    @Override
    public Object generateDefaultValue(ConstValue theConstValueParm) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setValue(Object valueParm) {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void read(TProtocol iprot) throws TException {
        value = iprot.readI32();
    }
}
