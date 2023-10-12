package com.example.wordcountapp;

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
    private Button buttonCount;
    private Spinner spinnerCountType;
    private TextView textViewResult;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        spinnerCountType = findViewById(R.id.spinnerCountType);
        buttonCount = findViewById(R.id.buttonCount);
        textViewResult = findViewById(R.id.textViewResult);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.count_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountType.setAdapter(adapter);

        buttonCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                String countType = spinnerCountType.getSelectedItem().toString();

                if (text.isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.empty_text_warning, Toast.LENGTH_SHORT).show();
                } else {
                    int count = 0;
                    if (countType.equals(getString(R.string.words))) {
                        count = counter.countWords(text);
                    } else if (countType.equals(getString(R.string.characters))) {
                        count = counter.countCharacters(text);
                    }

                    textViewResult.setText(getString(R.string.result, count));
                }
            }
        });
    }
}

