package com.dwiyan.latihan11;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView actUserName;
    EditText etPassword;
    private String[] listUser = {"admin","agus","akmal","almaira","amanda","anindiva"};
    Button btnLogin;
    private int percobaan = 3;
    public static String ExtraName = "ExtraName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actUserName = findViewById(R.id.autoedittextusername);
        etPassword = findViewById(R.id.edittextpassword);
        btnLogin = findViewById(R.id.btnlogin);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.select_dialog_item,listUser);
        actUserName.setAdapter(arrayAdapter);
        actUserName.setThreshold(1);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username = actUserName.getText().toString().trim();
                String Password = etPassword.getText().toString().trim();
                if (percobaan <= 0){
                    ShowDialog(getString(R.string.msgboxlock));
                    return;
                }
                if(TextUtils.isEmpty(Username)) {
                    ShowDialog(getString(R.string.msgboxusernameempty));
                    return;
                }
                if(TextUtils.isEmpty(Password)) {
                    ShowDialog(getString(R.string.msgboxpassempty));
                    return;
                }
                if (Username.equals("dwiyan") && Password.equals("Dwiyan170897")){
                    Toast.makeText(MainActivity.this, getString(R.string.msgboxloginsuccess), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,UserActivity.class);
                    intent.putExtra(ExtraName,Username);
                    startActivity(intent);
                } else {
                    ShowDialog(getString(R.string.msgboxloginfailed));
                    percobaan--;
                    Clear();
                }
            }
        });




    }

    private void ShowDialog(String Pesan) {
        android.app.AlertDialog.Builder A_Builder = new android.app.AlertDialog.Builder(MainActivity.this);
        A_Builder.setPositiveButton("OK",null);
        A_Builder.setTitle(getString(R.string.info));
        A_Builder.setMessage(Pesan);
        AlertDialog Alert = A_Builder.create();
        Alert.show();
    }

    private void Clear() {
        actUserName.setText("");
        etPassword.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.actionlanguage) {
            Intent mIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(mIntent);
        }
        return super.onOptionsItemSelected(item);
    }

}
