import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreatPopUpConvert {


    public static void main(String[] args) {
        String str = "var reqOrderListWin:GmReqOrderListWin = PopWinManager.createPopUp( GmReqOrderListWin,obj)) as GmReqOrderListWin;";
        String str2 = "PopWinManager.createPopUp ( GoodsPriceRebateInfoWin, {GOODS_ORDER:this.selectedItem, ORDER_ITEM:orderItem} );";
        String str3 = "<ztesoft:DataGrid id=\"dgReqGoodsSnInfo\" width=\"100%\" height=\"100%\"\n" +
                "\t\t\t\t\t\t\t\t  dataProvider=\"{gmAllocatonSn4ReturnArr}\">\n" +
                "\t\t\t\t\t<ztesoft:columns>\n" +
                "\t\t\t\t\t\t<ztesoft:DataGridColumn dataField=\"MODEL_NAME\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\theaderText=\"{res('INVENTORY.ALLOCATION_SN_MODEL_ID')}\"/>\n" +
                "\t\t\t\t\t\t<!--<ztesoft:DataGridColumn dataField=\"QTY\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\theaderText=\"{res('INVENTORY.ALLOCATION_SN_QTY')}\"/>-->\n" +
                "\t\t\t\t\t\t<ztesoft:DataGridColumn dataField=\"SN\" labelFunction=\"goodsSnLabel\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\theaderText=\"{res('INVENTORY.ALLOCATION_SN_SN')}\"/>\n" +
                "\t\t\t\t\t</ztesoft:columns>\n" +
                "\t\t\t\t</ztesoft:DataGrid>";
        String regx = "createPopUp\\(.*?\\)";
        String regx2 = "(?<=\\()[^\\)]+";  //使用了正则中的零宽度断言，(?<=\\( 表示( 后有或没有内容且宽度为0
        String regx3 = "(?<=res\\()[^\\)]+";
//        String regx4 = "(?<=\").*?(?=\")"; 匹配引号内的内容
        String regx4 = "<!--[\\s\\S]*?-->";

//        Pattern p = Pattern.compile(regx4);
//        Matcher m = p.matcher(str3);

        String name = str3.substring(str3.indexOf(":") + 1, str3.indexOf(" "));

        name = name.substring(0,1).toLowerCase().concat(name.substring(1));
        System.out.println(name);
//
//        while (m.find()) {
//            String str4 = m.group();
//            System.out.println(str4);

//            String winName = str4.substring(0, str4.indexOf(","));
//            String param = str4.substring(str4.indexOf(",") + 1);
//            System.out.println(winName);
//            System.out.println(param);

//        }


    }

}
