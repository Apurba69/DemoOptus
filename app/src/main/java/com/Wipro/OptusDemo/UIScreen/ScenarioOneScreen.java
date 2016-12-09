package com.Wipro.OptusDemo.UIScreen;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.Wipro.OptusDemo.Adapter.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by AP359544 on 12/8/2016.
 */
public class ScenarioOneScreen extends AppCompatActivity implements View.OnClickListener{
    Button mBlueBtn;
    Button mRedBtn;
    Button mGreenBtn;
    TextView mSetectItem;
    LinearLayout mBottomLinear;
    RecyclerView horizontal_recycler_view;
    HorizontalAdapter horizontalAdapter;
    private List<Data> data;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scenario_one_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mSetectItem=(TextView)findViewById(R.id.selectedText);
        mBlueBtn=(Button)findViewById(R.id.blueBtn);
        mRedBtn=(Button)findViewById(R.id.redBtn);
        mGreenBtn=(Button)findViewById(R.id.greenBtn);
        mBottomLinear=(LinearLayout)findViewById(R.id.bottomLinear);
        mBlueBtn.setOnClickListener(this);
        mRedBtn.setOnClickListener(this);
        mGreenBtn.setOnClickListener(this);

        horizontal_recycler_view= (RecyclerView) findViewById(R.id.horizontal_recycler_view);
        data = fill_with_data();
        horizontalAdapter=new HorizontalAdapter(data, getApplication());
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(ScenarioOneScreen.this, LinearLayoutManager.HORIZONTAL, false);
        horizontal_recycler_view.setLayoutManager(horizontalLayoutManager);
        horizontal_recycler_view.setAdapter(horizontalAdapter);


        setFragment(new FragmentOne());


    }

    protected void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View view) {
        int Id = view.getId();
        switch (Id){

            case R.id.blueBtn:
                mBottomLinear.setBackgroundColor(Color.BLUE);
                break;
            case R.id.redBtn:
                mBottomLinear.setBackgroundColor(Color.RED);
                break;
            case R.id.greenBtn:
                mBottomLinear.setBackgroundColor(Color.GREEN);
                break;

        }
    }

    public List<Data> fill_with_data() {

        List<Data> data = new ArrayList<>();

        data.add(new Data("Item 1"));
        data.add(new Data("Item 2"));
        data.add(new Data("Item 3"));
        data.add(new Data("Item 4"));
        data.add(new Data("Item 5"));

        return data;
    }

    public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyViewHolder> {


        List<Data> horizontalList = Collections.emptyList();
        Context context;


        public HorizontalAdapter(List<Data> horizontalList, Context context) {
            this.horizontalList = horizontalList;
            this.context = context;
        }


        public class MyViewHolder extends RecyclerView.ViewHolder {

            TextView txtview;
            public MyViewHolder(View view) {
                super(view);
                txtview=(TextView) view.findViewById(R.id.txtNewsSource);
            }
        }



        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);

            return new MyViewHolder(itemView);
        }


        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {

            holder.txtview.setText(horizontalList.get(position).txt);

            holder.txtview.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    String list = horizontalList.get(position).txt.toString();
                    mSetectItem.setText(list);
                    switch (position){

                        case 0:
                            setFragment(new FragmentOne());
                            break;
                        case 1:
                            setFragment(new FragmentTwo());
                            break;
                        case 2:
                            setFragment(new FragmentThree());
                            break;
                        case 3:
                            setFragment(new FragmentFour());
                            break;
                        case 4:
                            setFragment(new FragmentFive());
                            break;

                    }
                    Toast.makeText(ScenarioOneScreen.this, "Fragment"+" "+(position+1), Toast.LENGTH_SHORT).show();
                }

            });

        }

        @Override
        public int getItemCount()
        {
            return horizontalList.size();
        }
    }


}
