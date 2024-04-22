const itemsPerPage = 2;
let currentPage = 1;

function fetchAccountDetails() {
    let element = document.getElementById('LoanTypes');
    let loanTypeIp=element.value;
    console.log(loanTypeIp);
    let LoanTypes = [
        {  
           id: 101, 
           name: 'Personal Loan', 
           loanType:'Personal', 
           description: 'Personal loan ,for any personal needs' 
        },
        {  
            id: 102, 
            name: 'Personal Loan', 
            loanType:'Personal', 
            description:'Personal loan ,for any personal needs' 
        },    
        {  
            id: 2, 
            name: 'Home Loan',
            loanType:'Home', 
            description: 'want a new home? or wanna reinnovate ? we are here for you' 
        },
        { 
            id: 3, 
            name: 'Gold Loan', 
            loanType:'Gold',
            description: 'Indians have the most amount of gold! why not we get some for you' 
        },
        { 
            id: 4, 
            name: 'Education Loan', 
            loanType:'Education',
            description: 'because without education we are nothing , we will help you persue your dream!' 
        },
        { 
            id: 5, 
            name: 'Agriculture Loan', 
            loanType:'Agriculture',
            description: 'You make the food we cook,and we help you when you are in neeed ' 
        },
        { 
            id: 6, 
            name: 'Business Loan', 
            loanType:'Business',
            description: 'A loan for starting or expanding a business.' 
        }
    ];
    let listLoans = LoanTypes.filter(loan => loan.loanType.toLowerCase().includes(loanTypeIp.toLowerCase()));
    displayAccountDetails(listLoans);
}
function displayAccountDetails(listLoans) {
    const startIndex = (currentPage - 1) * itemsPerPage;
    const endIndex = startIndex + itemsPerPage;
    const paginatedAccounts = listLoans.slice(startIndex, endIndex);

    let loanDetailsContainer = document.getElementById('loansDetailsContainer');
    console.log(loanDetailsContainer.value);
    loanDetailsContainer.innerHTML = '';
    console.log(paginatedAccounts.length);
    if (paginatedAccounts.length > 0) {
        paginatedAccounts.forEach(loan => {
            let loanCard = document.createElement('div');
            loanCard.className = 'col-lg-6 loan-box';
            loanCard.innerHTML = `
                <h3 class="loan-title">Loans Details</h3>
                <p><strong>Loan ID:</strong> ${loan.id}</p>
                <p><strong>Loan name:</strong> ${loan.name}</p>
                <p><strong>Loan type:</strong> ${loan.loanType}</p>
                <p><strong>Description:</strong> ${loan.description}</p>
            `;
            loanDetailsContainer.appendChild(loanCard);
        });
        console.log(listLoans.length);
        renderPagination(listLoans.length);
    } else {
        alert('No loans available for this type.');
    }
}

function renderPagination(totalItems) {
    const totalPages = Math.ceil(totalItems / itemsPerPage);
    const paginationContainer = document.getElementById('pagination');
    paginationContainer.innerHTML = '';

    if (totalPages >=1) {
        for (let i = 1; i <= totalPages; i++) {
            const liClass = (i === currentPage) ? 'page-item active' : 'page-item';
            const paginationHtml = `
                <li class="${liClass}">
                    <button class="page-link" onclick="changePage(${i})">${i}</button>
                </li>
            `;
            paginationContainer.innerHTML += paginationHtml;
        }
    }
}

function changePage(page) {
    currentPage = page;
    fetchAccountDetails();
}