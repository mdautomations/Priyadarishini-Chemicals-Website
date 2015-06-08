package com.adaptavant.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adaptavant.util.EmailUtil;
import com.google.appengine.labs.repackaged.org.json.JSONException;
//import com.adaptavant.service.GoogleStorageService;
//import com.google.appengine.api.datastore.Blob;
@Controller
public class AdaptavantRegisterAction {
	
	private static final Logger log = Logger.getLogger(AdaptavantRegisterAction.class.getName());
	private static final long serialVersionUID = 1L;
	ResourceBundle lResourceBundle = ResourceBundle.getBundle("ApplicationResources");
	
	/**
	 * Controller class which recives the form Data.
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	
	
	/*
	 * This method is the callback of the google authentication which checks for the email exists and redirects to the chatbuilder page or login page acc.. 
	 */
	
	
	static Map setContactMethodMap( String pTitle , String pValue , String pType , Map pContactMethodMap )
	{
		try
			{
				pContactMethodMap.put( "title" , pTitle );
				pContactMethodMap.put( "value" , pValue );
				pContactMethodMap.put( "type" , pType );
			}
		catch ( Exception ex )
			{
				log.log( java.util.logging.Level.SEVERE , "\n pTitle: " + pTitle + "\n pValue: " + pValue + "\n pType: " + pType
				        + "\n pContactMethodMap: " + pContactMethodMap + "\n" , ex );
			}

		return pContactMethodMap;
	}
	@RequestMapping(value="/logout" , method = RequestMethod.GET )
	public String Logout( HttpSession session, Model model , HttpServletRequest request , HttpServletResponse response)
		{
			log.info( "Inside logout method. Going to log out" );
			try
				{
					session.removeAttribute( "loginmap" );
					session.invalidate();
					log.info( "Forwarding to Index" );
					
				}
			catch ( Exception e )
				{
					e.printStackTrace();
					log.info( "Exception while removing/invalidating session" + e.getMessage() );
				}
				
				return "redirect:/" ;
		}
  	
