package com.numad24fa_yonghuafu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ContactsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ContactsAdapter adapter;
    private ArrayList<Contact> contactsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        // Initialize the contacts list
        contactsList = new ArrayList<>();

        // Set up RecyclerView and adapter
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ContactsAdapter(contactsList, new ContactsAdapter.OnContactClickListener() {
            @Override
            public void onContactClick(Contact contact) {
                dialPhoneNumber(contact.getPhoneNumber());
            }

            @Override
            public void onContactDelete(Contact contact) {
                // Delete the contact from the list
                contactsList.remove(contact);
                adapter.notifyDataSetChanged();
                Toast.makeText(ContactsActivity.this, "Contact Deleted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onContactEdit(Contact contact) {
                // Open the EditContactActivity for editing a contact
//                Intent intent = new Intent(ContactsActivity.this, EditContactActivity.class);
//                intent.putExtra("contact_name", contact.getName());
//                intent.putExtra("contact_phone", contact.getPhoneNumber());
//                startActivityForResult(intent, 2); // Start activity to edit contact
            }
        });

        recyclerView.setAdapter(adapter);

        // Floating Action Button to add a new contact
        FloatingActionButton fab = findViewById(R.id.fab_add_contact);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open AddContactActivity to add a new contact
                Intent intent = new Intent(ContactsActivity.this, AddContactActivity.class);
                startActivityForResult(intent, 1); // Start activity to add contact
            }
        });
    }

    private void dialPhoneNumber(String phoneNumber) {
        // Dial the phone number when clicked
        Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
        startActivity(dialIntent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            // Handle the addition of a new contact
            String name = data.getStringExtra("name");
            String phone = data.getStringExtra("phone");
            Contact newContact = new Contact(name, phone);
            contactsList.add(newContact);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Contact Added", Toast.LENGTH_SHORT).show();
        } else if (requestCode == 2 && resultCode == RESULT_OK && data != null) {
            // Handle the edit of an existing contact
            String updatedName = data.getStringExtra("name");
            String updatedPhone = data.getStringExtra("phone");

            // Find the contact and update it
            for (int i = 0; i < contactsList.size(); i++) {
                Contact contact = contactsList.get(i);
                if (contact.getName().equals(updatedName)) {
                    contact.setName(updatedName);  // Update name
                    contact.setPhoneNumber(updatedPhone);  // Update phone number
                    adapter.notifyItemChanged(i); // Notify the adapter of the update
                    Toast.makeText(this, "Contact Updated", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
    }
}
