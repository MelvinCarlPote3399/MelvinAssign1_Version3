//Name: Melvin Carl Pote; Student number: N01483399; Section: A
package melvincarl.pote.n01483399;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RentActivity extends OptionsMenuActivity {

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
            public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
                //RadioButton rb1 = (RadioButton) findViewById(R.id.Apartment);
                //RadioButton rb2 = (RadioButton) findViewById(R.id.Detached_home);

                switch (checkId) {
                    case R.id.Apartment:
                        Toast.makeText(RentActivity.this,"Apartment selected!",Toast.LENGTH_LONG).show();
                        break;

                    case R.id.Detached_home:
                        Toast.makeText(RentActivity.this,"Detached home selected!",Toast.LENGTH_LONG).show();
                        break;

                }
                rentImageButton = (ImageButton) findViewById(R.id.RentButton);
                rentImageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (checkId==R.id.Apartment){
                            Intent goToVisitScreen = new Intent(RentActivity.this, ApartmentActivity.class);
                            startActivity(goToVisitScreen);
                        }
                        else if(checkId==R.id.Detached_home){
                            Intent goToSecondVisitScreen = new Intent(RentActivity.this,DetachedHomeActivity.class);
                            startActivity(goToSecondVisitScreen);
                        }
                        else {
                            Toast.makeText(RentActivity.this,"Please select an option",Toast.LENGTH_LONG).show();

                        }

                    }
                });
            }
        });



    }






}