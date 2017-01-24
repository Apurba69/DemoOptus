package com.Wipro.OptusDemo.UIScreen;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.Wipro.OptusDemo.Adapter.Data;
import com.Wipro.OptusDemo.Constant.ConstantElement;
import com.Wipro.OptusDemo.UIScreen.databinding.ScenarioOneScreenBinding;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by AP359544 on 1/23/2017.
 */
public class ScenarioOneScreen extends AppCompatActivity implements View.OnClickListener{
    private ScenarioOneScreenBinding mScenarioOneScreenBinding;
    private HorizontalAdapter horizontalAdapter;
    private List<Data> data;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScenarioOneScreenBinding = DataBindingUtil.setContentView(this, R.layout.scenario_one_screen);
        setSupportActionBar(mScenarioOneScreenBinding.toolbar);
        mScenarioOneScreenBinding.contentScenarioOne.blueBtn.setOnClickListener(this);
        mScenarioOneScreenBinding.contentScenarioOne.greenBtn.setOnClickListener(this);
        mScenarioOneScreenBinding.contentScenarioOne.redBtn.setOnClickListener(this);
        data = fill_with_data();
        horizontalAdapter = new HorizontalAdapter(data, getApplication());
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(ScenarioOneScreen.this, LinearLayoutManager.HORIZONTAL, false);
        mScenarioOneScreenBinding.contentScenarioOne.horizontalRecyclerView.setLayoutManager(horizontalLayoutManager);
        mScenarioOneScreenBinding.contentScenarioOne.horizontalRecyclerView.setAdapter(horizontalAdapter);
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
                mScenarioOneScreenBinding.contentScenarioOne.bottomLinear.setBackgroundColor(Color.BLUE);
                break;
            case R.id.redBtn:
                mScenarioOneScreenBinding.contentScenarioOne.bottomLinear.setBackgroundColor(Color.RED);
                break;
            case R.id.greenBtn:
                mScenarioOneScreenBinding.contentScenarioOne.bottomLinear.setBackgroundColor(Color.GREEN);
                break;
            default:
                break;
        }
    }

    private List<Data> fill_with_data() {

        List<Data> data = new ArrayList<>();
        for(int i = 0;i< ConstantElement.ITEM.length;i++){
            data.add(new Data(ConstantElement.ITEM[i]));
        }

        return data;
    }

    public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.HorizontalItemViewHolder> {


        List<Data> horizontalList = Collections.emptyList();
        Context context;


        public HorizontalAdapter(List<Data> horizontalList, Context context) {
            this.horizontalList = horizontalList;
            this.context = context;
        }


        public class HorizontalItemViewHolder extends RecyclerView.ViewHolder {

            TextView txtview;
            public HorizontalItemViewHolder(View view) {
                super(view);
                txtview=(TextView) view.findViewById(R.id.txtNewsSource);
            }
        }



        @Override
        public HorizontalItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);

            return new HorizontalItemViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final HorizontalItemViewHolder holder, final int position) {

            holder.txtview.setText(horizontalList.get(position).txt);

            holder.txtview.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    String list = horizontalList.get(position).txt.toString();
                    mScenarioOneScreenBinding.contentScenarioOne.selectedText.setText(list);
                    switch (position){

                        case ConstantElement.FRAGMENT_TYPE_1:
                            setFragment(new FragmentOne());
                            break;
                        case ConstantElement.FRAGMENT_TYPE_2:
                            setFragment(new FragmentTwo());
                            break;
                        case ConstantElement.FRAGMENT_TYPE_3:
                            setFragment(new FragmentThree());
                            break;
                        case ConstantElement.FRAGMENT_TYPE_4:
                            setFragment(new FragmentFour());
                            break;
                        case ConstantElement.FRAGMENT_TYPE_5:
                            setFragment(new FragmentFive());
                            break;
                        default:
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
