package org.example.node;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Parameter  extends Node{
    private String text;
    private Location location;

}
