package br.com.tairoroberto.aulasfiap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;

public class ConfirmacaoActivity extends AppCompatActivity {

    private static final String TAG = "TAG";
    private TextView textViewConfirmacao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salvar_usuario);
        textViewConfirmacao = (TextView) findViewById(R.id.textViewConfirmacao);


        if (getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            Log.i(TAG, "onCreate: "  + bundle.get("nome"));
            Log.i(TAG, "onCreate: "  + bundle.get("idade"));
            Log.i(TAG, "onCreate: "  + bundle.get("time"));

            textViewConfirmacao.setText(Html.fromHtml(getString(R.string.parabens, bundle.getString("nome"), bundle.getString("time"))));
        }
    }
}
