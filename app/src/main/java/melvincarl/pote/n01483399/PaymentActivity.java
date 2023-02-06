//Name: Melvin Carl Pote; Student number: N01483399; Section: A
package melvincarl.pote.n01483399;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class PaymentActivity extends OptionsMenuActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    EditText firstName, lastName, postalCode, creditCardNumber, nameAddress, phoneNumber, CVVValue;
    ImageButton completePayment;

    boolean allFieldsChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //for the Spinner in the payment screen
        spinner = findViewById(R.id.countrySpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Countries, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        //for the payment screen validation
        firstName = findViewById(R.id.FirstName);
        lastName = findViewById(R.id.LastName);
        postalCode = findViewById(R.id.PostalCode);
        nameAddress = findViewById(R.id.Address);
        creditCardNumber = findViewById(R.id.CreditCardNumber);
        phoneNumber = findViewById(R.id.PhoneNumber);
        CVVValue = findViewById(R.id.CVVCard);

        completePayment = findViewById(R.id.CompletePayment);

        completePayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View complete) {
                allFieldsChecked = CheckPaymentFields();

                if (allFieldsChecked) {
                    onBackPressed();
                }
            }
        });


    }


    //Spinner text
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String choice = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(getApplicationContext(), choice, Toast.LENGTH_SHORT).show();
    }

    //not necessary; it appeared when creating the onItemSelected
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    //Payment screen validation
    private boolean CheckPaymentFields() {
        if (firstName.length() == 0) {
            firstName.setError("This field is required");
            return false;
        }

        if (lastName.length() == 0) {
            lastName.setError("This field is required");
            return false;
        }

        if (postalCode.length() == 0) {
            postalCode.setError("This field is required");
            return false;
        } else if (postalCode.length() < 6) {
            postalCode.setError("Please enter a valid postal code or zip code");
            return false;
        }

        if (creditCardNumber.length() == 0) {
            creditCardNumber.setError("This field is required");
            return false;
        } else if (creditCardNumber.length() < 16) {
            creditCardNumber.setError("Please enter a valid credit card number!");
            return false;
        }

        if (nameAddress.length() == 0) {
            nameAddress.setError("This field is required.");
            return false;
        }

        if (phoneNumber.length() == 0) {
            phoneNumber.setError("This field is required");
            return false;
        }

        if (CVVValue.length() == 0) {
            CVVValue.setError("This field is required");
            return false;
        } else if (CVVValue.length() < 3) {
            CVVValue.setError("Please enter a proper CVV value.");
            return false;
        }

        //returns true after the validation is correct
        return true;
    }
    @Override
    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(PaymentActivity.this);

        builder.setMessage("Your request is being processed.");
        builder.setTitle("Success!");
        builder.setCancelable(false);

        builder.setPositiveButton("OK",(DialogInterface.OnClickListener) (dialog, which) ->{
            Intent intent = new Intent(PaymentActivity.this,PoteActivity.class);
            startActivity(intent);
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

}
