package com.anaya.victor.gamea.entities;

import java.util.List;

import com.squareup.moshi.Json;
public class RegisterErr{

	@Json(name = "fecha_nacimiento")
	private List<String> fechaNacimiento;

	@Json(name = "distrito")
	private List<String> distrito;

	@Json(name = "password")
	private List<String> password;

	@Json(name = "ci")
	private List<String> ci;

	@Json(name = "apellido")
	private List<String> apellido;

	@Json(name = "nombre")
	private List<String> nombre;

	@Json(name = "email")
	private List<String> email;

	public void setFechaNacimiento(List<String> fecNac){
		this.fechaNacimiento = fecNac;
	}

	public List<String> getFechaNacimiento(){
		return fechaNacimiento;
	}

	public void setDistrito(List<String> distrito){
		this.distrito = distrito;
	}

	public List<String> getDistrito(){
		return distrito;
	}

	public void setPassword(List<String> password){
		this.password = password;
	}

	public List<String> getPassword(){
		return password;
	}

	public void setCi(List<String> ci){
		this.ci = ci;
	}

	public List<String> getCi(){
		return ci;
	}

	public void setApellido(List<String> apellido){
		this.apellido = apellido;
	}

	public List<String> getApellido(){
		return apellido;
	}

	public void setNombre(List<String> nombre){
		this.nombre = nombre;
	}

	public List<String> getNombre(){
		return nombre;
	}

	public void setEmail(List<String> email){
		this.email = email;
	}

	public List<String> getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"RegisterErr{" + 
			"fec_nac = '" + fechaNacimiento + '\'' +
			",distrito = '" + distrito + '\'' + 
			",password = '" + password + '\'' + 
			",ci = '" + ci + '\'' + 
			",apellido = '" + apellido + '\'' + 
			",nombre = '" + nombre + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}