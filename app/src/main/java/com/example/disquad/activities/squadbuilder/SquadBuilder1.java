package com.example.disquad.activities.squadbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.disquad.R;
import com.example.disquad.classes.squad.Squad;
import com.example.disquad.utilities.SquadBuilderUtils;
import com.google.android.material.textfield.TextInputLayout;

import java.io.Serializable;

public class SquadBuilder1 extends AppCompatActivity {
    // CLASS PROPERTIES
    private String TAG = "SquadBuilder1.java";
    private int targetSquadCount;
    private int currentSquadCount = 0;

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String mobileNumber;

    private Squad squad;

    private static boolean inputValid;

    // Text views
    TextView instructions;

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

        // Reset input validation
        SquadBuilderUtils.resetValidation();

        // Initialize instructions
        instructions = findViewById(R.id.text_instructions);

        // If the user has already entered their primary information, update the instructions accordingly
        if(currentSquadCount != 0) {
            instructions.setText("Great! Let's keep building your squad. Who's next?");
        }

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
        continueButton = findViewById(R.id.button_finish);
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
                inputValid = SquadBuilderUtils.validateSB1(firstNameInput, lastNameInput, emailInput, mobilePhoneInput, firstNameInput, currentSquadCount);

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
                inputValid = SquadBuilderUtils.validateSB1(firstNameInput, lastNameInput, emailInput, mobilePhoneInput, lastNameInput, currentSquadCount);

                // Call custom method to toggle continue button
                SquadBuilderUtils.toggleContinueButton(getApplicationContext(), continueButton);
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        // Initialize email address input field
        emailInput = findViewById(R.id.input_layout_email);

        // If the primary user has already entered their information, email is optional
        if(currentSquadCount != 0) {
            emailInput.setHint("Email Address (Optional)");
        }

        // Watch for changes to email input field
        emailInput.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // On input change to Email field validate input
                inputValid = SquadBuilderUtils.validateSB1(firstNameInput, lastNameInput, emailInput, mobilePhoneInput, emailInput, currentSquadCount);

                // Call custom method to toggle continue button
                SquadBuilderUtils.toggleContinueButton(getApplicationContext(), continueButton);
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        // Initialize mobile number input field
        mobilePhoneInput = findViewById(R.id.input_layout_mobile);

        // If the primary user has already entered their information, mobile number is optional
        if(currentSquadCount != 0) {
            mobilePhoneInput.setHint("Mobile Number (Optional)");
        }

        // Watch for changes to the mobile number input field
        mobilePhoneInput.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // On input change to Mobile Number field validate input
                inputValid = SquadBuilderUtils.validateSB1(firstNameInput, lastNameInput, emailInput, mobilePhoneInput, mobilePhoneInput, currentSquadCount);

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

        // Get current and target squad counts
        targetSquadCount = extras.getInt("targetSquadCount");
        currentSquadCount = extras.getInt("currentSquadCount");

        // Get current squad, if one exists
        try {
            squad = (Squad) extras.getSerializable("squad");
        }

        catch (Exception exception) {
            Log.d(TAG, "retrieveData: Unable to retrieve squad.");
        }
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

        if(squad != null) {
            squadBuilder2Intent.putExtra("squad", (Serializable) squad);
        }
    }
}