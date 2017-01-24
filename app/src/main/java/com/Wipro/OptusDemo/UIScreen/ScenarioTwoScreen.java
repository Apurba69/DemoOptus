package com.Wipro.OptusDemo.UIScreen;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import com.Wipro.OptusDemo.Constant.ConstantElement;
import com.Wipro.OptusDemo.UIScreen.databinding.ScenarioTwoScreenBinding;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AP359544 on 1/23/2017.
 */
public class ScenarioTwoScreen extends AppCompatActivity implements AdapterView.OnItemSelectedListener,View.OnClickListener {
    private int pos=0;
    private Context mContext=this;
    private List<String> places = new ArrayList<String>();
    private ScenarioTwoScreenBinding mScenarioTwoScreenBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScenarioTwoScreenBinding = DataBindingUtil.setContentView(this,R.layout.scenario_two_screen);
        setSupportActionBar(mScenarioTwoScreenBinding.toolbar);
        mScenarioTwoScreenBinding.contentScenarioTwo.navigateBtn.setOnClickListener(this);
        for(int i =0; i< ConstantElement.placeName.length;i++){
            places.add(ConstantElement.placeName[i]);
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, places);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mScenarioTwoScreenBinding.contentScenarioTwo.spinner.setAdapter(dataAdapter);
        mScenarioTwoScreenBinding.contentScenarioTwo.spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        pos=position;
        mScenarioTwoScreenBinding.contentScenarioTwo.carText.setText("Car: " + ConstantElement.Car[position] + " Mins");
        mScenarioTwoScreenBinding.contentScenarioTwo.trainText.setText("Train: " + ConstantElement.Train[position] + " Mins");
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.navigateBtn:
                Intent lIntent = new Intent(mContext,MapNavigator.class);
                lIntent.putExtra("LAT",ConstantElement.latt[pos]);
                lIntent.putExtra("LONG",ConstantElement.longg[pos]);
                lIntent.putExtra("PLACE",places.get(pos));
                startActivity(lIntent);
                break;


        }
    }
}
