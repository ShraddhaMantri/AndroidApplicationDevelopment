package com.cs442.ssamant4.foodbasket;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.annotation.IdRes;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabSelectedListener;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabSelectedListener;

public class MenuCategories extends AppCompatActivity
{
    //shraddha start
    private long timer = 2000;

    private String time;
    private int loop;

    private ImageView imageView;
    private Handler customHandler = new Handler();
    Integer imgs[] = new Integer[]{
            R.drawable.ad,
            R.drawable.ad4,
            R.drawable.ad3
    };

    private ImageView imgbtnAdd;
    private ImageView i1;
    private ImageView i2;
    private  ImageView i3;
    private ImageView i4;
    private ImageView i5;
    private ImageView i6;
    private ImageView i7;

    private ImageView m1;
    private  ImageView m2;
    private  ImageView m3;
    private ImageView m4;
    private ImageView m5;
    private ImageView m6;

    //shraddha end

    //sohan start bottom menu
    private CoordinatorLayout coordinatorLayout;
    // sohan end bottom menu

    SharedPreferences mpref;
    SharedPreferences login_info;
    SharedPreferences.Editor editor;
    String userType;
    String menu_type;
    Spinner s;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_categories);

        //sohan bottom menu start
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.bottomMenuBar);

        BottomBar bottomBar = BottomBar.attach(this, savedInstanceState);
        bottomBar.setItemsFromMenu(R.menu.bottom_menu, new OnMenuTabSelectedListener()
        {
            @Override
            public void onMenuItemSelected(int itemId)
            {
                switch (itemId)
                {
                    case R.id.Home:
                        Intent i=new Intent(getApplicationContext(),MenuCategories.class);
                        startActivity(i);
                        break;
                    case R.id.CartScreen:
                      Intent intent = new Intent(getApplicationContext(),Cart.class);
                        startActivity(intent);

                        break;
                    case R.id.AboutUs:
                       Intent in=new Intent(getApplicationContext(),Aboutus.class);
                        startActivity(in);
                        break;
                    case R.id.Logout:
                        Intent inten=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(inten);
                        break;
                }
            }
        });

        //sohan end


        //shraddha start
        imageView = (ImageView) findViewById(R.id.imgbtnAdd);
        i1 = (ImageView) findViewById(R.id.i1);
        i2 = (ImageView) findViewById(R.id.i2);
        i3 = (ImageView)findViewById(R.id.i3);
        i4 = (ImageView)findViewById(R.id.i4);
        i5 = (ImageView)findViewById(R.id.i5);
        i6 = (ImageView)findViewById(R.id.i6);
        i7 = (ImageView)findViewById(R.id.i7);

        m1 = (ImageView)findViewById(R.id.m1);
        m2 = (ImageView)findViewById(R.id.m2);
        m3 = (ImageView)findViewById(R.id.m3);
        m4 = (ImageView)findViewById(R.id.m4);
        m5 = (ImageView)findViewById(R.id.m5);
        m6 = (ImageView)findViewById(R.id.m6);


        customHandler.postDelayed(runnable, timer);

        imgbtnAdd = (ImageView) findViewById(R.id.imgbtnAdd);
        imgbtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "Description of advertisement";
                Intent intent = new Intent(getApplicationContext(), AdDetails.class);
                startActivity(new Intent(MenuCategories.this, AdDetails.class));
            }
        });

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "Description for particular item i2";
                Intent intent = new Intent(getApplicationContext(), ViewFullImage.class);
                intent.putExtra("BITMAP_ID",4);
                intent.putExtra("Name_id",4);
                intent.putExtra("Price_id",4);
                intent.putExtra("Ingrediants_id",4);
                intent.putExtra("Pos",4);
                startActivity(intent);
            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "Description for particular item i1";
                Intent intent = new Intent(getApplicationContext(), ViewFullImage.class);
                intent.putExtra("BITMAP_ID",3);
                intent.putExtra("Name_id",3);
                intent.putExtra("Price_id",3);
                intent.putExtra("Ingrediants_id",3);
                intent.putExtra("Pos",3);
               // startActivity(intent);
                startActivity(intent);
            }
        });

        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "Description for particular item i1";
                Intent intent = new Intent(getApplicationContext(), ViewFullImage.class);
                intent.putExtra("BITMAP_ID",2);
                intent.putExtra("Name_id",2);
                intent.putExtra("Price_id",2);
                intent.putExtra("Ingrediants_id",2);
                intent.putExtra("Pos",2);
                // startActivity(intent);
                startActivity(intent);
            }
        });

        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "Description for particular item i1";
                Intent intent = new Intent(getApplicationContext(), ViewFullImage.class);
                intent.putExtra("BITMAP_ID",1);
                intent.putExtra("Name_id",1);
                intent.putExtra("Price_id",1);
                intent.putExtra("Ingrediants_id",1);
                intent.putExtra("Pos",1);
                // startActivity(intent);
                startActivity(intent);
            }
        });

        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "Description for particular item i1";
                Intent intent = new Intent(getApplicationContext(), ViewFullImage.class);
                intent.putExtra("BITMAP_ID",0);
                intent.putExtra("Name_id",0);
                intent.putExtra("Price_id",0);
                intent.putExtra("Ingrediants_id",0);
                intent.putExtra("Pos",0);
                // startActivity(intent);
                startActivity(intent);
            }
        });

        i6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "Description for particular item i1";
                Intent intent = new Intent(getApplicationContext(), ViewFullImage.class);
                intent.putExtra("BITMAP_ID",0);
                intent.putExtra("Name_id",0);
                intent.putExtra("Price_id",0);
                intent.putExtra("Ingrediants_id",0);
                intent.putExtra("Pos",0);
                // startActivity(intent);
                startActivity(intent);
            }
        });

        i7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "Description for particular item i1";
                Intent intent = new Intent(getApplicationContext(), ViewFullImage.class);
                intent.putExtra("BITMAP_ID",5);
                intent.putExtra("Name_id",5);
                intent.putExtra("Price_id",5);
                intent.putExtra("Ingrediants_id",5);
                intent.putExtra("Pos",5);
                // startActivity(intent);
                startActivity(intent);
            }
        });

        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "Description for particular item i1";
                Intent intent = new Intent(getApplicationContext(), ViewFullImage.class);
                intent.putExtra("BITMAP_ID",6);
                intent.putExtra("Name_id",6);
                intent.putExtra("Price_id",6);
                intent.putExtra("Ingrediants_id",6);
                intent.putExtra("Pos",6);
                // startActivity(intent);
                startActivity(intent);
            }
        });

        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "Description for particular item i1";
                Intent intent = new Intent(getApplicationContext(), ViewFullImage.class);
                intent.putExtra("BITMAP_ID",7);
                intent.putExtra("Name_id",7);
                intent.putExtra("Price_id",7);
                intent.putExtra("Ingrediants_id",7);
                intent.putExtra("Pos",7);
                // startActivity(intent);
                startActivity(intent);
            }
        });

        m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "Description for particular item i1";
                Intent intent = new Intent(getApplicationContext(), ViewFullImage.class);
                intent.putExtra("BITMAP_ID",8);
                intent.putExtra("Name_id",8);
                intent.putExtra("Price_id",8);
                intent.putExtra("Ingrediants_id",8);
                intent.putExtra("Pos",8);
                // startActivity(intent);
                startActivity(intent);
            }
        });

        m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "Description for particular item i1";
                Intent intent = new Intent(getApplicationContext(), ViewFullImage.class);
                intent.putExtra("BITMAP_ID",0);
                intent.putExtra("Name_id",0);
                intent.putExtra("Price_id",0);
                intent.putExtra("Ingrediants_id",0);
                intent.putExtra("Pos",0);
                // startActivity(intent);
                startActivity(intent);
            }
        });

        m5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "Description for particular item i1";
                Intent intent = new Intent(getApplicationContext(), ViewFullImage.class);
                intent.putExtra("BITMAP_ID",9);
                intent.putExtra("Name_id",9);
                intent.putExtra("Price_id",9);
                intent.putExtra("Ingrediants_id",9);
                intent.putExtra("Pos",9);
                // startActivity(intent);
                startActivity(intent);
            }
        });

        m6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "Description for particular item i1";
                Intent intent = new Intent(getApplicationContext(), ViewFullImage.class);
                intent.putExtra("BITMAP_ID",10);
                intent.putExtra("Name_id",10);
                intent.putExtra("Price_id",10);
                intent.putExtra("Ingrediants_id",10);
                intent.putExtra("Pos",10);
                // startActivity(intent);
                startActivity(intent);
            }
        });


        //shraddha end

        mpref = getSharedPreferences("User_Info", 0);

        userType = mpref.getString("user_type", "UsernotIdentified");
        //login_info = getSharedPreferences("User_Info", Context.MODE_PRIVATE);
        editor = mpref.edit();
        s = (Spinner) findViewById(R.id.spinner);


    }


    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if(loop < imgs.length)
            {
                imageView.setImageResource(imgs[loop]);
                loop++;
            }

            if(loop == imgs.length){
                loop = 0;
            }
            customHandler.postDelayed(this,2000);
        }

    };

    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        customHandler.removeCallbacks(runnable);
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.action_menu,menu);
        return true;
    }

    public void BreakfastMenu(View v) {

        editor.putString("menu_type", "BreakFast");
        editor.apply();
        Intent i = new Intent(this, ImageListView.class);
        menu_type = s.getSelectedItem().toString();
        i.putExtra("Type", menu_type);


        startActivity(i);

    }

    public void LunchMenu(View v) {
        editor.putString("menu_type", "Lunch");
        editor.apply();
        Intent i = new Intent(this, ImageListView.class);
        menu_type = s.getSelectedItem().toString();
        i.putExtra("Type", menu_type);
        startActivity(i);
    }

    public void DinnerMenu(View v) {
        editor.putString("menu_type", "Dinner");
        editor.apply();
        Intent i = new Intent(this, ImageListView.class);
        menu_type = s.getSelectedItem().toString();
        i.putExtra("Type", menu_type);
        startActivity(i);
    }

    public void SnacksMenu(View v) {
        editor.putString("menu_type", "Snacks");
        editor.apply();
        Intent i = new Intent(this, ImageListView.class);
        menu_type = s.getSelectedItem().toString();
        i.putExtra("Type", menu_type);
        startActivity(i);
    }
}