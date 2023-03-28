package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button[] buttons = new Button[10];
    TextView result;
    Button button_add, button_sub, button_div, button_mult, button_eq;
    double num1, num2;
    int i;
    boolean add_op=false, sub_op=false, div_op=false, mult_op=false;
    boolean first = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
        button_add = findViewById(R.id.button_add);
        button_sub = findViewById(R.id.button_sub);
        button_div = findViewById(R.id.button_div);
        button_mult = findViewById(R.id.button_mult);
        button_eq = findViewById(R.id.button_eq);
        Button button_sign = findViewById(R.id.button_sign);
        Button button_ac = findViewById(R.id.button_ac);
        for (i = 0; i < 10; i++) {
            String buttonID = "button" + i;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttons[i] = findViewById(resID);
        }

        button_eq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    num2 = Double.parseDouble(result.getText().toString());
                    Log.d("num1",""+num1);
                    Log.d("TAG", ""+num2);
                    result.setText(""+compute(num1, num2));
                    button_add.setBackgroundColor(Color.parseColor("#FFA500"));
                    button_div.setBackgroundColor(Color.parseColor("#FFA500"));
                    button_sub.setBackgroundColor(Color.parseColor("#FFA500"));
                    button_mult.setBackgroundColor(Color.parseColor("#FFA500"));
                    first = true;
                } catch (NumberFormatException e) {

                }
            }
        });

        button_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                first = true;
                result.setText("");
                operator("AC");
            }
        });


        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeOP();
                operator(button_add.getText().toString());

            }
        });
        button_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeOP();
                operator(button_sub.getText().toString());
            }
        });
        button_mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeOP();
                operator(button_mult.getText().toString());
            }
        });
        button_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeOP();
                operator(button_div.getText().toString());
            }
        });

        button_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    result.setText(-1*Double.parseDouble(result.getText().toString())+"");
                } catch (NumberFormatException e) {

                }
            }
        });

        buttons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText().toString() + 0);
            }
        });
        buttons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText().toString() + 1);
            }
        });
        buttons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText().toString() + 2);
            }
        });
        buttons[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText().toString() + 3);
            }
        });
        buttons[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText().toString() + 4);
            }
        });
        buttons[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText().toString() + 5);
            }
        });
        buttons[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText().toString() + 6);
            }
        });
        buttons[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText().toString() + 7);
            }
        });
        buttons[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText().toString() + 8);
            }
        });
        buttons[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText().toString() + 9);
            }
        });
        Button button_dot = findViewById(R.id.button_dot);
        button_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!result.getText().toString().contains(".")){
                    result.setText(result.getText().toString()+".");
                }
            }
        });
        Button button_percentage = findViewById(R.id.button_percent);
        button_percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(Double.parseDouble(result.getText().toString()) * 0.01 +"");
            }
        });
    }


    void operator(String op) {
        switch (op){
            case "+":
                button_mult.setBackgroundColor(Color.parseColor("#FFA500"));
                button_div.setBackgroundColor(Color.parseColor("#FFA500"));
                button_sub.setBackgroundColor(Color.parseColor("#FFA500"));
                button_add.setBackgroundColor(Color.parseColor("#86EE56"));
                add_op = true;
                sub_op = false;
                div_op = false;
                mult_op = false;
                break;

            case "-":
                button_mult.setBackgroundColor(Color.parseColor("#FFA500"));
                button_div.setBackgroundColor(Color.parseColor("#FFA500"));
                button_add.setBackgroundColor(Color.parseColor("#FFA500"));
                button_sub.setBackgroundColor(Color.parseColor("#86EE56"));
                add_op = false;
                sub_op = true;
                div_op = false;
                mult_op = false;
                break;

            case "x":
                button_add.setBackgroundColor(Color.parseColor("#FFA500"));
                button_div.setBackgroundColor(Color.parseColor("#FFA500"));
                button_sub.setBackgroundColor(Color.parseColor("#FFA500"));
                button_mult.setBackgroundColor(Color.parseColor("#86EE56"));
                add_op = false;
                sub_op = false;
                div_op = false;
                mult_op = true;
                break;

            case "/":
                button_add.setBackgroundColor(Color.parseColor("#FFA500"));
                button_div.setBackgroundColor(Color.parseColor("#FFA500"));
                button_sub.setBackgroundColor(Color.parseColor("#FFA500"));
                button_div.setBackgroundColor(Color.parseColor("#86EE56"));
                add_op = false;
                sub_op = false;
                div_op = true;
                mult_op = false;
                break;

            case "AC":
                button_add.setBackgroundColor(Color.parseColor("#FFA500"));
                button_div.setBackgroundColor(Color.parseColor("#FFA500"));
                button_sub.setBackgroundColor(Color.parseColor("#FFA500"));
                button_div.setBackgroundColor(Color.parseColor("#FFA500"));
                add_op = false;
                sub_op = false;
                div_op = false;
                mult_op = false;
                break;
        }


    }
    void changeOP() {
        if (first) {
            try {
                num1 = Double.parseDouble(result.getText().toString());
                result.setText("");
                first = false;
            } catch (NumberFormatException e) {

            }
        }

    }

    Double compute(Double n1, Double n2) {
        if (add_op) {
            return n1+n2;
        }
        else if (sub_op){
            return n1-n2;
        }
        else if (div_op){
            return n1/n2;
        }
        else if (mult_op){
            return n1*n2;
        }
        return null;
    }

}