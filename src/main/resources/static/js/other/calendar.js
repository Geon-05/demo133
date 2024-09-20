const monthYear = document.getElementById('monthYear');
const calendarDays = document.getElementById('calendarDays');
const eventsList = document.getElementById('events');

let currentDate = new Date();
// 이벤트 DB에서 가져오도록 변경예정
let events = [
    { date: '2024-09-21', title: '도서관 강연' },
    { date: '2024-09-22', title: '책 모임' },
    { date: '2024-09-25', title: '어린이 독서 워크숍' }
];

function renderCalendar() {
    const year = currentDate.getFullYear();
    const month = currentDate.getMonth();

    // 달력의 날짜 및 월 표기
    monthYear.innerText = `${year}년 ${month + 1}월`;

    // 해당 월의 첫날과 마지막 날 계산
    const firstDay = new Date(year, month, 1).getDay();
    const lastDate = new Date(year, month + 1, 0).getDate();

    // 달력 초기화
    calendarDays.innerHTML = '';

    // 빈 칸 추가 (해당 월 첫 번째 요일 전까지)
    for (let i = 0; i < firstDay; i++) {
        const emptyCell = document.createElement('div');
        emptyCell.classList.add('empty');
        calendarDays.appendChild(emptyCell);
    }

    // 날짜 추가
    for (let day = 1; day <= lastDate; day++) {
        const dateCell = document.createElement('div');
        
        dateCell.innerText = day;
        const dateString = `${year}-${String(month + 1).padStart(2, '0')}-${String(day).padStart(2, '0')}`;
        
        // 날짜 클릭 시 이벤트 표시
        dateCell.addEventListener('click', () => displayEvents(dateString));
        
        calendarDays.appendChild(dateCell);
    }
}

function displayEvents(dateString) {
    eventsList.innerHTML = '';
    const dayEvents = events.filter(event => event.date === dateString);
    
    if (dayEvents.length === 0) {
        eventsList.innerHTML = '<li>이 날에는 이벤트가 없습니다.</li>';
    } else {
        dayEvents.forEach(event => {
            const li = document.createElement('li');
            li.innerText = event.title;
            eventsList.appendChild(li);
        });
    }
}

// 이전 및 다음 달 버튼 기능
document.getElementById('prevMonth').addEventListener('click', () => {
    currentDate.setMonth(currentDate.getMonth() - 1);
    renderCalendar();
});

document.getElementById('nextMonth').addEventListener('click', () => {
    currentDate.setMonth(currentDate.getMonth() + 1);
    renderCalendar();
});

// 초기 렌더링
renderCalendar();