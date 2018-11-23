package com.anaya.victor.gamea;


import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {
    Button btn_register;

    TextInputLayout til_date, til_ci, til_nombre,til_apellido,til_telefono,til_zona,til_password,til_password_confirm;
    TextInputEditText edt_fec_nac;
    MaterialBetterSpinner sp_distrito;
    AwesomeValidation validator;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        validator = new AwesomeValidation(ValidationStyle.TEXT_INPUT_LAYOUT);
        init();
        setupRules();
    }

    private void init() {
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Registrarme");
        actionBar.setHomeButtonEnabled(true);
        //INITIALIZE UI
        til_ci = (TextInputLayout)findViewById(R.id.til_ci);
        til_nombre = (TextInputLayout)findViewById(R.id.til_nombre);
        til_apellido = (TextInputLayout)findViewById(R.id.til_apellido);
        til_date = (TextInputLayout) findViewById(R.id.til_fec_nac);
        til_telefono = (TextInputLayout)findViewById(R.id.til_telefono);
        til_zona = (TextInputLayout)findViewById(R.id.til_zona);
        til_password = (TextInputLayout)findViewById(R.id.til_password);
        til_password_confirm = (TextInputLayout)findViewById(R.id.til_password_confirm);

        btn_register = (Button)findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validator.clear();
                if (validator.validate()){
                    Toast.makeText(getApplicationContext(),"Paso",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Algo salio mal",Toast.LENGTH_LONG).show();
                }
                //startActivity(new Intent(RegisterActivity.this, PrincipalActivity.class));
            }
        });
        edt_fec_nac = (TextInputEditText)findViewById(R.id.edt_fec_nac);
        edt_fec_nac.setKeyListener(null);
        til_date.getEditText().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard(v);
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(RegisterActivity.this,
                        mDateSetListener,
                        year,month,day);
                dialog.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month+1;
                til_date.getEditText().setText(month+"/"+day+"/"+year);
            }
        };

        String[] SPINNERLIST = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, SPINNERLIST);
        sp_distrito = (MaterialBetterSpinner)findViewById(R.id.sp_distrito);
        sp_distrito.setAdapter(arrayAdapter);
    }

    public void setupRules(){
        validator.addValidation(this,R.id.til_ci, RegexTemplate.NOT_EMPTY,R.string.required);
        validator.addValidation(this,R.id.til_nombre, RegexTemplate.NOT_EMPTY,R.string.required);
        validator.addValidation(this,R.id.til_apellido, RegexTemplate.NOT_EMPTY,R.string.required);
        validator.addValidation(this,R.id.til_fec_nac, RegexTemplate.NOT_EMPTY,R.string.required);
        validator.addValidation(this,R.id.til_zona, RegexTemplate.NOT_EMPTY,R.string.required);
        validator.addValidation(this,R.id.til_password, RegexTemplate.NOT_EMPTY,R.string.required);
        validator.addValidation(this,R.id.til_password_confirm, RegexTemplate.NOT_EMPTY,R.string.required);

    }

    private void hideKeyboard(View v){
        InputMethodManager imm = (InputMethodManager) RegisterActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}
