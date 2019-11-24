package com.example.studenthelpernew.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.studenthelpernew.DashboardActivity;
import com.example.studenthelpernew.FirstPageActivity;
import com.example.studenthelpernew.MainActivity;
import com.example.studenthelpernew.R;
import com.example.studenthelpernew.SessionHandler;
import com.example.studenthelpernew.User;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private SessionHandler session;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        session= new SessionHandler(getActivity().getApplicationContext());
        User user = session.getUserDetails();
        TextView text = root.findViewById(R.id.WELCOME);
        TextView userInfo = root.findViewById(R.id.UserInfo);
        text.setText("Welcome "+user.getFullName()+", your session will expire on "+user.getSessionExpiryDate());
        userInfo.setText("Username:" +user.getUsername() + "\n" + "Full Name : " + user.getFullName() );
        Button button = root.findViewById(R.id.logout);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.logoutUser();
                Intent i = new Intent(getActivity(), MainActivity.class);
                startActivity(i);
            }
        });



        return root;



    }
}