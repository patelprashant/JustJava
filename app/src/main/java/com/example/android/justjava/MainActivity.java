package com.example.android.justjava;

import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    int unitPrice = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * This method is called when the order button is clicked
     *
     * @param view view to pass
     */
    public void submitOrder(View view) {
        int totalPrice = calculatePrice(quantity);
        String priceMessage = createOrderSummary(totalPrice);

        displayMessage(priceMessage);
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextview = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextview.setText(message);
    }

    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method called when the plus button is clicked
     *
     * @param view
     */
    public void increment(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    /**
     * This method called when the minus button is clicked
     *
     * @param view
     */
    public void decrement(View view) {
        quantity--;
        displayQuantity(quantity);
    }

    private int calculatePrice(int quantity) {
        return quantity * unitPrice;
    }

    private String createOrderSummary(int totalPrice) {
        String priceMessage = "Name: Prashant Patel ";
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + totalPrice;
        priceMessage += "\nThank You!";

        return priceMessage;
    }
}
