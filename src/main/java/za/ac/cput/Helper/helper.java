package za.ac.cput.Helper;

import org.apache.commons.lang3.StringUtils;

public class helper {

    public static boolean isEmptyOrNull(String str)
    {
        return StringUtils.isEmpty(str);
    }
    public static String setEmptyIfNull(String str)
    {
        if(isEmptyOrNull(str))
            return "";


        return str;
    }
}
