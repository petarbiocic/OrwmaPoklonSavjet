package com.example.poklonsavjet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.poklonsavjet.Answer;
import com.example.poklonsavjet.Present;
import com.example.poklonsavjet.QuestionWithAnswers;
import com.example.poklonsavjet.R;

import java.util.ArrayList;
import java.util.List;

public class QuestionsActivity extends AppCompatActivity {

    private TextView tv_question;
    private RadioGroup rg;
    private RadioButton rb_first_answer;
    private RadioButton rb_second_answer;
    private RadioButton rb_third_answer;
    private RadioButton rb_fourth_answer;
    private Button btn_next;
    private List<RadioButton> radioButtons = new ArrayList<>();

    private List<QuestionWithAnswers> questions = new ArrayList<>();
    private Integer questionNumber = 0;

    private List<String> answers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        setUI();
        createQuestions();
        showQuestionOnView(questions.get(0));
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSomethingChecked()) {
                    answers.add(getAnswer());
                    questionNumber++;
                    if (questionNumber + 1 == questions.size()) {
                        btn_next.setText("Prikaži poklon");
                    }
                    if (questionNumber < questions.size()) {
                        showQuestionOnView(questions.get(questionNumber));
                    } else {
                        startNextActivity(pickPresent());
                    }
                } else {
                    showToast("Please select an answer.");
                }
            }
        });
    }

    private void setUI() {
        tv_question = findViewById(R.id.tv_question);
        rg = findViewById(R.id.radioGroup);
        rb_first_answer = findViewById(R.id.rb_first_answer);
        rb_second_answer = findViewById(R.id.rb_second_answer);
        rb_third_answer = findViewById(R.id.rb_third_answer);
        rb_fourth_answer = findViewById(R.id.rb_fourth_answer);
        btn_next = findViewById(R.id.btn_next_question);

        radioButtons.add(rb_first_answer);
        radioButtons.add(rb_second_answer);
        radioButtons.add(rb_third_answer);
        radioButtons.add(rb_fourth_answer);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private Boolean isSomethingChecked() {
        return rb_first_answer.isChecked() || rb_second_answer.isChecked() || rb_third_answer.isChecked() || rb_fourth_answer.isChecked();
    }

    private void showQuestionOnView(QuestionWithAnswers q) {
        tv_question.setText(q.getQuestion());
        int numberOfAnswers = q.getAnswers().size();
        rg.clearCheck();
        for (int i = 0; i < radioButtons.size(); i++) {
            radioButtons.get(i).setVisibility(View.GONE);
        }
        for (int i = 0; i < numberOfAnswers; i++) {
            radioButtons.get(i).setVisibility(View.VISIBLE);
            radioButtons.get(i).setText(q.getAnswers().get(i));
        }
    }

    private void createQuestions() {
        List<String> answers = new ArrayList<>();
        answers.add("muško");
        answers.add("žensko");
        QuestionWithAnswers q = new QuestionWithAnswers("Spol osobe?", answers);
        this.questions.add(q);

        List<String> answers1 = new ArrayList<>();
        answers1.add("da");
        answers1.add("ne");
        QuestionWithAnswers q1 = new QuestionWithAnswers("Punoljetna osoba?", answers1);
        this.questions.add(q1);

        List<String> answers2 = new ArrayList<>();
        answers2.add("manje od godinu dana");
        answers2.add("dulje od godinu dana");
        QuestionWithAnswers q2 = new QuestionWithAnswers("Koliko dugo poznajete osobu?", answers2);
        this.questions.add(q2);

        List<String> answers3 = new ArrayList<>();
        answers3.add("da");
        answers3.add("ne");
        QuestionWithAnswers q3 = new QuestionWithAnswers("Ljubavni odnos s osobom?", answers3);
        this.questions.add(q3);

        List<String> answers4 = new ArrayList<>();
        answers4.add("svečana prilika");
        answers4.add("ne svečana prilika");
        QuestionWithAnswers q4 = new QuestionWithAnswers("Prilika zbog koje kupujete poklon?", answers4);
        this.questions.add(q4);

        List<String> answers5 = new ArrayList<>();
        answers5.add("da");
        answers5.add("ne");
        QuestionWithAnswers q5 = new QuestionWithAnswers("Je li osoba sportski tip?", answers5);
        this.questions.add(q5);

        List<String> answers6 = new ArrayList<>();
        answers6.add("da");
        answers6.add("ne");
        QuestionWithAnswers q6 = new QuestionWithAnswers("Je li osoba umjetnik?", answers6);
        this.questions.add(q6);

        List<String> answers7 = new ArrayList<>();
        answers7.add("da");
        answers7.add("ne");
        QuestionWithAnswers q7 = new QuestionWithAnswers("Skupocijeni poklon?", answers7);
        this.questions.add(q7);

        List<String> answers8 = new ArrayList<>();
        answers8.add("mali poklon");
        answers8.add("veliki poklon");
        QuestionWithAnswers q8 = new QuestionWithAnswers("Veličina poklona?", answers8);
        this.questions.add(q8);

        List<String> answers9 = new ArrayList<>();
        answers9.add("da");
        answers9.add("ne");
        QuestionWithAnswers q9 = new QuestionWithAnswers("Iako ste prošli kroz sva pitanja, želite li odlučiti ipak Gift Card?", answers9);
        this.questions.add(q9);
    }

    private String getAnswer() {
        if (rb_first_answer.isChecked()) {
            return rb_first_answer.getText().toString();
        }
        if (rb_second_answer.isChecked()) {
            return rb_second_answer.getText().toString();
        }
        if (rb_third_answer.isChecked()) {
            return rb_third_answer.getText().toString();
        }
        return rb_fourth_answer.getText().toString();
    }

    private Present pickPresent() {
        Answer a = new Answer();
        a.setSex(answers.get(0));
        a.setMature(answers.get(1));
        a.setKnowingAboveAYear(answers.get(2));
        a.setLoveRelationship(answers.get(3));
        a.setCeremonyOccasion(answers.get(4));
        a.setSportType(answers.get(5));
        a.setArtistType(answers.get(6));
        a.setExpensive(answers.get(7));
        a.setSize(answers.get(8));
        a.setGiftCard(answers.get(9));

        if (a.getGiftCard().equals("da")) {
            return new Present("Gift Card", R.drawable.giftcard);
        }

        if (a.getArtistType().equals("da")) {
            return new Present("Prekrasna slika", R.drawable.slika);
        }

        if (a.getLoveRelationship().equals("da") && a.getCeremonyOccasion().equals("ne")) {
            if (a.getSex().equals("žensko")) {
                return new Present("Buket cvijeća", R.drawable.cvijece);
            } else {
                return new Present("Gajba piva", R.drawable.gajbapiva);
            }
        }

        if (a.getSize().equals("veliki poklon")) {
            if (a.getSex().equals("muško")) {
                if (a.getExpensive().equals("da")) {
                    return new Present("Auto", R.drawable.muskiauto);
                }
                if (a.getSportType().equals("da")) {
                    if (a.getMature().equals("da")) {
                        return new Present("Sprava za vježbanje", R.drawable.gladiatorsprava);
                    } else {
                        return new Present("Koš", R.drawable.kosnamontiranje);
                    }
                }
                return new Present("TV", R.drawable.tv);
            } else {
                if (a.getExpensive().equals("da")) {
                    return new Present("Auto", R.drawable.zenskiauto);
                }
                if (a.getSportType().equals("da")) {
                    return new Present("Traka za trcanje", R.drawable.trakazatrcanje);
                }
                return new Present("Namještaj", R.drawable.namjestaj);
            }
        } else {
            if (a.getSex().equals("muško")) {
                if (a.getExpensive().equals("da") || a.getCeremonyOccasion().equals("svečana prilika")) {
                    return new Present("Muški sat", R.drawable.muskisat);
                }
                if (a.getSportType().equals("da")) {
                    if (a.getMature().equals("da")) {
                        return new Present("Bicikl", R.drawable.bicikl);
                    } else {
                        return new Present("Lopta", R.drawable.lopta);
                    }
                }
                return new Present("Muški parfem", R.drawable.muskiparfem);
            } else {
                if (a.getExpensive().equals("da") || a.getCeremonyOccasion().equals("svečana prilika")) {
                    return new Present("Ženski sat", R.drawable.zenskisat);
                }
                if (a.getSportType().equals("da")) {
                    return new Present("Patike za trčanje ženske", R.drawable.zenskepatike);
                }


                return new Present("Ženski parfem", R.drawable.zenskiparfem);
            }
        }
    }

    private void startNextActivity(Present p) {
        String presentName = p.getName();
        Integer presentImageID = p.getImageID();
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("presentName", presentName);
        intent.putExtra("presentImageID", presentImageID);

        ArrayList<String> questions = new ArrayList<>();
        for (int i = 0; i < this.questions.size(); i++) {
            questions.add(this.questions.get(i).getQuestion());
        }

        intent.putStringArrayListExtra("questions", questions);
        intent.putStringArrayListExtra("answers", (ArrayList<String>) answers);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
