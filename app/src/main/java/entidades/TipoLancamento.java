package entidades;

/**
 * Created by rafikrafael on 02/04/2018.
 */

public enum TipoLancamento {
    CREDITO("Credito", 0),
    DEBITO("Debito", 1);

    private String stringValue;
    private int intValue;
    private TipoLancamento(String toString, int value) {
        stringValue = toString;
        intValue = value;
    }

    @Override
    public String toString() {
        return stringValue;
    }
}
