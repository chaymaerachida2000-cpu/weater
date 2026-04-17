// 1. حطي الكود ديال الـ API هنا (خودي واحد فابور من openweathermap.org)
const apiKey = "724b2a92510b4372a15d849e4a8ee6aa"; 

const submitBtn = document.getElementById('submit-btn');
const cityInput = document.getElementById('city-name');
const nameInput = document.getElementById('user-name');


submitBtn.addEventListener('click', () => {
    const city = cityInput.value;
    const user = nameInput.value;

    if (city === "") {
        alert("Please enter a city name!");
        return;
    }

    
   

    // استدعاء الوظيفة اللي كتجيب الحرارة
    getWeather(city);
});

async function getWeather(city) {
    // هاد الرابط كيمشي يجيب المعلومات من القمر الصناعي ديال الأرصاد الجوية
    const url = `https://api.openweathermap.org/data/2.5/weather?q=${city}&units=metric&appid=${apiKey}`;

    try {
        const response = await fetch(url);
        const data = await response.json();

        if (data.cod === 200) {
            // 2. هنا كنبدلو المعلومات فـ الصفحة ديالك
            document.querySelector('.weather-header h1').innerText = data.name;
            document.querySelector('.actual-temp').innerText = `${Math.round(data.main.temp)}°C - actual`;
            
            // سدي المنيو فاش يطلع النتيجة (إلا بغيتي)
            document.getElementById('form-box').style.display = 'none';
        } else {
            alert("City not found. Try again!");
        }
    } catch (error) {
        console.log("Error:", error);
    }
}