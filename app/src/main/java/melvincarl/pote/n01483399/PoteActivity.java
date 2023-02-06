//Name: Melvin Carl Pote; Student number: N01483399; Section: A
package melvincarl.pote.n01483399;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PoteActivity extends OptionsMenuActivity {

    private  Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.poteactivity);
        button = (Button) findViewById(R.id.enter_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRentActivity();
            }
        });

    }
    public void openRentActivity() {
        Intent intent = new Intent(this, RentActivity.class);
        startActivity(intent);
    }

}