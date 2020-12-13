package com.example.myapplication.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.myapplication.Information;
import com.example.myapplication.Notify;
import com.example.myapplication.R;


public class trangchu extends Fragment implements View.OnClickListener {

    ImageView img1_245, img2_245;
    RelativeLayout rl1_245, rl2_245, rl3_245;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.trangchu, container, false);


        img1_245 = root.findViewById(R.id.imageNotify);
        img1_245.setOnClickListener(this);
        img2_245 = root.findViewById(R.id.imageAdd);
        img2_245.setOnClickListener(this);
        rl1_245 = root.findViewById(R.id.relativeTichdiem);
        rl2_245 = root.findViewById(R.id.relativeDathang);
        rl3_245 = root.findViewById(R.id.relativeCoupon);
        rl1_245.setOnClickListener(this);
        rl2_245.setOnClickListener(this);
        rl3_245.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.imageNotify) {
            Intent dsp = new Intent(trangchu.this.getActivity(), Notify.class);
            startActivity(dsp);
        }
        if (v.getId() == R.id.imageAdd) {
            Intent dsp = new Intent(trangchu.this.getActivity(), Information.class);
            startActivity(dsp);
        }
        if (v.getId() == R.id.relativeTichdiem) {
            Toast.makeText(this.getActivity(), "Tích điểm", Toast.LENGTH_SHORT).show();
        }
        if (v.getId() == R.id.relativeDathang) {
            Toast.makeText(this.getActivity(), "Đặt hàng ", Toast.LENGTH_SHORT).show();
        }
        if (v.getId() == R.id.relativeCoupon) {
            Toast.makeText(this.getActivity(), "Coupon", Toast.LENGTH_SHORT).show();
        }
    }
}