	public String getMailBody(String name,String email, String phone, String msg)
	{
		String sMail ="";
//		sMail="<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>"+
//			"<html xmlns='http://www.w3.org/1999/xhtml'>"+
//				"<head>"+
//				"</head>"+
//				"<body>"+
//				"<table cellpadding='0' cellspacing='0' border='0' width='600px' style='font-family:helvetica; font-size:12px;'>"+
//				"<tr>"+
//					"<td>"+
//						"<table cellpadding='0' cellspacing='0' width='600px' bgcolor='#f0f0f0' border='0' style=' border:1px solid #e3e2e2; padding:10px 30px 30px;'>"+
//		            	"<tr>"+
//		                	"<td valign='bottom'><a href='www.mdautomations.com'><img src='http://mdautomations.com/MDLOGO.png' width='246' height='88' alt='www.mdautomations.com' border='0' /></a></td>"+
//		                    "<td align='right' valign='bottom'>"+
//		                    	"<p style='color:#4c4c4c; line-height:18px;'>sales@mdautomations.com <br />"+
//		                    	"+91.99.52592624</p>"+
//		                     "</td>"+
//		                "</tr>"+
//		                "<br/>"+
//		                "<br/>"+
//		                "<tr>"+
//			            	"<td colspan='2' style='height:170px; #height:140px; ' align='center'>"+
//			                	"<img src='http://9.etacreatives.appspot.com/thankyou.png' width='310' height='99' />"+
//			                "</td>"+
//		                "</tr>"+
//		                "<br/>"+
//		                "<tr>"+
//		                	"<td colspan='2' style='#padding:0px 30px 15px;'>"+
//		                    	"<h3 style='color:#4c4c4c; font-size:15px; margin:0px; '>Hi "+sName +",</h3>"+
//		                    "</td>"+
//		                "</tr>"+
//		                "<br/>"+
//		                "<br/>"+
//		                "<tr>"+
//		                	"<td colspan='2' style='#padding:0px 30px 15px;>"+
//		                    	"<p style='font-size:13px; color:#4c4c4c; line-height:24px;'>We will get back to you with potential ideas on your requirement.</p>"+
//		                    "</td>"+
//		                "</tr>"+
//		                "<tr>"+
//		                	"<td colspan='2' style='#padding:0px 30px 15px;'>"+
//		                    	"<p style='font-size:13px; color:#4c4c4c; line-height:24px;'>We do the best at MD Automations. Your project is half done, the moment you landed at MD Automations.</p>"+
//		                    "</td>"+
//		                "</tr>"+
//		                "<tr>"+
//		                	"<td colspan='2'  style='#padding:0px 30px 15px;'>"+
//		                    	"<p style='font-size:13px; color:#4c4c4c; line-height:24px;'>Thank's for your interest in MD Automations.</p>"+
//		                    "</td>"+
//		                "</tr>"+
//		                "<tr>"+
//		                	"<td colspan='2'>"+
//		                    	"<p style='font-size:13px; color:#4c4c4c; line-height:18px;'><b>Regards,</b><br style='margin-bottom:10px;' />"+
//		                            "Sales and Marketing Department,<br />"+
//		                            "MD Automations.<br />"+
//		                            "sales@mdautomations.com<br />"+
//		                            "+91.99.52.592624"+
//		                         "</p>"+
//		                    "</td>"+
//		                "</tr>"+
//		                "</table>"+
//	                "</td>"+
//                "</tr>"+
//                "<tr>"+
//                	"<td align='center' style='padding-top:20px; color:#4c4c4c;'>&#169; MD Automations.</td>"+
//                "</tr>"+
//                "</table>"+
//                "</body>"+	
//				"</html>";		
sMail = "<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>"+
		"<html xmlns='http://www.w3.org/1999/xhtml'>"+
		"<head>"+
		"<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />"+
		"<title>Prichem Groups Client Receipt</title>"+
		"</head>"+

		"<body bgcolor='#f5f6f7'>"+
		"<div  style='background-color:#f5f6f7; width:750px;' >"+
		"<div style='background-color: #000000;background-repeat:repeat-x; height:0px;'>&nbsp;</div>"+
			"<table width='650px' cellpadding='0' cellspacing='0' border='0' style='margin:30px auto;'>"+
		      "<tr>"+
		            "<td width='300px'>"+
		                "<a href='www.prichemgroups.com'><img src='http://prichemgroups.com/prichemban.png' border='0' alt='Prichem Groups' /></a>"+
		            "</td>"+
		            "<td width='359px' align='right' valign='bottom'>"+
		                "<span style='font-family:Helvetica; font-size:14px; color:#808080;'>Have a Question?<br /><b style='color:#434341; text-decoration:underline; font-size:12px; text-decoration:none;'>Call 91.422 2567040, 91.8508888111</b></span>"+
		            "</td>"+
		       "</tr>"+
		       "<tr>"+
		       		"<td height='10px'></td>"+
		       "</tr>"+
		        "<tr>"+
					"<td colspan='3'>"+
					"<h3 style='background:url(http://mdautomations.com/bg.png) #2080bc no-repeat 0px; border-radius:10px 10px 0px 0px; width:626px; min-height:71px; padding:40px 0 0 25px; margin:0px 1px; font-family:helvetica;color:#ffffff; font-size:23px;'>Thank you for registering with us!</h3>"+
					"</td>"+
				"</tr>"+
		        "<tr>"+
		            "<td colspan='3' background='http://mdautomations.com/bg_content.gif' >"+
		                    "<table cellpadding='0' cellspacing='0' border='0' width='100%'>"+
		                          "<tr>"+
		                             "<td colspan='2' height='30px' >&nbsp;</td>"+
		                          "</tr>"+
		                          "<tr>"+
		                            "<td colspan='2' background='http://mdautomations.com/bg_content.gif' width='417px' style='font-family: helvetica; padding-right:7px; padding-left:7px; font-size:12px; color:#000000; '>"+
		                                "<table cellpadding='0' cellspacing='0' border='0' style='margin:0px 23px;'>"+
		                                   " <tr>"+
		                                        "<td valign='top'>"+
		                                        	"<div style='font-family:helvetica; font-size:14px; font-weight:bold; color:#333333; margin:0px 0px 20px 0px;'>Dear "+name+" ,</div>"+
		                                            
		                                        	"<p style='margin:0px 0px 20px 0px; font-size:13px; line-height:22px;'>Thank you for signing up with Prichem Groups!</p>"+
		                                            "<p style='margin:0px 0px 20px 0px; line-height:22px; font-size:13px;'>Prichem provides world class quality products, service, customer satisfaction, innovative and tailor made solutions to industries. We continously work towards accomplishing its mission which indicates improvising our quality day to day by adopting new technologies and methods.</p>"+
		                                            "<p style='margin:0px 0px 23px 0px; line-height:18px; font-size:13px;'>Please check your following details</p>"+
		                                            "<h3 style='font-size:15px; margin:10px 0px 10px 0px; line-height:18px; font-weight:bold; color:#323232;'>Your Summary</h3>"+
		                                         "</td>"+
		                                    "</tr>"+
		                                    "<tr>"+
		                                    	"<td>"+
		                                           "<table cellpadding='0' cellspacing='0' border='0' width='100%' style='padding:5px 0px;'>"+
		                                            	"<thead>"+
		                                                	"<tr>"+
		                                                    	"<th colspan='2' align='left' style='padding-left:10px; border-bottom:1px solid #b2b2b2; line-height:20px; border: 1px solid #b2b2b2; background-color: #e8e8e8; border-radius: 5px 5px 0px 0px;'>Customer Detail</th>"+
		                                                    "</tr>"+
		                                                "</thead>"+
		                                                "<tbody>"+
		                                                
		                                                	"<tr>"+
		                                                    	"<td style='padding:10px 0px 0px 10px; line-height:18px; border-left:1px solid #d2d2d2;' width='80%'>"+
		                                                    		"<td style='color:#0070b8; border-right:1px solid #d2d2d2; text-align:left;'></td>"+
		                                                    	"</td>"+
		                                                    "</tr>"+
															"<tr>"+
															
		                                                  		  	"<td style='padding:0px 0px 3px 10px; line-height:18px; border-left:1px solid #d2d2d2; border-bottom:1px solid #f4f4f4;'>Name</td>"+
		                                                  	
		                                                 	        "<td style='padding:0px 10px 3px 0px; color:#0070b8; border-right:1px solid #d2d2d2; text-align:left; border-bottom:1px solid #f4f4f4;'>"+name+"</td>"+
		                                                 	   "</tr>"+
		                                                     
																"<tr>"+
		                                                  		  	"<td style='padding:0px 0px 3px 10px; line-height:18px; border-left:1px solid #d2d2d2; border-bottom:1px solid #f4f4f4;'>Email </td>"+
		                                                 	       "<td style='padding:0px 10px 3px 0px; color:#0070b8; border-right:1px solid #d2d2d2; text-align:left; border-bottom:1px solid #f4f4f4;'>"+email+"</td>"+
		                                                 	  " </tr>"+
														 		"<tr>"+
		                                                  		  	"<td style='padding:0px 0px 3px 10px; line-height:18px; border-left:1px solid #d2d2d2; border-bottom:1px solid #f4f4f4;'>Contact Number</td>"+
		                                                 	        "<td style='padding:0px 10px 3px 0px; color:#0070b8; border-right:1px solid #d2d2d2; text-align:left; border-bottom:1px solid #f4f4f4;'>"+phone+"</td>"+
		                                                 	   "</tr>"+
														 		"<tr>"+
		                                                  		  	"<td style='padding:0px 0px 3px 10px; line-height:18px; border-left:1px solid #d2d2d2; border-bottom:1px solid #f4f4f4;'>Message / Query </td>"+
		                                                 	       " <td style='padding:0px 10px 3px 0px; color:#0070b8; border-right:1px solid #d2d2d2; text-align:left; border-bottom:1px solid #f4f4f4;'>"+msg+"</td>"+
		                                                 	   "</tr>"+
		                                                "</tbody>"+
		                                            "</table>"+
		                                        "</td>"+
		                                    "</tr>"+
		                                   
		                            "</table>"+
		                            "</td>"+
		                          "</tr>"+  
		                    "</table>"+
		                "</td>"+
		            "</tr>"+ 
		            "<tr>"+
		                 "<td colspan='2' background='http://mdautomations.com/bg_bottom.gif' height='26px'></td>"+
		            "</tr>"+
		            "<tr>"+
		                 "<td colspan='2' style='height:10px;'></td>"+
		            "</tr>"+
		              
		              "<tr>"+
		                 "<td colspan='2' background='http://prichemgroups.com/img_footer.png' height='76px'><div style='margin-left:260px; color:#434343; font-size:11px;font-family:tahoma;'>#49/2, Guru Building, Nava India Road, Near SNR Sons College, K. R. Puram, Coimbatore, Tamil Nadu - 641 006. <br/>"+
	"&#169; 2015 Prichem Groups. All Rights Reserved.</div></td>"+
		              "</tr>"+
		    "</table>"+
		"</div>"+

		"</body>"+
		"</html>";
		return sMail;
	}
	
	
	@RequestMapping(value="/studentregistration",method=RequestMethod.POST)
	public @ResponseBody String registeration(HttpServletRequest request,HttpServletResponse response,HttpSession session)throws IOException, JSONException
	{
		System.out.println(" Name  " +request.getParameter("name"));
		System.out.println(" Email :: " +request.getParameter("email"));
		System.out.println(" Phone :: " +request.getParameter("phone"));
		System.out.println(" Message :: " +request.getParameter("msg"));
			 try
				{
					
					String sClientMail = getMailBody(request.getParameter("name"),request.getParameter("email"),request.getParameter("phone"),request.getParameter("msg"));
					System.out.println("mail is this::"+sClientMail);
					EmailUtil.sendMailToClient(sClientMail,request.getParameter("email"));
				}
				catch(Exception e)
				{
					e.getStackTrace();
					System.out.println("the exception is this :: "+e);
					return "failure";
				}
			 	finally
				{
					//pm.close();
				}
				return "success";
		 }
	
