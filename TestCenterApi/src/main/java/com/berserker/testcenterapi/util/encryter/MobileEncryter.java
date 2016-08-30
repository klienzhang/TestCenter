package com.berserker.testcenterapi.util.encryter;

import org.apache.commons.lang.StringUtils;
import org.apache.http.annotation.ThreadSafe;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ThreadSafe
public class MobileEncryter {

    private static final Logger logger = LogManager.getLogger(MobileEncryter.class);
    private static final String salt = "N0thing_gReat_wAs_eveR_achieved_with0ut_enthusiasm, N0_do_n0_die.";
    private static BlowfishForStr blowfish;

    static {
        blowfish = new BlowfishForStr(salt.substring(32), salt.substring(48, 56));
    }

    /**
     * 加密
     * @param content
     * @return
     */
    public static String encode(String content) {
        if (StringUtils.isEmpty(content)) {
            return null;
        }
        try {
            byte[] encryptedBytes = blowfish.encrypt(content);
            char[] base64Chars = Base64.encode(encryptedBytes);
            int i;
            for (i = 0; i < base64Chars.length; i++) {
                if (base64Chars[i] == '=') {
                    break; // = only appear at end, so i is the ending
                } else if (base64Chars[i] == '+') {
                    base64Chars[i] = '-';
                } else if (base64Chars[i] == '/') {
                    base64Chars[i] = '_';
                }
            }
            return new String(base64Chars, 0, i);
        } catch (Exception e) {
            logger.error("encode error, content=" + content, e);
        }
        return null;
    }

    /**
     * 解密
     * @param content
     * @return
     */
    public static String decode(String content) {
        if (StringUtils.isEmpty(content)) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder(content);
            int i = content.length();
            while (i % 4 != 0) {
                sb.append('=');
                i++;
            }
            for (i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == '-') {
                    sb.setCharAt(i, '+');
                } else if (sb.charAt(i) == '_') {
                    sb.setCharAt(i, '/');
                }
            }
            byte[] sourceBytes = Base64.decode(sb.toString());
            return blowfish.decrypt(sourceBytes);
        } catch (Exception e) {
            logger.error("decode error, content=" + content, e);
        }
        return null;
    }
}
