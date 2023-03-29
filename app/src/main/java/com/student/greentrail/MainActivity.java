package com.student.greentrail;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.student.greentrail.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements LoginDialog.OnLoginListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home,R.id.navigation_maps,R.id.navigation_qrcode, R.id.navigation_plant)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        LoginDialog.showDialog(this,this);
    }

    @Override
    public void onLogin(String phoneNumber, String password) {
        if (phoneNumber.equals("123456") && password.equals("123456")){
            Toast.makeText(this, "Login successful！", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Login failed！", Toast.LENGTH_SHORT).show();
        }
    }
}