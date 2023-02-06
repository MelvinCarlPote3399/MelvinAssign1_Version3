package melvincarl.pote.n01483399;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;

public class ApartmentActivity extends OptionsMenuActivity {

    //creating a variable of type image button
    ImageButton apartmentImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartment_screen);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkBox3);

        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox)v).isChecked()){
                    Toast.makeText(ApartmentActivity.this,"Apartment 1 selected",Toast.LENGTH_SHORT).show();
                }
            }
        });

        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                if (((CheckBox)v2).isChecked()){
                    Toast.makeText(ApartmentActivity.this,"Apartment 2 selected",Toast.LENGTH_SHORT).show();
                }
            }
        });

        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v3) {
                if (((CheckBox)v3).isChecked()){
                    Toast.makeText(ApartmentActivity.this,"Apartment 3 selected",Toast.LENGTH_SHORT).show();
                }
            }
        });


        apartmentImageButton = (ImageButton) findViewById(R.id.ProceedPayment);
        apartmentImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!checkBox1.isChecked() && !checkBox2.isChecked() && !checkBox3.isChecked()){
                    Toast.makeText(ApartmentActivity.this,"Please select an option!",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent goToPayment = new Intent(ApartmentActivity.this,PaymentActivity.class);
                    startActivity(goToPayment);
                }
            }
        });



    }
}