package com.hhz.demo.encrypt;

import java.util.Random;


/**
 * <p class="detail">
 * 功能:验证码工具类
 * </p>
 *
 * @author HuangHuizhou
 * @ClassName Code util.
 * @Version V1.0.
 * @date 2019.03.25 14:19:51
 */
public class CodeUtil {
    private final static Random RANDOM = new Random(System.currentTimeMillis());

    private final static int DEFAULT_LENGTH = 6;

    public static String getCode() {

        return getCode(DEFAULT_LENGTH);
    }

    public static String getCode(int codeLength) {
        int min = (int) Math.pow(10, codeLength - 1);
        int max = (int) Math.pow(10, codeLength) - 1;
        int code = RANDOM.nextInt((max - min) + 1) + min;
        return String.valueOf(code);
    }
}
