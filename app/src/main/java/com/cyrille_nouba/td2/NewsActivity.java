package com.cyrille_nouba.td2;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NewsActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAbout;
    Button btnDetails;
    Button btnLogout;
    String url = "http://android.busin.fr/";
    String url1 = "http://goole.fr/";
    TextView lblLogin;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        setTitle(getLocalClassName());

        btnAbout = (Button) findViewById(R.id.btnAbout);
        btnDetails = (Button) findViewById(R.id.btnDetailsNews);
        btnLogout = (Button) findViewById(R.id.btnLogout);
        lblLogin = (TextView) findViewById(R.id.lblLogin);

        lblLogin.setAutoSizeTextTypeWithDefaults(TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM);
        lblLogin.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        Intent intentR = getIntent();
        String login_EXTRA = intentR.getStringExtra("login");
        lblLogin.setText(login_EXTRA);

        btnAbout.setOnClickListener(NewsActivity.this);
        btnDetails.setOnClickListener(NewsActivity.this);
        btnLogout.setOnClickListener(NewsActivity.this);


    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btnAbout:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
                break;
            case R.id.btnDetailsNews:
        intent = new Intent(NewsActivity.this, DetailsActivity.class);
        startActivity(intent);
        case R.id.btnLogout:
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url1));
            startActivity(intent);
        
    }
    }
}
