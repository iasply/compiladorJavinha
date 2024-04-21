package org.example.node;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enumerate.BinaryOp;
import org.example.enumerate.Kind;

@Data
@NoArgsConstructor
public class Binary extends Node {
    private Kind kind = Kind.BINARY;
    private Node lhs;
    private BinaryOp op;
    private Node rhs;
    private Location location;
}
