package com.Application.GitContent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Arrays;

public class GitUsuarioContent {
	private List<String> Lista(String elemento){
		return Arrays.asList((elemento.split(",")));
	}
	
	private List<String> GetAvatar(List<String> lista) {
		int calculo1;
		int calculo2;
		List<String> corretos = new ArrayList<>();
		for(String valor: lista) {
			if(valor.contains("avatar_url") && valor.contains("https")) {
				calculo1 = valor.indexOf("http");
				calculo2 = valor.length();
				corretos.add(valor.substring(calculo1,calculo2));
				return corretos;
			}
		}
		return null;
	}
	
	private List<String> Filtro(String elemento){
		List<String> item = Lista(elemento);
		List<String> corretos = new ArrayList<>();
		List<String> avatar = GetAvatar(item);
		int calculo1;
		int calculo2;
		for(String valor : item) {
			if(valor.contains("html_url") && valor.chars().filter(ch -> ch == '/').count() == 4) {
				calculo1 = valor.indexOf("http");
				calculo2 = valor.length();
				corretos.add(valor.substring(calculo1,calculo2));
			}
		}
		return (Stream.concat(avatar.stream(), corretos.stream())
                             .collect(Collectors.toList()));
	}
	
	
	private static String getUrlContents(String theUrl)  
	  {  
	    StringBuilder content = new StringBuilder();  
	    try  
	    {  
	      URL url = new URL(theUrl);  
	      URLConnection urlConnection = url.openConnection();
	      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));  
	      String line;  
	      while ((line = bufferedReader.readLine()) != null)  
	      {  
	        content.append(line + "\n");  
	      }  
	      bufferedReader.close();  
	    }  
	    catch(Exception e)  
	    {  
	      e.printStackTrace();  
	    }  
	    return content.toString();  
	  }  
	
	public List<String> GitFunction(String url) {
		return Filtro(getUrlContents(modificador(url)));
	}
	
	public String modificador(String gitHubUsuario) {
		return (gitHubUsuario.replace("github.com/", "api.github.com/users/") + "/repos");
	}
	
}
