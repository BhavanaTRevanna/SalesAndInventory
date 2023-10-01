package com.Practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonParser;

public class JSONDATATest {
	public static void main(String[] args) throws Throwable, Throwable, Throwable {
		JSONParser p=new JSONParser();
		Object obj = p.parse(new FileReader(".\\src\\test\\resources\\jsonFile.json"));
		
		JSONObject map=(JSONObject) obj;
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("url"));
		System.out.println(map.get("browser"));
		
		
	}

}
