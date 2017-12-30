package com.cs442.ssamant4.foodbasket;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.text.TextDirectionHeuristicCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabSelectedListener;

public class Cart extends AppCompatActivity {

    TextView cart_title;
    TextView cart_price,cart_order;
    Button checkout;
    AlertDialog alertDialog;
    String cart_product_title;
    int cart_cost,total_price=0;
    String cart_product_price;
    Button cancel_ship;
    Button confirm_ship;
    Button cancel_pay;
    //sohan start bottom menu
    private CoordinatorLayout coordinatorLayout;
    // sohan end bottom menu

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        alertDialog = new AlertDialog.Builder(this).create();
        cart_title = (TextView) findViewById(R.id.Cart_Title);
        cart_price = (TextView) findViewById(R.id.Cart_Price);
        cart_order=(TextView)findViewById(R.id.order_data);
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
                    case R.id.CartScreen:

                        break;
                    case R.id.Home:
                        Intent i=new Intent(getApplicationContext(),MenuCategories.class);
                        startActivity(i);
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


        if (ViewFullImage.flag == 0) {
            cart_order.setText("Currently Cart is empty!!");
        } else {
            cart_order.setText("");
            for (int i = 0; i < ViewFullImage.ordr_summary.size(); i++) {


                if (ViewFullImage.ordr_summary.get(i) != "Null"&&ViewFullImage.ordr_price.get(i)!=-1) {
                    cart_order.setText(cart_order.getText().toString() + " " + ViewFullImage.ordr_summary.get(i) + "\n");
                    total_price=total_price+ViewFullImage.ordr_price.get(i);

                }


            }
            cart_price.setText(cart_price.getText()+Integer.toString(total_price));
        }
    }
    public void confirmaddress(View view) {
         if(cart_order.getText().toString().trim().equals("Currently Cart is empty!!")||cart_order.getText().toString().equals("")) {
             alertDialog.setTitle("Order Details");
             alertDialog.setMessage("Currently Cart is empty!!");
             alertDialog.setButton(android.support.v7.app.AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {

                 @Override
                 public void onClick(DialogInterface dialog, int which) {
                     alertDialog.dismiss();

                 }
             });
             alertDialog.show();
         }

        else {

             Intent i = new Intent(this, CkeckoutScreen.class);
             startActivity(i);
         }
    }
}
