package org.example.node;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enumerate.Kind;

@Data
@NoArgsConstructor
public class If extends Node {
    private Kind kind = Kind.IF;
    private Node condition;
    private Node then;
    private Node otherwise;
    private Location location;

}
