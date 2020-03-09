package com.khpc.cn.core.resolver;

import com.khpc.cn.core.entity.exception.HandleDataExecption;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Vinne
 * @date 2020/1/16 15:18
 * @description  统一异常处理处理器
 **/
public class UnifiedExecptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        // 封装异常结果
        Map<String,Object>  resultMap = new HashMap<>(4);
        resultMap.put("result",e);
        // 判断异常类型 假如为数据处理异常，则返回首页
        // shiro登录权限认证异常
        if(e instanceof UnknownAccountException){
            System.out.print("登录异常");
            return null;
        }
        else{
            return null;
        }
    }
}
