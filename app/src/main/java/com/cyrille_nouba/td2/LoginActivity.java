package com.cyrille_nouba.td2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "NewsList";
    private Button btnLog;
    EditText textID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle(getLocalClassName());

        btnLog = (Button) findViewById(R.id.btnLogin);
        textID = (EditText) findViewById(R.id.textID);

        btnLog.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btnLogin:
                intent = new Intent(LoginActivity.this, NewsActivity.class);
                String stringLog = textID.getText().toString();
                intent.putExtra("login", stringLog);
                NewsListApplication app = (NewsListApplication) getApplicationContext();
                app.setLogin(stringLog);
                startActivity(intent);
                finish();
                break;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "fin de l'activité" + getLocalClassName());
    }
}

