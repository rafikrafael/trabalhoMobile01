package com.example.rafikrafael.controlefinanceiro;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import Controller.ControllerLancamento;
import entidades.Lancamento;
import entidades.TipoLancamento;

public class MainActivity extends AppCompatActivity {

    public final static int REQ_CODE_CHILD = 1;

    private EditText editResultado;
    private Button btnLancar;

    private ControllerLancamento controllerLancamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sp = this.getPreferences(Context.MODE_PRIVATE);

        controllerLancamento = new ControllerLancamento(sp);
        editResultado = (EditText) findViewById(R.id.editResultado);
        editResultado.setEnabled(false);

        btnLancar = (Button) findViewById(R.id.btnLancar);
        getSaldoEmTela();
    }

    public void btnLancarClicked(View view){
        Intent intent = new
                Intent(this, AddLancamento.class);
        startActivityForResult(intent, REQ_CODE_CHILD);
    }

    private void getSaldoEmTela() {
        editResultado.setText(controllerLancamento.getSaldo().toString());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQ_CODE_CHILD) {
            if (resultCode == Activity.RESULT_OK) {
                Lancamento lancamento = (Lancamento) data.getExtras().getSerializable("lancamento");
                controllerLancamento.add(lancamento);
                controllerLancamento.saveListInPreferences();
                getSaldoEmTela();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
