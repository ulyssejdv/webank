package fr.ulysse.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


/**
 * Created by ulysse on 17/10/2017.
 */
@Aspect
@Component
public class LoggerController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("execution(* fr.ulysse.controllers.ClientController.*(..))")
    public Object logThis(ProceedingJoinPoint pjp) {

        Object proceed = null;

        long startAt = System.currentTimeMillis();

        try {
            proceed = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        long endAt = System.currentTimeMillis();

        StringBuilder logString = new StringBuilder();

        // Execution time
        logString.append("["+(endAt - startAt)+"ms]");

        // Controller Name
        logString.append("["+pjp.getSignature().getDeclaringType().getSimpleName()+"]");

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();

        // HTTP Method
        logString.append("["+request.getMethod()+"]");

        // URI path
        logString.append("["+request.getRequestURI()+"]");

        // Method Controller Name
        logString.append("["+pjp.getSignature().getName()+"()]");

        // Given args to the method
        logString.append(Arrays.toString(pjp.getArgs()));

        logger.info(logString.toString());


        return proceed;
    }
}
