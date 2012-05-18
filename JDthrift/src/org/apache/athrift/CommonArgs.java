package org.apache.athrift;

import java.util.ArrayList;

import org.apache.athrift.service.ThriftServiceItem;
import org.apache.thrift.TBase;
import org.apache.thrift.TException;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.protocol.TProtocol;

/**
 * 输入参数类
 * 该类是作为调用远程服务的输入参数,具体用法如下:
 * 某服务的thrift配置文件如下:
 * service xxxxxx {
        list<list<UserProfile>> retrieve(1: i32 uid, 2: required string test) throws(1: Xception err1)
      }
       调用retrieve的示例代码如下:
     CommonArgs tmpCommonArgs = new CommonArgs();
     tmpCommonArgs.addOneValue("uid", 10);
     tmpCommonArgs.addOneValue("test", "test123");
     // 用方法名:'retrieve'和包含具体调用参数的CommonArgs的实例，调用client.sendRequest方法
     client.sendRequest("retrieve", tmpCommonArgs);
 * @author netcomm
 *
 */
public class CommonArgs extends CommonStruct implements TBase {
    private ThriftServiceItem theThriftServiceItem;
    
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
        theThriftServiceItem.getArgsStruct().write(oprot, this);
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

    public void setThriftServiceItem(ThriftServiceItem theThriftServiceItemParm) {
        theThriftServiceItem = theThriftServiceItemParm;
    }

}
