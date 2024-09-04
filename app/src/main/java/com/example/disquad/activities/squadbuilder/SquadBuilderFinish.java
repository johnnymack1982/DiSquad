package com.example.disquad.activities.squadbuilder;

import android.content.Intent;
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
import com.example.disquad.classes.squad.Squad;
import com.example.disquad.classes.squad.SquadMember;
import com.example.disquad.utilities.FileUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class SquadBuilderFinish extends AppCompatActivity {
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

    Squad squad;

    // Text Views
    TextView instructions;

    // Buttons
    Button backButton;
    Button finishButton;
    Button addButton;

    // Intents
    Intent squadBuilder1Intent;



    // SYSTEM GENERATED METHODS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_squad_builder_finish);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Call custom method to retrieve data from previous activity
        retrieveData();

        // Call custom method to create new squad member
        createSquadMember();

        // Call custom method to initialize UI
        initializeUI();
    }



    // CUSTOM METHODS
    // Custom method to retrieve user input from previous activity
    private void retrieveData() {
        Bundle extras = getIntent().getExtras();

        // Get all user input collected so far
        targetSquadCount = extras.getInt("targetSquadCount");
        currentSquadCount = extras.getInt("currentSquadCount");

        firstName = extras.getString("firstName");
        lastName = extras.getString("lastName");
        emailAddress = extras.getString("emailAddress");
        mobileNumber = extras.getString("mobileNumber");

        dateOfBirth = (Date)extras.getSerializable("dateOfBirth");
        height = extras.getInt("height");
        isAnnualPassholder = extras.getBoolean("isAnnualPassholder");
        hasDAS = extras.getBoolean("hasDAS");
        isSquadLeader = extras.getBoolean("isSquadLeader");
    }

    // Custom method to create new squad member
    private void createSquadMember() {
        // Create new squad member from user input
        SquadMember newSquadMember = new SquadMember(firstName, lastName, emailAddress, mobileNumber, dateOfBirth, height, isSquadLeader, isAnnualPassholder, hasDAS);

        // If the squad hasn't been created yet, create one
        if(squad == null) {
            squad = new Squad(null, new ArrayList<SquadMember>());
        }

        // Add the current squad member to the squad
        squad.addSquadMember(newSquadMember);

        // If the current squad member is supposed to be the squad leader, set them as squad leader within the squad object
        for(SquadMember squadMember : squad.getSquadMembers()) {
            if(squadMember.isSquadLeader()) {
                squad.setSquadLeader(squadMember);
            }
        }

        // Increase current squad count by one
        currentSquadCount++;

        // If target squad count has been reached, prevent user from adding any additional squad members
        if(targetSquadCount == currentSquadCount) {
            if(addButton == null) {
                addButton = findViewById(R.id.button_add);
            }
            addButton.setEnabled(false);
            addButton.setBackgroundColor(getColor(R.color.secondary_text));
        }
    }

    // Custom method to initialize UI
    private void initializeUI() {
        // Initialize intents
        squadBuilder1Intent = new Intent(this, SquadBuilder1.class);

        // Initialize back button
        backButton = findViewById(R.id.button_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // Initialize finish button
        finishButton = findViewById(R.id.button_finish);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: LAUNCH MISSION BUILDER AND PASS SQUAD FORWARD
                FileUtils.writeSquadLocal(getApplicationContext(), squad);
            }
        });

        // Initialize add button
        if(addButton == null) {
            addButton = findViewById(R.id.button_add);
        }

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Return to SquadBuilder1 and pass squad forward
                squadBuilder1Intent.putExtra("targetSquadCount", targetSquadCount);
                squadBuilder1Intent.putExtra("currentSquadCount", currentSquadCount);
                squadBuilder1Intent.putExtra("squad", (Serializable) squad);
                startActivity(squadBuilder1Intent);
            }
        });

        // Initialize instructions text view
        instructions = findViewById(R.id.text_instructions);

        // Populate text
        String message = "Great! We've added " + firstName + " to the " + lastName + " squad";
        if(isSquadLeader) {
            message = message + " as the Squad Leader.";
        }

        else {
            message = message + ".";
        }

        if(targetSquadCount == currentSquadCount) {
            message = message + " It looks like your squad is complete! Just to recap, here's what we have:\n";

            for(SquadMember squadMember : squad.getSquadMembers()) {
                message = message + "\n" + squadMember.getFirstName() + " " + squadMember.getLastName();
            }
        }

        else {
            message = message + "You have " + currentSquadCount;

            if (currentSquadCount == 1) {
                message = message + " person";
            } else {
                message = message + " people";
            }
            message = message + " in your squad. \n\n Do you want to add another squad member now? " +
                    "You can always come back and do this later if you need to.";
        }

        instructions.setText(message);
    }
}