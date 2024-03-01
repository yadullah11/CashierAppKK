package com.example.tugaspb;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RadioGroup kebabRadioGroup, memberRadioGroup;
    private RadioButton originalRadioButton, cheeseRadioButton, beefRadioButton;
    private RadioButton regularRadioButton, goldRadioButton, platinumRadioButton;
    private EditText quantityEditText;

    private Button orderButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi view
        kebabRadioGroup = findViewById(R.id.radioGroupKebab);
        originalRadioButton = findViewById(R.id.radioButtonOriginal);
        cheeseRadioButton = findViewById(R.id.radioButtonCheese);
        beefRadioButton = findViewById(R.id.radioButtonBeef);

        memberRadioGroup = findViewById(R.id.radioGroupMember);
        regularRadioButton = findViewById(R.id.radioButtonRegular);
        goldRadioButton = findViewById(R.id.radioButtonGold);
        platinumRadioButton = findViewById(R.id.radioButtonPlatinum);

        quantityEditText = findViewById(R.id.editTextQuantity);

        orderButton = findViewById(R.id.buttonOrder);
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hitungTotalHarga();
            }
        });


    }

    private void hitungTotalHarga() {

        int hargakebab = 0;

        int selectedkebabId = kebabRadioGroup.getCheckedRadioButtonId();
        if (selectedkebabId == originalRadioButton.getId()) {
            hargakebab = 10000;
        } else if (selectedkebabId == cheeseRadioButton.getId()) {
            hargakebab = 12000;
        } else if (selectedkebabId == beefRadioButton.getId()) {
            hargakebab = 15000;
        }

        int jumlah = Integer.parseInt(quantityEditText.getText().toString());

        int diskonMember = 0;
        int selectedMemberId = memberRadioGroup.getCheckedRadioButtonId();
        if (selectedMemberId == regularRadioButton.getId()) {
            diskonMember = 0;
        } else if (selectedMemberId == goldRadioButton.getId()) {
            diskonMember = 10;
        } else if (selectedMemberId == platinumRadioButton.getId()) {
            diskonMember = 20;
        }

        int totalHarga = (hargakebab * jumlah) - (hargakebab * jumlah * diskonMember / 100);
        if (selectedkebabId == cheeseRadioButton.getId()) {
            tampilkanDialog("Harga Cheese kebab : " + hargakebab + "                                                  Jumlah : " + jumlah + "                                                       Total Harga : " + totalHarga );
        } else if (selectedkebabId == originalRadioButton.getId()) {
            tampilkanDialog("Harga Original kebab : " + hargakebab + "                                                  Jumlah : " + jumlah + "                                                       Total Harga : " + totalHarga );
        } else if (selectedkebabId == beefRadioButton.getId()) {
            tampilkanDialog("Harga Beef kebab : " + hargakebab + "                                                  Jumlah : " + jumlah + "                                                       Total Harga : " + totalHarga );

        }
    }

    private void tampilkanDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("                   King Kebab")
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }



}