package com.tests.MyListeners;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class iAnnotationTransformerListener implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation, Class Class, Constructor constructor, Method method) {
        annotation.setRetryAnalyzer(RetryListener.class);
    }
}
