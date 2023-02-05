package melvincarl.pote.n01483399;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DetachedHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detached_home);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}