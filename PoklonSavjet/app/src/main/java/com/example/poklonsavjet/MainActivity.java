package com.example.poklonsavjet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.poklonsavjet.R;

public class MainActivity extends AppCompatActivity {
    private Button btn_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start = findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNextActivity();
            }
        });
    }

    private void startNextActivity()
    {
        Intent intent = new Intent(this, QuestionsActivity.class);
        startActivity(intent);
        finish();
    }
}