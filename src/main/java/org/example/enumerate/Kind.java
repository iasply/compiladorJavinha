package org.example.enumerate;

import lombok.Getter;

@Getter
public enum Kind {
    BINARY("Binary"),
    BINARYOP("BinaryOp"),
    BOOL("Bool"),
    CALL("Call"),
    INT("Int"),
    FILE("File"),
    FIRST("First"),
    FUNCTION("Function"),
    IF("If"),
    LET("Let"),
    LOCATION("Location"),
    PARAMETER("Parameter"),
    PRINT("Print"),
    SECOND("Second"),
    STR("Str"),
    TERM("Term"),
    TUPLE("Tuple"),
    VAR("Var");

    private final String kind;

    Kind(String kind) {
        this.kind = kind;
    }

    public static Kind fromString(String text) {
        for (Kind kind : Kind.values()) {
            if (kind.kind.equalsIgnoreCase(text)) {
                return kind;
            }
        }
        throw new IllegalArgumentException("No constant with text " + text + " found");
    }

    public String getKind() {
        return kind;
    }
}
