package org.example.node;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enumerate.Kind;

@Data
@NoArgsConstructor
public class Parameter  extends Node{
    private Kind kind = Kind.PARAMETER;
    private String text;
    private Location location;

}
