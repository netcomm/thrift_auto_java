package test;

import java.util.ArrayList;

import org.apache.athrift.AutoClient;
import org.apache.athrift.AutoThriftGenerator;
import org.apache.athrift.CommonArgs;
import org.apache.athrift.CommonException;
import org.apache.athrift.CommonStruct;
import org.apache.athrift.service.ThriftServicesParser;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;


public class AutoClientExample {
    public static void main(String[] args) {
        try {
            // 第一步: 创建thrift的通讯链路
            TTransport transport = null;
            transport = new TSocket("localhost", 9090);
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);

            // 第二步: 生成对应thrift配置文件解析引擎，并生成自动Client实例
            AutoThriftGenerator tmpAutoThriftGenerator = new AutoThriftGenerator();
            ThriftServicesParser tmpThriftServicesParser =
                    tmpAutoThriftGenerator.generateAutoThrift("D:/资料/thrift", "firstTest.thrift");
            AutoClient client = new AutoClient(protocol, "UserStorage", tmpThriftServicesParser);

            // 第三步: 使用自动Client实例,调用具体的远端服务(用户自己编写的业务代码)
            CommonArgs tmpCommonArgs = new CommonArgs();
            tmpCommonArgs.addOneValue("uid", 10);
            tmpCommonArgs.addOneValue("test", "test123");
            ArrayList tmpList = (ArrayList) client.sendRequest("retrieve", tmpCommonArgs);
            System.out.println("服务器端返回:"+tmpList.size());
            
            // 第四步: 关闭通讯链路
            transport.close();
        }
        catch (TException x) {
            x.printStackTrace();
        }
        catch (CommonException ae) {
            ae.printStackTrace();
        }
    }
}