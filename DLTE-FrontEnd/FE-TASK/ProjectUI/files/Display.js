document.addEventListener('DOMContentLoaded', function() {
    var jsonData = {
        "cards": [
            {
                "frontTitle": "Agriculture Loan",
                "backTitle": "Krishi sahayak loan",
                "frontText": "Low interest, Instant money",
                "backText": "Max tenure: 2 Years | ROI: 7.2"
            },
            {
                "frontTitle": "Educational Loan",
                "backTitle": "Scholars support loan",
                "frontText": "Low interest, Instant money",
                "backText": "Max tenure: 5 Years | ROI: 8.2"
            },
            {
                "frontTitle": "Business Loan",
                "backTitle": "Stronger together business loan",
                "frontText": "Low interest, Instant money",
                "backText": "Max tenure: 8 Years | ROI: 9.0"
            }
        ]
    };

    document.querySelectorAll('.flip-card-inner').forEach(function(flipCardInner, index) {
        const frontTitle = flipCardInner.querySelector('.flip-card-front .card-title');
        const backTitle = flipCardInner.querySelector('.flip-card-back .card-title');
        const frontText = flipCardInner.querySelector('.flip-card-front .card-text');
        const backText = flipCardInner.querySelector('.flip-card-back .card-text');

        if (index < jsonData.cards.length) {
            // Populate front side
            if (frontTitle) {
                frontTitle.textContent = jsonData.cards[index].frontTitle;
            }
            if (frontText) {
                frontText.textContent = jsonData.cards[index].frontText;
            }

            // Populate back side
            if (backTitle) {
                backTitle.textContent = jsonData.cards[index].backTitle;
            }
            if (backText) {
                backText.textContent = jsonData.cards[index].backText;
            }
        }
    });
});