package org.example.node;

import lombok.Data;
import org.example.enumerate.Kind;

@Data
public abstract class Node {
    private Kind kind;

}
