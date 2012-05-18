package org.apache.athrift;


/**
 * 自定义异常类
 * 具体使用方法:
 * 某thrift配置文件内容如下：
    exception Xception {
      1: i32 errorCode,
      2: string message
    }
    
    exception Xception2 {
      1: i32 errorCode
    }

    service UserStorage {
        string getString() throws(1: Xception err1, 2: Xception2 err2)
      }
    ...
           现在如果某客户端调用该服务发生异常了,则无论发生哪种自定义异常,该客户端都将报CommonException异常,但
  CommonException实例的name属性值不同,如"err1"或"err2"。异常的实际内容视异常的结构定义而不同。
 * @author netcomm
 *
 */
public class CommonException extends Exception
{
    private String name;
    private CommonStruct theExceptStructDetail = null;

    public CommonException(String nameParm, CommonStruct theExceptStructDetailParm)
    {
        name = nameParm;
        theExceptStructDetail = theExceptStructDetailParm;
    }
    
    public CommonStruct getTheExceptStructDetail() {
        return theExceptStructDetail;
    }

    public String getName() {
        return name;
    }
    
    public String toString()
    {
        StringBuffer retStrBuf = new StringBuffer();
        retStrBuf.append("�쳣����: "+name+":");
        retStrBuf.append(theExceptStructDetail.toString());
        return retStrBuf.toString();
    }
}
