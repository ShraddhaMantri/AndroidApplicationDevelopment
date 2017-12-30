package com.cs442.ssamant4.foodbasket;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabSelectedListener;

import java.util.ArrayList;

public class ViewFullImage extends AppCompatActivity
{
    private ImageView imageView;
    private TextView item_name;
    private TextView item_price;
    private TextView item_ingrediants;
    SharedPreferences login_info;
    SharedPreferences.Editor editor;
    SharedPreferences mpref;
    Button plus;
    Button minus;
    Button cart;
    int q=0,total_price=0;
    public static int flag=0;
    String result="",orderinfo;
    TextView quantity;
    int pos;
    public static ArrayList<String> ordr_summary=new ArrayList<String>();
    public static ArrayList<Integer> ordr_price=new ArrayList<Integer>();
    AlertDialog alertDialog;
    Handling_items handling_items;

    //sohan start bottom menu
    private CoordinatorLayout coordinatorLayout;
    // sohan end bottom menu

    String product_name; // to be used in cart screen
    String cost;  // to be used in cart screen
    String quant; // to be used in cart screen
    int price=0;
    int price_item=0;// to be used in cart screen
    String s1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_full_image);


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

        login_info=getSharedPreferences("User_Info",0);
        alertDialog = new AlertDialog.Builder(this).create();
        editor=login_info.edit();
        mpref=getSharedPreferences("User_Info",0);
        Intent intent = getIntent();
        int b = intent.getIntExtra(ImageListView.BITMAP_ID,0);
        int  n= intent.getIntExtra("Name_id",0);
        int p = intent.getIntExtra("Price_id",0);
        final int in = intent.getIntExtra("Ingrediants_id",0);
        pos=intent.getIntExtra("Pos",0);
        Toast.makeText(this,Integer.toString(pos),Toast.LENGTH_LONG).show();
        plus=(Button) findViewById(R.id.plus);
        minus=(Button) findViewById(R.id.minus);
        cart=(Button) findViewById(R.id.add_to_cart);
        for (int i = 0; i < 25; i++) {
            ordr_summary.add("Null");
            ordr_price.add(-1);
        }
        quantity=(TextView) findViewById(R.id.quantity_number);

        imageView = (ImageView) findViewById(R.id.imageViewFull);
        item_name=(TextView)findViewById(R.id.Item_name);
        item_price=(TextView)findViewById(R.id.Item_price);
        item_ingrediants=(TextView)findViewById(R.id.Item_ingrediants);

        imageView.setImageBitmap(GetAllImages.bitmaps[b]);
        item_name.setText(GetAllImages.Names[n]);
        item_ingrediants.setText(GetAllImages.ingrediants[in]);
        item_price.setText(GetAllImages.prices[p]);

        quant=quantity.getText().toString(); //quantity converted in string
        q=Integer.parseInt(quant);  // quantity converted in integer

        product_name=item_name.getText().toString(); // name to be used in cart screen

        cost=item_price.getText().toString(); // used for sending it to cart screen
        price=Integer.parseInt(cost); // price converted to int
        plus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                quant=quantity.getText().toString(); //quantity converted in string
                q=Integer.parseInt(quant);  // quantity converted in integer
                q++;
                price_item=price*q;
                quant=String.valueOf(q);
                quantity.setText(quant);
            }
        });

        minus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(q>0)
                {
                    quant=quantity.getText().toString(); //quantity converted in string
                    q=Integer.parseInt(quant);  // quantity converted in integer
                    q--;
                    price_item=price*q;
                    quant=String.valueOf(q);
                    quantity.setText(quant);
                }
                else
                {
                    quantity.setText(quant);
                    price_item=price*q;
                }
            }
        });

        cart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
               // price=price*q;
                if(q==0)
                {
                    ViewFullImage.ordr_summary.set(pos,"Null");
                    ViewFullImage.ordr_price.set(pos,-1);
                    alertDialog.setTitle("Order Details");
                    alertDialog.setMessage("No of items cannot be zero");
                    alertDialog.setButton(android.support.v7.app.AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            alertDialog.dismiss();

                        }
                    });
                    alertDialog.show();
                }
                else {
                    flag = 1;
                    result += mpref.getString("order_info", "") + "Item1: " + product_name + "\n" + "Quantity:" + quant + "\n" + "Price:" + String.valueOf(price_item) + "\n" + "_____________________________________" + "\n";

                    total_price = mpref.getInt("Total_Order_Price", 0) + price_item;
                    editor.putString("order_info", result);

                    editor.putInt("Total_Order_Price", total_price);
                    editor.apply();
                    //orderinfo=mpref.getString("order_info","Empty");
                    ordr_summary.set(pos, "Item1: " + product_name + "\n" + "Quantity:" + quant + "\n" + "Price:" + String.valueOf(price_item));
                    ordr_price.set(pos, price_item);
                    //Intent intent = new Intent(ViewFullImage.this, Cart.class);
                    // intent.putExtra("product name", product_name);
                 //   intent.putExtra("product name", result);
                   // intent.putExtra("price", total_price);
                    //startActivity(intent);
                  Toast.makeText(getApplicationContext(),"Item has been added to cart",Toast.LENGTH_LONG).show();
                    Intent i=new Intent(ViewFullImage.this,MenuCategories.class);
                    startActivity(i);

                }


            }
        });

    }

    public void shareText(View view)
    {
        Intent intent = new Intent(android.content.Intent.ACTION_SEND);
        intent.setType("text/plain");
        String shareBodyText = "Your shearing message goes here";
        intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject/Title");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
        startActivity(Intent.createChooser(intent, "Choose sharing method"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.action_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.share:
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBodyText = "So Awesome Food at very afforable price such as "+product_name;
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"Food Basket! Food for all the hoogers ");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
                startActivity(Intent.createChooser(sharingIntent, "Shearing Option"));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
