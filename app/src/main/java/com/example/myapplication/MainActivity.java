package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.service.controls.templates.ControlButton;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtuser_245,edtpass_245;
    Button btdangnhap_245,btdangki_245,btthoat_245;
    String ten_245,mk_245;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        controlbutton();
    }
    private void controlbutton() {
        btthoat_245.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this,R.style.Theme_AppCompat_DayNight_Dialog);
                builder.setTitle("Bạn có muốn thoát");
                builder.setMessage("Hãy chọn bên dưới");
                builder.setIcon(R.drawable.avar1);
                builder.setPositiveButton("có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();
                    }
                });

                builder.setNegativeButton("không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.show();
            }
        });
        btdangki_245.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog =new Dialog(MainActivity.this);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.customdk);
                final EditText edtdk=(EditText)dialog.findViewById(R.id.etđk);
                final EditText edtmk=(EditText)dialog.findViewById(R.id.etmk);
                Button bthuy=(Button)dialog.findViewById(R.id.bth);
                Button btdongy=(Button)dialog.findViewById(R.id.btdy);
                btdongy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (edtdk.getText().length() != 0 && edtmk.getText().length() != 0) {
                            ten_245 = edtdk.getText().toString().trim();
                            mk_245 = edtmk.getText().toString().trim();
                            edtuser_245.setText(ten_245);
                            edtpass_245.setText(mk_245);
                            dialog.cancel();
                         } else {
                            Toast.makeText(MainActivity.this, "Mời bạn nhập đủ thông tin ", Toast.LENGTH_SHORT).show();
                        }
                }
                });
                bthuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
        btdangnhap_245.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtuser_245.getText().length()!=0 &&edtpass_245.getText().length()!=0){
                    if(edtuser_245.getText().toString().equals(ten_245)&& edtpass_245.getText().toString().equals(mk_245)) {
                        Toast.makeText(MainActivity.this, "Bạn đã đăng nhập thành công ", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                        startActivity(intent);
                    }else if(edtuser_245.getText().toString().equals("Thuan")&& edtpass_245.getText().toString().equals("789")) {
                    Toast.makeText(MainActivity.this, "Bạn đã đăng nhập thành công ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(intent);
                    } else {
                    Toast.makeText(MainActivity.this, "Bạn đã đăng nhập thất bại ", Toast.LENGTH_SHORT).show();}}
                    else {
                        Toast.makeText(MainActivity.this, "Mời bạn nhập đủ thông tin ", Toast.LENGTH_SHORT).show();
                    }
                }
        });
    }

    private  void anhxa(){
        btthoat_245 =(Button)findViewById(R.id.buttonthoat);
        edtuser_245 = (EditText)findViewById(R.id.editTextEmailAddress);
        edtpass_245 =(EditText)findViewById(R.id.editTextPassword);
        btdangnhap_245=(Button)findViewById(R.id.buttondangnhap);
        btdangki_245 =(Button)findViewById(R.id.buttondangki);
    }
}