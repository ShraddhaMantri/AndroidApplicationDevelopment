package com.cs442.ssamant4.foodbasket;

import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CkeckoutScreen extends AppCompatActivity {
Button confirm_ship;
    Button cancel_pay;
    AlertDialog alertDialog;
    String value="";
    EditText Name,address,city,state,zip,phone,cardnumber,doe,cvv;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        alertDialog = new AlertDialog.Builder(this).create();
        setContentView(R.layout.activity_ckeckout_screen);
        Name=(EditText)findViewById(R.id.fullname);
        address=(EditText)findViewById(R.id.address1);
        city=(EditText)findViewById(R.id.city_edit_text);
        state=(EditText)findViewById(R.id.state);
        zip=(EditText)findViewById(R.id.zip);
        phone=(EditText)findViewById(R.id.phone);
        cardnumber=(EditText)findViewById(R.id.cardno);
        doe=(EditText)findViewById(R.id.expirydate);
        cvv=(EditText)findViewById(R.id.cvv);


    }
    public void display_payment_popup(View view)
    {
        if(Name.getText().toString().equals("")||address.getText().toString().equals("")||city.getText().toString().equals("")||state.getText().toString().equals("")||zip.getText().toString().equals("")||phone.getText().toString().equals(""))
        {
            alertDialog.setTitle("Address Details");
            alertDialog.setMessage("One or more fields are empty");
            alertDialog.setButton(android.support.v7.app.AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(),"Thank you",Toast.LENGTH_LONG);


                }
            });
            alertDialog.show();
        }
        else {
            final Dialog dialog = new Dialog(CkeckoutScreen.this);
            dialog.setContentView(R.layout.payment_popup);
            dialog.setTitle("Shipping Address");
            dialog.show();


            confirm_ship = (Button) dialog.findViewById(R.id.btn_confirm_pay);

            confirm_ship.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {

                    dialog.dismiss();
                    Log.i("My message", "confirmed payment");
                    for (int i = 0; i < ViewFullImage.ordr_summary.size(); i++) {
                        ViewFullImage.ordr_summary.set(i, "Null");
                        ViewFullImage.ordr_price.set(i, -1);
                        ViewFullImage.flag = 0;
                    }
                    cardnumber=(EditText) dialog.findViewById(R.id.cardno);
                    doe=(EditText)dialog.findViewById(R.id.expirydate);
                    cvv=(EditText)dialog.findViewById(R.id.cvv);
                    if(cardnumber.getText().toString().equals("")||doe.getText().toString().equals("")||cvv.getText().toString().equals(""))
                    {
                        alertDialog.setTitle("Payment details");
                        alertDialog.setMessage("Please enter all the fields");
                        alertDialog.setButton(android.support.v7.app.AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "Thank you", Toast.LENGTH_LONG);
                                Intent i = new Intent(getApplicationContext(), MenuCategories.class);
                                startActivity(i);

                            }
                        });
                        alertDialog.show();

                    }
                    else {
                        alertDialog.setTitle("Order Confirmation");
                        alertDialog.setMessage("Your order has placed successfully");
                        alertDialog.setButton(android.support.v7.app.AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "Thank you", Toast.LENGTH_LONG);
                                Intent i = new Intent(getApplicationContext(), MenuCategories.class);
                                startActivity(i);

                            }
                        });
                        alertDialog.show();

                        addNotification();
                    }



                }
            });
            cancel_pay = (Button) dialog.findViewById(R.id.btn_cancel_pay);

            cancel_pay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("My message", "cancelled payment");
                    dialog.dismiss();
                }
            });
        }

    }

    public void addNotification()
    {
        NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.notify)
                .setContentTitle("Food Basket")
                .setContentText("We received your order. It will be delivered soon");

        Intent Nintent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, Nintent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(1, builder.build());
    }


}