package com.example.disquad.utilities;

import android.content.Context;
import android.widget.Toast;

import com.example.disquad.classes.squad.Squad;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileUtils {
    private static String TAG = "FileUtils.java";

    // CLASS PROPERTIES



    // CONSTRUCTORS



    // GETTERS / SETTERS



    // CUSTOM METHODS
    // Custom method to write squad data to local storage
    public static void writeSquadLocal(Context context, Squad squad) {
        // Reference file name
        File file = new File(context.getFilesDir() + "squad.dis");

        // Initialize output streams
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            Toast.makeText(context, "Congratulations! The " + squad.getSquadLeader().getLastName() + " squad has been created.", Toast.LENGTH_LONG).show();
        }

        catch (FileNotFoundException exception) {
            throw new RuntimeException(TAG + ": " + exception);
        }

        catch (IOException exception) {
            throw new RuntimeException(TAG + ": " + exception);
        }
    }
}
