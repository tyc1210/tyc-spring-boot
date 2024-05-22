package com.tyc.module.system.filter;

import cn.hutool.core.util.StrUtil;
import com.tyc.boot.common.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static com.tyc.module.system.exception.SystemErrorCodeConstants.NEED_LOGIN;


/**
 * 类描述
 *
 * @author tyc
 * @version 1.0
 * @date 2024-05-20 18:01:51
 */
@Slf4j
@Component
@WebFilter(urlPatterns = {"/*"}, filterName = "loginInterceptor")
public class SysLoginFilter extends OncePerRequestFilter {

    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver resolver;

    private final String[] UN_CHECK_URI_ARR = {"druid","login","register","favicon"};

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Methods","POST, GET");
        String uri = request.getRequestURI();
        String method = request.getMethod();
        if("OPTIONS".equals(method)){
            filterChain.doFilter(request, response);
            return;
        }

        // 判断是否拦截
        boolean check = StrUtil.containsAnyIgnoreCase(uri,UN_CHECK_URI_ARR);
        if(!check){
            // todo 执行校验 token 逻辑
            if(!checkToken()){
                resolver.resolveException(request, response, null, new CommonException(NEED_LOGIN));
                return;
            }
        }

        filterChain.doFilter(request, response);
        return;
    }

    boolean checkToken(){
        return false;
    }
}
