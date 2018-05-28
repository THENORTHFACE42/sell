package com.lizhenjie.utils;

import com.lizhenjie.enums.CodeEnum;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 16:59 2018/5/10
 * @Modified By:
 */
public class EnumUtil {
    public static <T extends CodeEnum>T getByCode(Integer code, Class<T> enumClass){
        for(T each:enumClass.getEnumConstants())
        {
            if(code.equals(each.getCode()))
            {
                return each;
            }
        }
        return null;
    }
}
