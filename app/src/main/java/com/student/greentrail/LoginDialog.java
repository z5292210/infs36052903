package com.student.greentrail;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginDialog {
    public static void showDialog(Context context, OnLoginListener listener) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dialog_login, null);

        final EditText etPhoneNumber = view.findViewById(R.id.et_phone_number);
        final EditText etPassword = view.findViewById(R.id.et_password);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(view)
                .setTitle("Login")
                .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String phoneNumber = etPhoneNumber.getText().toString().trim();
                        String password = etPassword.getText().toString().trim();
                        listener.onLogin(phoneNumber, password);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public interface OnLoginListener {
        void onLogin(String phoneNumber, String password);
    }
}

