package Controller;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import entidades.Lancamento;
import entidades.TipoLancamento;

/**
 * Created by rafikrafael on 02/04/2018.
 */

public class ControllerLancamento {

    private final String LANCAMENTO_JSON = "lancamentosFinanceirosJson";

    private ArrayList<Lancamento> lancamentos = new ArrayList<Lancamento>();
    private SharedPreferences sp;

    public ControllerLancamento(SharedPreferences sp){
        this.sp = sp;
        this.getListFromPreferences();
    }

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

    public void getListFromPreferences() {
        String lancamentosJson = sp.getString(LANCAMENTO_JSON,"");

        Gson gson = new Gson();
        ArrayList<Lancamento> lancamentosSalvos = gson.fromJson(lancamentosJson,
                new TypeToken<List<Lancamento>>(){}.getType());
        if (lancamentosSalvos != null && lancamentosSalvos.size() > 0) {
            lancamentos.clear();
            lancamentos.addAll(lancamentosSalvos);
        }
    }

    public void saveListInPreferences() {
        SharedPreferences.Editor editor = sp.edit();
        Gson gson = new Gson();
        String lancamentosJson = gson.toJson(lancamentos);
        editor.putString(LANCAMENTO_JSON,lancamentosJson);
        editor.commit();

    }
}
