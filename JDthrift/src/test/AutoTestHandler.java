package test;

import java.util.ArrayList;

import org.apache.athrift.CommonException;
import org.apache.athrift.CommonStruct;
import org.apache.thrift.TException;

public class AutoTestHandler
{
    public void store(CommonStruct commonStructParm) throws TException {
        // TODO Auto-generated method stub
    }
    
    public ArrayList<ArrayList<CommonStruct>> retrieve(int uid, String testParm) throws TException, CommonException
    {
        ArrayList retList = new ArrayList();
        try
        {
            for (int i = 0; i < 10; i++)
            {
                ArrayList tmpInnerList = new ArrayList();
                for (int j = 0; j < 10; j++)
                {
                    CommonStruct retCommonStruct = new CommonStruct();
                    retCommonStruct.addOneValue("uid", i * 10 + j);
                    retCommonStruct.addOneValue("name", "new world");
                    retCommonStruct.addOneValue("blurb", "test");
                    
                    CommonStruct tmpPosi = new CommonStruct();
                    tmpPosi.addOneValue("posi", "testPosi");
                    retCommonStruct.addOneValue("theuserPosi", tmpPosi);
                    tmpInnerList.add(retCommonStruct);
                }
                retList.add(tmpInnerList);
            }
        }
        catch(Exception ex)
        {
            CommonStruct tmpExcept = new CommonStruct();
            tmpExcept.addOneValue("errorCode", 100);
            tmpExcept.addOneValue("message", "no good");
            throw new CommonException("err1", tmpExcept);
        }
        
        return retList;
    }
    
    public ArrayList<ArrayList<CommonStruct>> retrieve(int uid) throws TException, CommonException
    {
        ArrayList retList = new ArrayList();
        try
        {
            Integer tmpInt = Integer.parseInt("abc");
            for (int i = 0; i < 10; i++)
            {
                ArrayList tmpInnerList = new ArrayList();
                for (int j = 0; j < 10; j++)
                {
                    CommonStruct retCommonStruct = new CommonStruct();
                    retCommonStruct.addOneValue("uid", i * 10 + j);
                    retCommonStruct.addOneValue("name", "new world");
                    retCommonStruct.addOneValue("blurb", "test");
                    
                    CommonStruct tmpPosi = new CommonStruct();
                    tmpPosi.addOneValue("posi", "testPosi");
                    retCommonStruct.addOneValue("theuserPosi", tmpPosi);
                    tmpInnerList.add(retCommonStruct);
                }
                retList.add(tmpInnerList);
            }
        }
        catch(Exception ex)
        {
            CommonStruct tmpExcept = new CommonStruct();
            tmpExcept.addOneValue("errorCode", 100);
            tmpExcept.addOneValue("message", "no good");
            throw new CommonException("err1", tmpExcept);
        }
        
        return retList;
    }
    
    public String getUserName()  throws TException, CommonException
    {
        return "abc";
    }
}
