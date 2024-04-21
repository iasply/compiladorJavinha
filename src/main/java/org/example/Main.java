package org.example;


import org.example.node.Node;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) throws IOException {
//        String filePath = "print.json";
        String filePath = "sum.json";

        String jsonString = new String(Files.readAllBytes(Paths.get(filePath)));


        JSONObject jsonObject = new JSONObject(jsonString);

        MemoryObject memoryObject = new MemoryObject();
        Node nodeExpression = memoryObject.read(jsonObject);


        new Compilate().run(nodeExpression);


    }
}