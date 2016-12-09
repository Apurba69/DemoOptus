package com.Wipro.OptusDemo.UIScreen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AP359544 on 12/8/2016.
 */
public class ScenarioTwoScreen extends AppCompatActivity implements AdapterView.OnItemSelectedListener,View.OnClickListener {
    int pos=0;
    Button mNavigatorBtn;
    private Context mContext=this;
    List<String> places = new ArrayList<String>();
    double [] latt={-21.56,-33.8535,-33.8910};
    double [] longg ={148.95,151.2249,151.2715};
    int [] Car={80,60,100};
    int [] Train={120,90,150};
    TextView mCar;
    TextView mTrain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scenario_two_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mNavigatorBtn = (Button)findViewById(R.id.navigateBtn);
        mNavigatorBtn.setOnClickListener(this);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        mCar = (TextView)findViewById(R.id.carText);
        mTrain = (TextView)findViewById(R.id.trainText);
        places.add("Blue Mountains");
        places.add("Taronga Zoo");
        places.add("Bondi Beach");
        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, places);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        pos=position;
        mCar.setText("Car: "+Car[position]+" Mins");
        mTrain.setText("Train: " + Train[position] + " Mins");
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.navigateBtn:
                Intent lIntent = new Intent(mContext,MapNavigator.class);
                lIntent.putExtra("LAT",latt[pos]);
                lIntent.putExtra("LONG",longg[pos]);
                lIntent.putExtra("PLACE",places.get(pos));
                startActivity(lIntent);
                break;


        }
    }
}
