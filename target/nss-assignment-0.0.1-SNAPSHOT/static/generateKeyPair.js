function getKeyUrl(){
    var baseUrl = $("meta[name=baseUrl]").attr("content")
    return baseUrl + "/api/keyserver";
}


function generateKey()
{

(async () => {

var u_name=document.getElementById("inputName").value;
var u_email=document.getElementById("inputEmail").value;
//console.log(u_name+"");
  var passphrase=document.getElementById("inputPassphrase").value;
  const { privateKeyArmored, publicKeyArmored, revocationCertificate } = await openpgp.generateKey({
        userIds: [{ name: u_name, email: u_email }], // you can pass multiple user IDs
        curve: 'ed25519',                                           // ECC curve name
        passphrase: passphrase          // protects the private key
    });

    console.log(privateKeyArmored);     // '-----BEGIN PGP PRIVATE KEY BLOCK ... '
    console.log(publicKeyArmored);      // '-----BEGIN PGP PUBLIC KEY BLOCK ... '
    console.log(revocationCertificate); // '-----BEGIN PGP PUBLIC KEY BLOCK ... '

var text = privateKeyArmored;
var data = new Blob([text], {type: 'text/plain'});

var url = window.URL.createObjectURL(data);

document.getElementById('download_link1').href = url;
document.getElementById('download_link1').click();


var text = publicKeyArmored;
var data = new Blob([text], {type: 'text/plain'});

var url = window.URL.createObjectURL(data);

document.getElementById('download_link2').href = url;
document.getElementById('download_link2').click();


var text = revocationCertificate;
var data = new Blob([text], {type: 'text/plain'});

var url = window.URL.createObjectURL(data);

document.getElementById('download_link3').href = url;
document.getElementById('download_link3').click();
addPublicKey(u_email,u_name,publicKeyArmored);
//uploadKey(publicKeyArmored);
})();
}


function uploadKey(publicKeyArmored)
{
(async () => {
    var hkp = new openpgp.HKP('https://keyserver.ubuntu.com/');

   

    await hkp.upload(publicKeyArmored);
})();
}

//BUTTON ACTIONS
function addPublicKey(email,name,publicKeyArmored){
    //Set the values to update
    var json = {
        "email":email,
        "name":name,
        "public_key":publicKeyArmored
    };
    var url = getKeyUrl();

    $.ajax({
       url: url,
       type: 'POST',
       data: JSON.stringify(json),
       headers: {
        'Content-Type': 'application/json'
       },      
       success: function(response) {
            alert('Key Pair generated !!!'); 
       },
       error: handleAjaxError
    });

    return false;
}

//INITIALIZATION CODE
function init(){
    $('#generate-key').click(generateKey);
}

$(document).ready(init);