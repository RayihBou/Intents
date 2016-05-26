package comrayihbou.github.intents;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

//En esta clase se manejaran todas las variables en el activity DetalleContacto.

public class DetalleContacto extends AppCompatActivity {

    //Declaracion de Variables de los TextView del activity DetalleContacto.
    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvEmail;

    //Manejo del metodo OnCreate en donde obtendremos toda la informacion de los campos y ademas de ello los editaremos.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Bundle parametros = getIntent().getExtras(); //Con el Bundle creamos un metodo para obtener los datos con el intent. Es obligatorio para el manejo de datos.

        //metodos para obtener los datos de nuestro archivo xml de strings, para declarar el nombre de los parametros que usaremos.
        String nombre = parametros.getString(getResources().getString(R.string.pnombre));
        String telefono = parametros.getString(getResources().getString(R.string.ptelefono));
        String email = parametros.getString(getResources().getString(R.string.pemail));

        //Casteo para hacer el llamado a la variable del activity que vamos a usar
        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);

        //Modificar el texto de acuerdo a los resultados arrojados despues del casteo.
        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
    }

    //Metodo para generar una llamada al momento que pulsemos el icono o el texto del telefono en nuestro detalle de contacto.
    public void llamar(View v) {

        String telefono = tvTelefono.getText().toString();

        //Inicio del Permiso, esto es un override del permisio del intent al cual accesamos desde el android manifest y para activarlo le damos control enter en el error del intnet en el uri.
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        //Activacion de llamar al momento de pulsar la imagen o el texto. Aplicamos el Uri.parse.
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefono)));


    }

    //Metodo para generar un correo al momento que pulsemos el icono o el texto del telefono en nuestro detalle de contacto
    public void enviarMail(View v){

        String email = tvEmail.getText().toString(); //Declaracion de variable a usar.
        Intent emailIntent = new Intent(Intent.ACTION_SEND); //Intent que especifica la accion a realizar.
        emailIntent.setData(Uri.parse("mailto:")); //Aplicando el nombre a la Uri.
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email); //Con el intent Extra podemos solicitar la informacion solicitada que deseemos.
        emailIntent.setType("message/rfc822"); //Aqui especificamos el chooser del tipo de aplicacion que queremos selecionar para estar función.
        startActivity(Intent.createChooser(emailIntent, "Email")); //Creacion del chooser en el activity.

    }

    //Esto genera que la actividad anterior se finalize.
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(DetalleContacto.this, PantallaPrincipal.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);

    }
}
