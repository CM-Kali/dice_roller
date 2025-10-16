package com.example.java_01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import android.graphics.Color;
import android.content.res.ColorStateList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button rollButton = findViewById(R.id.Roll_btn);
         ImageView midDice = findViewById(R.id.image_MidDice);
        ImageView leftDice = findViewById(R.id.image_leftDice);
        ImageView rightDice = findViewById(R.id.image_RightDice);

        int[] diceArray = {
                R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6
        };

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // ✅ Change button color to red when tapped
                rollButton.setBackgroundTintList(ColorStateList.valueOf(Color.RED));

                // Roll dice
                Random rand = new Random();
                int number1 = rand.nextInt(6);
                int number2 = rand.nextInt(6);
                int number3 = rand.nextInt(6);

                leftDice.setImageResource(diceArray[number1]);
                midDice.setImageResource(diceArray[number3]);
                rightDice.setImageResource(diceArray[number2]);

                // ✅ Return button color back to normal after 300ms
                rollButton.postDelayed(() -> {
                    rollButton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#5462B1")));
                }, 100);
            }
        });
    }
}
