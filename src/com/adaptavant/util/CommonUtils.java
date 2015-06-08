package com.adaptavant.util;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

public class CommonUtils 
{
	private static final Logger	log		= Logger.getLogger( CommonUtils.class.getPackage().getName());
	
	public static HashMap<String, String> getBrodwerDetails(String browserDetails)
	{
		//String userAgent = request.getHeader("User-Agent");
		String 				userAgent 		= 	browserDetails;
		String 				user 			= 	userAgent.toLowerCase();
		String 				os 				= 	"";
		String 				browser 		= 	"";
		HashMap<String, String> userAgentMap=	null;
		try
		{
			log.info("User Agent for the request is===>"+browserDetails);
			userAgentMap	=	new HashMap<String, String>();
			//=================OS=======================
		     if (userAgent.toLowerCase().indexOf("windows") >= 0 )
		     {
		    	 os = "Windows";
		     }
		     else if(userAgent.toLowerCase().indexOf("mac") >= 0)
		     {
		    	 os = "Mac";
		     }
		     else if(userAgent.toLowerCase().indexOf("x11") >= 0)
		     {
		    	 os = "Unix";
		     }else if(userAgent.toLowerCase().indexOf("android") >= 0)
		     {
		    	 os = "Android";
		     }
		     else if(userAgent.toLowerCase().indexOf("iphone") >= 0)
		     {
		    	 os = "IPhone";
		     }else{
		    	 os = "UnKnown,	More-Info: "+userAgent;
		     }
		     //===============Browser===========================
		    if (user.contains("msie"))
		    {
		    	String substring=userAgent.substring(userAgent.indexOf("MSIE")).split(";")[0];
		    	browser=substring.split(" ")[0].replace("MSIE", "IE")+"-"+substring.split(" ")[1];
		    }
		    else if (user.contains("safari") && user.contains("version"))
		    {
		    	browser=(userAgent.substring(userAgent.indexOf("Safari")).split(" ")[0]).split("/")[0]+"-"+(userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
		    }
		    else if ( user.contains("opr") || user.contains("opera"))
		    {
		    	if(user.contains("opera"))
		    		browser=(userAgent.substring(userAgent.indexOf("Opera")).split(" ")[0]).split("/")[0]+"-"+(userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
		    	else if(user.contains("opr"))
		    		browser=((userAgent.substring(userAgent.indexOf("OPR")).split(" ")[0]).replace("/", "-")).replace("OPR", "Opera");
		    }
		    else if (user.contains("chrome"))
		    {
		    	browser=(userAgent.substring(userAgent.indexOf("Chrome")).split(" ")[0]).replace("/", "-");
		    }
		    else if ((user.indexOf("mozilla/7.0") > -1) || (user.indexOf("netscape6") != -1)  || (user.indexOf("mozilla/4.7") != -1) || (user.indexOf("mozilla/4.78") != -1) || (user.indexOf("mozilla/4.08") != -1) || (user.indexOf("mozilla/3") != -1) )
		    {
		    	//browser=(userAgent.substring(userAgent.indexOf("MSIE")).split(" ")[0]).replace("/", "-");
		    	browser = "Netscape-?";
		    		  
		    }
		    else if (user.contains("firefox"))
		    {
		    	browser=(userAgent.substring(userAgent.indexOf("Firefox")).split(" ")[0]).replace("/", "-");
		    }
		    else
		    {
		    	browser = "UnKnown,	More-Info: "+userAgent;
		    }
		    log.info("Operating System======>"+os);
		    log.info("Browser Name==========>"+browser);
		    userAgentMap.put("os", os);
		    userAgentMap.put("browser", browser);
		}
		catch (StringIndexOutOfBoundsException ste) 
		{
			log.log(Level.SEVERE,"Exception while getting browser details"+ste.getMessage(),ste);
			browser = "UnKnown,	More-Info:: "+userAgent;	
			userAgentMap.put("os", os);
		    userAgentMap.put("browser", browser);
		}
		catch (ArrayIndexOutOfBoundsException ae) 
		{
			log.log(Level.SEVERE,"Exception while getting browser details"+ae.getMessage(),ae);
			browser = "UnKnown,	More-Info:: "+userAgent;	
			userAgentMap.put("os", os);
		    userAgentMap.put("browser", browser);
		}
		catch (Exception e) 
		{
			log.log(Level.SEVERE,"Exception while getting browser details"+e.getMessage(),e);						
		}
		return  userAgentMap;    
	}
	
	public static HashMap<String, Object> getLocationDetails(HttpServletRequest request)
	{
		HashMap<String, Object> locationMap	=	null; 
		String country	=	"",city="",region="",latitude="",longitude="",temp="",state="",title="",address="",zip="";
		boolean	primary	=	true;
		try
		{
			locationMap	= new HashMap<String, Object>();
			country		=	request.getHeader("X-AppEngine-Country"); 
			region		=	request.getHeader("X-AppEngine-Region");
			city		=	request.getHeader("X-AppEngine-City");
			temp		=	request.getHeader("X-AppEngine-CityLatLong");
			latitude	=	(temp.split(","))[0];
			longitude	=	(temp.split(","))[1];
			log.info("country>>"+country+"region>>"+region+"city>>"+city+"temp>>"+temp+"latitude>>"+latitude+"longitude>>"+longitude);
			locationMap.put("title",title);
			locationMap.put("address", address);
			locationMap.put("city", city);
			locationMap.put("state", region);
			locationMap.put("country", country);
			locationMap.put("zip", zip);
			locationMap.put("primary", primary);
			locationMap.put("latitude", latitude);
			locationMap.put("longitude", longitude);
			log.info("locationMap==>"+locationMap);
		}catch (Exception e) 
		{
			log.log(Level.SEVERE,"Exception while getting location"+e.getMessage(),e);
		}
		return locationMap;
	}
}
