package com.numad24fa_yonghuafu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditContactActivity extends AppCompatActivity {

    private EditText etName, etPhone;
    private Button btnSave;
    private String originalName, originalPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        // Retrieve the contact details passed from the ContactsActivity
        originalName = getIntent().getStringExtra("contact_name");
        originalPhone = getIntent().getStringExtra("contact_phone");

        // Initialize the views
        etName = findViewById(R.id.et_name);
        etPhone = findViewById(R.id.et_phone);
        btnSave = findViewById(R.id.btn_save_contact);

        // Pre-fill the fields with the original contact details
        etName.setText(originalName);
        etPhone.setText(originalPhone);

        // Save button listener to send the updated data back to ContactsActivity
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String updatedName = etName.getText().toString();
                String updatedPhone = etPhone.getText().toString();

                // Create an Intent to return the updated contact data
                Intent resultIntent = new Intent();
                resultIntent.putExtra("name", updatedName);
                resultIntent.putExtra("phone", updatedPhone);

                // Set the result and finish the activity
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
