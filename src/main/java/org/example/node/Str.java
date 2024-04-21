package org.example.node;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enumerate.Kind;

@Data
@NoArgsConstructor
public class Str  extends Node{
    private Kind kind = Kind.STR;
    private String value;
    private Location location;

}
