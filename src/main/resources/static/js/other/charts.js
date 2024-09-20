// Chart.js 기본 설정 업데이트
Chart.defaults.font.family = 'Nunito, -apple-system, system-ui, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif';
Chart.defaults.color = '#858796';

// 숫자 형식 함수 개선
function number_format(number, decimals = 0, dec_point = '.', thousands_sep = ',') {
  number = parseFloat(number);
  if (!isFinite(number)) {
    return '0';
  }

  const n = number.toFixed(decimals);
  const parts = n.split('.');
  parts[0] = parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, thousands_sep);
  return parts.join(dec_point);
}

// 영역 차트 예제
const areaCtx = document.getElementById("myAreaChart").getContext('2d');
const myLineChart = new Chart(areaCtx, {
  type: 'line',
  data: {
    labels: ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"],
    datasets: [{
      label: "수익",
      data: [0, 10000, 5000, 15000, 10000, 20000, 15000, 25000, 20000, 30000, 25000, 40000],
      backgroundColor: "rgba(78, 115, 223, 0.05)",
      borderColor: "rgba(78, 115, 223, 1)",
      fill: true,
      tension: 0.3,
      pointRadius: 3,
      pointBackgroundColor: "rgba(78, 115, 223, 1)",
      pointBorderColor: "#fff",
      pointHoverRadius: 5,
      pointHoverBackgroundColor: "rgba(78, 115, 223, 1)",
      pointHoverBorderColor: "#fff",
      pointHitRadius: 10,
      pointBorderWidth: 2,
    }],
  },
  options: {
    responsive: true,
    maintainAspectRatio: false,
    layout: {
      padding: {
        left: 10,
        right: 25,
        top: 25,
        bottom: 0,
      },
    },
    scales: {
      x: {
        grid: {
          display: false,
          drawBorder: false,
        },
        ticks: {
          maxTicksLimit: 12,
        },
      },
      y: {
        ticks: {
          maxTicksLimit: 5,
          padding: 10,
          callback: function(value) {
            return '₩' + number_format(value);
          },
        },
        grid: {
          color: "rgb(234, 236, 244)",
          drawBorder: false,
          borderDash: [2],
          zeroLineBorderDash: [2],
        },
      },
    },
    plugins: {
      legend: {
        display: false,
      },
      tooltip: {
        backgroundColor: "rgb(255,255,255)",
        bodyColor: "#858796",
        titleMarginBottom: 10,
        titleColor: '#6e707e',
        titleFont: { size: 14 },
        borderColor: '#dddfeb',
        borderWidth: 1,
        padding: 15,
        displayColors: false,
        mode: 'index',
        intersect: false,
        callbacks: {
          label: function(context) {
            const label = context.dataset.label || '';
            return label + ': ₩' + number_format(context.parsed.y);
          },
        },
      },
    },
  },
});

// 파이 차트 예제
const pieCtx = document.getElementById("myPieChart").getContext('2d');
const myPieChart = new Chart(pieCtx, {
  type: 'doughnut',
  data: {
    labels: ["직접", "추천", "소셜"],
    datasets: [{
      data: [55, 30, 15],
      backgroundColor: ['#4e73df', '#1cc88a', '#36b9cc'],
      hoverBackgroundColor: ['#2e59d9', '#17a673', '#2c9faf'],
      borderColor: "rgba(234, 236, 244, 1)",
    }],
  },
  options: {
    responsive: true,
    maintainAspectRatio: false,
    plugins: {
      tooltip: {
        backgroundColor: "rgb(255,255,255)",
        bodyColor: "#858796",
        borderColor: '#dddfeb',
        borderWidth: 1,
        padding: 15,
        displayColors: false,
        caretPadding: 10,
      },
      legend: {
        display: false,
      },
    },
    cutout: '80%',
  },
});