package com.example.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.jar.Attributes;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    public int quantity = 2;
    public int whippingCost = 1;
    public int chocoCost = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        //to get the state of the checkbox
        CheckBox whipped = findViewById(R.id.checkBox);
        boolean hasWhippedCream = whipped.isChecked();
        //getting the state of choco and storing it in the variable
        CheckBox choco = findViewById(R.id.checkBox2);
        boolean hasChoco = choco.isChecked();

        //getting the name of the customer
        EditText name = findViewById(R.id.name);
        Editable cname = name.getText();

        display(quantity);
        int price = calculatePrice(hasWhippedCream,hasChoco);
        String summary = createOrderSummary(cname,price,hasWhippedCream,hasChoco);
//        TextView textView2 = findViewById(R.id.order_summary_text_view);
//        textView2.setText(summary);
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setData(Uri.parse("geo:47.6,-122.3"));
//        if(intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }

        //sending the summary to the mail via intent
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
//        intent.putExtra(Intent.EXTRA_EMAIL, "justjavacoffee@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java Order for "+ cname);
        intent.putExtra(Intent.EXTRA_TEXT, summary);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    //To create a summary of the order
    public String createOrderSummary(Editable cname,int price, boolean hasWhippedCream, boolean hasChocolate) {
        String priceMessage = "Name: "+ cname;
        priceMessage = priceMessage+"\nAdd whipped cream? "+ hasWhippedCream;
        priceMessage = priceMessage+"\nAdd chocolate? "+ hasChocolate;
        priceMessage = priceMessage + "\nQuantity: "+ quantity;
        priceMessage = priceMessage + "\nPrice: "+ price;
        priceMessage = priceMessage + "\nThank You !";
        return  priceMessage;
    }
    //To calculate the price of the coffee
    public int calculatePrice(boolean hasWhippedCream, boolean hasChoco) {
        int calPrice = 0;
        int costPerCup = 15;
        if(hasWhippedCream && hasChoco) {
            calPrice = costPerCup + whippingCost + chocoCost;
        } else if(hasWhippedCream) {
            calPrice = costPerCup + whippingCost;
        } else if(hasChoco) {
            calPrice = costPerCup + chocoCost;
        } else {
            calPrice = costPerCup;
        }
            return (calPrice * quantity);


    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(""+number);
    }

    public void decrement(View view) {
//        int quantity = 2;
        if(quantity == 1) {
            Toast.makeText(this, "You can not order less than a cup of coffee.", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        display(quantity);
    }

    public void increment(View view) {
//        int quantity = 2;
        if(quantity == 100) {
            Toast.makeText(this, "You can not order more than 100 cups.", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        display(quantity);
    }
}