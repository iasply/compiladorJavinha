package org.example.node;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enumerate.Kind;
import org.example.enumerate.Term;

import java.util.List;

@Data
@NoArgsConstructor
public class Call  extends Node{
    private Kind kind =  Kind.CALL;
    private Node callee;
    private List<Node> arguments;
    private Location location;

}
