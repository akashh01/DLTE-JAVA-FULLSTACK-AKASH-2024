const getAllLoans = () => {
    let soapRequest = `<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:loan="http://loans.services">
    <soapenv:Header/>
   <soapenv:Body>
   <loan:viewAllAvailableLoanRequest/>
   </soapenv:Body>
   </soapenv:Envelope>`;

    $.ajax({
        url: "http://localhost:8088/loansrepo/",
        type: "POST",
        dataType: "xml",
        beforeSend: function (handler) {
            handler.setRequestHeader("Authorization","Basic "+sessionStorage.getItem("logged"));
            handler.setRequestHeader("SOAPAction", "viewAllAvailableLoanRequest");
        },
        contentType: "text/xml;charset=utf-8",
        data: soapRequest,
        success: function (response) {

            $('#loanList').empty();


            $(response).find('ns2\\:LoanAvailable').each(function () {

                const loanId = $(this).find('ns2\\:loanNumber').text();
                const loanName = $(this).find('ns2\\:loanType').text();
                const loanType = $(this).find('ns2\\:loanName').text();
                const loanDescription = $(this).find('ns2\\:loanDescription').text();
                const loanRoi = $(this).find('ns2\\:loanRoi').text();
                const loanHtml = `
                <div class="col-md-4 mb-4">
                            <div class="card">
                                <div class="card-body">
                                <br>
                                    <h5 class="card-title">${loanType}</h5>
                                    <p class="card-text">Loan number: ${loanId}</p>
                                    <p class="card-text">loan name: ${loanName}</p>
                                    <p class="card-text">loan description ${loanDescription}</p>
                                    <p class="card-text">loan roi: ${loanRoi}</p>
                                
                                </div>
                            </div>
                        </div>`;
                    
                $('#loanList').append(loanHtml);
            });
        },
        error: function (xhr, status, error) {
            console.error(xhr.responseText);
        }
    });
}
$(document).ready(function () {
    getAllLoans();
});