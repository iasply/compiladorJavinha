package org.example.node;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enumerate.Kind;

@Data
@NoArgsConstructor
public class Location extends Node {

        private Kind kind = Kind.LOCATION;
        private int start;
        private int end;
        private String filename;
}
