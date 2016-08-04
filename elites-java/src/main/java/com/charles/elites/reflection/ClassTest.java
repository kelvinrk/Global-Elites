package com.charles.elites.reflection;

import com.charles.elites.objects.Student;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Set;

/**
 * Created by Kelvin.R.K on 7/1/2016.
 */
public class ClassTest {
    public static void main(String[] args) {
        testClass();
    }

    public static void testClass() {
        Student student = new Student(1, "Cristiano");
        Class<?> clazz = student.getClass();

        System.out.println("clazz " + clazz);
        System.out.println("clazz.getSimpleName() " + clazz.getSimpleName());

        System.out.println("clazz.getPackage() " + clazz.getPackage());

        Set<Field> allFields = ReflectionUtils.getAllFields(clazz,
                ReflectionUtils.withModifier(Modifier.PRIVATE));

        for(Field field : allFields)
            System.out.println(field.getName());

         Set<Method> allMethods =  ReflectionUtils.getAllMethods(clazz,
                 ReflectionUtils.withModifier(Modifier.PUBLIC));

        for(Method method : allMethods)
            System.out.println(method.getName());
    }
}
