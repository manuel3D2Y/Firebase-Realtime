package mx.com.proyecto.ejemplofirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private EditText editDeporte;
    private EditText editNombre;

    DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    DatabaseReference childDeporte = referencia.child("deporte");
    DatabaseReference childNombre= referencia.child("nombre");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editDeporte = (EditText) findViewById(R.id.txtDeporte);
        editNombre = (EditText) findViewById(R.id.txtEquipo);
    }

    @Override
    protected void onStart() {
        super.onStart();

        childDeporte.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String deporte = dataSnapshot.getValue().toString();
                editDeporte.setText(deporte);

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        childNombre.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String nombre = dataSnapshot.getValue().toString();
                editNombre.setText(nombre);

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
