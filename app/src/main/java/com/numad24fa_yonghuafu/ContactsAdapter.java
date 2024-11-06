package com.numad24fa_yonghuafu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactViewHolder> {

    private List<Contact> contactsList;
    private OnContactClickListener listener;

    public ContactsAdapter(List<Contact> contactsList, OnContactClickListener listener) {
        this.contactsList = contactsList;
        this.listener = listener;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_item, parent, false);
        return new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        Contact contact = contactsList.get(position);
        holder.name.setText(contact.getName());
        holder.phone.setText(contact.getPhoneNumber());

        holder.callButton.setOnClickListener(v -> listener.onContactClick(contact));
        holder.deleteButton.setOnClickListener(v -> listener.onContactDelete(contact));
        holder.editButton.setOnClickListener(v -> listener.onContactEdit(contact));
    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        public TextView name, phone;
        public ImageButton callButton, deleteButton, editButton;

        public ContactViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.contact_name);
            phone = view.findViewById(R.id.contact_phone);
            callButton = view.findViewById(R.id.call_button);
            deleteButton = view.findViewById(R.id.delete_button);
            editButton = view.findViewById(R.id.edit_button);
        }
    }

    public interface OnContactClickListener {
        void onContactClick(Contact contact);
        void onContactDelete(Contact contact);
        void onContactEdit(Contact contact);
    }
}