	@RequestMapping(value="/feedback",method=RequestMethod.POST)
	public @ResponseBody String feedback(@RequestParam(value="responseboxHTML",required=false)String responses,@RequestParam(value="tree_contents",required=false)String paramds,@RequestParam(value="studentemail",required=false)String studentemail,@RequestParam(value="studentname",required=false)String studentname,@RequestParam(value="sendresponse",required=false)String sendresponse,HttpServletRequest request,HttpServletResponse response,HttpSession session)throws IOException, JSONException
			{
//				System.out.println("parameter is this ::"+paramds);
				System.out.println("studentname is this ::"+studentname);
				System.out.println("studentemail is this ::"+studentemail);
				System.out.println("sendresponse is this ::"+sendresponse);
				
				String Str = paramds.replace('\"', '\'');
//				String sMail = "<!DOCTYPE html>"+
//				"<html lang='en'>"+
//				    "<body >"+
//				    "<img src='http://mdautomations.com/MDLOGO.png' width='246' height='90' border='0' alt='MD Automations' /></a>"+
//				    Str+
//				    "</body>"+
//				    "</html>";
//				log.info("sMail is"+sMail);
//				if(sendresponse=="true")
//				{
//					EmailUtil.sendFeedbackMail(sMail,studentemail,studentname);
//				}
//				else
//				{
//					EmailUtil.sendFeedbackMail(sMail,"",studentname);
//				}
				String sMail=	"<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>"+
				"<html xmlns='http://www.w3.org/1999/xhtml'>"+
				"<head>"+
				"<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />"+
				"<title>MD Automations Client Receipt</title>"+
				"</head>"+

				"<body bgcolor='#f5f6f7'>"+
				"<div  style='background-color:#f5f6f7; width:750px;' >"+
				"<div style='background-color: #000000;background-repeat:repeat-x; height:0px;'>&nbsp;</div>"+
					"<table width='650px' cellpadding='0' cellspacing='0' border='0' style='margin:30px auto;'>"+
				      "<tr>"+
				            "<td width='300px'>"+
				                "<a href='www.mdautomations.com'><img src='http://mdautomations.com/MDLOGO.png' width='246' height='90' border='0' alt='MD Automations' /></a>"+
				            "</td>"+
				       "</tr>"+
				       "<tr>"+
				       		"<td height='10px'></td>"+
				       "</tr>"+
				        "<tr>"+
							"<td colspan='3'>"+
							"<h3 style='background:url(http://mdautomations.com/bg.png) #2080bc no-repeat 0px; border-radius:10px 10px 0px 0px; width:626px; min-height:71px; padding:40px 0 0 25px; margin:0px 1px; font-family:helvetica;color:#ffffff; font-size:23px;'>Thanks for your valuable feedback!</h3>"+
							"</td>"+
						"</tr>"+
				           Str+responses+
				           "<table width='650px' cellpadding='0' cellspacing='0' border='0' style='margin:30px auto;'>"+
				            "<tr>"+
				                 "<td colspan='2' background='http://mdautomations.com/bg_bottom.gif' height='26px'></td>"+
				            "</tr>"+
				            "<tr>"+
				                 "<td colspan='2' style='height:10px;'></td>"+
				            "</tr>"+
				              
				              "<tr>"+
				                 "<td colspan='2' background='http://mdautomations.com/img_footer.png' height='76px'><div style='margin-left:260px; color:#434343; font-size:11px;font-family:tahoma;'>#18, Subramaniya Swamy Koil St, Tirupattur, Vellore Dist- 635601. <br/>"+
			"&#169; 2003 MD Automations. All Rights Reserved.</div></td>"+
				              "</tr>"+
				    "</table>"+
				"</div>"+

				"</body>"+
				"</html>";
				log.info("sMail is"+sMail);
				log.info("sendresponse is"+sendresponse);
				if(sendresponse.equalsIgnoreCase("true"))
					{
						System.out.println("hello");
					 	EmailUtil.sendFeedbackMail(sMail,studentemail,studentname);
					}
					else
					{
						System.out.println("hello1");
						EmailUtil.sendFeedbackMail(sMail,"",studentname);
					}
				return paramds;
				
			}
	@RequestMapping(value="/feedbackmsg",method=RequestMethod.POST)
	public @ResponseBody String feedback(@RequestParam(value="name",required=false)String name,@RequestParam(value="email",required=false)String email,@RequestParam(value="phone",required=false)String number,@RequestParam(value="message",required=false)String message,HttpServletRequest request,HttpServletResponse response,HttpSession session)throws IOException, JSONException
			{
//				System.out.println("parameter is this ::"+paramds);
				System.out.println("studentname is this ::"+name);
				System.out.println("studentemail is this ::"+email);
				System.out.println("sendresponse is this ::"+number);
				System.out.println("sendresponse is this ::"+message);
				
				String sMail= "Name :: "+name+"Email :: "+email+"Phone :: "+number+"message :: "+message;
			
			
					 	sendmsgbackMail(sMail,"sathya@mdautomations.com",name);
					 	
					 	System.out.println("mails ent is this ::"+message);
					
				return null;
				
			}
	public static void sendmsgbackMail(String sMessage,String sEmail,String sName) throws UnsupportedEncodingException

