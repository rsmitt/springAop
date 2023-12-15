package ru.edu.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import ru.edu.bins.DivideException;

@Aspect
@Component
public class LogAspect {
    // для всех методов в классе WriterAdapter
    @Pointcut("execution(* ru.edu.bins.WriterAdapter.*(..))")
    public void loggingExecution(){}

    @Before("loggingExecution()")
    public void loggingBefore() {
        System.out.println("adding additional logic from aspect :: before");
    }

    @AfterReturning(pointcut = "loggingExecution()", returning = "retVal")
    public void loggingAfterReturning(Object retVal) {
        System.out.println("adding additional logic from aspect :: afterReturning :: method return value = " + retVal);
    }

    @AfterThrowing(value = "loggingExecution()", throwing = "ex")
    public void loggingAfterThrowing(DivideException ex) {
        System.out.println("adding additional logic from aspect :: AfterThrowing");

    }

    @After(value = "loggingExecution()")
    public void loggingAfterFinal() {
        System.out.println("adding additional logic from aspect :: AfterFinal");

    }

    @Around("loggingExecution()")
    public Object loggingAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // StopWatch
        System.out.println("some logic before method processing...");
        Object retVal = "Aspect :: " + proceedingJoinPoint.proceed();
        System.out.println("some logic after method processing...");

        return retVal;
    }
}
