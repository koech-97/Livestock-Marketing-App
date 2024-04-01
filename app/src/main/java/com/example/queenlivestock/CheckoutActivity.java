package com.example.queenlivestock;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        // Retrieve product details from intent extras
        String productName = getIntent().getStringExtra("productName");
        String productPrice = getIntent().getStringExtra("productPrice");
        String productImage = getIntent().getStringExtra("productImage");

        // Initialize views
        ImageView imageViewProduct = findViewById(R.id.imageViewProduct);
        TextView textViewProductName = findViewById(R.id.textViewProductName);
        TextView textViewPrice = findViewById(R.id.textViewPrice);
        Button btnCheckout = findViewById(R.id.buttonCheckout);

        // Set product details to views
        textViewProductName.setText(productName);
        textViewPrice.setText("Price: " + productPrice);
        if (productImage != null && !productImage.isEmpty()) {
            imageViewProduct.setImageURI(Uri.parse(productImage));
            imageViewProduct.setClipToOutline(true);
            imageViewProduct.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }

        // Handle checkout button click
        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show confirmation dialog
                showDialog();
            }
        });
    }

    private void showDialog() {
        // Create custom dialog
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_confirmation);

        // Initialize views
        TextView textViewTitle = dialog.findViewById(R.id.textViewConfirmationTitle);
        TextView textViewMessage = dialog.findViewById(R.id.textViewConfirmationMessage);
        Button buttonConfirm = dialog.findViewById(R.id.buttonConfirm);
        Button buttonCancel = dialog.findViewById(R.id.buttonCancel);

        // Set dialog content
        textViewTitle.setText("Confirm Checkout");
        textViewMessage.setText("Are you sure you want to checkout this item?");

        // Handle confirm button click
        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform checkout action
                performCheckout();
                // Dismiss dialog
                dialog.dismiss();
            }
        });

        // Handle cancel button click
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dismiss dialog
                dialog.dismiss();
            }
        });

        // Show dialog
        dialog.show();
    }

    private void performCheckout() {
        // Perform checkout action here
        // Add your implementation to complete the checkout process
    }
}
