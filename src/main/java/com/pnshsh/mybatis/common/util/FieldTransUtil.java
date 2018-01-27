package com.pnshsh.mybatis.common.util;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 字段转化工具类
 */
public class FieldTransUtil {

    /**
     * @param str
     * @param isOmitPrefix 是否会略前缀
     * @return
     */
    public static String trans(String str, boolean isOmitPrefix) {
        String[] fragments = str.split("_");
        if (fragments.length == 0) {
            return StringUtils.lowerCase(str);
        } else if (fragments.length == 1) {
            return StringUtils.lowerCase(fragments[0]);
        } else if(fragments.length > 1) {
            String[] backup = fragments;
            if (isOmitPrefix == true) {
                backup = ArrayUtils.subarray(backup, 1, backup.length);
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i=0; i<backup.length; i++) {
                stringBuilder.append(StringUtils.capitalize(StringUtils.lowerCase(backup[i])));
            }
            return StringUtils.uncapitalize(stringBuilder.toString());
        }
        return str;
    }

}
