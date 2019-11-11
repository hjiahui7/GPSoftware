package software.service.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Aspect
@Component
public class WebLogAspect {
  private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

  @Pointcut("execution(public * software.*.*(..))")
  public void webLog() {}

  @Before("webLog()")
  public void deBefore(JoinPoint joinPoint) throws Throwable {
    ServletRequestAttributes attributes =
        (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = attributes.getRequest();
    logger.info("\nURL : " + request.getRequestURL().toString());
    logger.info("HTTP_METHOD : " + request.getMethod());
    logger.info("IP : " + request.getRemoteAddr());
    Enumeration<String> enu = request.getParameterNames();
    while (enu.hasMoreElements()) {
      String name = (String) enu.nextElement();
      logger.info("name:{},value:{}", name, request.getParameter(name) + "\n");
    }
  }

  @AfterReturning(returning = "ret", pointcut = "webLog()")
  public void doAfterReturning(Object ret) throws Throwable {
    // 处理完请求，返回内容
    logger.info("RESPONSE : " + ret + "\n");
  }
}
