package org.apache.athrift;

import java.util.ArrayList;

import org.apache.athrift.service.ThriftServiceItem;
import org.apache.athrift.service.type.BaseType;
import org.apache.athrift.service.type.struct.Item;
import org.apache.thrift.TBase;
import org.apache.thrift.TException;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.protocol.TProtocol;

/**
 * 服务调用返回的结果类
 * 调用该类的getRetValue方法取回实际结果
 * @author netcomm
 *
 */
public class CommonResult implements TBase {
    private BaseType retType;
    private ArrayList<Item> throwExceptionsList = null;
    private Object retValue;
    private Object[] retException;
    private boolean isSetSuccess = false;
    
    public CommonResult(ThriftServiceItem theThriftServiceItemParm)
    {
        retType = theThriftServiceItemParm.getRetType();
        throwExceptionsList = theThriftServiceItemParm.getTheThrowExceptions();
    }
    
    public boolean isSetSuccess()
    {
        return isSetSuccess;
    }
    
    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void read(TProtocol iprot) throws TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          
          boolean tmpIsHaveException = false;
          if (schemeField.id != 0)
          {
              for (Item tmpOneItem: throwExceptionsList)
              {
                  if (tmpOneItem.getIdx() == schemeField.id)
                  {
                      tmpIsHaveException = true;
                      isSetSuccess = false;
                      tmpOneItem.getType().read(iprot);
                      retException = new Object[2];
                      retException[0] = tmpOneItem.getName();
                      retException[1] = tmpOneItem.getType().getValue();
                      break;
                  }
              }
          }
          
          if (tmpIsHaveException == false)
          {
              switch (schemeField.id) {
                case 0: // SUCCESS
                    retType.read(iprot);
                    retValue = retType.getValue();
                    isSetSuccess = true;
                  break;
                default:
                  org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
          }
          
          iprot.readFieldEnd();
        }
        
        if (retType == null) // 返回 void
        {
            isSetSuccess = true;
        }
        
        iprot.readStructEnd();
    }

    @Override
    public void write(TProtocol oprot) throws TException {
        // TODO Auto-generated method stub
        
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

    public Object getRetValue() {
        return retValue;
    }

    public Object[] getRetException() {
        return retException;
    }

}
