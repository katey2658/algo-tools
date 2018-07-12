package com.busyzero.algo.security.http;

/**
 * IP 处理工具类
 *
 * @author wangdong1995
 */
public class IDCardUtils {

    /** 默认隐藏的字符  */
    private static final String SYMBOL_HIDE_DEFAULT = "*";

    /** 默认隐藏开始位置 */
    private static final int START_INDEX_HIDE_DEFAULT = 6;

    /** 默认隐藏结束位置 */
    private static final int END_INDEX_HIDE_DEFAULT = 14;

    /** 默认身份证开始下标 */
    private static final int MIN_ID_CARD_INDEX_DEFAULT = 1;

    /** 默认身份证开始下标 */
    private static final int MAX_ID_CARD_INDEX_DEFAULT = 18;


    /**
     * 校验IP 是否正确
     *
     * @param ip
     * @return
     */
    public static boolean valid (String ip){
        return true;
    }

    /**
     * 默认的隐藏实现
     *
     * @param originalId
     * @return
     */
    public static String overrideId(final String originalId){
        return IDCardUtils.overrideId(originalId, START_INDEX_HIDE_DEFAULT, END_INDEX_HIDE_DEFAULT, SYMBOL_HIDE_DEFAULT);
    }

    /**
     * 定制自己想要的IP 隐藏方案
     *
     * @param originalId
     * @param startIndex 开始位置 最小 1
     * @param endIndex  结束位置 最大18
     * @param symbol 自定义隐藏符
     * @return
     */
    public static String overrideId(final String originalId, int startIndex, int endIndex, String symbol){
        int overrideLength =  endIndex - startIndex + 1;
        if (null == originalId || overrideLength < 1 || null == symbol || originalId.length() != 18) {
            throw new IllegalArgumentException();
        }
        if (startIndex < MIN_ID_CARD_INDEX_DEFAULT) {
            startIndex = MIN_ID_CARD_INDEX_DEFAULT;
        }
        if (endIndex > MAX_ID_CARD_INDEX_DEFAULT) {
            endIndex = MAX_ID_CARD_INDEX_DEFAULT;
        }
        int length = symbol.length();
        if (length > overrideLength) {
            symbol = symbol.substring(0, overrideLength);
        }

        final String ipPrefix = originalId.substring(0, startIndex);
        final String ipSuffix = originalId.substring(endIndex, MAX_ID_CARD_INDEX_DEFAULT);
        StringBuilder builder =  new StringBuilder(ipPrefix);
        for (int i = startIndex; i <= endIndex; i = i + length) {
            builder.append(symbol);
        }
        builder.append(ipSuffix);
        return builder.toString();
    }

}
