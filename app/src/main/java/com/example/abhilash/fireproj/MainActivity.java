package com.example.abhilash.fireproj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    EditText editTextname;
    Button buttonadd;
    Spinner spinnergenres;
ListView listViewArtists ;

List<Artist> artistList;
    DatabaseReference databaseartist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseartist = FirebaseDatabase.getInstance().getReference("artists");

        editTextname = (EditText) findViewById(R.id.editTextname);
        buttonadd = (Button)findViewById(R.id.addartist);
        spinnergenres = (Spinner) findViewById(R.id.spinnergenre);
listViewArtists = (ListView) findViewById(R.id.listViewArtists);
artistList = new ArrayList<>();
        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addartist();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseartist.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                artistList.clear();
                for (DataSnapshot artistsnapshot : dataSnapshot.getChildren())
                {
                    Artist artist = artistsnapshot.getValue(Artist.class);
                    artistList.add(artist);

                }
               Artistlist adapter = new Artistlist(MainActivity.this,artistList);
                listViewArtists.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void addartist()
    {
        String name = editTextname.getText().toString().trim();
        String genre = spinnergenres.getSelectedItem().toString();

        if (!TextUtils.isEmpty(name))
        {
             String id = databaseartist.push().getKey();
             Artist artist = new Artist(id,name,genre);
             databaseartist.child(id).setValue(artist);
         Toast.makeText(this,"artist added " , Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this,"enter something",Toast.LENGTH_LONG).show();
        }
    }
}
