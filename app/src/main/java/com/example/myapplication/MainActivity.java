package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Spinner countTypeSpinner;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        countTypeSpinner = findViewById(R.id.countTypeSpinner);
        Button countButton = findViewById(R.id.countButton);
        resultTextView = findViewById(R.id.resultTextView);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.count_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countTypeSpinner.setAdapter(adapter);

        countButton.setOnClickListener(view -> {
            String text = editText.getText().toString();
            String selectedCountType = countTypeSpinner.getSelectedItem().toString();

            if (text.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please enter text", Toast.LENGTH_SHORT).show();
                return;
            }

            int count = 0;

            if (selectedCountType.equals(getString(R.string.words))) {
                count = WordCounter.countWords(text);
            } else if (selectedCountType.equals(getString(R.string.characters))) {
                count = WordCounter.countCharacters(text);
            } else if (selectedCountType.equals(getString(R.string.punctuation))) {
                count = WordCounter.countPunctuation(text);
            }

            resultTextView.setText(String.format("%s: %d", selectedCountType, count));
        });
    }
}
