package com.studiomasteguh.yourfirstinteractiveui.clicklable.image;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.studiomasteguh.yourfirstinteractiveui.R;

public class ClickLableImage extends AppCompatActivity {
    TextView tvFroyo, tvDonuts, tvIceCream;
    ImageView imgDonuts, imgFroyo, imgIceCream;
    FloatingActionButton btnCart;

//    public static final String EXTRA_MESSAGE = "extra_message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_lable_image);

        // iniasi find viewby id from textview desc
        tvFroyo = findViewById(R.id.desc_froyo);
        tvDonuts = findViewById(R.id.desc_donuts);
        tvIceCream = findViewById(R.id.desc_ice_cream);

        btnCart = findViewById(R.id.btn_cart);

        // inisiasi find view byid from image 
        imgDonuts = findViewById(R.id.img_donuts);
        imgFroyo = findViewById(R.id.img_froyo);
        imgIceCream = findViewById(R.id.img_icecream);

        // on click in froyo
        imgFroyo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ClickLableImage.this, "You Ordered a Froyo.", Toast.LENGTH_SHORT).show();
            }
        });

        // on click in froyo
        imgDonuts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ClickLableImage.this, "You Ordered a donut.", Toast.LENGTH_SHORT).show();
            }
        });

        imgIceCream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ClickLableImage.this, "You Ordered a Ice Cream SandWich.", Toast.LENGTH_SHORT).show();
            }
        });

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(getApplicationContext(), OrderActivity.class);
                pindah.putExtra(OrderActivity.EXTRA_MESSAGE, "Donuts");
                startActivity(pindah);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_settings :
                return true;
            case R.id.action_message :
                Intent pindah = new Intent(getApplicationContext(), OrderActivity.class);
                pindah.putExtra(OrderActivity.EXTRA_MESSAGE, "Donuts");
                startActivity(pindah);
                Toast.makeText(this, "You Selected Order", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_status :
                Toast.makeText(this, "You Selected Status", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_favorites :
                Toast.makeText(this, "You Selected Favorites", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_contact :
                Toast.makeText(this, "You Selected Selected Contact", Toast.LENGTH_SHORT).show();
                return true;
            default:
        }
        return onOptionsItemSelected(item);
    }
}
