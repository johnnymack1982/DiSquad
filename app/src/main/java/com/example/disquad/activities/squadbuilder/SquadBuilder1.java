package com.example.disquad.activities.squadbuilder;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.disquad.R;
import com.example.disquad.utilities.SquadBuilderUtils;
import com.google.android.material.textfield.TextInputLayout;

public class SquadBuilder1 extends AppCompatActivity {
    // CLASS PROPERTIES
    private String TAG = "SquadBuilder1.java";
    private int targetSquadCount;
    private int currentSquadCount;

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String mobileNumber;

    private static boolean inputValid;

    // Buttons
    private Button backButton;
    private Button continueButton;

    // Text Inputs
    private TextInputLayout firstNameInput;
    private TextInputLayout lastNameInput;
    private TextInputLayout emailInput;
    private TextInputLayout mobilePhoneInput;



    // SYSTEM GENERATED METHODS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_squad_builder1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Call custom method to initialize UI
        initializeUI();
    }



    // CUSTOM METHODS
    // Custom method to initialize the UI
    private void initializeUI() {
        // Initialize back button
        backButton = findViewById(R.id.button_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Return to the previous activity
                finish();
            }
        });

        // Initialize continue button
        continueButton = findViewById(R.id.button_continue);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: LAUNCH NEXT ACTIVITY. SEND COLLECTED DATA FORWARD
            }
        });

        // Initialize first name input field
        firstNameInput = findViewById(R.id.input_layout_first_name);
        firstNameInput.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // On input change to First Name field, validate input
                inputValid = SquadBuilderUtils.validateSB1(firstNameInput, lastNameInput, emailInput, mobilePhoneInput, firstNameInput);

                // Call custom method to toggle continue button
                toggleContinueButton();
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        // Initialize last name input field
        lastNameInput = findViewById(R.id.input_layout_last_name);
        lastNameInput.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // On input change to Last Name field, validate input
                inputValid = SquadBuilderUtils.validateSB1(firstNameInput, lastNameInput, emailInput, mobilePhoneInput, lastNameInput);

                // Call custom method to toggle continue button
                toggleContinueButton();
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        // Initialize email address input field
        emailInput = findViewById(R.id.input_layout_email);
        emailInput.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // On input change to Email field validate input
                inputValid = SquadBuilderUtils.validateSB1(firstNameInput, lastNameInput, emailInput, mobilePhoneInput, emailInput);

                // Call custom method to toggle continue button
                toggleContinueButton();
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        // Initialize mobile number input field
        mobilePhoneInput = findViewById(R.id.input_layout_mobile);
        mobilePhoneInput.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // On input change to Mobile Number field validate input
                inputValid = SquadBuilderUtils.validateSB1(firstNameInput, lastNameInput, emailInput, mobilePhoneInput, mobilePhoneInput);

                // Call custom method to toggle continue button
                toggleContinueButton();
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }

    // Custom method to toggle continue button on and off
    private void toggleContinueButton() {
        // If input is valid and the button is currently disable...
        if(inputValid && !continueButton.isEnabled()) {
            // Enable the button
            continueButton.setEnabled(true);

            // Change button color to orange
            continueButton.setBackgroundColor(getColor(R.color.accent));
        }

        // If input is invalid and button is currently enabled...
        else {
            // Disable button
            continueButton.setEnabled(false);

            // Change button color to gray
            continueButton.setBackgroundColor(getColor(R.color.secondary_text));
        }
    }
}