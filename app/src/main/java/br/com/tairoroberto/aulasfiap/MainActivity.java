package br.com.tairoroberto.aulasfiap;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private TextInputLayout textInputEditTextNome;
    private TextInputLayout textInputEditTextIdade;
    private String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        textInputEditTextNome = (TextInputLayout) findViewById(R.id.textInputEditTextNome);
        textInputEditTextIdade = (TextInputLayout) findViewById(R.id.textInputEditTextIdade);
        setSupportActionBar(toolbar);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                time = spinner.getAdapter().getItem(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void salvarUsuario(View view) {
        if (TextUtils.isEmpty(textInputEditTextIdade.getEditText().getText().toString())){
            Snackbar.make(textInputEditTextIdade, "Insira a idade", Snackbar.LENGTH_SHORT).show();
            textInputEditTextIdade.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(textInputEditTextNome.getEditText().getText().toString())){
            Snackbar.make(textInputEditTextNome, "Insira o nome", Snackbar.LENGTH_SHORT).show();
            textInputEditTextNome.requestFocus();
            return;
        }
        if (time.equalsIgnoreCase("Selecione o time")){
            Snackbar.make(textInputEditTextNome, "Selecione o time", Snackbar.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(MainActivity.this, ConfirmacaoActivity.class);
        intent.putExtra("nome", textInputEditTextNome.getEditText().getText().toString());
        intent.putExtra("idade", textInputEditTextIdade.getEditText().getText().toString());
        intent.putExtra("time", time);
        startActivity(intent);
    }
}
