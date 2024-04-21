package org.example.node;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.json.JSONObject;

@Data
@NoArgsConstructor
public class FileJ extends Node{
    private String name;
    private JSONObject expression;
    private Location location;
}
