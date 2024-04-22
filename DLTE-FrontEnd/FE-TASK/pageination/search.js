
// Sample loan data
const loanData = [
    { id: 1, name: 'Personal Loan', loanType:'Personal', description: 'A loan for personal use,education, medical expenses, travel' },
    { id: 2, name: 'Home Loan',loanType:'Home', description: 'A loan for purchasing a new home or refinancing an existing mortgage.' },
    { id: 3, name: 'Gold Loan', loanType:'Gold',description: 'Unlock the power of your precious metal.' },
    { id: 4, name: 'Education Loan', loanType:'Education',description: 'A loan for financing educational expenses, such as tuition, books, and housing.' },
    { id: 5, name: 'Agriculture Loan', loanType:'Agricultural',description: 'A loan to buying inputs such as fertilizers, seeds, insecticides ' },
    { id: 6, name: 'Business Loan', loanType:'Business',description: 'A loan for starting or expanding a business.' },
];
  
  let currentPage = 1;
  const itemsPerPage = 2;
  
  // Function to display loan table
  function displayLoanTable(loans) {
    const loanTableBody = document.getElementById('loanTableBody');
    loanTableBody.innerHTML = '';
  
    const mainContent = document.getElementById('main-content');
    mainContent.style.display = 'none';
  
    const loanTableContainer = document.getElementById('loan-table-container');
    loanTableContainer.style.display = 'block';
  
    const startIndex = (currentPage - 1) * itemsPerPage;
    const endIndex = startIndex + itemsPerPage;
    const currentLoans = loans.slice(startIndex, endIndex);
  
    currentLoans.forEach(loan => {
      const row = document.createElement('tr');
      row.innerHTML = `
        <td>${loan.name}</td>
        <td>${loan.loanType}</td>
        <td>${loan.description}</td>
      `;
      loanTableBody.appendChild(row);
    });
  
    const totalPages = Math.ceil(loans.length / itemsPerPage);
    const currentPageNum = document.getElementById('currentPageNum');
    currentPageNum.innerHTML = `<a class="page-link" href="#">${currentPage}</a>`;
  
    const prevPageBtn = document.getElementById('prevPageBtn');
    const nextPageBtn = document.getElementById('nextPageBtn');
  
    prevPageBtn.addEventListener('click', () => {
      if (currentPage > 1) {
        currentPage--;
        displayLoanTable(loans);
      }
    });
  
    nextPageBtn.addEventListener('click', () => {
      if (currentPage < totalPages) {
        currentPage++;
        displayLoanTable(loans);
      }
    });
  }
  
  // Function to filter loans based on search input
  function filterLoans(searchTerm) {
    const filteredLoans = loanData.filter(loan =>
      loan.name.toLowerCase().includes(searchTerm.toLowerCase()) ||
      loan.loanType.toLowerCase().includes(searchTerm.toLowerCase())
    );
    currentPage = 1; // Reset to first page
    displayLoanTable(filteredLoans);
  }
  
  // Event listeners
  document.getElementById('allLoansLink').addEventListener('click', (e) => {
    e.preventDefault();
    currentPage = 1; // Reset to first page
    displayLoanTable(loanData);
  });
  
  document.getElementById('searchBtn').addEventListener('click', () => {
    const searchTerm = document.getElementById('searchInput').value;
    filterLoans(searchTerm);
  });