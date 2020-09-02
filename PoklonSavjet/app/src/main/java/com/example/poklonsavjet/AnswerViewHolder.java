package com.example.poklonsavjet;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AnswerViewHolder extends RecyclerView.ViewHolder {
    private TextView tv_question;
    private TextView tv_answer;

    public AnswerViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_question = itemView.findViewById(R.id.tv_question1);
        tv_answer = itemView.findViewById(R.id.tv_answer1);
    }

    @SuppressLint("SetTextI18n")
    public void bind(String question, String answer){
        tv_question.setText("Pitanje: "+question);
        tv_answer.setText("Odgovor: "+answer);
    }
}
