package com.example.numberconvertorproject;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    private EditText etnumber;
    private TextView tvresult;
    private Button convertbttn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiate();
        setAction();
    }
    private void initiate(){
        etnumber=findViewById(R.id.inputet);
        tvresult=findViewById(R.id.outputtv);
        convertbttn=findViewById(R.id.convertbttn);
    }
    private void setAction(){
        convertbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int input = Integer.parseInt(etnumber.getText().toString());
                Model model = new Model();
                if (input < 20) {

                    tvresult.setText(model.getOnes()[input]);
                } else if (input < 100) {
                    int tensIndex = input / 10;
                    int onesIndex = input % 10;

                    if (onesIndex != 0) {
                        tvresult.setText(model.getTens()[tensIndex] + " " + model.getOnes()[onesIndex]);
                    } else {
                        tvresult.setText(model.getTens()[tensIndex]);
                    }
                } else {
                    int hundredsIndex = input / 100;
                    int remainder = input % 100;
                    int tensIndex = remainder / 10;
                    int onesIndex = remainder % 10;

                    if (onesIndex != 0) {
                        tvresult.setText(model.getOnes()[hundredsIndex] + " Hundred " + model.getTens()[tensIndex] + " " + model.getOnes()[onesIndex]);
                    } else {
                        tvresult.setText(model.getOnes()[hundredsIndex] + " Hundred " + model.getTens()[tensIndex]);
                    }
                }
            }});
        }
    }
