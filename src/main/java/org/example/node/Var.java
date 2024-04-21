package org.example.node;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enumerate.Kind;

@Data
@NoArgsConstructor
public class Var extends Node {
    private Kind kind = Kind.VAR;
    private String text;
    private Location location;

}
