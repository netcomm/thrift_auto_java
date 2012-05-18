package org.apache.athrift.service.type;

import org.apache.athrift.compiler.FieldType;
import org.apache.athrift.compiler.FieldType_HMap;
import org.apache.athrift.compiler.FieldType_List;
import org.apache.athrift.compiler.FieldType_Set;
import org.apache.athrift.service.ServiceCatalog;
import org.apache.athrift.service.ThriftServicesParser;

public class TypeFactory {
    public static BaseType generateOneType(FieldType theFieldTypeParm,
            ThriftServicesParser theThriftServicesParserParm) throws Exception
    {
        BaseType retType = null;
        if (theFieldTypeParm instanceof FieldType_HMap)
        {
            retType = new MapBaseType((FieldType_HMap)theFieldTypeParm,
                theThriftServicesParserParm);
        }
        else if (theFieldTypeParm instanceof FieldType_List)
        {
            retType = new ListBaseType((FieldType_List)theFieldTypeParm,
                theThriftServicesParserParm);
        }
        else if (theFieldTypeParm instanceof FieldType_Set)
        {
            retType = new SetBaseType((FieldType_Set)theFieldTypeParm,
                theThriftServicesParserParm);
        }
        else // 基本类型或struct或enum,如:string/int/double等
        {
            String tmpType = theFieldTypeParm.getTypeDescr();
            if ("string".equals(tmpType))
            {
                retType = new StringBaseType();
            }
            else if ("bool".equals(tmpType))
            {
                retType = new BoolBaseType();
            }
            else if ("byte".equals(tmpType))
            {
                retType = new ByteBaseType();
            }
            else if ("i16".equals(tmpType))
            {
                retType = new I16BaseType();
            }
            else if ("i32".equals(tmpType))
            {
                retType = new I32BaseType();
            }
            else if ("i64".equals(tmpType))
            {
                retType = new I64BaseType();
            }
            else if ("double".equals(tmpType))
            {
                retType = new DoubleBaseType();
            }
            else if ("binary".equals(tmpType))
            {
                retType = new BinaryBaseType();
            }
            
            if (retType == null)
            {
                retType = (BaseType)theThriftServicesParserParm.getTheTypedefsHMap()
                    .get(tmpType);
                if (retType == null)
                {
                    retType = (BaseType)ServiceCatalog.getInstance().getTypedefsHMap_WithFilePrefix()
                        .get(tmpType);
                    if (retType == null)
                    {
                        retType = (BaseType)theThriftServicesParserParm.getTheEnumHMap()
                            .get(tmpType);
                        if (retType == null)
                        {
                            retType = (BaseType)ServiceCatalog.getInstance().getEnumHMap_WithFilePrefix()
                                .get(tmpType);
                            if (retType == null)
                            {
                                retType = (BaseType)theThriftServicesParserParm.getTheStructHMap()
                                    .get(tmpType);
                                if (retType == null)
                                {
                                    retType = (BaseType)ServiceCatalog.getInstance().getStructHMap_WithFilePrefix()
                                        .get(tmpType);
                                    if (retType == null)
                                    {
                                        retType = (BaseType)theThriftServicesParserParm.getTheExceptionHMap()
                                            .get(tmpType);
                                        if (retType == null)
                                        {
                                            retType = (BaseType)ServiceCatalog.getInstance().getExceptionHMap_WithFilePrefix()
                                                .get(tmpType);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        if (retType == null)
        {
            throw new Exception("该行语句有问题,无法正确创建相应类型:"+theFieldTypeParm.getTypeDescr());
        }
        
        return retType;
    }
}
