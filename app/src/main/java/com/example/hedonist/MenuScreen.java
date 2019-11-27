package com.example.hedonist;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuScreen extends AppCompatActivity {

    //region SUMS
    private HashMap<String, Integer> mapOfSum = new HashMap<>();
    private final String COFFEE = "COFFEE";
    private final String TEA = "TEA";
    private final String MILKSHAKE = "MILKSHAKE";

    private final String CINNAMON = "CINNAMON";
    private final String LEMON = "LEMON";
    private final String MILK = "MILK";
    private final String MARSHMALLOW = "MARSHMALLOW";
    //endregion

    //region VIEWS
    private TextView showSum;
    private CheckBox checkBoxCinnamon;
    private CheckBox checkBoxMilk;
    private CheckBox checkBoxSugar;
    private CheckBox checkBoxMarshmallow;
    private CheckBox checkBoxLemon;
    private Button buttonOrder;
    //endregion

    private int totalSum = 0;
    private ArrayList<String> userOrder = new ArrayList<>();
    private OrderModel order = new OrderModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateSums();
        showSum = findViewById(R.id.tv_total_sum);
        totalSum += mapOfSum.get(COFFEE);
        setAmount(totalSum);

        checkBoxCinnamon = findViewById(R.id.checkbox_cinnamon);
        checkBoxMilk = findViewById(R.id.checkbox_milk);
        checkBoxSugar = findViewById(R.id.checkbox_sugar);
        checkBoxMarshmallow = findViewById(R.id.checkbox_marshmallow);
        checkBoxLemon = findViewById(R.id.checkbox_lemon);
        buttonOrder = findViewById(R.id.btn_order);

        RadioGroup radioGroup = findViewById(R.id.radio_btn_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int id) {
                int diff = 0;
                switch (id) {
                    case R.id.radio_btn_coffee:
                        diff = countDifference(order.getBeverage(), OrderModel.BEVERAGE.COFFEE);
                        order.setBeverage(OrderModel.BEVERAGE.COFFEE);
                        break;
                    case R.id.radio_btn_tea:
                        diff = countDifference(order.getBeverage(), OrderModel.BEVERAGE.TEA);
                        order.setBeverage(OrderModel.BEVERAGE.TEA);
                        break;
                    case R.id.radio_btn_milkshake:
                        diff = countDifference(order.getBeverage(), OrderModel.BEVERAGE.MILKSHAKE);
                        order.setBeverage(OrderModel.BEVERAGE.MILKSHAKE);
                        break;
                }
                totalSum += diff;
                setAmount(totalSum);
            }
        });

        checkBoxCinnamon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int sumOfExtra = mapOfSum.get(CINNAMON);
                if(b) {
                    totalSum += sumOfExtra;
                } else {
                    totalSum -= sumOfExtra;
                }
                setAmount(totalSum);
            }
        });
        checkBoxMilk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                checkBoxLemon.setChecked(false);
                int sumOfExtra = mapOfSum.get(MILK);
                if(b) {
                    if(checkBoxMarshmallow.isChecked()) {
                        checkBoxMarshmallow.setChecked(false);
                    }
                    totalSum += sumOfExtra;
                } else {
                    totalSum -= sumOfExtra;
                }
                setAmount(totalSum);
            }
        });
        checkBoxMarshmallow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int sumOfExtra = mapOfSum.get(MARSHMALLOW);
                if(b) {
                    if(checkBoxMilk.isChecked()) {
                        checkBoxMilk.setChecked(false);
                    }
                    totalSum += sumOfExtra;
                } else {
                    totalSum -= sumOfExtra;
                }
                setAmount(totalSum);
            }
        });
        checkBoxLemon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                checkBoxMilk.setChecked(false);


                int sumOfExtra = mapOfSum.get(LEMON);
                if(b) {
                    totalSum += sumOfExtra;
                    userOrder.add(LEMON);
                } else {
                    totalSum -= sumOfExtra;
                }
                setAmount(totalSum);
            }
        });

//        checkBoxCinnamon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View checkBoxCinnamon) {
//                Log.i("Click radio", "clik checkBoxCinnamon");
//                totalSum += 50;
//                setAmount(totalSum);
//            }
//        });
//        checkBoxMilk.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View checkBoxMilk) {
//                Log.i("Click radio", "clik checkBoxMilk");
//                totalSum += 50;
//                setAmount(totalSum);
//            }
//        });
//        checkBoxMarshmallow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View checkBoxMarshmallow) {
//                Log.i("Click radio", "clik checkBoxMarshmallow");
//                totalSum += 100;
//                setAmount(totalSum);
//            }
//        });
//        checkBoxLemon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View checkBoxCinnamon) {
//                Log.i("Click radio", "clik checkBoxLemon");
//                totalSum += 50;
//                setAmount(totalSum);
//            }
//        });
        buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuScreen.this, ThankyouPage.class);
                intent.putExtra("TOTAL_SUM", totalSum);
                intent.putExtra("ORDER", userOrder);
                startActivity(intent);
            }
        });
    }

//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putString("UserSum", String.valueOf(totalSum));
//    }

    //region Support
    private void setAmount(int amount) {
        showSum.setText(String.format(getString(R.string.total_sum), amount));
    }

    private void generateSums() {
        mapOfSum.put(TEA, 450);
        mapOfSum.put(COFFEE, 550);
        mapOfSum.put(MILKSHAKE, 650);
        mapOfSum.put(MARSHMALLOW, 100);
        mapOfSum.put(MILK, 50);
        mapOfSum.put(LEMON, 50);
        mapOfSum.put(CINNAMON, 50);
    }

    private int countDifference(OrderModel.BEVERAGE oldType, OrderModel.BEVERAGE newType) {
        int sumOfOldType = mapOfSum.get(getKeyByType(oldType));
        int sumOfNewType = mapOfSum.get(getKeyByType(newType));
        return sumOfNewType - sumOfOldType;
    }

    private String getKeyByType(OrderModel.BEVERAGE type) {
        switch (type) {
            case COFFEE:
                return COFFEE;
            case TEA:
                return TEA;
            case MILKSHAKE:
                return MILKSHAKE;
            default:
                return "";
        }
    }
    //endregion
}
