// custom.js
document.addEventListener('DOMContentLoaded', function() {
    const frontTitles = ["Agriculture Loan", "Educational Loan", "Business Loan"]; // Custom titles for front side
    const backTitles = ["Krishi sahayak loan", "Scholars support  loan", "Stronger together business loan"]; // Custom titles for back side
    const frontTexts = ["Low intrest,Instant money", "Low intrest,Instant money", "Low intrest,instant money"]; // Custom texts for front side
    const backTexts = ["Max tenure: 2 Years | ROI: 7.2", "Max tenure: 5 Years | ROI: 8.2", "Max tenure: 8 Years | ROI: 9.0"]; // Custom texts for back side

    document.querySelectorAll('.flip-card-inner').forEach(function(flipCardInner, index) {
        const frontTitle = flipCardInner.querySelector('.flip-card-front .card-title');
        const backTitle = flipCardInner.querySelector('.flip-card-back .card-title');
        const frontText = flipCardInner.querySelector('.flip-card-front .card-text');
        const backText = flipCardInner.querySelector('.flip-card-back .card-text');


        if (frontTitle) {
            frontTitle.textContent = frontTitles[index % frontTitles.length];
        }

        if (frontText) {
            frontText.textContent = frontTexts[index % frontTexts.length];
        }


        if (backTitle) {
            backTitle.textContent = backTitles[index % backTitles.length];
        }

        if (backText) {
            backText.textContent = backTexts[index % backTexts.length];
        }
    });
});
