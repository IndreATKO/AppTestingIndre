package com.example.textcounterindre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

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
        if (this.spDropDown.getSelectedItem().toString().equalsIgnoreCase("Words")) {
//to do
        } else {
            int charsCount = TextUtils.getCharsCount(this.txtMain.getText().toString());
            String charsCountFormatted = String.valueOf(charsCount);
            this.tvResult.setText(charsCountFormatted);

//            String content = this.txtMain.getText().toString()
//            int charsCount = content.length();
//            String charsCountFormatted = String.valueOf(charsCount);
//            this.tvResult.setText(charsCountFormatted);
        }
    }
}