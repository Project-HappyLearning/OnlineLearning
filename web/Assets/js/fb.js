const ratings = document.querySelectorAll('.rating');
const ratingsContainer = document.querySelector('.ratings-container');
const sendBtn = document.querySelector('#send');
const feedback = document.querySelector('#feedback');
let selectedRating = 'Tuyệt Vời'; // Default rating text in Vietnamese

ratingsContainer.addEventListener('click', (e) => {
  if (e.target.closest('.rating')) {
    removeActive();
    e.target.closest('.rating').classList.add('active');
    selectedRating = e.target.closest('.rating').querySelector('small').textContent.trim();
  }
});

sendBtn.addEventListener('click', () => {
  feedback.innerHTML = `
    <i class="fas fa-heart"></i>
    <strong>Thank You!</strong>
    <br>
    <strong>Feedback: ${selectedRating}</strong>
    <p>Chúng tôi sẽ sử dụng phản hồi của bạn để cải thiện dịch vụ hỗ trợ khách hàng của chúng tôi.</p>
    <button id="homeBtn" class="btn">Return to Home</button>`;
  
  document.getElementById('homeBtn').addEventListener('click', () => {
    window.location.href = '../home.jsp'; // Change 'home.jsp' to the home page URL
  });
});

function removeActive() {
  ratings.forEach(rating => {
    rating.classList.remove('active');
  });
}
