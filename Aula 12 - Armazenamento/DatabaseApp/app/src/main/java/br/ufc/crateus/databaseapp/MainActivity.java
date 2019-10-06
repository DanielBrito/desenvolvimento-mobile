package br.ufc.crateus.databaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import br.ufc.crateus.databaseapp.dao.UserDAO;
import br.ufc.crateus.databaseapp.database.DatabaseClient;
import br.ufc.crateus.databaseapp.model.User;

public class MainActivity extends AppCompatActivity {

    UserDAO users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        users = DatabaseClient.getInstance(getApplicationContext()).userDao();

        users.insert(new User("Daniel", "Brito"));

        //Insert
        users.insert(new User("Anderson", "Almada"));

        //Select all
        List<User> userList = users.getAll();
        Log.i("Select All", userList.toString());

        //Select by Name
        User user1 = users.findByName("Anderson", "Almada");
        Log.i("Select Name", user1.toString());

        //Select by ID
        User user2 = users.getById(2);
        Log.i("Select ID", user2.toString());

        //Select by Ids
        userList = users.loadAllByIds(new int[]{1,2});
        Log.i("Select Ids", userList.toString());

        //Delete
        //users.delete(user1);

        //Update
        user2.firstName = "Roberto";
        user2.lastName = "Carlos";
        users.update(user2);
    }
}
