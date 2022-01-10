package com.nomad.android32;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText email, title, message;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.text_input_edit_text);
        title = findViewById(R.id.text_input_edit_title);
        message = findViewById(R.id.text_input_edit_text_000);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW , Uri.parse("mailto:" + email.getText()));
            intent.putExtra(Intent.EXTRA_SUBJECT, title.getText().toString());
            intent.putExtra(Intent.EXTRA_EMAIL, email.getText().toString());
            intent.putExtra(Intent.EXTRA_TEXT, message.getText());
            startActivity(Intent.createChooser(intent, ""));
        });

    }
}