package org.apache.athrift.service.type.struct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.athrift.CommonStruct;
import org.apache.athrift.compiler.ConstValue;
import org.apache.athrift.compiler.Field;
import org.apache.athrift.compiler.Struct;
import org.apache.athrift.service.ThriftServicesParser;
import org.apache.athrift.service.type.BaseType;
import org.apache.thrift.TBase;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;


public class ThriftStruct extends BaseType {
    private static final org.apache.thrift.protocol.TField Struct_SUCCESS_FIELD_DESC =
        new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.STRUCT, (short)0);
    private String name;
    private LinkedHashMap<Integer, Item> theItems = new LinkedHashMap<Integer, Item>();
    private HashMap<String, Item> theItemHMap = new HashMap<String, Item>();
    private HashMap<String, TField> theSendTFieldHMap = new HashMap<String, TField>();
    private Item[] requiredItems = null;
    private org.apache.thrift.protocol.TStruct STRUCT_DESC = null;
    private int autoIdxMax = 0;
    
    public ThriftStruct()
    {
        
    }
    
    public ThriftStruct(Struct theOneStructParm,
            ThriftServicesParser theThriftServicesParserParm) throws Exception
    {
        int tmpRequiredItemCnt = 0;
        name = theOneStructParm.getName();
        for (int i = 0; i < theOneStructParm.getFieldList().size(); i++)
        {
            Field tmpOneField = theOneStructParm.getFieldList().get(i);
            String tmpIdx = tmpOneField.getFieldID();
            int tmpIdxInt = 0;
            if (tmpIdx != null)
            {
                tmpIdxInt = Integer.parseInt(tmpIdx.substring(0, tmpIdx.length() - 1));
            }
            else
            {
                autoIdxMax--;
                tmpIdxInt = autoIdxMax;
            }
            
            Item tmpOneStructItem =
                new Item(tmpIdxInt, tmpOneField,
                        theThriftServicesParserParm);
            theItems.put(tmpOneStructItem.getIdx(), tmpOneStructItem);
            theItemHMap.put(tmpOneStructItem.getName(), tmpOneStructItem);
            
            org.apache.thrift.protocol.TField tmpNewTField =
                new org.apache.thrift.protocol.TField(tmpOneStructItem.getName(),
                    tmpOneStructItem.getType().getTType(), (short)tmpOneStructItem.getIdx());
            theSendTFieldHMap.put(tmpOneStructItem.getName(), tmpNewTField);
            
            if ("r".equals(tmpOneStructItem.getRequiredAndOptionalSign()))
            {
                if (requiredItems == null)
                {
                    requiredItems = new Item[theOneStructParm.getFieldList().size()];
                }
                
                requiredItems[tmpRequiredItemCnt] = tmpOneStructItem;
                tmpRequiredItemCnt++;
            }
        }
        
        STRUCT_DESC = new org.apache.thrift.protocol.TStruct(name);
    }

    public String getName() {
        return name;
    }
    
    public String getTypeDescr()
    {
        return name;
    }
    
    public void read(org.apache.thrift.protocol.TProtocol iprot)
        throws org.apache.thrift.TException
    {
        // 设置默认值
        for (Map.Entry<Integer, Item> tmpOneItem : theItems.entrySet())
        {
            Item tmpTheItem = tmpOneItem.getValue();
            Object tmpDefaultValue = tmpTheItem.getDefaultValue();
            if (tmpDefaultValue != null)
            {
                tmpTheItem.getType().setValue(tmpDefaultValue);
            }
        }
        
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
            break;
          }
          
          Item tmpItem = theItems.get(new Integer(schemeField.id));
          if (tmpItem != null)
          {
              if (schemeField.type == tmpItem.getType().getTType()) {
                  tmpItem.getType().read(iprot);
              } else {
                  org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
          }
          else
          {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              throw new TException("缺少#"+schemeField.id+":#元素");
          }
          
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();
        
        validate();
    }
    
    private void validate() throws org.apache.thrift.TException
    {
        // check for required fields
        if (requiredItems != null)
        {
            for (int i = 0; i < requiredItems.length; i++)
            {
                Item tmpTheItem = requiredItems[i];
                if (tmpTheItem != null)
                {
                    if (tmpTheItem.getType().getValue() == null)
                    {
                        System.out.println("必输项检查发现问题!!!");
                        throw new org.apache.thrift.protocol
                            .TProtocolException("attention!!! Required field '"
                                +tmpTheItem.getName()+"' was not present! Struct: " + toString());
                    }
                }
                else
                {
                    break;
                }
            }
        }
    }
    
    private void validateWrite(Object valueParm) throws org.apache.thrift.TException
    {
        CommonStruct tmpValue = (CommonStruct)valueParm;
        if (requiredItems != null)
        {
            for (int i = 0; i < requiredItems.length; i++)
            {
                Item tmpTheItem = requiredItems[i];
                if (tmpTheItem != null)
                {
                    if (tmpValue.getOneValue(tmpTheItem.getName()) == null)
                    {
                        System.out.println("必输项检查发现问题!!!");
                        throw new org.apache.thrift.protocol
                            .TProtocolException("attention!!! Required field '"
                                +tmpTheItem.getName()+"' was not present! Struct: " + toString());
                    }
                }
                else
                {
                    break;
                }
            }
        }
    }
    
    public String toString()
    {
        StringBuffer retBufStr = new StringBuffer();
        
        retBufStr.append(name+"#\r\n");
        for (Item tmpOneSI: theItems.values())
        {
            retBufStr.append(tmpOneSI.toString()+"\r\n");
        }
        
        return retBufStr.toString();
    }

    public LinkedHashMap<Integer, Item> getTheItems() {
        return theItems;
    }

    public void setTheItems(LinkedHashMap<Integer, Item> theItemsParm) {
        this.theItems = theItemsParm;
        theItemHMap.clear();
        theSendTFieldHMap.clear();
        
        int tmpRequiredItemCnt = 0;
        for (Item tmpOneSI: theItems.values())
        {
            theItemHMap.put(tmpOneSI.getName(), tmpOneSI);
            
            if ("r".equals(tmpOneSI.getRequiredAndOptionalSign()))
            {
                if (requiredItems == null)
                {
                    requiredItems = new Item[this.theItems.size()];
                }
                
                requiredItems[tmpRequiredItemCnt] = tmpOneSI;
                tmpRequiredItemCnt++;
            }
            
            org.apache.thrift.protocol.TField tmpNewTField =
                new org.apache.thrift.protocol.TField(tmpOneSI.getName(),
                    tmpOneSI.getType().getTType(), (short)tmpOneSI.getIdx());
            theSendTFieldHMap.put(tmpOneSI.getName(), tmpNewTField);
        }
        
        STRUCT_DESC = new org.apache.thrift.protocol.TStruct(name);
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Class getClassDescr()
    {
        return CommonStruct.class;
    }
    
    public Object getValue()
    {
        CommonStruct retCommonStruct = new CommonStruct();
        for (Item tmpOneItem: theItems.values())
        {
            retCommonStruct.addOneValue(tmpOneItem.getName(), tmpOneItem.getType().getValue());
        }
        
        return retCommonStruct;
    }
    
    public TBase deepCopy() {
        ThriftStruct retThriftStruct = new ThriftStruct();
        LinkedHashMap<Integer, Item> tmpCloneItems = new LinkedHashMap<Integer, Item>();
        
        Item tmpCloneItem = null;
        for (Item tmpOneItem: theItems.values())
        {
            tmpCloneItem = (Item)tmpOneItem.deepCopy();
            tmpCloneItems.put(tmpCloneItem.getIdx(), tmpCloneItem);
        }
        
        retThriftStruct.setName(name);
        retThriftStruct.setTheItems(tmpCloneItems);
        return retThriftStruct;
    }
    
    public byte getTType()
    {
        return org.apache.thrift.protocol.TType.STRUCT;
    }
    
    public void writeSuccessReturn(TProtocol oprot, Object valueParm) throws TException {
        oprot.writeFieldBegin(Struct_SUCCESS_FIELD_DESC);
        write(oprot, valueParm);
        oprot.writeFieldEnd();
    }
    
    public void write(TProtocol oprot, Object valueParm) throws TException {
        validateWrite(valueParm);
        
        oprot.writeStructBegin(STRUCT_DESC);
        CommonStruct tmpValue = (CommonStruct)valueParm;
        
        ArrayList<Object[]> tmpList = tmpValue.getValues();
        for (Object[] tmpOneObjs: tmpList)
        {
            Item tmpItem = theItemHMap.get(tmpOneObjs[0]);
            oprot.writeFieldBegin(theSendTFieldHMap.get(tmpOneObjs[0]));
            tmpItem.getType().write(oprot, tmpOneObjs[1]);
            oprot.writeFieldEnd();
        }
        
        oprot.writeFieldStop();
        oprot.writeStructEnd();
    }

    public void setTheItemHMap(HashMap theItemHMap) {
        this.theItemHMap = theItemHMap;
    }
    
    @Override
    public Object generateDefaultValue(ConstValue theConstValueParm) {
        CommonStruct retCommonStruct = new CommonStruct();
        HashMap<ConstValue, ConstValue> tmpHashMapValue =
                (HashMap)theConstValueParm.getDefaultValue();
        for (Map.Entry<ConstValue, ConstValue> tmpOneItem : tmpHashMapValue.entrySet())
        {
            String tmpOneItemName = (String)tmpOneItem.getKey().getDefaultValue();
            Item tmpItem = theItemHMap.get(tmpOneItemName);
            retCommonStruct.addOneValue(tmpOneItemName,
                tmpItem.getType().generateDefaultValue(tmpOneItem.getValue()));
        }
        
        return retCommonStruct;
    }

    @Override
    public void setValue(Object valueParm) {
        CommonStruct tmpCommonStruct = (CommonStruct)valueParm;
        for (Object[] tmpOneObjs: tmpCommonStruct.getValues())
        {
            Item tmpItem = theItemHMap.get(tmpOneObjs[0]);
            tmpItem.getType().setValue(tmpOneObjs[1]);
        }
    }
}
