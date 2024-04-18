const performValidate=()=>{
   var isValid=true
   var myForm = document.forms['application']
   const name = myForm.accountHolder.value
   const accNum=myForm.accountNumber.value
   const contact=myForm.contacts.value
   var nameErr=document.getElementById("nameErr")
   var emailErr=document.getElementById("emailErr")
   var accErr=document.getElementById("accErr")
   var contactErr=document.getElementById("contactErr")
   try{
    if(!(/[A-Za-z]/).test(name)){
        throw "*Requires only alphabets"
    }
    }
    catch(message){
      isValid=false
      nameErr.innerHTML=message
    }

    try{
      if(!(/^\d{16}$/).test(accNum)){
        throw "*Account number must be exactly 16 digits";
    }
   }
   catch(message){
    isValid=false;
    accErr.innerHTML=message;
 }
 try{
  if(!(/^\d{10}$/).test(contact)){
    throw "*Contact number should be 10 digit";
  }
  }
  catch(message){
    isValid=false;
    contactErr.innerHTML=message;
  }
    return isValid
}