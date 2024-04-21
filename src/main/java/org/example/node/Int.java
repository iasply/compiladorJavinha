package org.example.node;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enumerate.Kind;

@Data
@NoArgsConstructor
public class Int  extends Node{
    private Kind kind = Kind.INT;
    private int value;
    private Location location;

}
