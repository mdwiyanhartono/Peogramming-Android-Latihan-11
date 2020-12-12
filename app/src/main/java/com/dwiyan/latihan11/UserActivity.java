package com.dwiyan.latihan11;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class UserActivity extends AppCompatActivity {

    TextView TV_Welcome;

    FloatingActionButton fb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        fb = findViewById(R.id.floatingActionButton);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialog();
            }
        });

        Inisial();
        Set_Object();
    }
    private void ShowDialog() {
        final Dialog d = new Dialog(this);
        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
        d.setContentView(R.layout.profile);
        d.show();
    }


    private void Inisial() {
        TV_Welcome = findViewById(R.id.textviewWelcome);
    }

    private void Set_Object() {
        Intent intent = getIntent();
        String Username = intent.getStringExtra(MainActivity.ExtraName);
        TV_Welcome.setText(getString(R.string.textviewWelcome) + " " + Username);
    }

}
