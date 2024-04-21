package org.example.node;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enumerate.Kind;

@Data
@NoArgsConstructor
public class Tuple extends Node {
    Kind kind = Kind.TUPLE;
    Node first;
    Node second;
    Location location;

}
