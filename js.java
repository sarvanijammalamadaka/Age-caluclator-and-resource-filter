document.getElementById('ageForm').addEventListener('submit', function(event) {
    event.preventDefault();
    
    const birthYear = document.getElementById('birthYear').value;
    const currentYear = new Date().getFullYear();
    const age = currentYear - birthYear;

    document.getElementById('age').textContent = age;

    const content = document.getElementById('content');
    content.innerHTML = '';

    const data = getDataForAge(age);
    
    if (data) {
        content.innerHTML = `
			<h3>Links:</h3>
			</br>
            <ul>${data.links.map(link => `<li><a href="${link.url}" target="_blank">${link.name}</a></li>`).join('')}</ul>
            <h3>Places to Visit:</h3>
			</br>
            <ul>${data.places.map(place => `<li>${place}</li>`).join('')}</ul>
            <h3>Quotes:</h3>
			</br>
            <p>"${data.quotes}"</p>
            <h3>Activities:</h3>
			</br>
            <ul>${data.activities.map(activity => `<li>${activity}</li>`).join('')}</ul>
        `;
    } else {
        content.innerHTML = '<p>No data available for this age group.</p>';
    }

    document.getElementById('results').classList.remove('hidden');
});

function getDataForAge(age) {
    if (age <= 18) {
        return {
            links: [
                { name: 'Educational Resources', url: 'https://www.khanacademy.org' },
                { name: 'Fun Activities for Kids', url: 'https://www.funology.com' }
            ],
            places: ['Country Culture Area', 'Zoo or  Parks', 'Museums'],
            quotes: 'The beautiful thing about learning is that no one can take it away from you.',
            activities: ['Playing Sports', 'Learning a Musical Instrument', 'Drawing and Painting']
        };
    } else if (age <= 50) {
        return {
            links: [
                { name: 'Testbook', url: 'https://testbook.com/' },
                { name: 'Internshala', url: 'https://internshala.com/' }
            ],
            places: ['India', 'Amazon forest', 'Tokyo'],
            quotes: 'The best time to plant a tree was 20 years ago. The second best time is now.',
            activities: ['Adventures', 'Fitness', 'Coding Bootcamp']
        };
    } else {
        return {
            links: [
                { name: 'thirdAGE', url: 'https://thirdage.com/' },
                { name: 'Amintro', url: 'https://amintro.com/#:~:text=Amintro%20is%20the%20best%20social,fashioned%20power%20of%20simple%20friendship.' }
            ],
            places: ['Rajasthan-India', 'Tokyo-Japan', 'Rome-Italy'],
            quotes: 'You are never too old to set another goal or to dream a new dream.',
            activities: ['Gardening', 'Reading', 'Yoga']
        };
    }
}
