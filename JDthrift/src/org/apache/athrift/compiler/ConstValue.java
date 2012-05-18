package org.apache.athrift.compiler;

import java.util.ArrayList;
import java.util.HashMap;

public class ConstValue {
    private ArrayList<ConstValue> itemList = new ArrayList<ConstValue>();
    private HashMap<ConstValue, ConstValue> hashMapValue = new HashMap<ConstValue, ConstValue>();
    private String type;
    private String value;
    
    public void setItemList(ArrayList<ConstValue> itemList) {
        this.itemList = itemList;
    }
    public void setItemMap(HashMap<ConstValue, ConstValue> hashMapValue) {
        this.hashMapValue = hashMapValue;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setValue(String valueParm) {
        if (valueParm != null)
        {
            String tmpValue = valueParm.replaceAll("\"", "");
            this.value = tmpValue;
        }
    }
    public ArrayList<ConstValue> getItemList() {
        return itemList;
    }
    public HashMap<ConstValue, ConstValue> getHashMapValue() {
        return hashMapValue;
    }
    public String getType() {
        return type;
    }
    
    public Object getDefaultValue() {
        Object retValue = value;
        
        if (retValue == null)
        {
            retValue = itemList;
            if (retValue == null)
            {
                retValue = hashMapValue;
            }
        }
        
        return retValue;
    }
}
