package com.example.shreevatsa.emailsender2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import javax.security.auth.Subject;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.

    EditText subject;
    EditText text;
    EditText email;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subject = findViewById(R.id.subject);
        text = findViewById(R.id.text);
        email = findViewById(R.id.email);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                String[] emails = email.getText().toString().split(",");
                intent.putExtra(Intent.EXTRA_EMAIL,emails);
                intent.putExtra(Intent.EXTRA_SUBJECT,subject.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT,text.getText().toString());

                intent.setType("message/rfc822");

                startActivity(Intent.createChooser(intent,"Choose your email sender"));
            }
        });



        // Example of a call to a native method

    }


}
