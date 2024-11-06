package com.numad24fa_yonghuafu;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    private TextView tvAboutMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about); // Make sure this points to the correct layout

        tvAboutMe = findViewById(R.id.tv_about_me); // Ensure the correct ID
//        tvAboutMe.setText("Name: Yonghua Fu\nEmail: fu.yong@northeastern.edu");
    }
}
