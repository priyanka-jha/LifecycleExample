package com.example.lifecycleexample;

import android.app.Activity;
import android.content.Context;
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


public class Fragment2 extends Fragment {

    EditText editText2;
    Button btnSubmit2;

    public Fragment2() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        Log.i("Lifecycle Fragment2 ", "onAttach context");

    }

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);

        Log.i("Lifecycle Fragment2 ", "onAttach activity");

    }

    @Override
    public void onAttachFragment(@NonNull Fragment childFragment) {
        super.onAttachFragment(childFragment);

        Log.i("Lifecycle Fragment2 ", "onAttachFragment");

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.i("Lifecycle Fragment2 ", "onSaveInstanceState");

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.i("Lifecycle Fragment2 ", "onActivityCreated");

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("Lifecycle Fragment2 ", "onCreate");


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.i("Lifecycle Fragment2 ", "onCreateView");


        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_2, container, false);
        editText2 = v.findViewById(R.id.edName2);
        btnSubmit2 = v.findViewById(R.id.btnSubmit2);

        Bundle bundle = getArguments();
        String message = bundle.getString("message");
        editText2.setText(message);
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();

        Log.i("Lifecycle Fragment2 ", "onStart");

    }

    @Override
    public void onResume() {
        super.onResume();

        Log.i("Lifecycle Fragment2 ", "onResume");

    }

    @Override
    public void onPause() {
        super.onPause();

        Log.i("Lifecycle Fragment2 ", "onPause");

    }

    @Override
    public void onStop() {
        super.onStop();

        Log.i("Lifecycle Fragment2 ", "onStop");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Log.i("Lifecycle Fragment2 ", "onDestroyView");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.i("Lifecycle Fragment2 ", "onDestroy");

    }

    @Override
    public void onDetach() {
        super.onDetach();

        Log.i("Lifecycle Fragment2 ", "onDetach");

    }
}