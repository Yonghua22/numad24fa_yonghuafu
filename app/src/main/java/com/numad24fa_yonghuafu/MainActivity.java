package com.numad24fa_yonghuafu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // About Button - Opens AboutActivity
        Button aboutButton = findViewById(R.id.button_about);
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open AboutActivity when button is clicked
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });

        // Quick Calc Button - Opens CalcActivity
        Button quicCalcButton = findViewById(R.id.btn_quic_calc);
        quicCalcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalcActivity.class);
                startActivity(intent);
            }
        });

        // Contacts Collector Button - Opens ContactsActivity
        Button contactsButton = findViewById(R.id.btn_contacts_collector);
        contactsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ContactsActivity.class);
                startActivity(intent);
            }
        });
    }
}
