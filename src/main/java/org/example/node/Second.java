package org.example.node;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enumerate.Kind;

@Data
@NoArgsConstructor
public class Second extends Node {
    private Kind kind = Kind.SECOND;
    private Node value;
    private Location location;

}
