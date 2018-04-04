package entidades;

import java.io.Serializable;

/**
 * Created by rafikrafael on 02/04/2018.
 */

public class Lancamento implements Serializable {

    private Double valor;
    private TipoLancamento tipo;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public TipoLancamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoLancamento tipo) {
        this.tipo = tipo;
    }
}
