package com.example.e_learniverse_android.implicit_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.e_learniverse_android.R;

public class ImplicitIntentActivity extends AppCompatActivity {

    private Button btnDial, btnMsg, btnEmail, btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        btnDial = (Button)findViewById(R.id.btnDial);
        btnMsg = (Button)findViewById(R.id.btnMsg);
        btnEmail = (Button)findViewById(R.id.btnEmail);
        btnShare = (Button)findViewById(R.id.btnShare);

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iDial = new Intent(Intent.ACTION_DIAL);
                iDial.setData(Uri.parse("tel: " + "+88017762344"));
                startActivity(iDial);
            }
        });

        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iMsg = new Intent(Intent.ACTION_SENDTO);
                iMsg.setData(Uri.parse("smsto: " + Uri.encode("+88017762344")));
                iMsg.putExtra("sms_body", "Sergio Ramos is the Best Defender in the World");
                startActivity(iMsg);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iEmail = new Intent(Intent.ACTION_SEND);
                iEmail.setType("message/rfc822");
                iEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"sergio_ramos@gmail.com", "akash@gmail.com"});
                iEmail.putExtra(Intent.EXTRA_SUBJECT, "Subject to my IDOL");
                iEmail.putExtra(Intent.EXTRA_TEXT, "You are the Best Man!!!");

                startActivity(Intent.createChooser(iEmail, "Email Via"));
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iShare = new Intent(Intent.ACTION_SEND);
                iShare.setType("text/plain");
                iShare.putExtra(Intent.EXTRA_TEXT, "Go to https://realmadrid.com");

                startActivity(Intent.createChooser(iShare, "Share Via"));
            }
        });
    }
}