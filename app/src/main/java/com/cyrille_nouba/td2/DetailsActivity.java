package com.cyrille_nouba.td2;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    TextView lblLogin2;
    Button btnValider;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setTitle(getLocalClassName());
        lblLogin2 = findViewById(R.id.lblLogin2);
        btnValider = findViewById(R.id.btnValider);

        lblLogin2.setAutoSizeTextTypeWithDefaults(TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM);
        lblLogin2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        NewsListApplication app = (NewsListApplication) getApplicationContext();
        String login = app.getLogin();

        lblLogin2.setText(login);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btnValider:
                NewsListApplication app = (NewsListApplication) getApplicationContext();
                String login = app.getLogin();
                intent = new Intent(DetailsActivity.this, NewsActivity.class);
                intent.putExtra("login", login);
                startActivity(intent);
        }
    }
}
