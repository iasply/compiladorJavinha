package org.example.node;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enumerate.Kind;

@Data
@NoArgsConstructor
public class Bool  extends Node{
    private Kind kind = Kind.BOOL;
    private boolean value;
    private Location location;
}
