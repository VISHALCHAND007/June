package com.example.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.courtcounter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    int score1 = 0;
    int score2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.point3A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score1 += 3;
                displayA(score1);
            }
        });
        binding.point2A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score1 += 2;
                displayA(score1);
            }
        });
        binding.point1A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score1 += 1;
                displayA(score1);
            }
        });
        binding.point3B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score2 += 3;
                displayB(score2);
            }
        });
        binding.point2B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score2 += 2;
                displayB(score2);
            }
        });
        binding.point1B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score2 += 1;
                displayB(score2);
            }
        });
        binding.reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score1 = 0;
                score2 = 0;
                displayB(score2);
                displayA(score1);
            }
        });
    }

    public void displayA(int score) {
        binding.scoreA.setText(""+score1);
    }
    public void displayB(int score) {
        binding.scoreB.setText(""+score2);
    }
}