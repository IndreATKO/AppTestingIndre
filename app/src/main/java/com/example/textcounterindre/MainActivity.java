package com.example.textcounterindre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.textcounterindre.utils.TextUtils;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;
    EditText txtMain;
    Spinner spDropDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tvResult = findViewById(R.id.tvResult);
        this.txtMain = findViewById(R.id.txtMain);
        this.spDropDown = findViewById(R.id.spDropDown);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.counting_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spDropDown.setAdapter(adapter);

    }

    public void onBtnCalculateClick(View view) {
        if(txtMain.getText().toString().isEmpty()) {
            Toast.makeText(this, "Text is empty", Toast.LENGTH_LONG).show();
            } else {
                if (this.spDropDown.getSelectedItem().toString().equalsIgnoreCase("Words")) {
//to do
                    int wordsCount = TextUtils.getWordsCount(this.txtMain.getText().toString());
                    String wordsCountFormatted = String.valueOf(wordsCount);
                    this.tvResult.setText("Words: " + wordsCountFormatted);

                    // String wordsCountFormatted = String.valueOf(String.valueOf(wordsCount).split("\\s+").length);
                    //String wordsCount = txtMain.getText().toString();
                    //String[] wordsCountFormatted = wordsCount.split(" ");
                   // tvResult.setText("Words: " + wordsCountFormatted.length);

            } else {
                   int charsCount = TextUtils.getCharsCount(this.txtMain.getText().toString());
                   String charsCountFormatted = String.valueOf(charsCount);
                   this.tvResult.setText("Chars: " + charsCountFormatted);

             }
        }
    }
}

