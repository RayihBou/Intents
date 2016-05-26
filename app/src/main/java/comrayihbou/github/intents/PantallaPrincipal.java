package comrayihbou.github.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/*Importante: Pagina icons8.com. Variedad de iconos para nuestras aplicaciones android.

Uso de:
    ºLinerLayout. Para ubicar textView e imageView en una misma linea. Es importante el uso de la orientacion.
    ºMargenes en textView e imageView.
    ºUri.parse.
    ºMetodo OnkeyDown.
    ºArrayList<>.
    ºMetodo PutExtra.



*/

public class PantallaPrincipal extends AppCompatActivity {

    //Declaracion del ArrayList.
    ArrayList<Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);

        //Constructor para indentificar el Arraylist como la variable contactos, utilizando todas las variables de la Clase Contacto.java .
        contactos = new ArrayList<Contacto>();

        //Creando Contactos
        contactos.add(new Contacto("Rayih Bou", "+584146715290", "rayihbou@gmail.com"));
        contactos.add(new Contacto("Laura Sanchez", "+58416573962", "laurasanchez@gmail.com"));
        contactos.add(new Contacto("Jesus Tremon", "+584142597439", "jesustremon@gmail.com"));
        contactos.add(new Contacto("Pedro Soto", "+584127198415", "pedrosoto@gmail.com"));
        contactos.add(new Contacto("Maria Salgado", "+584247213490", "mariasalgado@gmail.com"));

        //Metodo para obtener solamente el nombre de nuestro detalle contacto, esto es lo que mostraremos en nuesta PantallaPrincipal en el ListView.
        ArrayList<String> nombresContacto = new ArrayList<>();
        for (Contacto contacto: contactos) {
            nombresContacto.add(contacto.getNombre());
        }

        //Casteo del ListView de nuestro activity PantallaPrincipal.
        ListView lstContactos = (ListView) findViewById(R.id.lstContactos);
        //Aplicar Adaptador para el ListView.
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContacto)); //Recordar que el simple_list_item_1 lo utilizamos automaticamente del repositorio de android.

        //Listener para el ListView.
        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Generamos el intent de acuerdo a la accion que queremos ejecutar despues de pulsar la variable del ListView.
                Intent intent = new Intent(PantallaPrincipal.this, DetalleContacto.class);

                //Metodo putExtra para asignarle las variables al parametro que estamos utilizando para asi poder emigrar las variable a la otra activity y seran recibidos con el Bundle.
                intent.putExtra(getResources().getString(R.string.pnombre), contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono), contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail), contactos.get(position).getEmail());

                //Generamos el intent despues de los resultados obtenidos.
                startActivity(intent);
            }
        });
    }
}
