package com.anaya.victor.gamea;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.anaya.victor.gamea.entities.AccessToken;
import com.anaya.victor.gamea.entities.RegisterErr;
import com.anaya.victor.gamea.entities.TokenManager;
import com.anaya.victor.gamea.entities.Utils;
import com.anaya.victor.gamea.network.ApiService;
import com.anaya.victor.gamea.network.RetrofitBuilder;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.lang.annotation.Annotation;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    Button btn_register;

    TextInputLayout til_date, til_ci, til_nombre,til_apellido,til_telefono,til_zona,til_email,til_password,til_password_confirm;
    TextInputEditText edt_fec_nac;
    MaterialBetterSpinner sp_distrito;
    AwesomeValidation validator;
    String distrito;
    Toolbar toolbar;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    //API SERVICE
    ApiService service;
    Call<AccessToken>call;
    // TOKEN MANAGER
    TokenManager tokenManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        validator = new AwesomeValidation(ValidationStyle.TEXT_INPUT_LAYOUT);
        init();
        tokenManager = TokenManager.getInstance(getSharedPreferences("prefs",MODE_PRIVATE));
        setupRules();
        service = RetrofitBuilder.createService(ApiService.class);
    }

    private void init() {
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Registrarme");

        //INITIALIZE UI
        til_ci = (TextInputLayout)findViewById(R.id.til_ci);
        til_nombre = (TextInputLayout)findViewById(R.id.til_nombre);
        til_apellido = (TextInputLayout)findViewById(R.id.til_apellido);
        til_date = (TextInputLayout) findViewById(R.id.til_fec_nac);
        til_telefono = (TextInputLayout)findViewById(R.id.til_telefono);
        til_zona = (TextInputLayout)findViewById(R.id.til_zona);
        til_email = (TextInputLayout)findViewById(R.id.til_email);
        til_password = (TextInputLayout)findViewById(R.id.til_password);
        til_password_confirm = (TextInputLayout)findViewById(R.id.til_password_confirm);

        btn_register = (Button)findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Esta seguro de crear su cuenta..?");
                builder.setMessage("Por favor verifique  sus datos");
                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        validator.clear();
                        if (validator.validate()){
                            register();
                        }else{
                            Toast.makeText(getApplicationContext(),"Algo salio mal",Toast.LENGTH_LONG).show();
                        }
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
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
                til_date.getEditText().setText(year+"/"+month+"/"+day);
            }
        };

        String[] SPINNERLIST = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, SPINNERLIST);
        sp_distrito = (MaterialBetterSpinner)findViewById(R.id.sp_distrito);
        sp_distrito.setAdapter(arrayAdapter);
        sp_distrito.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                distrito = parent.getItemAtPosition(position).toString();
            }
        });
    }
    private void register(){
        call = service.resgister_usuario(
                til_ci.getEditText().getText().toString(),til_nombre.getEditText().getText().toString(),til_apellido.getEditText().getText().toString(),til_date.getEditText().getText().toString(),til_telefono.getEditText().getText().toString(),til_email.getEditText().getText().toString(),til_zona.getEditText().getText().toString(),distrito,til_password.getEditText().getText().toString(),til_password_confirm.getEditText().getText().toString()
        );
        call.enqueue(new Callback<AccessToken>() {
            @Override
            public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                if (response.isSuccessful()){
                    tokenManager.saveToken(response.body());
                    startActivity(new Intent(RegisterActivity.this, PrincipalActivity.class));
                    finish();
                }else{
                    if (response.code() == 422){
                        handleErrors(response.errorBody());
                    }
                }
            }

            @Override
            public void onFailure(Call<AccessToken> call, Throwable t) {
                Log.w("Error_network",t.getMessage());
            }
        });
    }

    private void handleErrors(ResponseBody response){
        RegisterErr registerErr = Utils.registerErrConverter(response);
        if (registerErr.getCi() != null)
            til_ci.setError(registerErr.getCi().get(0));
        if (registerErr.getNombre() != null)
            til_nombre.setError(registerErr.getNombre().get(0));
        if (registerErr.getApellido() != null)
            til_apellido.setError(registerErr.getApellido().get(0));
        if (registerErr.getFechaNacimiento() != null)
            til_date.setError(registerErr.getFechaNacimiento().get(0));
        if (registerErr.getDistrito() != null)
            sp_distrito.setError(registerErr.getDistrito().get(0));
        if (registerErr.getEmail() != null)
            til_email.setError(registerErr.getEmail().get(0));
        if (registerErr.getPassword() != null)
            til_password.setError(registerErr.getPassword().get(0));
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (call != null){
            call.cancel();
        }
    }
}
