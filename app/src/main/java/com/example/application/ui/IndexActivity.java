package com.example.application.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.application.R;

public class IndexActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
    }


    public void onClick(View view){
        switch (view.getId()) {
            case R.id.index_sequence:
                startActivity(new Intent(IndexActivity.this, SequenceActivity.class));
                break;
            case R.id.index_random:
                startActivity(new Intent(IndexActivity.this, RandomActivity.class));
                break;
            case R.id.index_strengthen:
                startActivity(new Intent(IndexActivity.this, StrengthenActivity.class));
                break;
            case R.id.index_simulation:
                startActivity(new Intent(IndexActivity.this, SimulationActivity.class));
                break;

       }
    }

}
