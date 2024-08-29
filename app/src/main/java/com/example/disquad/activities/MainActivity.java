package com.example.disquad.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.disquad.R;
import com.example.disquad.activities.squadbuilder.SquadBuilderIntro;

public class MainActivity extends AppCompatActivity {
    // CLASS PROPERTIES
    private String TAG = "MainActivity.java";

    // Buttons
    private Button getStartedButton;


    // SYSTEM GENERATED METHODS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initializeUI();
    }



    // CUSTOM METHODS
    private void initializeUI() {
        // Reference the Squad Builder Introduction Activity
        Intent squadBuilderIntroActivityIntent = new Intent(this, SquadBuilderIntro.class);

        // Initialize 'Get Started' button
        getStartedButton = findViewById(R.id.button_finish);
        getStartedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launch Squad Bulder when 'Let's get started!' is clicked
                startActivity(squadBuilderIntroActivityIntent);
            }
        });
    }
}