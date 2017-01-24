package com.Wipro.OptusDemo.UIScreen;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.Wipro.OptusDemo.UIScreen.databinding.MainScreenBinding;

public class OptusLaunchActivity extends AppCompatActivity implements View.OnClickListener{
    private MainScreenBinding mainScreenBinding;
    private Context mContent=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainScreenBinding = DataBindingUtil.setContentView(this,R.layout.main_screen);
        setSupportActionBar(mainScreenBinding.toolbar);
        mainScreenBinding.layoutScreen.scenarioOneBtn.setOnClickListener(this);
        mainScreenBinding.layoutScreen.scenarioTwoBtn.setOnClickListener(this);
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
            default:
                break;
        }
    }
}
