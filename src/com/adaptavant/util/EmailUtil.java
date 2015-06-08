package com.adaptavant.util;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Part;
import java.io.IOException;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class EmailUtil
	{
		private static final Logger	mLogger	= Logger.getLogger( EmailUtil.class.getPackage().getName() );
		
		/**
		 * This method sends mail on registration on  "Request-A-Quote"
		 * Functionality has to implement
		 */
		/*public static void sendSuccessRegisterMail(String sFrom,String sName,String smessage) throws UnsupportedEncodingException
		{
			Properties props = new Properties();
			Session session = Session.getDefaultInstance(props, null);
			 try { 
				    Message msg = new MimeMessage(session);
		            msg.setFrom(new InternetAddress("info@voicecurve.com","VoiceCurve"));
		            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(sFrom,sName));
		            //msg.addRecipient(Message.RecipientType.BCC, new InternetAddress("pavankumar.vengal@a-cti.com","Pavan-LexReception"));
		            msg.setSubject("Adaptavnt Signup details!!!");
		            msg.setContent(smessage, "text/html");
		            Transport.send(msg);
		        } catch (AddressException e) {
		        	 e.printStackTrace();
		        } catch (MessagingException e) {
		            e.printStackTrace();
		        }
		}*/
		/**
		 * This method sends registration details to info@voicecurve.com
		 * @param sMessage
		 * @throws UnsupportedEncodingException
		 */
		public static void sendMailToClient(String sMessage,String sEmail) throws UnsupportedEncodingException
		{
			 mLogger.info("Sending Mail to client");
			 Properties props = new Properties();
			 Session session = Session.getDefaultInstance(props, null);
			
			 Message msg = new MimeMessage(session);
			
			try
			{
					msg.setFrom(new InternetAddress("info@prichemgroups.com","Prichem Groups")); 
					msg.addRecipient(Message.RecipientType.BCC, new InternetAddress("info@prichemgroups.com","Prichem Groups"));
					msg.addRecipient( Message.RecipientType.TO , new InternetAddress(sEmail,"Prichem Groups" ));
					msg.setReplyTo(InternetAddress.parse("info@prichemgroups.com"));  
			        msg.setSubject("Thanks For Registering with Prichem!");
			        msg.setContent(sMessage, "text/html");
			        Transport.send(msg);
			        mLogger.info("Mail sent successfully to client");
			        
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		public static void sendFeedbackMail(String sMessage,String sEmail,String sName) throws UnsupportedEncodingException

		{

		mLogger.info("Sending Mail to client");
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
		        mLogger.info("Mail sent successfully to client");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		public static void sendMailToAdaptavantAttachment(String sMessage, byte[] sFileContent, String sFileName) throws IOException
		{
			 mLogger.info("Inside the SendMail");
			 Properties props = new Properties();
			 Session session = Session.getDefaultInstance(props, null);
			 session.setDebug(true); 
			 Multipart mp = new MimeMultipart();
			 String FileExtention = sFileName.substring(sFileName.lastIndexOf('.') + 1);
			 try { 
				 	Message msg = new MimeMessage(session);
				 	String mode = new ModeUtil().getMode();
				 	mLogger.info("The mode is   : " +mode);
				 	try
					{
							msg.setFrom(new InternetAddress("sathya@mdautomations.com","MD AUTOMATIONS")); 
							msg.addRecipient( Message.RecipientType.TO , new InternetAddress( "sathya@mdautomations.com","MD AUTOMATIONS" ));
							 msg.addRecipient( Message.RecipientType.BCC , new InternetAddress("sathya@mdautomations.com","MD AUTOMATIONS") );
							 msg.setSubject("MD AUTOMATIONS Lead Details!!!");
					}
					catch(Exception e)
					{
						mLogger.info( e.getMessage() );
					}
		            
		            MimeBodyPart htmlPart = new MimeBodyPart();
		            htmlPart.setContent(sMessage, "text/html");
		            mp.addBodyPart(htmlPart);
		            
		            MimeBodyPart attachment = new MimeBodyPart();
		            DataSource src = null;
				    if(FileExtention.equalsIgnoreCase("pdf"))
				    {
				     mLogger.info("sending PDF");
				     attachment.setFileName(sFileName); 
					 attachment.setDisposition(Part.ATTACHMENT);
					 src = new ByteArrayDataSource(sFileContent, "application/pdf"); 
					 attachment.setDataHandler(new DataHandler(src)); 
				    // attachment.setHeader("Content-Type", "application/pdf; charset=iso-8859-1");
				    }
				    else if(FileExtention.equalsIgnoreCase("doc")||FileExtention.equalsIgnoreCase("docx"))
				    {
				     mLogger.info("sending DOC");
				     //attachment.setHeader("Content-Type", "application/msword; charset=iso-8859-1");
				     attachment.setFileName(sFileName); 
				     attachment.setDisposition(Part.ATTACHMENT);
				     src = new ByteArrayDataSource(sFileContent, "application/msword"); 
					 attachment.setDataHandler(new DataHandler(src)); 
				    }
				    else if(FileExtention.equalsIgnoreCase("odt"))
				    {
				     mLogger.info("sending ODT format file");
				     //attachment.setHeader("Content-Type", "application/msword; charset=iso-8859-1");
				     attachment.setFileName(sFileName); 
				     attachment.setDisposition(Part.ATTACHMENT);
				     src = new ByteArrayDataSource(sFileContent, "application/vnd.oasis.opendocument.text"); 
					 attachment.setDataHandler(new DataHandler(src)); 
				    }
				    else if(FileExtention.equalsIgnoreCase("png"))
				    {
				     mLogger.info("sending ODT format file");
				     //attachment.setHeader("Content-Type", "application/msword; charset=iso-8859-1");
				     attachment.setFileName(sFileName); 
				     attachment.setDisposition(Part.ATTACHMENT);
				     src = new ByteArrayDataSource(sFileContent, "image/png"); 
					 attachment.setDataHandler(new DataHandler(src)); 
				    }
				    else if(FileExtention.equalsIgnoreCase("jpg"))
				    {
				     mLogger.info("sending ODT format file");
				     //attachment.setHeader("Content-Type", "application/msword; charset=iso-8859-1");
				     attachment.setFileName(sFileName); 
				     attachment.setDisposition(Part.ATTACHMENT);
				     src = new ByteArrayDataSource(sFileContent, "image/jpeg"); 
					 attachment.setDataHandler(new DataHandler(src)); 
				    }
				    else if(FileExtention.equalsIgnoreCase("jpeg"))
				    {
				     mLogger.info("sending JPEG format file");
				     //attachment.setHeader("Content-Type", "application/msword; charset=iso-8859-1");
				     attachment.setFileName(sFileName); 
				     attachment.setDisposition(Part.ATTACHMENT);
				     src = new ByteArrayDataSource(sFileContent, "image/jpeg"); 
					 attachment.setDataHandler(new DataHandler(src)); 
				    }
				    else if(FileExtention.equalsIgnoreCase("bmp"))
				    {
				     mLogger.info("sending bmp format file");
				     //attachment.setHeader("Content-Type", "application/msword; charset=iso-8859-1");
				     attachment.setFileName(sFileName); 
				     attachment.setDisposition(Part.ATTACHMENT);
				     src = new ByteArrayDataSource(sFileContent, "image/bmp"); 
					 attachment.setDataHandler(new DataHandler(src)); 
				    }
				    else if(FileExtention.equalsIgnoreCase("rtf"))
				    {
				     mLogger.info("sending bmp format file");
				     //attachment.setHeader("Content-Type", "application/msword; charset=iso-8859-1");
				     attachment.setFileName(sFileName); 
				     attachment.setDisposition(Part.ATTACHMENT);
				     src = new ByteArrayDataSource(sFileContent, "application/rtf"); 
					 attachment.setDataHandler(new DataHandler(src)); 
				    }
				    mp.addBodyPart(attachment); 
				    msg.setContent(mp);
		            Transport.send(msg);
		            mLogger.info("Mail sended with attachment "+sFileName);
		        } catch (AddressException e) {
		        	 e.printStackTrace();
		        } catch (MessagingException e) {
		            e.printStackTrace();
		        }
		}
		public static void sendMailToAdaptavantAttachmentWithoutfile(String sMessage) throws IOException
		{
			 mLogger.info("Inside the SendMail");
			 Properties props = new Properties();
			 Session session = Session.getDefaultInstance(props, null);
			 session.setDebug(true); 
			 Multipart mp = new MimeMultipart();
			 try { 
				 	Message msg = new MimeMessage(session);
				 	String mode = new ModeUtil().getMode();
				 	mLogger.info("The mode is   : " +mode);
				 	try
					{
							msg.setFrom(new InternetAddress("sathya@mdautomations.com","MD AUTOMATIONS")); 
							msg.addRecipient( Message.RecipientType.TO , new InternetAddress( "sathya@mdautomations.com","MD AUTOMATIONS" ));
							 msg.addRecipient( Message.RecipientType.BCC , new InternetAddress("sathya@mdautomations.com","MD AUTOMATIONS") );
							 msg.setSubject("MD AUTOMATIONS Lead Details!!!");
					}
					catch(Exception e)
					{
						mLogger.info( e.getMessage() );
					}
		            
		            MimeBodyPart htmlPart = new MimeBodyPart();
		            htmlPart.setContent(sMessage, "text/html");
		            mp.addBodyPart(htmlPart);
		            MimeBodyPart attachment = new MimeBodyPart();
				    mp.addBodyPart(attachment); 
				    msg.setContent(mp);
		            Transport.send(msg);
		        } catch (AddressException e) {
		        	 e.printStackTrace();
		        } catch (MessagingException e) {
		            e.printStackTrace();
		        }
		}
		public static void sendStatusMail(String subject, String messagebody,String Option)
		{
			mLogger.info("Inside sendMailToDevelopers method" + "subject:" + subject+ "messagebody :" + messagebody);

			String 	from 	= null;
			String 	to 		= null;
			String 	cc	 	= null;
			String 	bcc	 	= null;
			String 	mode 	= null;
			String fromName	= null;
			String toName	= null;
			try
			{
				from 			= 	ResourceBundle.getBundle("ApplicationResources").getString("autogenerated-email.registration-confirmation.from-address");
				mode 			= 	new ModeUtil().getMode();
				fromName		=	"Exception-MD AUTOMATIONS";
				
				mLogger.info("the mode is this :: "+mode);
				
				 if("dev".equalsIgnoreCase(Option))
				{
					
						fromName			=	"Exception-etaCreatives";
						toName				=	"Eta Creatives";
						to 					= 	ResourceBundle.getBundle("ApplicationResources").getString("developer_email");
						cc 				= 	ResourceBundle.getBundle("ApplicationResources").getString("sathya_email");
						bcc 				= 	null;
						sendGeneralPorposeMail(from,fromName , to, toName,cc, bcc, subject, messagebody);
				}
				mLogger.info("from :" + from + "to:" + to +"mode"+mode +"bcc"+bcc);
			}
			catch (Exception e)
			{
				e.printStackTrace();
				mLogger.log(java.util.logging.Level.SEVERE, e.getMessage(), e);
			}
		}
		public static void sendGeneralPorposeMail(String pFromAddress , String pFromName , String pToAddress , String pToName ,String pcc, String pbcc, String pSubject , String pBody) throws Exception
		{
	    	Properties 		props 		= 	null;
	    	Session 		session 	=	null;
	    	Message 		msg 		=	null;
	    	String[] 		To 			=	null;
	    	String[]  		Cc 			=	null;	
	    	String[] 		Bcc 		=	null;
			try
			{
				mLogger.info("Inside the mail method !!!");
				mLogger.info("pFromAddress : " + pFromAddress);
				mLogger.info("pFromName : " + pFromName);
				mLogger.info("pToAddress : " + pToAddress);
				mLogger.info("pToName : " + pToName);
				mLogger.info("pcc : " + pcc);
				mLogger.info("pbcc : " + pbcc);
				mLogger.info("pSubject : " + pSubject);
				mLogger.info("pBody : " + pBody);
				
				props 		= 	new Properties();
				session 	= 	Session.getDefaultInstance(props, null);
				msg 		= 	new MimeMessage(session);
				msg.setSubject(pSubject);
				mLogger.info("subject:" + pSubject);
				
				if(pToAddress!=null)
				{
					mLogger.info("pToAddress Exists ");
					To 			= 	pToAddress.split(",");
					javax.mail.internet.InternetAddress[] addressTo = new javax.mail.internet.InternetAddress[To.length];
					for (int i = 0; i < To.length; i++)
					{
						addressTo[i] = new javax.mail.internet.InternetAddress(To[i]);
						mLogger.info("multiple address :" + addressTo[i]);
					}
					msg.setRecipients(javax.mail.Message.RecipientType.TO, addressTo);
				}
				
				if(pFromAddress!=null)
				{
					mLogger.info("pFromAddress Exists ");
					msg.setFrom(new InternetAddress(pFromAddress, pFromName));
				}
				
				
				if (pcc != null)
				{
					mLogger.info("pcc Exists ");
					Cc = pcc.split(",");
					javax.mail.internet.InternetAddress[] addressCc = new javax.mail.internet.InternetAddress[Cc.length];
					
					Cc 			= pcc.split(",");
					
					for (int i = 0; i < Cc.length; i++)
					{
						addressCc[i] = new javax.mail.internet.InternetAddress(Cc[i]);
						mLogger.info("multiple address :" + addressCc[i]);
					}
					msg.setRecipients(javax.mail.Message.RecipientType.CC, addressCc);
				}
				
				if (pbcc != null)
				{
					mLogger.info("pbcc Exists ");
					javax.mail.internet.InternetAddress[] addressBcc = null;
					Bcc = pbcc.split(",");
					addressBcc = new javax.mail.internet.InternetAddress[Bcc.length];

					for (int i = 0; i < Bcc.length; i++)
					{
						addressBcc[i] = new javax.mail.internet.InternetAddress(Bcc[i]);
						mLogger.info("multiple address :" + addressBcc[i]);
					}
					msg.setRecipients(javax.mail.Message.RecipientType.BCC, addressBcc);
				}
				
				msg.setContent(pBody, "text/html");
				Transport.send(msg);
				
				mLogger.info("Mail sent successfully");
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		
	}
