
**Joinpoint**: Is a point during the execution of a program, such as the execution of a method or the handling of an exception. When the code is executed and the condition for pointcut is met, the advice is executed. 

**PointCut**: Is a predicate that helps match an Advice to be applied by an Aspect at a particular JoinPoint. The expression used to define when a call to a method should be intercepted
The Advice is associated with a Pointcut expression, and it runs at any Joinpoint matched by the Pointcut.

**Advice**: Is an action taken by an aspect at a particular Joinpoint. Is the logic that you want to invoke when you intercept a method
Different types of advice include “around,” “before,” and “after.”  It is modelled as an interceptor, maintaining a chain of interceptors around the Joinpoint.

**Aspect**: A combination of defining when you want to intercept a method call (Pointcut) and what to do (Advice) is called an Aspect

**RetentionPolicy.RUNTIME**: The annotations annotated using the RUNTIME retention policy are retained during runtime and can be accessed in our program during runtime.

**@Around** uses an around advice. It intercepts the method call and uses joinPoint.proceed() to execute the method

In this project we are implementing two aspects:

First one: mesure time that a method is executed.

Second one: log initially the method name and the class where is the method and with parameters and in case of exception print a warning, if no exception print a info, and the method response.

Also then it was Modified the first log to just be printed in service methods with a pointcut instead of annotation. 

How proxies in spring work:
https://medium.com/trabe/understanding-aop-in-spring-from-magic-to-proxies-6f5911e5e5a8