package org.example;

import com.google.gson.Gson;
import lombok.NoArgsConstructor;
import org.example.enumerate.BinaryOp;
import org.example.enumerate.Kind;
import org.example.enumerate.NotTerm;
import org.example.enumerate.Term;
import org.example.node.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
public class MemoryObject {
    private static final String KIND = "kind";
    private String LOCATION = "Location";

    public Node read(JSONObject jsonObject) {
        FileJ fileJ = new FileJ();
        fileJ.setExpression(jsonObject.getJSONObject("expression"));
        fileJ.setName(jsonObject.get("name").toString());
        fileJ.setLocation(locationSet(jsonObject));

        return act(fileJ.getExpression());
    }

    private Node act(JSONObject expression) {
        Node node = null;
        try {
            node = Term.returnObject(expression.get(KIND).toString());
            Field[] fields = node.getClass().getDeclaredFields();
            fieldResolve(fields, node, expression);
            node.toString();
        } catch (NotTerm ex) {
            throw new RuntimeException(ex);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return node;

    }

    private void fieldResolve(Field[] fields, Node node, JSONObject expression) throws IllegalAccessException {
        for (Field field : fields) {
            if (field.getName().equals(KIND)) {
                continue;
            }
            field.setAccessible(true);

            if (field.getType().equals(List.class) && node.getKind().equals(Kind.FUNCTION)) {
                JSONArray parameters = expression.getJSONArray("parameters");
                List<Parameter> array = new ArrayList<>();
                int length = parameters.length();

                for (int i = 0; i < length; i++) {
                    Object o = parameters.get(i);
                    array.add(parameterSet((JSONObject) o));

                }

                parameters.toString();

                field.set(node, array);
                continue;
            }

            if (field.getType().equals(List.class) && node.getKind().equals(Kind.CALL)) {
                JSONArray parameters = expression.getJSONArray("arguments");
                List<Node> array = new ArrayList<>();
                int length = parameters.length();

                for (int i = 0; i < length; i++) {
                    Object o = parameters.get(i);
                    array.add(toNode((JSONObject) o));

                }

                parameters.toString();

                field.set(node, array);
                continue;
            }


            if (field.getType().equals(Parameter.class)) {
                field.set(node, parameterSet(expression.getJSONObject("name")));
                continue;
            }
            if (field.getType().equals(Location.class)) {
                field.set(node, locationSet(expression));
                continue;
            }

            if (field.getType().equals(Node.class)) {
                field.set(node, toNode(expression.getJSONObject(field.getName())));
                continue;
            }

            if (field.getType().equals(BinaryOp.class)) {
                Object o = expression.get(field.getName());

                field.set(node, BinaryOp.valueOf(o.toString()));
                continue;
            }

            if (field.getType().equals(Call.class)) {
               // field.set(node, toNode())

                System.out.println();
            }

            field.set(node, expression.get(field.getName()));

        }
    }

    private Parameter parameterSet(JSONObject o) {
        Parameter parameter = new Parameter();
        parameter.setText(o.get("text").toString());
        parameter.setLocation(locationSet(o));

        return parameter;
    }

    private Node toNode(JSONObject jsonObject) {
        Node node = null;
        try {
            node = Term.returnObject(jsonObject.get(KIND).toString());
        } catch (NotTerm e) {
            throw new RuntimeException(e);
        }
        Field[] fields = node.getClass().getDeclaredFields();
        try {
            fieldResolve(fields, node, jsonObject);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return node;
    }


    private Location locationSet(JSONObject s) {
        return new Gson().fromJson(s.get("location").toString(), Location.class);

    }

//    private Call callSet(JSONObject s) {
//        Call call = new Call();
//        call.setCallee(toNode(s.getJSONObject("calle")));
//        call.setArguments(toNode(s.getJSONObject("arguments")));
//
//        return call;
//    }


}
