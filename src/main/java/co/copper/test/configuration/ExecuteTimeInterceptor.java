package co.copper.test.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExecuteTimeInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(ExecuteTimeInterceptor.class);

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) {
        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    public void postHandle(
            HttpServletRequest request, HttpServletResponse response,
            Object handler, ModelAndView modelAndView) {
        long executeTime = System.currentTimeMillis() - (Long)request.getAttribute("startTime");
        if (log.isDebugEnabled()) {
            log.debug("{} {} <-- {} {} ms",request.getMethod(), request.getRequestURI(), HttpStatus.resolve(response.getStatus()),executeTime);
        }
    }

}