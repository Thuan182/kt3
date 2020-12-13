package com.example.myapplication.tablayout;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.model_adapter.DoUong;
import com.example.myapplication.model_adapter.SanPhamAdapter;

public class ThucUongFragment extends Fragment {

    private GridView gvmon;
    private SanPhamAdapter spadt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View r = inflater.inflate(R.layout.fragment_thuc_uong, container, false);
        gvmon = r.findViewById(R.id.gv_mon);
        spadt = new SanPhamAdapter(ThucUongFragment.this.getActivity(), R.layout.item);
        gvmon.setAdapter(spadt);
        registerForContextMenu(gvmon);
        fakeData();
        addEvents();
        return r;
    }
    private void fakeData() {
        spadt.add(new DoUong(R.drawable.latte, "Latte", "25.000"));
        spadt.add(new DoUong(R.drawable.caphedua, "Cà phê dừa", "27.000"));
        spadt.add(new DoUong(R.drawable.nuoccam, "Nước ép cam", "20.000"));
        spadt.add(new DoUong(R.drawable.trachanh ,"Trà Chanh", "19.000"));
        spadt.add(new DoUong(R.drawable.caramel, "Caramel coffee", "25.000"));
        spadt.add(new DoUong(R.drawable.trasua, "Trà Sữa", "27.000"));
        spadt.add(new DoUong(R.drawable.tradao, "Trà đào", "20.000"));

    }

    private void addEvents() {
        gvmon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                Dialog dialog = new Dialog(ThucUongFragment.this.getActivity());
                dialog.setContentView(R.layout.dilg_dathang);
                dialog.show();
            }
        });
        gvmon.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Dialog dialog = new Dialog(ThucUongFragment.this.getActivity());
                dialog.setContentView(R.layout.dhang);
                dialog.show();

                return true;
            }
        });
    }
}