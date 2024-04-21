package org.example.node;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enumerate.Kind;

@Data
@NoArgsConstructor
public class First extends Node {
    private Kind kind = Kind.FIRST;
    private Node value;
    private Location location;
}
