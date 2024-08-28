package com.example.disquad.activities.squadbuilder;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.disquad.R;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SquadBuilder2 extends AppCompatActivity {
    // CLASS PROPERTIES
    private int targetSquadCount;
    private int currentSquadCount;

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String mobileNumber;

    private Date dateOfBirth;
    private int height;
    private boolean isAnnualPassholder;
    private boolean hasDAS;
    private boolean isSquadLeader;

    // Text Views
    TextView instructions1;
    TextView instructions2;

    // Buttons
    Button backButton;
    Button continueButton;

    // Text Inputs
    private TextInputLayout dateOfBirthInput;
    private TextInputLayout heightInput;

    // Switch Inputs
    private Switch annualPassholderInput;
    private Switch hasDASInput;
    private Switch isSquadLeaderInput;


    // SYSTEM GENERATED METHODS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_squad_builder2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Retrieve data from previous activity
        retrieveData();

        // Call custom method to initialize UI
        initializeUI();
    }



    // CUSTOM METHODS
    // Custom method to retrieve data from previous activity
    private void retrieveData() {
        Bundle extras = getIntent().getExtras();

        targetSquadCount = extras.getInt("targetSquadCount");
        currentSquadCount = extras.getInt("currentSquadCount");

        firstName = extras.getString("firstName");
        lastName = extras.getString("lastName");
        emailAddress = extras.getString("emailAddress");
        mobileNumber = extras.getString("mobileNumber");
    }

    // Custom method to initialize the UI
    private void initializeUI() {
        // Initialize back button
        backButton = findViewById(R.id.button_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // Initialize continue button
        continueButton = findViewById(R.id.button_continue);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: COLLECT INPUT INTO DATA POINTS

                // TODO: LAUNCH NEXT ACTIVITY AND SEND ALL COLLECTED DATA FORWARD
            }
        });

        // Initialize first set of instructions
        instructions1 = findViewById(R.id.text_instructions);
        String message = "Tell us more about ";
        instructions1.setText(message + firstName + ".");

        // Initialize second set of instructions
        instructions2 = findViewById(R.id.text_instructions_2);
        message = "Do either of these apply to ";
        instructions2.setText(message + firstName + "?");

        // Initialize date of birth input
        dateOfBirthInput = findViewById(R.id.text_input_date_of_birth);
        dateOfBirthInput.getEditText().setFocusable(true);

        // Display first name in input hint
        message = "'s Date of Birth";
        dateOfBirthInput.setHint(firstName + message);

        dateOfBirthInput.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(hasFocus) {
                    // Call custom method to show date picker
                    showDatePicker();
                }
            }
        });

        // Initialise height input
        heightInput = findViewById(R.id.text_input_height);

        // Display first name in input hint
        message = "'s height in inches.";
        heightInput.setHint(firstName + message);

        // Initialize passholder input
        annualPassholderInput = findViewById(R.id.switch_annual_passholder);
        annualPassholderInput.setText(firstName + " is not an annual passholder");
        annualPassholderInput.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked) {
                    annualPassholderInput.setText(firstName + " is an annual passholder");
                }

                else {
                    annualPassholderInput.setText(firstName + " is not an annual passholder");
                }
            }
        });

        // Initialize DAS input
        hasDASInput = findViewById(R.id.switch_has_das);
        hasDASInput.setText(firstName + " doesn't have Disability Assistance Services (DAS)");
        hasDASInput.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked) {
                    hasDASInput.setText(firstName + " has Disability Assistance Services (DAS)");
                }

                else {
                    hasDASInput.setText(firstName + "doesn't have Disability Assistance Services (DAS)");
                }
            }
        });

        // Initialize squad leader input
        isSquadLeaderInput = findViewById(R.id.switch_is_squad_leader);
        isSquadLeaderInput.setText(firstName + " is not the " + lastName + " family squad leader");
        isSquadLeaderInput.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked) {
                    isSquadLeaderInput.setText(firstName + " is the " + lastName + " family squad leader");
                }

                else {
                    isSquadLeaderInput.setText(firstName + " is not the " + lastName + " family squad leader");
                }
            }
        });
    }

    // Custom method to show date picker
    private void showDatePicker() {
        // Get current date
        Date currentDate = Calendar.getInstance().getTime();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(currentDate);

        // Separate current date into month, day, and year
        int currentMonth = calendar.get(Calendar.MONTH);
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        int currentYear = calendar.get(Calendar.YEAR);

        // When a date is selected...
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, R.style.DatePicker, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
                // Set the date of birth to the selected date
                dateOfBirth = new Date(selectedYear-1900, selectedMonth, selectedDay);

                // Format the selected date into human-readable form
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("LLLL dd, yyyy");
                String dateOfBirthString = simpleDateFormat.format(dateOfBirth);

                // Display selected date back to the user
                dateOfBirthInput.getEditText().setText(dateOfBirthString);
            }
        }, currentYear, currentMonth, currentDay);

        // Show date picker to the user
        datePickerDialog.show();
    }
}