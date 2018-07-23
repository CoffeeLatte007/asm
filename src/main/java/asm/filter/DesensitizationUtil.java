/**
 * www.lz.pw Inc.
 * Copyright (c) 2010-2018 All Rights Reserved.
 */
package asm.filter;


import org.apache.commons.lang3.StringUtils;

/**
 * <p></p>
 *
 * @author 563868273@qq.com
 * @version $Id: DesensitizationUtil.java, v 0.1 2018-03-01 下午6:24 @lizhao07 $$
 */
public class DesensitizationUtil {
    public static final String MOBILE_DESENSITIZATION = "****";
    /**
     * 手机号加*脱敏
     * @param mobile
     * @return
     */
    public static String mobileDesensitiza(String mobile){
        if (StringUtils.isBlank(mobile) || mobile.length() != 11) {
            return mobile;
        }
        return new StringBuilder(mobile).replace(3, 7, MOBILE_DESENSITIZATION).toString();
    }

}