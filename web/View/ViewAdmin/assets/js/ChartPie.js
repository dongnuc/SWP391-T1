window.addEventListener('load', function () {
     var chartDataJson = document.getElementById('chartData').textContent;
            var chartData = JSON.parse(chartDataJson);

            // Tạo nhãn và dữ liệu cho biểu đồ
            var labels = [];
            var data = [];

            for (var key in chartData) {
                if (chartData.hasOwnProperty(key)) {
                    labels.push(key);
                    data.push(chartData[key]);
                }
            }
            // Vẽ biểu đồ tròn
            var ctx = document.getElementById('myPieChart').getContext('2d');

            var myPieChart = new Chart(ctx, {
                type: 'bar',
                    data: {
                        labels: labels,
                        datasets: [{
                            label: 'Number of Students',
                            data: data,
                            backgroundColor: 'rgba(75, 192, 192, 0.2)',
                            borderColor: 'rgba(75, 192, 192, 1)',
                            borderWidth: 1
                        }]
                    },
                    options: {
                        scales: {
                            y: {
                                beginAtZero: true
                            }
                        }
                    }
            });
});