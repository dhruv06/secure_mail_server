
var currentOTP=0;


function sendOTP()
{
currentOTP =Math.floor(100000 + Math.random() * 900000);	
	Email.send({
		Host: "smtp.gmail.com",
		Username : "nssproject1357@gmail.com",
		Password : "NSS#1357",
		To : document.getElementById("inputEmail1").value,
		From : "nssproject1357@gmail.com",
		Subject : "OTP for login",
		Body : "OTP for login is "+currentOTP
,
		}).then(
			message => alert("OTP sent successfully")
		);
	document.getElementById("otp_part").style.display="block";
}
function verifyOTP()
{
	if(document.getElementById("inputOtp").value!=currentOTP)
		{
		alert("Wrong OTP, Try again...")
		}
	else
		{
		 location.replace("http://localhost:9000/nss/site/features");
		}
	}
function init(){
    $('#sendotp').click(sendOTP);
    $('#login1').click(verifyOTP);
}
$(document).ready(init);