package com.example.patryyyk21.pierwszaaplikacja;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText etText;
    public EditText etNumber;
    public TextView tvText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etText = (EditText)findViewById(R.id.et_Text);
        etNumber = (EditText)findViewById(R.id.et_Number);
        tvText = (TextView)findViewById(R.id.tv_Text);

        final RadioGroup rgColorGroup = (RadioGroup)findViewById(R.id.rg_ColorGroup);

        Button bSave = (Button)findViewById(R.id.b_Save);
        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvText.setText(etText.getText().toString() + " " + etNumber.getText().toString());
                Toast.makeText(getApplicationContext(),
                        getString(R.string.message),
                        Toast.LENGTH_SHORT).show();
            }
        });

        rgColorGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(radioGroup.getCheckedRadioButtonId()!=-1)
                {
                    RadioButton rbColor = (RadioButton)findViewById(i);
                    Toast.makeText(getApplicationContext(),
                            "Zaznaczono " + rbColor.getText(),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void ClearInput(View view){
        etText.setText("");
        etNumber.setText("");
        tvText.setText("");
        Toast.makeText(getApplicationContext(),
                getString(R.string.clear_message),
                Toast.LENGTH_SHORT).show();
    }
}
