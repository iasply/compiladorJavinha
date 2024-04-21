package org.example.node;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enumerate.Kind;

@Data
@NoArgsConstructor
public class Print extends Node {
    private Kind kind = Kind.PRINT;
    private Node value;
    private Location location;
}
