<?php

$email = $_POST['email'];
$name = $_POST['name'];
$phone = $_POST['phone'];
$send_email_to = $_POST['owner_email'];
$message = $_POST['message'];

$email_subject = "New Contact Message";


function send_email($name,$email,$phone,$email_message)
{
  global $send_email_to;
  global $email_subject;


  $headers = "MIME-Version: 1.0" . "\r\n";
  $headers .= "Content-type:text/html;charset=iso-8859-1" . "\r\n";
  $headers .= "From: ".$email. "\r\n";

  $message .= "<strong>Name = </strong>".$name."<br>";
  $message .= "<strong>Email = </strong>".$email."<br>";
  $message .= "<strong>Phone = </strong>".$phone."<br>";
  $message .= "<strong>Message = </strong>".$email_message."<br>";
  @mail($send_email_to, $email_subject, $message,$headers);
  return true;
}

send_email($name,$email,$phone,$message);

?>
