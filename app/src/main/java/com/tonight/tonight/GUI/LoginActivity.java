package com.tonight.tonight.GUI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.tonight.tonight.Infra.GuiUtil;
import com.tonight.tonight.R;

public class LoginActivity extends AppCompatActivity {
    GuiUtil guiUtil = GuiUtil.getGuiUtil();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onButtonClick(View v) {
        if(v.getId() == R.id.botaoLogin) {
            EditText login = (EditText) findViewById(R.id.campoLogin);
            EditText senha = (EditText) findViewById(R.id.campoSenha);
            String loginString = login.getText().toString();
            String senhaString = senha.getText().toString();

            Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
            intent.putExtra("TESTE", loginString);
            startActivity(intent);

        }
    }
}
