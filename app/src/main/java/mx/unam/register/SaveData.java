package mx.unam.register;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SaveData extends AppCompatActivity {

    private TextView tvName;
    private TextView tvPhone;
    private TextView tvEmail;
    private TextView tvDesc;
    private String day;
    private String month;
    private String year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_data);

        Bundle parameters = getIntent().getExtras();
        String name  = parameters.getString(getResources().getString(R.string.j_name));
        String phone = parameters.getString(getResources().getString(R.string.j_phone));
        String email = parameters.getString(getResources().getString(R.string.j_email));
        String desc  = parameters.getString(getResources().getString(R.string.j_desc));
        String date  = parameters.getString(getResources().getString(R.string.j_date));
        day  = parameters.getString(getResources().getString(R.string.j_dayOfMonth));
        month  = parameters.getString(getResources().getString(R.string.j_month));
        year  = parameters.getString(getResources().getString(R.string.j_year));
        String newDate;
        TextView tvDate;

        tvName = findViewById(R.id.name);
        tvPhone = findViewById(R.id.phone);
        tvEmail = findViewById(R.id.email);
        tvDesc = findViewById(R.id.desc);
        tvDate = findViewById(R.id.bornDate);

        newDate = day + "/" + month + "/" + year;

        tvName.setText(name);
        tvPhone.setText(phone);
        tvEmail.setText(email);
        tvDesc.setText(desc);
        tvDate.setText(newDate);
    }

    public void editText(View v){
        Intent intent = new Intent(SaveData.this, MainActivity.class);
        intent.putExtra(getResources().getString(R.string.j_name), tvName.getText());
        intent.putExtra(getResources().getString(R.string.j_phone), tvPhone.getText());
        intent.putExtra(getResources().getString(R.string.j_email), tvEmail.getText());
        intent.putExtra(getResources().getString(R.string.j_desc), tvDesc.getText());
        intent.putExtra(getResources().getString(R.string.j_dayOfMonth), day);
        intent.putExtra(getResources().getString(R.string.j_month), month);
        intent.putExtra(getResources().getString(R.string.j_year), year);
        startActivity(intent);
    }
}