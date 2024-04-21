package org.example.node;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enumerate.Kind;
import org.example.enumerate.Term;

import java.util.List;

@Data
@NoArgsConstructor
public class Function extends Node {
    private Kind kind = Kind.FUNCTION;
    private List<Parameter> parameters;
    private Node value;
    private Location location;

}
