import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GridConvert {

    public static void main(String[] args) {
        String str = "";

        String str2 = "";

        List<DataGrid> list = new ArrayList<>();
        String path = "D:\\POST-CRM\\ZSmart_cvBS_V8.1E_Project\\branches\\main_branch\\POST\\CRM\\code\\flex\\BusinessCommon\\src\\com\\ztesoft\\zsmart\\bss\\post\\stock\\transfer\\view\\GmReqOrderAllocateGoodsWithSn.mxml";
        String path1 = "D:\\POST-CRM\\ZSmart_cvBS_V8.1E_Project\\branches\\main_branch\\POST\\CRM\\code\\flex\\bclib\\src\\com\\ztesoft\\zsmart\\post\\bclib\\inventory\\transfer\\view\\GmReqOrderCheckBoxDataGrid.mxml";
        String str3 = convertFileToString(path1);
        /*
        String regx = "<bc:.*?DataGrid[\\s\\S]*?>";
        Pattern p = Pattern.compile(regx);
        Matcher m = p.matcher(str3);
        if(m.find()) {
            System.out.println("ok");
            System.out.println(m.group());
        }*/
        list = getGridFileds(str3);

        for (DataGrid dataGrid : list) {
            System.out.println(dataGrid.toString());
        }

    }

    public static List<DataGrid> getGridFileds(String str) {
        List<DataGrid> list = new ArrayList<>();
        String regx1 = "<ztesoft:.*?DataGrid[\\s\\S]*?</ztesoft:.*?DataGrid>"; //匹配包括\n在内的任意字符
        String regx2 = "<!--[\\s\\S]*?-->";
        String regx3 = "(?<=id=\").*?(?=\")";
        String regx4 = "<ztesoft:DataGridColumn[\\s\\S]*?/>";
        String regx5 = "(?<=dataField=\").*?(?=\")";
        String regx6 = "(?<=res\\([\'|\"]).*?(?=\'\\))";
        Pattern p1 = Pattern.compile(regx1);
        Matcher m1 = p1.matcher(str);
        Pattern p2 = Pattern.compile(regx2);
        Pattern p3 = Pattern.compile(regx3);
        Pattern p4 = Pattern.compile(regx4);
        Pattern p5 = Pattern.compile(regx5);
        Pattern p6 = Pattern.compile(regx6);
        Matcher m2, m3, m4, m5, m6;

        while (m1.find()) {
            System.out.println(m1.group());

            String gridStr = m1.group().replaceAll(regx2, "");  //此处必须用replaceAll()
            System.out.println("gridStr+++: " + gridStr);
            m3 = p3.matcher(gridStr);
            String gridName = "";
            if (m3.find()) {
                gridName = m3.group();
                System.out.println("gridName+++: " + gridName);
            } else {
                gridName = gridStr.substring(gridStr.indexOf(":") + 1, gridStr.indexOf(" "));
                gridName = gridName.substring(0,1).toLowerCase().concat(gridName.substring(1));
            }

            m4 = p4.matcher(gridStr);
            DataGrid dataGrid;
            Column column;

            String label = "";
            String field = "";
            while (m4.find()) {
                String col = m4.group();
                System.out.println("col+++: " + col);
                m5 = p5.matcher(col);

                if (m5.find()) {
                    field = m5.group();
                    System.out.println("field+++: " + field);
                }
                m6 = p6.matcher(col);

                if (m6.find()) {
                    label = "I18N." + m6.group().replace(".", "_");
                    System.out.println("label+++: " + label);
                }

                column = new Column(label, field);
                dataGrid = new DataGrid(gridName, column);
                list.add(dataGrid);
            }


        }

        return list;
    }

    public static String convertFileToString (String FILE_IN) {
        String str="";
        File file=new File(FILE_IN);
        try {
            FileInputStream in=new FileInputStream(file);
            // size 为字串的长度 ，这里一次性读完
            int size=in.available();
            byte[] buffer=new byte[size];
            in.read(buffer);
            in.close();
            str=new String(buffer,"UTF-8");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        return str;
    }

}
class DataGrid {
    private String gridName;
    private Column column;

    public DataGrid(String gridName, Column column) {
        this.gridName = gridName;
        this.column = column;
    }

    public String getGridName() {
        return gridName;
    }

    public Column getColumn() {
        return column;
    }

    public void setGridName(String gridName) {
        this.gridName = gridName;
    }

    public void setColumn(Column column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "DataGrid{" +
                "gridName='" + gridName + '\'' +
                ", column=" + column.getLabel() + ":" + column.getField() +
                '}';
    }
}

class Column {
    private String label;
    private String field;

    public Column() {
    }

    public Column(String label, String field) {
        this.label = label;
        this.field = field;
    }

    public String getLabel() {
        return label;
    }

    public String getField() {
        return field;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setField(String field) {
        this.field = field;
    }
}