	{

	Properties props = new Properties();
	Session session = Session.getDefaultInstance(props, null);
	Message msg = new MimeMessage(session);
	try
	{
		msg.setFrom(new InternetAddress("sathya@mdautomations.com","MD AUTOMATIONS")); 
		if(sEmail.length()!=0)
		{
			msg.addRecipient(Message.RecipientType.BCC, new InternetAddress("team@mdautomations.com","MD AUTOMATIONS"));
			msg.addRecipient( Message.RecipientType.TO , new InternetAddress(sEmail,"MD AUTOMATIONS" ));
		}
		else
		{
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress("team@mdautomations.com","MD AUTOMATIONS"));
		}
			msg.setReplyTo(InternetAddress.parse("sathya@mdautomations.com"));  
	        msg.setSubject("Feedback from "+sName);
	        msg.setContent(sMessage, "text/html");
	        Transport.send(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@RequestMapping( value = "/one" , method = RequestMethod.GET)
	public void downloadPricing(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=Alchrome.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Alchrome.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/two" , method = RequestMethod.GET)
	public void two(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in notfound");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=AlphosADP_PDP.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Autobond.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/three" , method = RequestMethod.GET)
	public void three(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in notfound");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=AlphosASP_PSP.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Autobond.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/four" , method = RequestMethod.GET)
	public void four(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=Autobond.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Autobond.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/five" , method = RequestMethod.GET)
	public void five(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=Cleansel.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Cleansel.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/six" , method = RequestMethod.GET)
	public void six(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=Ferrokare.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Ferrokare.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/seven" , method = RequestMethod.GET)
	public void seven(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=Gencool.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Gencool.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/eight" , method = RequestMethod.GET)
	public void eight(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=Hydrodine.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Hydrodine.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/nine" , method = RequestMethod.GET)
	public void nine(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=Hydrosave.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Hydrosave.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/ten" , method = RequestMethod.GET)
	public void ten(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=Manganophos-HMP.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Manganophos-HMP.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/eleven" , method = RequestMethod.GET)
	public void eleven(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=MCP65CP.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/MCP65CP.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/twelve" , method = RequestMethod.GET)
	public void twelve(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=MCP65HP.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/MCP65HP.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/thirteen" , method = RequestMethod.GET)
	public void thirteen(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=PAICOR.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/PAICOR.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/fourteen" , method = RequestMethod.GET)
	public void fourteen(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=PAICORMC.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/PAICORMC.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/fifteen" , method = RequestMethod.GET)
	public void fifteen(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=PrichemHSR225.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/PrichemHSR225.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/sixteen" , method = RequestMethod.GET)
	public void sixteen(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=PrichemMFR25.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/PrichemMFR25.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/seventeen" , method = RequestMethod.GET)
	public void seventeen(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in pritocool plus green notfound");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=PrichemNAD.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/PrichemNAD.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/eighteen" , method = RequestMethod.GET)
	public void eighteen(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in pritocool star notfound");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=Prideg-ED.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Prideg-ED.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/nineteen" , method = RequestMethod.GET)
	public void nineteen(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in skylark not found");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=Prideg-HD.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Prideg-HD.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	
	@RequestMapping( value = "/twenty" , method = RequestMethod.GET)
	public void twenty(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=PridegALD15.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/PridegALD15.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}@RequestMapping( value = "/twentyone" , method = RequestMethod.GET)
	public void twentyone(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=Prideg-EPC.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Prideg-EPC.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/twentytwo" , method = RequestMethod.GET)
	public void twentytwo(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=PridegPCC.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/PridegPCC.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/twentythree" , method = RequestMethod.GET)
	public void twentythree(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=Pritobond-FGW.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Pritobond-FGW.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/twentyfour" , method = RequestMethod.GET)
	public void twentyfour(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=Pritobond-HG.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Pritobond-HG.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/twentyfive" , method = RequestMethod.GET)
	public void twentyfive(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=Pritobond-KG.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Pritobond-KG.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/twentysix" , method = RequestMethod.GET)
	public void twentysix(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=Pritobond-LG.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Pritobond-LG.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/twentyseven" , method = RequestMethod.GET)
	public void twentyseven(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=Pritobond-MG.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Pritobond-MG.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/twentyeight" , method = RequestMethod.GET)
	public void twentyeight(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=Pritobond-titration-LG.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Pritobond-titration-LG.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/twentynine" , method = RequestMethod.GET)
	public void twentynine(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=Pritocool_Plus.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Pritocool_Plus.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/thirty" , method = RequestMethod.GET)
	public void thirty(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=Pritocool-Star.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Pritocool-Star.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/thirtyone" , method = RequestMethod.GET)
	public void thirtyone(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=Pritocool.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Pritocool.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/thirtytwo" , method = RequestMethod.GET)
	public void thirtytwo(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=Pritox-DOT3.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Pritox-DOT3.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/thirtythree" , method = RequestMethod.GET)
	public void thirtythree(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=Pritox-FRONT-FORK-OIL.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Pritox-FRONT-FORK-OIL.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/thirtyfour" , method = RequestMethod.GET)
	public void thirtyfour(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=Pritox-GEM-20W40.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Pritox-GEM-20W40.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/thirtyfive" , method = RequestMethod.GET)
	public void thirtyfive(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=Pritox-GEM-20W50.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Pritox-GEM-20W50.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/thirtysix" , method = RequestMethod.GET)
	public void thirtysix(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=Pritox-ECO120.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Pritox-ECO120.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/thirtyseven" , method = RequestMethod.GET)
	public void thirtyseven(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=Pritox-RPD303B.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Pritox-RPD303B.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/thirtyeight" , method = RequestMethod.GET)
	public void thirtyeight(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=Pritox-RPD305B.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Pritox-RPD305B.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/thirtynine" , method = RequestMethod.GET)
	public void thirtynine(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=RPW303B.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/RPW303B.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/forty" , method = RequestMethod.GET)
	public void forty(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=RPW305B.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/RPW305B.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/fortyone" , method = RequestMethod.GET)
	public void fortyone(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=PRITOX-GEM-90.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/PRITOX-GEM-90.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/fortytwo" , method = RequestMethod.GET)
	public void fortytwo(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=PRITOX-GEM140.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/PRITOX-GEM140.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/fortythree" , method = RequestMethod.GET)
	public void fortythree(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=Prustoclean-MT.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Prustoclean-MT.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/fortyfour" , method = RequestMethod.GET)
	public void fortyfour(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=Radiwash.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Radiwash.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/fortyfive" , method = RequestMethod.GET)
	public void fortyfive(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=Rustnil.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Rustnil.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/fortysix" , method = RequestMethod.GET)
	public void fortysix(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=Rustphosclean.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Rustphosclean.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/fortyseven" , method = RequestMethod.GET)
	public void fortyseven(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=silicon-deformer.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/silicon-deformer.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/fortyeight" , method = RequestMethod.GET)
	public void fortyeight(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=SKYLARK.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/SKYLARK.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/fortynine" , method = RequestMethod.GET)
	public void fortynine(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=Subguard-100R.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Subguard-100R.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/fifty" , method = RequestMethod.GET)
	public void fifty(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=Sulfodine.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Sulfodine.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/fiftyone" , method = RequestMethod.GET)
	public void fiftyone(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=MCP65.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/MCP65.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/fiftytwo" , method = RequestMethod.GET)
	public void fiftytwo(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=MVLR25.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/MVLR25.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/fiftythree" , method = RequestMethod.GET)
	public void fiftythree(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=MVDR80.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/MVDR80.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/fiftyfour" , method = RequestMethod.GET)
	public void fiftyfour(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=MVP50.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/MVP50.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/fiftyfive" , method = RequestMethod.GET)
	public void fiftyfive(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=PrichemPBS60.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/PrichemPBS60.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/fiftysix" , method = RequestMethod.GET)
	public void fiftysix(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=Zinphophos-CZP.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Zinphophos-CZP.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	@RequestMapping( value = "/fiftyseven" , method = RequestMethod.GET)
	public void fiftyseven(HttpServletRequest request,HttpServletResponse response)throws NullPointerException, IOException
	{
		log.info("system.in");
         OutputStream out=response.getOutputStream(); 
         try 
         {
        	 response.setContentType("application/force-download");
        	 response.setHeader("Content-disposition", "attachment; filename=Zinphophos-HZP.pdf");
             out.write(IOUtils.toByteArray(new URL("http://testservice-url.appspot.com/pdf/Zinphophos-HZP.pdf").openStream()));  // write out the file we want to save.
             out.close(); // close the output stream writer
             out.flush();
         }
         catch(Exception m) 
         {
             System.out.println(m);
         }
	}
	
	
	
}
