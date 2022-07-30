package mx.unam.register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.autofill.AutofillValue;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout name;
    private int s_day;
    private int s_month;
    private int s_year;
    private DatePicker date;
    private TextInputLayout phone;
    private TextInputLayout email;
    private TextInputLayout desc ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.TIET_name);
        date = findViewById(R.id.TIET_date);
        phone = findViewById(R.id.TIET_phone);
        email = findViewById(R.id.TIET_email);
        desc  = findViewById(R.id.TIET_desc_contact);

        getDate();

        date.setOnDateChangedListener((date, year, month, day) -> {
            s_day   = day;
            s_month = month + 1;
            s_year  = year;
        });

        Bundle parameters = getIntent().getExtras();
        if (parameters != null) {
            String r_name  = parameters.getString(getResources().getString(R.string.j_name));
            String r_phone = parameters.getString(getResources().getString(R.string.j_phone));
            String r_email = parameters.getString(getResources().getString(R.string.j_email));
            String r_desc  = parameters.getString(getResources().getString(R.string.j_desc));
            int r_day   = Integer.parseInt(parameters.getString(getResources().getString(R.string.j_dayOfMonth)));
            int r_month = Integer.parseInt(parameters.getString(getResources().getString(R.string.j_month)));
            int r_year  = Integer.parseInt(parameters.getString(getResources().getString(R.string.j_year)));

            name .getEditText().setText(r_name);
            phone.getEditText().setText(r_phone);
            email.getEditText().setText(r_email);
            desc .getEditText().setText(r_desc);
            date.updateDate(r_year, r_month - 1, r_day);
        }
    }


    public void sendData(View v){
        Intent intent = new Intent(MainActivity.this, SaveData.class);
        intent.putExtra(getResources().getString(R.string.j_name),  name.getEditText().getText().toString());
        intent.putExtra(getResources().getString(R.string.j_dayOfMonth), String.valueOf(s_day));
        intent.putExtra(getResources().getString(R.string.j_month), String.valueOf(s_month));
        intent.putExtra(getResources().getString(R.string.j_year),  String.valueOf(s_year));
        intent.putExtra(getResources().getString(R.string.j_phone), phone.getEditText().getText().toString());
        intent.putExtra(getResources().getString(R.string.j_email), email.getEditText().getText().toString());
        intent.putExtra(getResources().getString(R.string.j_desc),  desc.getEditText().getText().toString());
        startActivity(intent);
    }

    public void getDate(){
        s_day = date.getDayOfMonth();
        s_month = date.getMonth() + 1;
        s_year = date.getYear();
    }

}