package com.santander.meetup.room.model;

import java.util.Random;

public class RoomIdGenerator {
	
public static void main (String[] args) {
		
		//Variables para generar el ID aleatorio.
		Random random = new Random();
		String alfa = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String cadena = "";
		int numero;
		int forma;
		
		//Método para calcula el codigo.
		forma=(int) (random.nextDouble() * alfa.length()-1+0);
		
		//Cantidad máxima de número aleatorios
		numero=(int) (random.nextDouble() * 999+100);
		cadena=cadena+alfa.charAt(forma)+numero;
		
		//System.out.println("Tu código es: "+cadena);
	}

}
