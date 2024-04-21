package org.example.node;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Location extends Node {
        private int start;
        private int end;
        private String filename;
}
