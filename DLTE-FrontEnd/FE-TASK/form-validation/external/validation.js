const performValidate=()=>{
   var isValid=true
   var myForm = document.forms['application']
   const name = myForm.accountHolder.value
   const accNum=myForm.accountNumber.value
   const contact=myForm.contacts.value
   const date=myForm.datesOfapp.value
   var nameErr=document.getElementById("nameErr")
   var emailErr=document.getElementById("emailErr")
   var accErr=document.getElementById("accErr")
   var contactErr=document.getElementById("contactErr")
   var dateErr=document.getElementById("dateErr")
   try{
    if(date==null){
        throw "*date cannot be null"
    }
    }
    catch(message){
      isValid=false
      nameErr.innerHTML=message
    }

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
document.getElementById('booktype').addEventListener('change', function() {
  if (this.value === '') {
      alert('Please select a type');
  }
});
document.getElementById('savings').addEventListener('change', validateRadio);
document.getElementById('salary').addEventListener('change', validateRadio);

function validateRadio() {
    var savings = document.getElementById('savings');
    var salary = document.getElementById('salary');
    if (!savings.checked && !salary.checked) {
        alert('Please select an account type');
    }
}