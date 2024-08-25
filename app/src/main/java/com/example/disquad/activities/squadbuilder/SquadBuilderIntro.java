package com.example.disquad.activities.squadbuilder;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.disquad.R;

public class SquadBuilderIntro extends AppCompatActivity {
    // CLASS PROPERTIES
    private String TAG = "SquadBuilderIntro.java";
    private int squadCount;

    // Buttons
    private Button continueButton;
    private Button backButton;
    private Button decreaseButton;
    private Button increaseButton;

    // TextViews
    private TextView squadCountDisplay;



    // SYSTEM GENERATED METHODS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_squad_builder_intro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initializeUI();
    }



    // CUSTOM METHODS
    // Custom method to initialize the UI
    private void initializeUI() {
        // Set squad count to 1
        squadCount = 1;

        // Initialize continue button
        continueButton = findViewById(R.id.button_continue);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: MOVE TO NEXT ACTIVITY. SEND SQUAD COUNT TO NEXT ACTIVITY
            }
        });

        // Initialize back button
        backButton = findViewById(R.id.button_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Go to previous activity
                finish();
            }
        });

        // Initialize squad count display
        squadCountDisplay = findViewById(R.id.text_squad_counter);
        squadCountDisplay.setText(String.valueOf(squadCount));

        // Initialize decrease button
        decreaseButton = findViewById(R.id.button_decrease);
        decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // If squad count is greater than or equal to 1...
                if(squadCount >= 1) {
                    // Decrease
                    squadCount--;

                    // Update squad count display
                    squadCountDisplay.setText(String.valueOf(squadCount));
                }

                // If squad count is exactly 1
                if(squadCount == 1) {
                    // Disable decrease button
                    decreaseButton.setEnabled(false);
                    decreaseButton.setBackgroundColor(getColor(R.color.secondary_text));
                }
            }
        });

        // Initialize increase button
        increaseButton = findViewById(R.id.button_increase);
        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Increase squad count by 1
                squadCount++;

                // Update squad count display
                squadCountDisplay.setText(String.valueOf(squadCount));

                // If squad count is greater than or equal to 1...
                if(squadCount >= 1) {
                    // Enable decrease button
                    decreaseButton.setEnabled(true);
                    decreaseButton.setBackgroundColor(getColor(R.color.accent));
                }
            }
        });
    }
}