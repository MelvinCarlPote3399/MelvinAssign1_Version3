package melvincarl.pote.n01483399;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RentActivity extends AppCompatActivity {

    //creating a variable of type image button
    ImageButton rentImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent);

        //Back button code
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Radio group and its radio buttons
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.HomeTypeGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton rb1 = (RadioButton) findViewById(R.id.Apartment);
                RadioButton rb2 = (RadioButton) findViewById(R.id.Detached_home);
                if(rb1.isChecked()){
                    DisplayToast();
                }
                else{
                    DisplayToast2();
                }

            }
        });

        ImageButton rentImageButton;

        rentImageButton = (ImageButton) findViewById(R.id.RentButton);
        rentImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToVisitScreen = new Intent(RentActivity.this,VisitScreen.class);
                startActivity(goToVisitScreen);
            }
        });

    }

    public void DisplayToast() {
        Toast.makeText(RentActivity.this,"Apartment selected!",Toast.LENGTH_LONG).show();
    }

    public void DisplayToast2(){
        Toast.makeText(RentActivity.this,"Detached home selected!",Toast.LENGTH_LONG).show();
    }




}