import Models.TestModel;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {

    public static void main(String[] args){

        TestModel testModel = new TestModel("Amine",1);
        Field[] fields = testModel.getClass().getDeclaredFields();
        Method[] methods = testModel.getClass().getDeclaredMethods();

        //Changing Private Fields
        Arrays.stream(fields)
                        .filter(field -> Modifier.isPrivate(field.getModifiers()))
                        .forEach(field -> {
                                    field.setAccessible(true);
                                    try {
                                        field.set(testModel,"Changed Private Field");
                                    } catch (IllegalAccessException e) {
                                        throw new RuntimeException(e);
                                    }
                                });
        System.out.print(testModel.toString());

        //Using Private Methods
        Arrays.stream(methods)
                .filter(method -> Modifier.isPrivate(method.getModifiers()))
                .forEach(method -> {
                    method.setAccessible(true);
                    try {
                        method.invoke(testModel);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                });

    }

}