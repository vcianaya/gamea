package com.anaya.victor.gamea.entities;

import com.anaya.victor.gamea.network.RetrofitBuilder;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;

public class Utils {
    public static RegisterErr registerErrConverter(ResponseBody response){
        Converter<ResponseBody, RegisterErr> converter = RetrofitBuilder.getRetrofit().responseBodyConverter(RegisterErr.class, new Annotation[0]);
        RegisterErr registerErr = null;
        try {
            registerErr = converter.convert(response);
        }catch (IOException e){
            e.printStackTrace();
        }
        return registerErr;
    }

    public static LoginError loginErrorConver(ResponseBody response){
        Converter<ResponseBody, LoginError> converter = RetrofitBuilder.getRetrofit().responseBodyConverter(LoginError.class, new Annotation[0]);
        LoginError loginError = null;
        try {
            loginError = converter.convert(response);
        }catch (IOException e){
            e.printStackTrace();
        }
        return loginError;
    }
}
