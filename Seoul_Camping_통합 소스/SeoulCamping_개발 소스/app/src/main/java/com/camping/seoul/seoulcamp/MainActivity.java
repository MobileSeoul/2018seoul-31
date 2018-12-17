package com.camping.seoul.seoulcamp;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

/*import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;*/

import fragment.NearByFragment;


public class MainActivity extends AppCompatActivity {

    /* BottomBar bottomBar;*/
    FrameLayout frameLayout;
    private String token, versionName;
    private int versionCode;
    private String hasCard, hasActivated;
    private Dialog slideDialog;
    private TextView tvupdate;
    private TextView tvskip, tvupdatediscription;
    private boolean callUpdateservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, Intro_Activity.class);

        startActivity(intent);

        frameLayout = (FrameLayout) findViewById(R.id.framelayout);

        replace_fragment(new NearByFragment());


    }


    public void replace_fragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout, fragment);
        transaction.commit();
    }


    //////////////////////////////////////////////////////////


}
