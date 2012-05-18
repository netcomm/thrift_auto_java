package org.apache.athrift.service.type.struct;

import org.apache.athrift.compiler.ConstValue;
import org.apache.athrift.compiler.Field;
import org.apache.athrift.service.ServiceCatalog;
import org.apache.athrift.service.ThriftServicesParser;
import org.apache.athrift.service.type.BaseType;
import org.apache.athrift.service.type.ThriftConstant;
import org.apache.athrift.service.type.ThriftEnum;
import org.apache.athrift.service.type.TypeFactory;

public class Item {
    private int idx;
    private String requiredAndOptionalSign; // r='required', o='optional'
    private BaseType type;
    private String name;
    private Object defaultValue;
    
    public Item()
    {
        
    }
    
    public Item(int idxParm, Field theFieldParm, ThriftServicesParser theThriftServicesParserParm)
        throws Exception
    {
        idx = idxParm;
        name = theFieldParm.getName();
        if (theFieldParm.getFieldReq() != null)
        {
            requiredAndOptionalSign = theFieldParm.getFieldReq().substring(0, 1);
        }
        
        type = TypeFactory.generateOneType(theFieldParm.getFieldType(),
            theThriftServicesParserParm);
        
        ConstValue tmpConstValue = theFieldParm.getDefaultValue();
        if (tmpConstValue != null)
        {
            if (tmpConstValue.getType().equals("identifier"))
            {
                String tmpIdentifier = (String)tmpConstValue.getDefaultValue();
                String tmpIdentifierSub = null;
                int tmpPosi = tmpIdentifier.lastIndexOf(".");
                if (tmpPosi != -1)
                {
                    tmpIdentifierSub = tmpIdentifier
                        .substring(tmpPosi + 1).trim();
                    tmpIdentifier = tmpIdentifier
                        .substring(0, tmpPosi).trim();
                }
                
                ThriftEnum tmpEnumType = (ThriftEnum)theThriftServicesParserParm.getTheEnumHMap()
                    .get(tmpIdentifier);
                if (tmpEnumType == null)
                {
                    tmpEnumType = (ThriftEnum)ServiceCatalog.getInstance().getEnumHMap_WithFilePrefix()
                        .get(tmpIdentifier);
                    if (tmpEnumType == null)
                    {
                        ThriftConstant tmpConstantType = (ThriftConstant)theThriftServicesParserParm.getTheConstantHMap().get(tmpIdentifier);
                        if (tmpConstantType == null)
                        {
                            tmpConstantType = (ThriftConstant)ServiceCatalog.getInstance()
                                .getConstantHMap_WithFilePrefix().get(tmpIdentifier);
                        }
                        
                        if (tmpConstantType != null)
                        {
                            defaultValue = tmpConstantType.getDefaultValue();
                        }
                    }
                }
                
                if (tmpEnumType != null)
                {
                    defaultValue = tmpEnumType.getEnumValue(tmpIdentifierSub);
                }
            }
            else
            {
                defaultValue = type.generateDefaultValue(tmpConstValue);
            }
        }
    }
    
    public String toString()
    {
        StringBuffer retBufStr = new StringBuffer();
        retBufStr.append(idx+": "+requiredAndOptionalSign+" "+type.getTypeDescr()+" "+name);
        return retBufStr.toString();
    }

    public int getIdx() {
        return idx;
    }

    public BaseType getType() {
        return type;
    }
    
    public Object deepCopy() {
        Item retItem = new Item();
        retItem.setIdx(idx);
        retItem.setName(name);
        retItem.setRequiredAndOptionalSign(requiredAndOptionalSign);
        retItem.setType((BaseType)type.deepCopy());
        return retItem;
    }

    public String getRequiredAndOptionalSign() {
        return requiredAndOptionalSign;
    }

    public String getName() {
        return name;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public void setRequiredAndOptionalSign(String requiredAndOptionalSign) {
        this.requiredAndOptionalSign = requiredAndOptionalSign;
    }

    public void setType(BaseType type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }
}
