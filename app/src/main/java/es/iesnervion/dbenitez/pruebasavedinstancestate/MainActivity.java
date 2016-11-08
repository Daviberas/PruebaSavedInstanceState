package es.iesnervion.dbenitez.pruebasavedinstancestate;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    static final String STATE_CONTADOR = "cont";
    Integer contador;
    TextView numeroPulsaciones;
    Button contar;
    Button mostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        if(savedInstanceState != null)
        {
            contador = savedInstanceState.getInt(STATE_CONTADOR);
        }
        else
            contador = 0;

        setContentView(R.layout.activity_main);

        numeroPulsaciones = (TextView) findViewById(R.id.pulsados);
        contar = (Button) findViewById(R.id.contar);
        mostrar = (Button) findViewById(R.id.mostrar);

        contar.setOnClickListener(this);
        mostrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.contar:
                contador++;
                break;
            case R.id.mostrar:
                numeroPulsaciones.setText(contador.toString());
                break;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);

        outState.putInt(STATE_CONTADOR,contador);
    }
}
