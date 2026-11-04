package api.utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class Dataproviders {

    @DataProvider(name="Data")
    public String[][] getAllData() throws IOException {
        String path=".\\testData\\userData.xlsx";

        ExcelUtility xlUtil=new ExcelUtility(path);

        int totalRows=xlUtil.getRowCount("Sheet1");
        int totalCols= xlUtil.getCellCount("Sheet1",1);

        String [][]apiData=new String[totalRows][totalCols];

        for(int i=1;i<=totalRows;i++){
            for(int j=0;j<totalCols;j++){
                apiData[i-1][j]=xlUtil.getCellData("Sheet1",i,j);
                //System.out.println(loginData[i-1][j]);
            }
        }
        return apiData;
    }


    @DataProvider(name="UserNames")
    public String[] getUserNames() throws IOException {
        String path=".\\testData\\userData.xlsx";

        ExcelUtility xlUtil=new ExcelUtility(path);

        int totalRows=xlUtil.getRowCount("Sheet1");

        String []apiData=new String[totalRows];

        for(int i=1;i<=totalRows;i++){
                apiData[i-1]=xlUtil.getCellData("Sheet1",i,1);
                //System.out.println(loginData[i-1][j]);
        }
        return apiData;
    }
}
