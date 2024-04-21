package org.example.node;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enumerate.Kind;


@Data
@NoArgsConstructor
public class Let  extends Node{
    private Kind kind = Kind.LET;
    private Parameter name;
    private Node value;
    private Node next;
    private Location location;

}
