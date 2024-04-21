package org.example.enumerate;


import lombok.Getter;
import org.example.node.*;


@Getter
public enum Term {
    BINARY(new Binary(), Kind.BINARY),
    BOOL(new Bool(), Kind.BOOL),
    CALL(new Call(), Kind.CALL),
    FIRST(new First(), Kind.FIRST),
    FUNCTION(new Function(), Kind.FUNCTION),
    IF(new If(), Kind.IF),
    INT(new Int(), Kind.INT),
    LET(new Let(), Kind.LET),
    PRINT(new Print(), Kind.PRINT),
    SECOND(new Second(), Kind.SECOND),
    STR(new Str(), Kind.STR),
    TUPLE(new Tuple(), Kind.TUPLE),
    VAR(new Var(), Kind.VAR);

    private final Node node;
    private final Kind kind;

    Term(Node node, Kind kind) {
        this.node = node;
        this.kind = kind;
    }

    public static Node returnObject(String s) throws NotTerm {
        for (Term t : Term.values()) {
            if (t.getKind().getKind().equals(s)) {
                return t.getNode();
            }
        }
        throw new NotTerm();
    }

    public Node getNode() {
        return node;
    }

    public Kind getKind() {
        return kind;
    }
}
