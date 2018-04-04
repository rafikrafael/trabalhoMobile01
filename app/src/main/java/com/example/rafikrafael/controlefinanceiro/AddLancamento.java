package com.example.rafikrafael.controlefinanceiro;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import entidades.Lancamento;
import entidades.TipoLancamento;

public class AddLancamento extends AppCompatActivity {

    private EditText editValor;
    private RadioGroup radioGroup;
    private Button btnLancar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lancamento);

        radioGroup = (RadioGroup) findViewById(R.id.rgTipoLancamento);
        editValor = (EditText) findViewById(R.id.editValor);

        editValor.setText("");

    }

    public void btnCancelarClicked(View view){
        finish();
    }

    public void btnLancarClicked(View view) {
        Lancamento lancamento = new Lancamento();
        lancamento.setTipo(TipoLancamento.CREDITO);
        if (radioGroup.getCheckedRadioButtonId() == R.id.radio_debito) {
            lancamento.setTipo(TipoLancamento.DEBITO);
        }
        Double valor = Double.parseDouble(editValor.getText().toString());
        lancamento.setValor(valor);

        int resultCode = 1;
        Intent resultIntent = new Intent();
        resultIntent.putExtra("lancamento", lancamento);
        setResult(resultCode, resultIntent);

        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

}
