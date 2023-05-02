package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textView2;
    private EditText editText1;
    private int secretNumber;
    private boolean gameEnded;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView2 = findViewById(R.id.text2);
        editText1 = findViewById(R.id.EditText1);
        Button guessButton = findViewById(R.id.GUESS);

        Random random = new Random();
        secretNumber = random.nextInt(100) + 1;

        gameEnded = false;

        guessButton.setOnClickListener(v -> {
            if (!gameEnded) {
                try {
                    int guess = Integer.parseInt(editText1.getText().toString());
                    if (guess == secretNumber) {
                        textView2.setText("Вы угадали!");
                        gameEnded = true;
                    } else if (guess < secretNumber) {
                        textView2.setText("Загаданное число больше " + guess);
                    } else {
                        textView2.setText("Загаданное число меньше " + guess);
                    }
                } catch (NumberFormatException e) {
                    textView2.setText("Введите целое число от 1 до 100!");
                }
            } else {
                // игра закончена, обнуляем и начинаем заново
                gameEnded = false;
                secretNumber = random.nextInt(100) + 1;
                textView2.setText("Введите число, потом нажмите GUESS");
            }
        });
    }
}