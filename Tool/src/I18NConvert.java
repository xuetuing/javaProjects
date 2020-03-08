import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class I18NConvert {
    public static int count = 0;
    public static void main(String[] args) {

        String str = "PopUp.info(res('INVENTORY.PLEASE_SELECT_REQ_ORDER'));";
        String str2 = "PopUp.info(res('COMMON.HINT_ADD_SUCCESS',res('INVENTORY.REQ_ORDER').toLowerCase()));";
        String str3 = "PopUp.confirm(res(\"COMMON.HINT_DEL_CONFIRM\"), function(event:CloseEvent)";

        System.out.println(strConvert(str3));

    }

    public static String strConvert(String str) {
        String regx1 = "res\\(.*?\\)";
        String regx2 = "res\\(.*?\\.toLowerCase\\(\\)\\)";
        Pattern p1 = Pattern.compile(regx1);
        Pattern p2 = Pattern.compile(regx2);
        Matcher m1 = p1.matcher(str);
        Matcher m2 = p2.matcher(str);
        StringBuilder sb = new StringBuilder(str.length());
//        int count = 0;
        if (m2.find()) {
            count++;
            String[] lst = str.split(regx2);
            //处理 匹配字符串
            String str2 = m2.group();
//            System.out.println(str2);
            String str3 = str2.substring(4, str2.length() - 1);
//            System.out.println(str3);
            sb.append(lst[0]).append(strConvert(str3)).append(lst[1]);
        } else if(m1.find()) {
            count++;
            String[] lst = str.split(regx1);
            String str2 = m1.group();
//            System.out.println(str2);
            String str3 = "I18N." + str2.substring(5, str2.length() - 2).replace(".", "_");
//            System.out.println(count);
            if (count > 1) {
                lst[0] = "I18N." + lst[0].replace("'", "").replace(".", "_");
            }
//            System.out.println(lst[0]);
            sb.append(lst[0]).append(str3).append(lst[1]);
        }

        return sb.toString();
    }
}
