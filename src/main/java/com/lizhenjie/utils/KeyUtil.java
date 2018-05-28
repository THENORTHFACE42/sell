package com.lizhenjie.utils;

import java.util.Random;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 18:21 2018/5/6
 * @Modified By:
 */
public class KeyUtil {
    /**
     * 生成唯一的主键
     * 格式：时间+随机数
     * @return
     */
    public static String genUniqueKey(){
        Random random= new Random();
        Integer number=random.nextInt(900000)+100000;
        return  System.currentTimeMillis()+String.valueOf(number);
    }
}
