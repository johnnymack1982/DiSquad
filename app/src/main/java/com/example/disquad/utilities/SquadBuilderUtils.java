package com.example.disquad.utilities;

import android.content.Context;
import android.util.Patterns;
import android.widget.Button;

import com.example.disquad.R;
import com.google.android.material.textfield.TextInputLayout;

public class SquadBuilderUtils {
    // CLASS PROPERTIES
    private static boolean inputValid = false;
    private static boolean firstNameValid = false;
    private static boolean lastNameValid = false;
    private static boolean emailValid = false;
    private static boolean mobileNumberValid = false;

    private static boolean dateOfBirthValid = false;
    private static boolean heightValid = false;



    // CONSTRUCTORS



    // GETTERS / SETTERS



    // CUSTOM METHODS
    // Custom method to validate input on SquadBuilder1 activity
    public static boolean validateSB1(TextInputLayout firstNameInput, TextInputLayout lastNameInput, TextInputLayout emailInput,
                                      TextInputLayout mobilePhoneInput, TextInputLayout callingInput) {

        // Get text inputs from all input fields
        String firstNameText = firstNameInput.getEditText().getText().toString().trim();
        String lastNameText = lastNameInput.getEditText().getText().toString().trim();
        String emailText = emailInput.getEditText().getText().toString().trim();
        String mobilePhoneText = mobilePhoneInput.getEditText().getText().toString().trim();

        // If first name field is empty..
        if(firstNameText.isEmpty() && firstNameInput == callingInput) {
            // Provide user with error message and indicate that input is invalid
            firstNameInput.setError("Please enter your first name");
            firstNameValid = false;
        }

        // If first name field is valid...
        else if(firstNameInput == callingInput) {
            // Remove errors from field and indicate that input is valid
            firstNameInput.setErrorEnabled(false);
            firstNameValid = true;
        }

        // If last name field is empty...
        if(lastNameText.isEmpty() && lastNameInput == callingInput) {
            // Provide user with error message and indicate that input is invalid
            lastNameInput.setError("Please enter your last name");
            lastNameValid = false;
        }

        // If last name field is valid...
        else if(lastNameInput == callingInput) {
            // Remove errors from field and indicate that input is valid
            lastNameInput.setErrorEnabled(false);
            lastNameValid = true;
        }

        // If email field does not contain a valid email address...
        if((!Patterns.EMAIL_ADDRESS.matcher(emailText).matches() || emailText.isEmpty()) && emailInput == callingInput) {
            // Provide user with error message and indicate that input is invalid
            emailInput.setError("Enter a valid email (i.e. example@gmail.com");
            emailValid = false;
        }

        // If email input is valid...
        else if(emailInput == callingInput) {
            // Remove errors from field and indicate that input is valid
            emailInput.setErrorEnabled(false);
            emailValid = true;
        }

        // If mobile number field does not contain a valid phone number...
        if((!Patterns.PHONE.matcher(mobilePhoneText).matches() || mobilePhoneText.length() != 10) && mobilePhoneInput == callingInput) {
            // Provide user with error message and indicate that input is invalid
            mobilePhoneInput.setError("Enter a mobile number i.e (555)678-1234");
            mobileNumberValid = false;
        }

        // If input is valid...
        else if(mobilePhoneInput == callingInput) {
            // Remove errors from field and indicate that input is valid
            mobilePhoneInput.setErrorEnabled(false);
            mobileNumberValid = true;
        }

        // If all fields are valid...
        if(firstNameValid && lastNameValid && emailValid && mobileNumberValid) {
            // Indicate that input is valid
            inputValid = true;
        }

        // Otherwise...
        else {
            // Indicate that input is invalid
            inputValid = false;
        }

        return inputValid;
    }

    // Custom method to validate input from the SquadBuilder2 activity
    public static boolean validateSB2(TextInputLayout dateOfBirthInput, TextInputLayout heightInput, TextInputLayout callingInput, String firstName) {
        // Get input from all text input fields
        String dateOfBirthText = dateOfBirthInput.getEditText().getText().toString().trim();
        String heightText = heightInput.getEditText().getText().toString().trim();

        if(dateOfBirthText.isEmpty() && dateOfBirthInput == callingInput) {
            dateOfBirthInput.setError("Please enter a valid date");
        }

        else if(dateOfBirthInput == callingInput) {
            dateOfBirthValid = true;
            dateOfBirthInput.setErrorEnabled(false);
        }

        if(heightText.isEmpty() && heightInput == callingInput) {
            if(firstName.substring(firstName.length() - 1).toLowerCase().equals("s")) {
                heightInput.setError("Please enter " + firstName + "' height in inches");
            }

            else {
                heightInput.setError("Please enter " + firstName + "'s height in inches");
            }
        }

        else if(heightInput == callingInput) {
            heightValid = true;
            heightInput.setErrorEnabled(false);
        }

        if(dateOfBirthValid && heightValid) {
            inputValid = true;
        }

        else {
            inputValid = false;
        }

        return inputValid;
    }

    // Custom method to toggle continue button on and off
    public static void toggleContinueButton(Context context, Button continueButton) {
        // If input is valid and the button is currently disable...
        if(inputValid) {
            // Enable the button
            continueButton.setEnabled(true);

            // Change button color to orange
            continueButton.setBackgroundColor(context.getColor(R.color.accent));
        }

        // If input is invalid and button is currently enabled...
        else {
            // Disable button
            continueButton.setEnabled(false);

            // Change button color to gray
            continueButton.setBackgroundColor(context.getColor(R.color.secondary_text));
        }
    }
}
