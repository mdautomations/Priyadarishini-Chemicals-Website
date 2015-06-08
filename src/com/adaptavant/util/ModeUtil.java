package com.adaptavant.util;

import java.util.ResourceBundle;
import java.util.logging.Logger;

import com.google.appengine.api.utils.SystemProperty;


public class ModeUtil {
	
	private static final Logger log = Logger.getLogger( ModeUtil.class.getName() );
	ResourceBundle lResourceBundle = ResourceBundle.getBundle("ApplicationResources");
	public String getMode()
	{
		String mode = "";
		String applicationId = SystemProperty.applicationId.get();
		

		try
		{
			if(applicationId.equals("adaptavantlocal") || applicationId.contains("local") )
	        {
	      		log.info("pointing to local ");	
	      		mode = "local";
	        	
	        }
			else if(applicationId.equals("newadaptavant"))
	        {
	      		log.info("pointing to live ");	
	      		mode = "LIVE";
	        	
	        }
	        else if(applicationId.equals("testing-adptavant"))
	        {
	        		        	
	        	log.info("pointing to staging");	
	        	mode = "STAGING";
	        	
	        }
	        else
	        {
	        	log.info("pointing to local");		   
	        	mode = "LOCAL";
	        }

		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.info("Exception in the method getMode ::"+e.getMessage());
		}
		return mode;
	}
	
	/**
	 * getting cms url based on mode
	 * @return
	 */
	public String getCMSUrl()
	{
		String cmsUrl					=	null;
		String mode						=	null;
		try
		{
			mode							=	getMode();
			log.info("The mode got  : " + mode);
			if("LIVE".equalsIgnoreCase(mode))
			{
				cmsUrl			=	ResourceBundle.getBundle( "ApplicationResources" ).getString( "cmsUrl" );
			}
			else if(("STAGING".equalsIgnoreCase(mode))||("DEV").equalsIgnoreCase(mode))
			{
				cmsUrl			=	ResourceBundle.getBundle( "ApplicationResources" ).getString( "stagingcmsUrl" );
			}
			else
			{
				cmsUrl			=	ResourceBundle.getBundle( "ApplicationResources" ).getString( "stagingcmsUrl" );
			}
			
			log.info("The cmsUrl url is  : " +cmsUrl);
		}
		catch(Exception e)
		{
			log.log( java.util.logging.Level.INFO , e.getMessage() , e );
		}
		return cmsUrl;
	}
	public String getArID()
	{
		String arID					=	null;
		String mode						=	null;
		try
		{
			mode							=	getMode();
			log.info("The mode got  : " + mode);
			if("LIVE".equalsIgnoreCase(mode))
			{
				arID			=	ResourceBundle.getBundle( "ApplicationResources" ).getString( "adaptavant.arpopup.id");
			}
				log.info("The arID  is  : "+arID);
		}
		catch(Exception e)
		{
			log.log( java.util.logging.Level.INFO , e.getMessage() , e );
		}
		return arID;
	}
	public String activeResponseURL()
	{
		String activeResponseURL					=	null;
		String mode						=	null;
		try
		{
			mode							=	getMode();
			log.info("The mode got  : " + mode);
			if("LIVE".equalsIgnoreCase(mode))
			{
				activeResponseURL			=	ResourceBundle.getBundle( "ApplicationResources" ).getString( "live.new.ar.url" );
			}
			log.info("The activeResponseURL url is  : " +activeResponseURL);
		}
		catch(Exception e)
		{
			log.log( java.util.logging.Level.INFO , e.getMessage() , e );
		}
		return activeResponseURL;
	}
	
	public String getBrandingBucketName()
	{
		log.info("Inside getBrandingBucketName method");
		String mode = this.getMode();
		String lBrandingBucketName = null;
		log.info("the mode value is :" + mode);
		try
		{
			if ("live".equalsIgnoreCase(mode))
			{
				lBrandingBucketName = ResourceBundle.getBundle("ApplicationResources").getString("googlestorage_livebucketname");
				log.info("Live bucket :: " + lBrandingBucketName);
			}
			else if ("beta".equalsIgnoreCase(mode))
			{
				lBrandingBucketName = ResourceBundle.getBundle("ApplicationResources").getString("googlestorage_livebucketname");
				log.info("beta bucket :: " + lBrandingBucketName);
			}
			else
			{
				lBrandingBucketName = ResourceBundle.getBundle("ApplicationResources").getString("googlestorage_stagingbucketname");
				log.info("staging or dev or local bucket:: " + lBrandingBucketName);
			}
			return lBrandingBucketName;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			log.info("Exception while getting the conversionsupport xmpp url based on the mode ::"+ e.getMessage());
			return lBrandingBucketName;
		}
	}
	}
