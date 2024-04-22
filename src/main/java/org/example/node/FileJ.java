package org.example.node;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.enumerate.Kind;
import org.json.JSONObject;

@Data
@NoArgsConstructor
public class FileJ extends Node{
    Kind kind = Kind.FILE;
    private String name;
    private JSONObject expression;
    private Location location;
}
