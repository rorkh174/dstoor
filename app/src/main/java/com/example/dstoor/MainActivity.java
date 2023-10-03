package com.example.dstoor;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextA, editTextB, editTextC;
    private Button calculateButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        editTextC = findViewById(R.id.editTextC);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        // Set a click listener for the Calculate button
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }

    // Method to perform quadratic equation calculation
    private void calculate() {
        try {
            // Retrieve coefficients from EditTexts
            double a = Double.parseDouble(editTextA.getText().toString());
            double b = Double.parseDouble(editTextB.getText().toString());
            double c = Double.parseDouble(editTextC.getText().toString());

            // Calculate discriminant
            double discriminant = b * b - 4 * a * c;

            // Calculate roots based on discriminant
            if (discriminant > 0) {
                double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                resultTextView.setText("Root 1: " + root1 + "\nRoot 2: " + root2);
            } else if (discriminant == 0) {
                double root = -b / (2 * a);
                resultTextView.setText("Root: " + root);
            } else {
                resultTextView.setText("Complex roots");
            }
        } catch (NumberFormatException e) {
            resultTextView.setText("Enter valid coefficients");
        }
    }
}