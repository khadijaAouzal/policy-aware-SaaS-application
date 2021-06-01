package org.sid.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class CurrentTenant {
	
	@Autowired
	HttpServletRequest reuest;
	
	public  JSONObject currentTenant() throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader("./src/main/resources/static/policies_repository.json");
		
		Object obj = jsonParser.parse(reader);
		JSONObject jsonObject= (JSONObject) obj;
		JSONObject core = (JSONObject) jsonObject.get("core");
		JSONObject specific = (JSONObject) core.get("specific");
		JSONArray tenant = (JSONArray) specific.get(reuest.getParameter("id_tenant"));
		JSONObject tenantObj = (JSONObject) tenant.get(0);
		return tenantObj;
		
	}

}
