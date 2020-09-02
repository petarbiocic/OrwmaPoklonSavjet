package com.example.poklonsavjet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AnswersRecyclerviewAdapter extends RecyclerView.Adapter<AnswerViewHolder>{
    List<QuestionWithAnswers> questionsAndAnswers = new ArrayList<>();

    @NonNull
    @Override
    public AnswerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.answer_element,parent,false);
        return new AnswerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AnswerViewHolder holder, int position) {
        String q = questionsAndAnswers.get(position).getQuestion();
        String a = questionsAndAnswers.get(position).getAnswers().get(0);
        holder.bind(q,a);
    }

    @Override
    public int getItemCount() {
        return questionsAndAnswers.size();
    }

    public void addData(List<QuestionWithAnswers> data){
        this.questionsAndAnswers.clear();
        this.questionsAndAnswers.addAll(data);
        notifyDataSetChanged();
    }
}
