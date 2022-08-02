//(0) 현재 로그인한 사용자 아이디
let principalId = $("#principalId").val();
let exercise = [];
let recog = [];
let vas = [];
var i = 0;
//(1) 마이기록 데이터 가져오기
function getMyRecord(id,i) {
    $.ajax({
        url:`/api/user/${id}/myRecord`,
        async:false,
        dataType:"json"
    }).done(res=>{
        console.log("마이기록 가져오기 성공")
        console.log(res);
        res.data.forEach((data) => {
            exercise.push(data.exercise_1/data.rms_MAX1, data.exercise_2/data.rms_MAX2, data.exercise_3/data.rms_MAX3);
            recog.push( recogCal(data.recog_1),  recogCal(data.recog_2),  recogCal(data.recog_3) );
            vas.push(data.vas*0.1, data.vas*0.1, data.vas*0.1);
        })
        getMyChart(i);
    }).fail(error=>{
        console.log("마이기록 가져오기 실패")
        console.log(error);
    });
}

getMyRecord(principalId,i);

//(1-1) 인지값 계산 함수
function recogCal(x) {
    if(x<=90) {
        y = 100;
    } else if(x<=120) {
        y = 190-x;
    } else if(x<=150) {
        y = 230-(4*x/3);
    } else if(x<=180) {
        y = 130-(2*x/3);
    } else {
        y = 10;
    }
    return y*0.01;
}

//(1-2) 주차, 회차 클릭 이벤트
$('.record').click( function() {
    i = Number($(this).val());
    $('#myChart').remove();
    $('.myChartWrap').append('<canvas id="myChart"></canvas>');
    getMyRecord(principalId,i);
})

//(1-3) 마이기록 차트 아이템
function getMyChart(i) {
    const ctx = document.getElementById('myChart').getContext('2d');
    const myChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: ['1라운드', '2라운드', '3라운드'],
            datasets: [{
                label: '운동',
                data: [exercise[i], exercise[i+1], exercise[i+2]],
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)'
                ],
                borderColor: [
                    'rgba(255, 99, 132, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)'
                ],
                borderWidth: 5
            }, {
                label: '인지',
                data: [recog[i], recog[i+1], recog[i+2]],
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)'
                ],
                borderColor: [
                    'rgba(255, 99, 132, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)'
                ],
                borderWidth: 5
            }, {
                label: 'vas',
                data: [vas[i]],
                backgroundColor: [
                    'rgba(55, 99, 132, 0.2)'
                ],
                borderColor: [
                    'rgba(55, 99, 132, 1)'
                ],
                borderWidth: 5
            }]
        },
        options: {
            scales: {
                y: {
                    min: 0,
                    max: 1,
                }
            }
        },
    });
}


