$(document).ready(function() {
	
	$('#clickupload').click(function(){
		$('#resume_upload').trigger('click');
	});
	
	$('#greenearth').click(function(){
		$('#registertoday').trigger('click');
	});

	$('#registertoday').click(function(){
		window.location.href="/portal?page=appengine";
	});
	$('#researchregister').click(function(){
		window.location.href="/portal?page=research";
	});
	$('#startproject').click(function(){
		window.location.href="/portal?page=home";
	});
	
	$('#customideas').click(function(){
		$('#clickupload').show();
		$('.modal-lg').show();
		$('#messagetextarea').attr("placeholder","Write us your ideas about your project");
		$('#formtitle').html('<center>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Join hands with us to get your ideas work!</b></center>');
		$('#uploadrequirement').html("Upload your Requirement")
	});
	
//	$('#formtitle').click(function(){
//		
//	});
	$('#adpt_fname').val("");
	$('#adpt_email').val("");
	$('#adpt_phone').val("");
	$('#adpt_referer').val("");
	$('#message').val("");
	var click = true;
	$(function() 
	{
	    $("#resume_upload").change(function ()
	    {
		       var fileName = $(this).val();
		       $("#uploadrequirement").html(fileName.split('\\').pop());
		       $('.file-upload').css('background-color','#e5e5e5');
	     });
	    
	  });
		$(function()
		{
			$('form#job-form').ajaxForm(options); 
		});
		var options={
			 beforeSubmit:  showRequest,  // pre-submit callback 
		     success:       showResponse  // post-submit callback 	
		};
		function showRequest(formData, jqForm, options)
		{
			console.log('validating form');
			var error = false;
			var phone 		= 		$.trim($('#adpt_phone').val());
			var reg_forcheckingmailid 	= /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
			var regnum 	= 	/^[0-9-+]+$/;
			 var regnum 	= 	/^[0-9-+]+$/;
			   var numbers 	= 	phone.split(/\d/).length - 1;
			   var phoneLength = phone.length;
			   var num		=	new Array();
			   if(phone!='3. Phone Number'&&regnum.test(phone)==true)
			   {
				   var j=0;
				   for(i=0;i<=phoneLength-1;i++)
				   {
					   if(!isNaN(phone[i]))
					   {
					    	num[j]=phone[i];
					    	j++;
					   }
				   }
				   console.log('phone length after for:'+num.length);
				   numbers=num.length;
			   }
			$('#adpt_fname').css('background-color','#e5e5e5');
			$('#adpt_email').css('background-color','#e5e5e5');
			$('.file-upload').css('background-color','#e5e5e5');
			$('#adpt_phone').css('background-color','#e5e5e5');
			$('#adpt_referer').css('background-color','#e5e5e5');
			if($('#adpt_fname').val()=='')
			 {
				$('#adpt_fname').css('background-color','rgb(233, 199, 199)');
				error=true;
			 }
			else if($('#adpt_fname').val()=='Name is missing !'||$('#adpt_fname').val()=='Invalid Name !'||$('#adpt_fname').val()=='Your Name')
			{
				$('#adpt_fname').css('background-color','rgb(233, 199, 199)');
				error=true;
			}
			if($('#adpt_email').val()=='')
			{
				$('#adpt_email').css('background-color','rgb(233, 199, 199)');
				error=true;
			}
			if($('#adpt_phone').val()=='' || numbers<=9 || numbers >20)
			{
				$('#adpt_phone').css('background-color','rgb(233, 199, 199)');
				error=true;
			}
			else if(!regnum.test($('#adpt_phone').val()))
			{
				$('#adpt_phone').css('background-color','rgb(233, 199, 199)');
				error=true;
			}
			if(!reg_forcheckingmailid.test($('#adpt_email').val()))
			{
				$('#adpt_email').css('background-color','rgb(233, 199, 199)');
				error=true;
			}
			if($('#resume_upload').val()=='')
			{
				$('.file-upload').css('background-color','rgb(233, 199, 199)');
				$('#uploadrequirement').text("Upload Requirement");
				error=true;
				$('#filerror').html("Please upload your ideas in any doc, pdf, txt, docx, rtf format. Thanks.");
				$('#success_message').show();
	        	$('#backgroundPopup').show();
			}
			if($('#message').val()=='')
			 {
				$('#message').css('background-color','rgb(233, 199, 199)');
				error=true;
			 }
			if(error==true)
				return false;
			else
				{
				trimspaces();
				if(click)
					{
					click = false;
					console.log('no errors submitting form');
					$('#loading_img').show();
					$('#success_message').hide();
					$('#error_message').hide();
					$('#sendbutton').hide();
					
					return true;
					}
				else{
					console.log('you are submitting multiple times stoping form submission');
					return false;
					}
				}
		}
		
		function showResponse(responseText, statusText, xhr, $form)
		{
			$('#loading_img').hide();
			$('#sendbutton').show();
			click = true;
			var results = JSON.parse(responseText);
			var registrationStatus =	results.registration;
			var fileSize		   = 	results.filesize;
			var contactID   	   = 	results.contactID; 
			var phone 			   = 	results.phone;	
			var accountNumber	   =    results.accountNumber; 
			var fileformat 		   = 	results.fileformat;
			if(fileSize=="huge")
			{
				$('.file-upload').css('background-color','rgb(233, 199, 199)');
	        	$('#uploadrequirement').html(" File size must be less than 3MB");
			}
			else if((fileSize=="") ||(fileSize==null))
			{
				$('form#job-form').resetForm();
	        	$('#filemessage').html("Upload Your Requirement");
			}
			else if(registrationStatus=='success')
	    	{
	        	$('form#job-form').resetForm();
	        	$('#uploadrequirement').html("Upload Your Requirement");
	        	$('#success_message').show();
	        	$('#backgroundPopup').show();
	        	$('#filerror').html("Thank you for your interest! We will get back to you after reviewing your requirement.If you have any queries please reach out to us at sales@mdautomations.com");
	        	$('#success_message').show();
	        	$('#backgroundPopup').show();
	        	$('#clickupload').hide();
				$('.modal-lg').hide();
	    	}
	        else if(fileformat=='failed')
	        {
	        	$('#filerror').html("File Invalid.Please upload your ideas in any doc, pdf, txt, docx, rtf format. Thanks.");
				$('#success_message').show();
	        	$('#backgroundPopup').show();
	        	$('#clickupload').hide();
				$('.modal-lg').hide();
	        }
		}
	
		function trimspaces() 
		{
		    //Get the trimmed name
			var name 		= 	$('#adpt_fname').val();
			var email 		= 	$('#adpt_email').val();
			var phone 		= 	$('#adpt_phone').val();
			var referer 	= 	$('#adpt_referer').val();
			var message		= 	$('#message').val();
		    name 			= 	trim(name);
		    email 			= 	trim(email);
		    phone 			= 	trim(phone);
		    referer 		= 	trim(referer);
		    message			=    trim(message)
		    if(name) 
		    {
		        //Update the form with the trimmed value, just before the form is sent
		    	$('#adpt_fname').val(name);
		    }
		    else {
		         //Trimmed value is empty
		    	$('#adpt_fname').css('background-color','rgb(233, 199, 199)');
		         return false;
		    }
		    if(email) 
		    {
		        //Update the form with the trimmed value, just before the form is sent
		    	$('#adpt_email').val(email);
		    }
		    else 
		    {
		         //Trimmed value is empty
		    	$('#adpt_email').css('background-color','rgb(233, 199, 199)');
		         return false;
		    }
		    if(phone) 
		    {
		        //Update the form with the trimmed value, just before the form is sent
		    	$('#adpt_phone').val(phone);
		    }
		    else 
		    {
		         //Trimmed value is empty
		    	$('#adpt_phone').css('background-color','rgb(233, 199, 199)');
		         return false;
		    }
		    if(referer) 
		    {
		        //Update the form with the trimmed value, just before the form is sent
		    	$('#adpt_referer').val(referer);
		    }
		    else 
		    {
		         //Trimmed value is empty
		    	$('#adpt_referer').css('background-color','rgb(233, 199, 199)');
		         return false;
		    }
		    if(message) 
		    {
		        //Update the form with the trimmed value, just before the form is sent
		    	$('#message').val(message);
		    }
		    else 
		    {
		         //Trimmed value is empty
		    	$('#message').css('background-color','rgb(233, 199, 199)');
		         return false;
		    }
		    console.info("Name :: "+$('#adpt_fname').val());
		    console.info("Email :: "+$('#adpt_email').val());
		    console.info("Phone :: "+$('#adpt_phone').val());
		    console.info("Referer :: "+$('#adpt_referer').val());
		    console.info("Message :: "+$('#message').val());
		    
		}

		function trim(value) 
		{
		    return value.replace(/^\s+|\s+$/g,"");
		}
	
	function position_popup () {
		var pop_pos = $(window).scrollTop() + 100;
		$('.popup_wrapper').css('top', pop_pos);
	}	

//InputBox
	$('input.text_val_act, textarea').focus(function() { 
	  if( this.value == this.defaultValue ) {
	   this.value = "";
	  }
	  }).blur(function() {
	   if( !this.value.length ) {
		this.value = this.defaultValue;
	   }
	}); 
	
 // black screen dynamic height on window resize	
	
  	$('.popup_close_act').click(function() {
  		$('#backgroundPopup').fadeOut();
		$(this).parent().hide();
				
	});
		
   var body_win_height = parseInt(document.body.clientHeight) ;
   var win_height = parseInt(document.documentElement.clientHeight) ;

	   if( body_win_height > win_height) {
		$('#backgroundPopup').height(body_win_height);
	   } else {
		$('#backgroundPopup').height(win_height);
	   }

	$(window).resize(function(){
	   var body_win_height = parseInt(document.body.clientHeight) ;
	   var win_height = parseInt(document.documentElement.clientHeight) ;

	   if( body_win_height > win_height) {
		$('#backgroundPopup').height(body_win_height);
	   } else {
		$('#backgroundPopup').height(win_height);
	   }
	}); 	

/******  black screen ends here********/ 	
	
});

