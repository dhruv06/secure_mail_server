function decrypt()
{

(async () => {
  
   
    const privateKeyArmored = document.getElementById("pvtkey").value;
 // encrypted private key
    const passphrase = document.getElementById("inputPassphrase").value ; // what the private key is encrypted with

    const { keys: [privateKey] } = await openpgp.key.readArmored(privateKeyArmored);
    await privateKey.decrypt(passphrase);

  var encrypted=document.getElementById("cipher").value;
    const { data: decrypted } = await openpgp.decrypt({
        message: await openpgp.message.readArmored(encrypted),              // parse armored message
       
        privateKeys: [privateKey]                                           // for decryption
    });
document.getElementById("output").innerHTML=decrypted;
console.log(decrypted);
})();
}
//INITIALIZATION CODE
function getKeyUrl(){
    var baseUrl = $("meta[name=baseUrl]").attr("content")
    return baseUrl + "/api/fetchmail";
}


function showbox()
{
	var url = getKeyUrl();
	var json = {
	        
	    };

	//get public key from keyserver
	 $.ajax({
	       url: url,
	       type: 'POST',
	       data: JSON.stringify(json),
	       headers: {
	        'Content-Type': 'application/json'
	       },     
	       success: function(response) {
	          //  encrypt(response.public_key); 
	       },
	       error: handleAjaxError
	    });	
}
function init(){
    $('#decrypt-data').click(showbox);
}

$(document).ready(init);