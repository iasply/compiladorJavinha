package org.example;

import com.sun.source.tree.BinaryTree;
import org.example.node.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static java.lang.System.*;

public class Compilate {

    LinkedHashMap<Parameter, Let> memoryLet = new LinkedHashMap<>();
    LinkedHashMap<List<Parameter>, Function> memoryFunction = new LinkedHashMap<>();

    public void run(Node nodeExpression) {
        switch (nodeExpression.getKind()) {
            case PRINT -> {
                Node value = ((Print) nodeExpression).getValue();
                Object object = getPrimitiveValue(value);

                if (object instanceof Node node) {
                    run(node);
                    return;
                }

                out.println(object);
            }
            case LET -> {
                Let let = (Let) nodeExpression;
                memoryLet.put(let.getName(), let);
            }
            case FUNCTION -> {
                Function function = (Function) nodeExpression;
                function.getValue();

            }
            case IF -> {

            }
            case BINARY -> {

            }
        }
    }

//    private Object useFunction(Function function, Call call){
//            if (!(function.getParameters().size()  == call.getArguments().size())){
//                throw new RuntimeException();
//            }
//
//
//    }

    private Object getPrimitiveValue(Node value) {
        try {
            Method getterMethod = value.getClass().getMethod("getValue");
            return getterMethod.invoke(value);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new IllegalArgumentException("Failed to access primitive value of node", e);
        }
    }


}
