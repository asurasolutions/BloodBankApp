package com.billy.bloodbank;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import android.widget.Button;

public class OptionActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    TextView Username;
    Button getBloodButton;

    CharSequence[] items = {"A+","A-","B+","B-","O+","O-","AB+","AB-"};
    boolean[] selectedItems = {false, false, false, false, false, false, false, false};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        Username = findViewById(R.id.Username);
        Username.setText("Hi" + "\n"+currentUser.getPhoneNumber()+"!");
        getBloodButton = findViewById(R.id.getBloodButton);
        getBloodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(OptionActivity.this);
                alertDialogBuilder.setCancelable(true);
                alertDialogBuilder.setTitle("Select Blood Type(s)");
                alertDialogBuilder.setMultiChoiceItems(items, selectedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        selectedItems[which] = isChecked;
                    }
                });
                alertDialogBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(OptionActivity.this, BloodAvailability.class);
                        intent.putExtra("Blood Types Requested", itemsToString());
                        dialog.dismiss();
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.setCanceledOnTouchOutside(true);
                alertDialog.show();
            }
        });

    }

    private String itemsToString(){
        String text = "";
        for(int i = 0; i<selectedItems.length;i++){
            if (selectedItems[i]){
                text = text + items[i] + " ";
            }
        }
        return text.trim();
    }

    public void onBackPressed() {
        finishAffinity();
        finish();
    }
}
