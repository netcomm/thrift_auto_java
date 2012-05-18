package org.apache.athrift;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.apache.athrift.service.ThriftServiceItem;
import org.apache.athrift.service.type.struct.Item;
import org.apache.athrift.service.type.struct.ThriftStruct;
import org.apache.thrift.TBase;
import org.apache.thrift.TException;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;


public class AutoProcessFunction extends org.apache.thrift.ProcessFunction {
    private ThriftServiceItem theServiceItem;
    private Method method = null;
    private org.apache.thrift.protocol.TStruct Return_Struct_DESC = null;
    private TField[] ERR1_FIELD_DESCs = null;
    
    public AutoProcessFunction(String funcNameParm, ThriftServiceItem theServiceItemParm) {
        super(funcNameParm);
        theServiceItem = theServiceItemParm;
        Return_Struct_DESC = new org.apache.thrift.protocol.TStruct(getMethodName()+"_result");
        
        ERR1_FIELD_DESCs = new TField[theServiceItem.getTheThrowExceptions().size()];
        int i = 0;
        for (org.apache.athrift.service.type.struct.Item tmpOneItem : theServiceItem.getTheThrowExceptions())
        {
            ERR1_FIELD_DESCs[i] =
                new TField(tmpOneItem.getName(), org.apache.thrift.protocol.TType.STRUCT, (short)tmpOneItem.getIdx());
            i++;
        }
    }


    protected TBase getEmptyArgsInstance() {
        return theServiceItem.getArgsStruct();
    }
    

    @Override
    protected TBase getResult(Object iface, TBase args) throws TException{
        ThriftStruct tmpArgsStruct = (ThriftStruct)args;
        Class[] parameterTypes = new Class[tmpArgsStruct.getTheItems().size()];
        int i = 0;
        for(Item tmpOneItem :tmpArgsStruct.getTheItems().values())
        {
            parameterTypes[i] = tmpOneItem.getType().getClassDescr();
            i++;
        }
        
        Object[] arguments = new Object[parameterTypes.length];
        i = 0;
        for(Item tmpOneItem :tmpArgsStruct.getTheItems().values())
        {
            arguments[i] = tmpOneItem.getType().getValue();
            if (arguments[i] == null)
            {
                Object tmpDefaultValue = tmpOneItem.getDefaultValue();
                if (tmpDefaultValue != null)
                {
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!…Ë÷√ƒ¨»œ÷µ:"+tmpDefaultValue);
                    arguments[i] = tmpDefaultValue;
                }
            }
            i++;
        }
        
        CommonResult retCommonResult = null;
        CommonException tmpAE = null;
        Object retValue = null;
        try
        {
            //Method method = iface.getClass().getMethod(getMethodName(), parameterTypes);
            /*if (theWrapper == null)
            {
                theWrapper = Wrapper.getWrapper(iface.getClass());
            }
            Object retValue = theWrapper.invokeMethod(iface, getMethodName(), parameterTypes, arguments);*/
            
            if (method == null)
            {
                method = iface.getClass().getMethod(getMethodName(), parameterTypes);
            }
            
            retValue = method.invoke(iface, arguments);
        }
        catch (SecurityException e)
        {
            e.printStackTrace();
        }
        catch (IllegalArgumentException e)
        {
            e.printStackTrace();
        }
        catch (InvocationTargetException e)
        {
            tmpAE = (CommonException)e.getTargetException();
            e.printStackTrace();
        }
        catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        retCommonResult = new CommonResult(retValue, tmpAE);
        
        return retCommonResult;
    }
    
    class CommonResult implements TBase
    {
        private Object retValue;
        private CommonException theAE;
        
        protected CommonResult(Object retValueParm, CommonException theAEParm)
        {
            retValue = retValueParm;
            theAE = theAEParm;
        }
        
        @Override
        public int compareTo(Object o) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public void read(TProtocol iprot) throws TException {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void write(TProtocol oprot) throws TException {
            oprot.writeStructBegin(Return_Struct_DESC);
            if (theAE != null)
            {
                String tmpExName = theAE.getName();
                TField tmpTheTField = null;
                for (int i = 0; i < ERR1_FIELD_DESCs.length; i++)
                {
                    if (ERR1_FIELD_DESCs[i].name.equals(tmpExName))
                    {
                        tmpTheTField = ERR1_FIELD_DESCs[i];
                        break;
                    }
                }
                
                oprot.writeFieldBegin(tmpTheTField);
                
                Item tmpExceptionItem = null;
                ArrayList<Item> tmpTheExceptionsList = theServiceItem.getTheThrowExceptions();
                for (Item tmpOneItem: tmpTheExceptionsList)
                {
                    if (tmpOneItem.getName().equals(tmpExName))
                    {
                        tmpExceptionItem = tmpOneItem;
                        break;
                    }
                }
                
                tmpExceptionItem.getType().write(oprot,
                        theAE.getTheExceptStructDetail());
                
                oprot.writeFieldEnd();
            }
            if (retValue != null) {
              theServiceItem.getRetType().writeSuccessReturn(oprot, retValue);
            }
            oprot.writeFieldStop();
            oprot.writeStructEnd();
            
            /*
             * oprot.writeStructBegin(STRUCT_DESC);
        if (struct.err2 != null) {
          oprot.writeFieldBegin(ERR2_FIELD_DESC);
          struct.err2.write(oprot);
          oprot.writeFieldEnd();
        }
        if (struct.success != null) {
          oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
          struct.success.write(oprot);
          oprot.writeFieldEnd();
        }
        oprot.writeFieldStop();
        oprot.writeStructEnd();
             */
        }

        @Override
        public TFieldIdEnum fieldForId(int fieldId) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public boolean isSet(TFieldIdEnum field) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public Object getFieldValue(TFieldIdEnum field) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public void setFieldValue(TFieldIdEnum field, Object value) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public TBase deepCopy() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public void clear() {
            // TODO Auto-generated method stub
            
        }
        
    }
}
