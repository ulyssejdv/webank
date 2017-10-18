package fr.ulysse.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;


/**
 * Created by ulysse on 17/10/2017.
 */
@Aspect
@Component
public class LoggerController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /*@Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping) && execution(* *(..))")
    public void pointCutPostMapping() {
    }

    @Pointcut("execution(* fr.ulysse.controllers.ClientController.*(..))")
    public void pointCutGetMapping() {
    }*/

    @Around("execution(* fr.ulysse.controllers.ClientController.*(..))")
    public void logThis(ProceedingJoinPoint pointcut) {

        Controller result = null;

        long start = System.currentTimeMillis();


        try {
            result = (Controller) pointcut.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        StringBuilder stringBuilder = new StringBuilder();

        long elapsedTime = System.currentTimeMillis() - start;
        stringBuilder.append("["+elapsedTime+"ms]");
        stringBuilder.append("["+pointcut.getClass().getName()+"]");
        stringBuilder.append("["+pointcut.getSignature().getName()+"]");

        logger.info(stringBuilder.toString());
    }
}
