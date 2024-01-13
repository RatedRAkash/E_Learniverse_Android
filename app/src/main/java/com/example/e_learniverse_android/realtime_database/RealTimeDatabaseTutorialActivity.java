package com.example.e_learniverse_android.realtime_database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_learniverse_android.R;
import com.example.e_learniverse_android.realtime_database.dto.FootballPlayerModel;

import androidx.annotation.NonNull;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RealTimeDatabaseTutorialActivity extends AppCompatActivity {

    private EditText jerseyNoEditText, nameEditText;
    private Button sendToRealTimeDatabase, btnGetDataFromRealTimeDatabase;
    private DatabaseReference databaseReference;
    private String newPlayerID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_time_database_tutorial);

        // Initialize Firebase Analytics
        FirebaseApp.initializeApp(this);

        sendToRealTimeDatabase = (Button) findViewById(R.id.btnSendToRealTimeDatabase);
        btnGetDataFromRealTimeDatabase = (Button) findViewById(R.id.btnGetDataFromRealTimeDatabase);
        jerseyNoEditText = (EditText) findViewById(R.id.jerseyNoId);
        nameEditText = (EditText) findViewById(R.id.playerNameId);


        //TODO: the Credentials are given in "google-services.json" file
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("FootballPlayer");

        //Firebase RealTime Database ee giye Rules Update kora lagbe
//        {
//            "rules": {
//            ".read": true,
//            ".write": true
//        }

        sendToRealTimeDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String jerseyNo = jerseyNoEditText.getText().toString().toString();
                String playerName = nameEditText.getText().toString().toString();

                newPlayerID = databaseReference.push().getKey();
                FootballPlayerModel playerModel = new FootballPlayerModel(jerseyNo, playerName);

                databaseReference.child(newPlayerID).setValue(playerModel)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                // Data successfully written to the database
                                Log.d("RMA", "Data written successfully");
                            } else {
                                // Handle the error
                                Log.e("RMA", "Error writing data to the database", task.getException());
                            }
                        });

                if (jerseyNo.equals("") || playerName.equals("")) {
                    Toast.makeText(RealTimeDatabaseTutorialActivity.this, "Please add Player data.", Toast.LENGTH_SHORT).show();
                } else {
                    addDatatoFirebase(playerModel);
                }
            }
        });

        sendToRealTimeDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                databaseReference.child(newPlayerID).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        FootballPlayerModel playerModel = dataSnapshot.getValue(FootballPlayerModel.class);
                        Log.d("RMA ---> Player: ", playerModel.toString());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Log.e("RMA", "Error Fetching Data from Database");
                    }
                });

            }
        });
    }

    private void addDatatoFirebase(FootballPlayerModel playerModel) {

        // we are use add value event listener method
        // which is called with database reference.
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // inside the method of on Data change we are setting
                // our object class to our database reference.
                // data base reference will sends data to firebase.
                databaseReference.setValue(playerModel);

                Toast.makeText(RealTimeDatabaseTutorialActivity.this, "Data added", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // if the data is not added or it is cancelled then
                // we are displaying a failure toast message.
                Toast.makeText(RealTimeDatabaseTutorialActivity.this, "Fail to add data " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }
}