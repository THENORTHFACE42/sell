package com.lizhenjie.utils;

import com.lizhenjie.vo.ResultVo;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 0:18 2018/5/4
 * @Modified By:
 */
public class ResultVoUtil {

    public static ResultVo success(Object object){
        ResultVo resultVo=new ResultVo();
        resultVo.setData(object);
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        return resultVo;
    }
    public static ResultVo success(){
        return success(null);
    }
    public static ResultVo error(Integer code,String msg){
        ResultVo resultVo=new ResultVo();
        resultVo.setCode(code);
        resultVo.setMsg(msg);
        return resultVo;
    }


}
