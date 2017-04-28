package ar.edu.ort.apptivo;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.text.Html;
        import android.text.method.LinkMovementMethod;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtMail;
    EditText edtPass;
    TextView lblRegistrar;
    Button btnIngreso;
    String strUser= "tato@gmail.com";
    String strPass= "12345678";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ObtenerReferencias();
        SetearListeners();
    }

    private void ObtenerReferencias(){
        edtMail=(EditText) findViewById(R.id.edtMail);
        edtPass=(EditText) findViewById(R.id.edtPass);
        lblRegistrar = (TextView) findViewById(R.id.txtRegistrar);
        btnIngreso = (Button) findViewById(R.id.btnIngreso);

        lblRegistrar.setText(   Html.fromHtml(
                "<a href=\"http://www.google.com\">Registrar(Por ahora google)</a> "));
        lblRegistrar.setMovementMethod(LinkMovementMethod.getInstance());

    }

    private void SetearListeners(){
        btnIngreso.setOnClickListener(onClick);
    }

    View.OnClickListener onClick = new View.OnClickListener(){
        @Override
        public void onClick(View v)
        {
            IniciarSegundaActividad();
        }
    };

    private void IniciarSegundaActividad() {
        String sError="";
        Boolean Error=true;
        if (!edtMail.getText().toString().contains("@")) {
            Error=false;
            sError+="El campo de mail debe contener un @" + "\n";
        }
        if (edtPass.getText().toString().length()<8) {
            Error=false;
            sError+="La password debe contener mas de 8 caracteres."+ "\n";
        }
        if (!edtMail.getText().toString().equals(strUser)|| !edtPass.getText().toString().equals(strPass)&&!Error) {
            Error=false;
            sError+="Los campos no son correctos.";
        }

        if (Error)
        {
            Intent intent = new Intent(this, MapsActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast msg = Toast.makeText(getApplicationContext(),sError , Toast.LENGTH_SHORT);
            msg.show();
        }
    }
}
