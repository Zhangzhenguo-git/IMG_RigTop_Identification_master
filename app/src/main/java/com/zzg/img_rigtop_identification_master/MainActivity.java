package com.zzg.img_rigtop_identification_master;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.imgPoint)
    IMGRigTopPointView imgPoint;
    @BindView(R.id.btAdd)
    Button btAdd;
    private int number=10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        imgPoint.setMessageNum(number);
//        imgPoint.setPoint(imgPoint.getWidth()-imgPoint.getPaddingRight(),imgPoint.getPaddingTop());
        imgPoint.setPointMode(IMGRigTopPointView.NUMBER_POINT);
        imgPoint.setHaveMesage(true);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgPoint.setMessageNum(number=number+5);
                imgPoint.setHaveMesage(true);
            }
        });
    }
}
