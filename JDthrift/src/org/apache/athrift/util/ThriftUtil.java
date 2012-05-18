package org.apache.athrift.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ThriftUtil {
    public static ArrayList readThriftFile(String fileName) throws Exception{
        ArrayList<String> retList = new ArrayList();
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                tempString = tempString.replaceAll(" +"," ");
                tempString = tempString.trim();
                if (! "".equals(tempString))
                {
                    if ((! tempString.startsWith("//")) || (! tempString.startsWith("#")))
                    {
                        int tmpPosi = tempString.indexOf("//");
                        if (tmpPosi != -1)
                        {
                            tempString = tempString.substring(0, tmpPosi);
                        }
                        
                        retList.add(tempString);
                    }
                }
            }
            
            deleteCommentLine(retList);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        
        return retList;
    }
    
    private static void deleteCommentLine(ArrayList<String> detailListParm) throws Exception
    {
        for (int i = 0; i < detailListParm.size(); i++)
        {
            if (detailListParm.get(i).startsWith("/*"))
            {
                ArrayList tmpDeleteList = new ArrayList();
                int j;
                for (j = i; j < detailListParm.size(); j++)
                {
                    tmpDeleteList.add(detailListParm.get(j));
                    if (detailListParm.get(j).endsWith("*/"))
                    {
                        break;
                    }
                }
                
                System.out.println(i +"#"+ j);
                for (int k = i; k <= j; k++)
                {
                    detailListParm.remove(i);
                }
                i--;
            }
        }
    }
    
    public static String deleteLastCommaOrSemicolon(String strDetailParm)
    {
        String retStr = strDetailParm;
        char tmpChar = retStr.charAt(retStr.length() - 1);
        
        if (tmpChar == ',' || tmpChar == ';')
        {
            retStr = retStr.substring(0, retStr.length() - 1);
        }
        
        return retStr;
    }
    
    
}
