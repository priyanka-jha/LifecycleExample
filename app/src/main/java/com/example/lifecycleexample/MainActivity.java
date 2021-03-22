package com.example.lifecycleexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Fragment1.onMessageReadListener {

    private static FragmentManager fm;

    LinearLayout fragmentContainer;
    Fragment1 fragment1;
    Fragment2 fragment2;
    Button btnReplace;
    TextView textMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("Lifecycle activity ", "onCreate");

        fragmentContainer = findViewById(R.id.fragmentContainer);
        btnReplace = findViewById(R.id.btnChange);
        textMsg = findViewById(R.id.textViewMsg);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();

        fm = getSupportFragmentManager();

        if(fragmentContainer != null) {   //check if the container is available or not


            if(savedInstanceState !=null){  //If forgot to check this condition,
                                            // that will lead to overlapping of fragment
                Log.i("Lifecycle activity ", "savedInstanceState not null");

                return;

            }
            else {

                Log.i("Lifecycle activity ", "savedInstanceState null");

            }

            FragmentTransaction ft = fm.beginTransaction();

            ft.add(R.id.fragmentContainer, fragment1, null).addToBackStack(null);
            ft.commit();
        }

        btnReplace.setOnClickListener(v -> {
            FragmentTransaction ft = fm.beginTransaction();

            ft.replace(R.id.fragmentContainer, fragment2, null).addToBackStack(null);
            ft.commit();
        });


    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.i("Lifecycle activity ", "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.i("Lifecycle activity ", "onRestoreInstanceState");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i("Lifecycle activity ", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i("Lifecycle activity ", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i("Lifecycle activity ", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i("Lifecycle activity ", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i("Lifecycle activity ", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i("Lifecycle activity ", "onDestroy");
    }


    @Override
    public void onMessageRead(String message) {

        textMsg.setText(""+message);

        Bundle bundle = new Bundle();
        bundle.putString("message",message);
        fragment2.setArguments(bundle);

        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentContainer,fragment2,null).addToBackStack(null).commit();
    }
}