package org.sid.custom_annotation;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.sid.service.CurrentTenant;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class Oauth2TokenImpl implements Condition{

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		CurrentTenant currentTenant = new CurrentTenant();
		try {
			JSONObject tenant =  currentTenant.currentTenant();
			JSONArray authentication = (JSONArray) tenant.get("authentication");
			JSONObject authenticationobj = (JSONObject) authentication.get(0);
			if(authenticationobj.get("variant").equals("oauth2Token"))
				return true;
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
