package com.studiomasteguh.yourfirstinteractiveui.user.navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.studiomasteguh.yourfirstinteractiveui.R;

public class NavDrawerExperiment extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer_experiment);
        Toolbar toolbar = findViewById(R.id.toolbar_nav);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        if (fab != null){
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, "Replace with your action", Snackbar.LENGTH_LONG).
                            setAction("Action",null).show();
                }
            });
        }

        DrawerLayout dw =  findViewById(R.id.dw_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, dw, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
                if ( dw != null){
                    dw.addDrawerListener(toggle);
                }
                toggle.syncState();
                NavigationView nv = findViewById(R.id.nav_view);
                if (nv != null){
                    nv.setNavigationItemSelectedListener(this);
                }
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    @Override
    public void onBackPressed() {
        DrawerLayout dw = findViewById(R.id.dw_layout);
        if (dw!=null){
            if (dw.isDrawerOpen(GravityCompat.START)){
                dw.closeDrawer(GravityCompat.START);
            } else {
                onBackPressed();
            }

        }
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        DrawerLayout dw = findViewById(R.id.dw_layout);
        switch (item.getItemId()){
            case R.id.nav_camera:
                dw.closeDrawer(GravityCompat.START);
                Toast.makeText(this, "Kamu Memilih Camera", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.nav_gallery:
                dw.closeDrawer(GravityCompat.START);
                Toast.makeText(this, "Kamu Memilih Gallery", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.nav_slideshow:
                dw.closeDrawer(GravityCompat.START);
                Toast.makeText(this, "Kamu Memilih SlideShow", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.nav_manage:
                dw.closeDrawer(GravityCompat.START);
                Toast.makeText(this, "Kamu Memilih Manage", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.nav_share:
                dw.closeDrawer(GravityCompat.START);
                Toast.makeText(this, "Kamu Memilih Share", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.nav_send:
                dw.closeDrawer(GravityCompat.START);
                Toast.makeText(this, "Kamu Memilih Send", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }
}
