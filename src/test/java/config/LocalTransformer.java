package config;


import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 注解转换器
 */
public class LocalTransformer implements IAnnotationTransformer{

    @SuppressWarnings("rawtypes")
    @Override
    public void transform(ITestAnnotation iTestAnnotation,
                          Class class1, Constructor constructor, Method method) {

        IRetryAnalyzer iRetryAnalyzer = iTestAnnotation.getRetryAnalyzer();
//        System.out.println("transform(),iRetryAnalyzer:"+iRetryAnalyzer);
        if(iRetryAnalyzer==null){
            iTestAnnotation.setRetryAnalyzer(Retry.class);
        }
    }

}
