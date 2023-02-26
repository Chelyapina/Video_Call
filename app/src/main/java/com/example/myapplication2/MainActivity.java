package com.example.myapplication2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import android.view.View.OnClickListener;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {
    TextView UserName_1, UserName_2, s;
    ImageButton Motion,
            VideoCam, Mic, Exit;
    ImageView Avatar1, Avatar2;

    ConstraintLayout constraintLayout_avatar_1, constraintLayout_avatar_2;

    boolean flag_VideoCam = true,
            flag_Mic = true,
            flag_Motion = true;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Motion = (ImageButton) findViewById(R.id.Motion);
        VideoCam = (ImageButton) findViewById(R.id.VideoCam);
        Mic = (ImageButton) findViewById(R.id.Mic);
        Exit = (ImageButton) findViewById(R.id.Exit);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @SuppressLint({"NonConstantResourceId", "ResourceType"})
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.Motion:
                        if (flag_Motion){
                            Avatar1 = (ImageView) findViewById(R.id.Avatar1);
                            Avatar2 = (ImageView) findViewById(R.id.Avatar2);
                            UserName_1 = (TextView) findViewById(R.id.UserName_1);
                            UserName_2 = (TextView) findViewById(R.id.UserName_2);
                            s = UserName_1;
                            constraintLayout_avatar_1 = (ConstraintLayout) findViewById(R.id.constraintLayout_avatar_1);
                            constraintLayout_avatar_2 = (ConstraintLayout) findViewById(R.id.constraintLayout_avatar_2);
                        }
                        else{
                            Avatar1 = (ImageView) findViewById(R.id.Avatar2);
                            Avatar2 = (ImageView) findViewById(R.id.Avatar1);
                            UserName_1 = (TextView) findViewById(R.id.UserName_2);
                            UserName_2 = (TextView) findViewById(R.id.UserName_1);
                            constraintLayout_avatar_1 = (ConstraintLayout) findViewById(R.id.constraintLayout_avatar_2);
                            constraintLayout_avatar_2 = (ConstraintLayout) findViewById(R.id.constraintLayout_avatar_1);
                        }
                        Avatar1.setImageResource(R.drawable.avatar_2);
                        constraintLayout_avatar_1.setBackgroundResource(R.drawable.avatar_2);
                        UserName_1.setText(R.string.Username_2);
                        Avatar2.setImageResource(R.drawable.avatar_1);
                        constraintLayout_avatar_2.setBackgroundResource(R.drawable.avatar_1);
                        UserName_2.setText(R.string.Username_1);
                        flag_Motion = !flag_Motion;
                        break;
                    case R.id.VideoCam:
                        if (flag_VideoCam)
                            VideoCam.setImageResource(R.drawable.baseline_videocam_off_24);
                        else
                            VideoCam.setImageResource(R.drawable.baseline_videocam_24);
                        flag_VideoCam = !flag_VideoCam;
                        break;
                    case R.id.Mic:
                        if (flag_Mic)
                            Mic.setImageResource(R.drawable.baseline_mic_off_24);
                        else
                            Mic.setImageResource(R.drawable.baseline_mic_none_24);
                        flag_Mic = !flag_Mic;
                        break;
                    case R.id.Exit:
                        finish();
                        break;
                }
            }
        };
        Motion.setOnClickListener(onClickListener);
        VideoCam.setOnClickListener(onClickListener);
        Mic.setOnClickListener(onClickListener);
        Exit.setOnClickListener(onClickListener);
    }

    public void showDialog(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("привет");

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void startNewActivity(View v){
        Intent intent = new Intent(this, MembersActivity.class);
        startActivity(intent);

    }


    public void startSMS(View v){
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.messaging");
        if (launchIntent != null) { // null если приложение не найдено или не имеет активити для запуска.
            startActivity(launchIntent);
        }
    }

}