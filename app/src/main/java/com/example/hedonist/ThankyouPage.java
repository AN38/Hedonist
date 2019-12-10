package com.example.hedonist;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThankyouPage extends AppCompatActivity {

    TextView showTotalSum;

    TextView showOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thank_you_page);

        int totalSum = getIntent().getIntExtra("TOTAL_SUM", 0);
        showTotalSum = findViewById(R.id.tv_show_sum);
        showTotalSum.setText(String.format(getString(R.string.total_sum), totalSum));

        String order = getIntent().getStringExtra("ORDER");
        showOrder = findViewById(R.id.tv_order);
        showOrder.setText(String.format(getString(R.string.your_order), order));
    }
}
