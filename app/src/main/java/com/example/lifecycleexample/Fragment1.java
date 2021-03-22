package com.example.lifecycleexample;

import android.app.Activity;
import android.content.Context;
import android.location.OnNmeaMessageListener;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Fragment1 extends Fragment {

    EditText editText1;
    Button btnSubmit1;
    onMessageReadListener messageListener;

    public interface onMessageReadListener{
       public void onMessageRead(String message);
    }

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        Log.i("Lifecycle Fragment1 ", "onAttach context");

        Activity activity = (Activity) context;
        try {
            messageListener = (onMessageReadListener) activity;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);

        Log.i("Lifecycle Fragment1 ", "onAttach activity");

    }

    @Override
    public void onAttachFragment(@NonNull Fragment childFragment) {
        super.onAttachFragment(childFragment);

        Log.i("Lifecycle Fragment1 ", "onAttachFragment");

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.i("Lifecycle Fragment1 ", "onSaveInstanceState");

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.i("Lifecycle Fragment1 ", "onActivityCreated");

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("Lifecycle Fragment1 ", "onCreate");


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.i("Lifecycle Fragment1 ", "onCreateView");

        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_1, container, false);
        editText1 = v.findViewById(R.id.edName1);
        btnSubmit1 = v.findViewById(R.id.btnSubmit1);

        btnSubmit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messageListener.onMessageRead(editText1.getText().toString());
            }
        });
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();

        Log.i("Lifecycle Fragment1 ", "onStart");

    }

    @Override
    public void onResume() {
        super.onResume();

        Log.i("Lifecycle Fragment1 ", "onResume");
        editText1.setText("");

    }

    @Override
    public void onPause() {
        super.onPause();

        Log.i("Lifecycle Fragment1 ", "onPause");

    }

    @Override
    public void onStop() {
        super.onStop();

        Log.i("Lifecycle Fragment1 ", "onStop");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Log.i("Lifecycle Fragment1 ", "onDestroyView");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.i("Lifecycle Fragment1 ", "onDestroy");

    }

    @Override
    public void onDetach() {
        super.onDetach();

        Log.i("Lifecycle Fragment1 ", "onDetach");

    }
}