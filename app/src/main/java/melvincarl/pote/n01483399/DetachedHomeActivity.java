package melvincarl.pote.n01483399;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Objects;

public class DetachedHomeActivity extends AppCompatActivity {

    ImageButton detachedhomeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detached_home);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        CheckBox house1 = (CheckBox) findViewById(R.id.houseBox1);
        CheckBox house2 = (CheckBox) findViewById(R.id.houseBox2);
        CheckBox house3 = (CheckBox) findViewById(R.id.houseBox3);

        house1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View h1) {
                if(((CheckBox)h1).isChecked()){
                    Toast.makeText(DetachedHomeActivity.this, "House 1 selected", Toast.LENGTH_SHORT).show();
                }
            }
        });

        house2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View h2) {
                if(((CheckBox)h2).isChecked()){
                    Toast.makeText(DetachedHomeActivity.this,"House 2 selected",Toast.LENGTH_SHORT).show();
                }
            }
        });

        house3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View h3) {
                if(((CheckBox)h3).isChecked()){
                    Toast.makeText(DetachedHomeActivity.this,"House 3 selected",Toast.LENGTH_SHORT).show();
                }
            }
        });

        detachedhomeButton = (ImageButton) findViewById(R.id.ProceedPayment2);
        detachedhomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View detachHome) {
                if (!house1.isChecked() && !house2.isChecked() && !house3.isChecked()){
                    Toast.makeText(DetachedHomeActivity.this,"Please select an option!",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent goToPayment2 = new Intent(DetachedHomeActivity.this,PaymentActivity.class);
                    startActivity(goToPayment2);
                }
            }
        });



    }
}