package Controller;

import java.util.LinkedList;

import entidades.Lancamento;
import entidades.TipoLancamento;

/**
 * Created by rafikrafael on 02/04/2018.
 */

public class ControllerLancamento {

    private LinkedList<Lancamento> lancamentos = new LinkedList<Lancamento>();

    public void add(Lancamento lancamento) {
        lancamentos.add(lancamento);
    }

    public Double getSaldo() {
        Double valor = 0D;

        if (lancamentos.size() <= 0) return 0D;

        for (Lancamento lancamento: lancamentos) {
            if (lancamento.getTipo().equals(TipoLancamento.CREDITO)) {
                valor += lancamento.getValor();
            } else {
                valor -= lancamento.getValor();
            }
        }

        return valor;
    }

}
