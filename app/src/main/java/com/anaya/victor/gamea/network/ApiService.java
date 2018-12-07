package com.anaya.victor.gamea.network;


import com.anaya.victor.gamea.entities.AccessToken;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("test_server")
    Call<ResponseBody>test_server();
    @POST("login")
    @FormUrlEncoded
    Call<AccessToken> login(@Field("username") String name, @Field("password") String password);

    @POST("logout")
    @FormUrlEncoded
    Call<ResponseBody> logout(@Field("token") String token);

    @POST("refresh")
    @FormUrlEncoded
    Call<AccessToken>refresh(@Field("refresh_token") String refreshToken);

    @POST("register")
    @FormUrlEncoded
    Call<AccessToken>resgister_usuario(@Field("ci") String ci, @Field("nombre") String nombre, @Field("apellido") String apellido, @Field("fecha_nacimiento") String fecha_nacimiento, @Field("telefono") String telefono, @Field("email") String email, @Field("zona") String zona, @Field("distrito") String distrito, @Field("password") String password, @Field("password_confirmation") String password_confirmation);

//    @GET("contacto")
//    Call<RespContact>contactos();
}
