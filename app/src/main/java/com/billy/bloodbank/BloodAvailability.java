package com.billy.bloodbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class BloodAvailability extends AppCompatActivity {

    String bloodTypes;
    String[] bloodTypesRequested;

    List<BloodType> BloodTypeList;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_availability);

        bloodTypes = getIntent().getStringExtra("Blood Types Requested");
        bloodTypesRequested = bloodTypes.split(" ");

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        BloodTypeList = new ArrayList<>();

        for(int i = 0; i < bloodTypesRequested.length; i++) {
           BloodTypeList.add(
                   new BloodType(1,bloodTypesRequested[i],45)
           );
        }

        BloodTypeAdapter adapter = new BloodTypeAdapter(this, BloodTypeList);

        recyclerView.setAdapter(adapter);
    }

    public void goToHome(View view){
        Intent intent = new Intent(this, OptionActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

    }

    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public void onBackPressed() {
        finish();
    }
}
