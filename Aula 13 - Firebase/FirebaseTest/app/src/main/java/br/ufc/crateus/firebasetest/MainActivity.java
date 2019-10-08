package br.ufc.crateus.firebasetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://aulamobile-11563.firebaseio.com");
        DatabaseReference myRef = database.getReference("users");

        // Post
        myRef.push().setValue(new User("Daniel", "danielbrito", 26));

        // Get one
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Iterable<DataSnapshot> children = dataSnapshot.getChildren();

                for(DataSnapshot data : children){

                    Log.i("Main", data.getKey() + " " + data.getValue(User.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        // Get one (Dynamic - Real time)
        myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Iterable<DataSnapshot> children = dataSnapshot.getChildren();

                for(DataSnapshot data : children){

                    Log.i("Main", data.getKey() + " " + data.getValue(User.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        // Remove
        myRef.child("-LqcAyEWPh7BuB2Uzlqd").removeValue();

        // Update
        myRef.child("-LqbVPjsw0nUA_WQizDN").setValue(new User("Albert", "einstein", 66));

        // Get by id
        myRef.child("-LqbVPjsw0nUA_WQizDN").addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Log.i("Main", dataSnapshot.getKey() + " " + dataSnapshot.getValue(User.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
