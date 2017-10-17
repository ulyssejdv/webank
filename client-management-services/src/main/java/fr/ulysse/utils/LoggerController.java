package fr.ulysse.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.logging.Logger;

/**
 * Created by ulysse on 17/10/2017.
 */
@Aspect
public class LoggerController {

    private Logger logger;

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void pointCutPostMapping() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void pointCutGetMapping() {
    }

    @Before("pointCutPostMapping() && pointCutGetMapping()")
    public void logThis(JoinPoint pointcut) {
        String methodName = pointcut.getSignature().getName();
        logger.info("Executing method: " + methodName);
    }
}
