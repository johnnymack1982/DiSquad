package com.example.disquad.activities.squadbuilder;

import android.content.Intent;
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

    // Intents
    Intent squadBuilder2Intent;



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

        // Collect data from previous activity
        retrieveData();

        // Call custom method to initialize UI
        initializeUI();
    }



    // CUSTOM METHODS
    // Custom method to initialize the UI
    private void initializeUI() {
        // Initialize intent for next activity
        squadBuilder2Intent = new Intent(this, SquadBuilder2.class);

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
                // Call custom method to collect user input into data points
                collectInputData();

                // Launch next activity and send collected data forward
                startActivity(squadBuilder2Intent);
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
                SquadBuilderUtils.toggleContinueButton(getApplicationContext(), continueButton);
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
                SquadBuilderUtils.toggleContinueButton(getApplicationContext(), continueButton);
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
                SquadBuilderUtils.toggleContinueButton(getApplicationContext(), continueButton);
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
                SquadBuilderUtils.toggleContinueButton(getApplicationContext(), continueButton);
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }

    // Custom method to retrieve data from previous activity
    private void retrieveData() {
        Bundle extras = getIntent().getExtras();

        targetSquadCount = extras.getInt("targetSquadCount");
        currentSquadCount = extras.getInt("currentSquadCount");
    }

    // Custom method to collect data from user input fields
    private void collectInputData() {
        // Collect user input into data points
        firstName = firstNameInput.getEditText().getText().toString().trim();
        lastName = lastNameInput.getEditText().getText().toString().trim();
        emailAddress = emailInput.getEditText().getText().toString().trim();
        mobileNumber = mobilePhoneInput.getEditText().getText().toString().trim();

        // Send all data collected so far to the next activity
        squadBuilder2Intent.putExtra("targetSquadCount", targetSquadCount);
        squadBuilder2Intent.putExtra("currentSquadCount", currentSquadCount);

        squadBuilder2Intent.putExtra("firstName", firstName);
        squadBuilder2Intent.putExtra("lastName", lastName);
        squadBuilder2Intent.putExtra("emailAddress", emailAddress);
        squadBuilder2Intent.putExtra("mobileNumber", mobileNumber);
    }
}