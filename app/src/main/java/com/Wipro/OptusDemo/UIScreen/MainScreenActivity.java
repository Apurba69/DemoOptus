package com.Wipro.OptusDemo.UIScreen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import android.widget.Button;

public class MainScreenActivity extends AppCompatActivity implements View.OnClickListener{

    private Context mContent=this;
    private Button mScenario_1_Btn;
    private Button mScenario_2_Btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mScenario_1_Btn=(Button)findViewById(R.id.scenarioOneBtn);
        mScenario_2_Btn=(Button)findViewById(R.id.scenarioTwoBtn);
        mScenario_1_Btn.setOnClickListener(this);
        mScenario_2_Btn.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        int Id = view.getId();
        switch (Id){
            case R.id.scenarioOneBtn:
                startActivity(new Intent(mContent,ScenarioOneScreen.class));
                break ;
            case R.id.scenarioTwoBtn:
                startActivity(new Intent(mContent,ScenarioTwoScreen.class));
                break ;
        }
    }
}
