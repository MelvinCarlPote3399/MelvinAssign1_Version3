//Name: Melvin Carl Pote; Student number: N01483399; Section: A
package melvincarl.pote.n01483399;

import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;



public class OptionsMenuActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.appbar_menu,menu);
        return true;
    }

    public boolean onOptionItemSelected(MenuItem item){
        switch (item.getItemId()){

            case R.id.callRent:
                Intent phoneCall = new Intent(Intent.ACTION_VIEW);
                phoneCall.setData(Uri.parse("Tel:"));
                startActivity(phoneCall);
                return true;

            case R.id.HelpScreen:
                Uri url = Uri.parse("http://www.google.ca");
                Intent i = new Intent(Intent.ACTION_VIEW,url);
                startActivity(i);
                return true;

            case R.id.goHome:
                Intent homeScreen = new Intent(OptionsMenuActivity.this,PoteActivity.class);
                startActivity(homeScreen);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
