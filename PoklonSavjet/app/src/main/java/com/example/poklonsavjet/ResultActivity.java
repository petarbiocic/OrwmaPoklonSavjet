package com.example.poklonsavjet;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity {
    private TextView tv_presentName;
    private ImageView iv_presentImage;
    private RecyclerView rc;
    private AnswersRecyclerviewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv_presentName = findViewById(R.id.tv_present_name);
        tv_presentName.setText(getIntent().getStringExtra("presentName"));
        iv_presentImage = findViewById(R.id.iv_present_image);
        iv_presentImage.setImageResource(getIntent().getIntExtra("presentImageID", R.drawable.ic_launcher_background));
        setupRecycler();


        ArrayList<String> questions = getIntent().getStringArrayListExtra("questions");
        ArrayList<String> answers = getIntent().getStringArrayListExtra("answers");
        List<QuestionWithAnswers> QAs = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++) {
            List<String> a = new ArrayList<String>();
            a.add(answers.get(i));
            QuestionWithAnswers qa = new QuestionWithAnswers(questions.get(i),a);
            QAs.add(qa);
        }
        adapter.addData(QAs);

        findViewById(R.id.btn_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResultActivity.this.finish();
                System.exit(0);
            }
        });
    }

    private void setupRecycler() {
        rc = findViewById(R.id.recyclerview);
        rc.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AnswersRecyclerviewAdapter();
        rc.setAdapter(adapter);
    }
}
