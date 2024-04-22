package org.example;

import org.example.node.Function;
import org.example.node.Let;
import org.example.node.Node;
import org.example.node.Print;

import java.lang.reflect.Field;

public class Compilate {

    public void run(Node nodeExpression) {
        switch (nodeExpression.getKind()) {
            case PRINT -> {
                Node value = ((Print) nodeExpression).getValue();
                Object primit = getPrimit(value);
                System.out.println(primit);

            }
            case LET -> {
                Node value = ((Let) nodeExpression).getValue();

                if (value instanceof Function){
                    Object o = useFunction((Function) value);
                }
            }
        }
    }

    private Object useFunction(Function node,){
            if (node.getParameters())
    }

    private Object getPrimit(Node value) {
        Class<? extends Node> aClass = value.getClass();
        try {
            Field field = aClass.getDeclaredField("value");
            field.setAccessible(true);
            return field.get(value);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

    }


}
