var privateKey123='';
function getKeyUrl(){
    var baseUrl = $("meta[name=baseUrl]").attr("content")
     
    return baseUrl + "/api/getkeyserver";
      
}

function getKeyUrlForSendMail()
{
	var baseUrl = $("meta[name=baseUrl]").attr("content")
    return baseUrl + "/api/sendMail";
}


function encrypt(pubkey)
{
	var passp=document.getElementById("passphrase").value;
(async () => {
  //  await openpgp.initWorker({ path: 'openpgp.worker.js' }); // set the relative web worker path

    // put keys in backtick (``) to avoid errors caused by spaces or tabs
    const publicKeyArmored = pubkey;
    const privateKeyArmored = privateKey123;
    const passphrase = passp; // what the private key is encrypted with

    const { keys: [privateKey] } = await openpgp.key.readArmored(privateKeyArmored);
    await privateKey.decrypt(passphrase);
var plaintext=document.getElementById("inputBody").value;

    const { data: encrypted } = await openpgp.encrypt({
        message: openpgp.message.fromText(plaintext),                 // input as Message object
        publicKeys: (await openpgp.key.readArmored(publicKeyArmored)).keys, // for encryption
        privateKeys: [privateKey]    
    });
  	console.log(encrypted);
  	
  	
  	var receiver=document.getElementById("inputEmail").value;
    
  	var url = getKeyUrlForSendMail();
  	var json = {
  			"sender":"xyz@gmail.com",
  			"receiver":receiver,
  	        "body":encrypted
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
  	            alert("Mail Sent Successfully");
  	            location.replace("http://localhost:9000/nss/site/Compose");
  	       },
  	       error: handleAjaxError
  	    });
  	
  	
  	
})();


}



function handleFileSelect(evt) {
    var files = evt.target.files; // FileList object

    // use the 1st file from the list
    f = files[0];

    var reader = new FileReader();

    // Closure to capture the file information.
    reader.onload = (function(theFile) {
        return function(e) {

		  privateKey123=e.target.result;
        };
      })(f);

      // Read in the image file as a data URL.
      reader.readAsText(f);
	 
  }
function searchKey()
{

   
var email=document.getElementById("inputEmail").value;

var url = getKeyUrl();
var json = {
        "email":email
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
            encrypt(response.public_key); 
       },
       error: handleAjaxError
    });

    
}
//INITIALIZATION CODE
function init(){
    $('#encrypt-data').click(searchKey);
}
document.getElementById('upload').addEventListener('change', handleFileSelect, false);
$(document).ready(init);