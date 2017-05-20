package br.com.tairoroberto.aulasfiap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class SalvarUsuarioActivity extends AppCompatActivity {

    private static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salvar_usuario);

        if (getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            Log.i(TAG, "onCreate: "  + bundle.get("nome"));
            Log.i(TAG, "onCreate: "  + bundle.get("idade"));
            Log.i(TAG, "onCreate: "  + bundle.get("time"));
        }
    }
}
