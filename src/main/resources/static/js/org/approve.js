
//(0) 현재 로그인한 사용자 아이디
let principalId = $("#principalId").val();

//(1) 신청한 환자 리스트 가져오기
let page = 0;
let startPage;
let endPage;
let currentPage;
let pageStart;
let pageEnd;
let pageState;
let nameText = $("#nameText").val();
let medicalText = $("#medicalText").val();
function approveList(id, page, nameText, medicalText) {
    $.ajax({
        url:`/api/org/${id}/approve?page=${page}&nameText=${nameText}&medicalText=${medicalText}`,
        dataType:"json"
    }).done(res=>{
        console.log("신청한 환자리스트 가져오기 성공")
        console.log(res);
        let pagingButton = userListPaging(res);
        $(".page-item").remove();
        $(".pagination").append(pagingButton);
        $("#approveList").empty();
        res.data.content.forEach((user) => {
            let approveItem = getApproveItem(user);
            $("#approveList").append(approveItem);
        })
        $(`#${res.data.number}`).addClass("active");
        medicalText = $("#medicalText").val("");
    }).fail(error=>{
        console.log("환자리스트 가져오기 실패")
        console.log(error);
    });
}

approveList(principalId, page, nameText, medicalText);

function getApproveItem(user) {
    let item = `<tr id="userList-${user.id}">
                    <td>${user.name}</td>
                    <td>${user.birth}</td>
                    <td>${user.phone}</td>
                    <td>${user.medicalInfo}</td>
                    <td>
                        <button onclick="approve(${user.id})" class="btn btn-secondary">승인대기</button>
                    </td>
                </tr>`
    return item;
}

//(1-1) 환자 리스트 페이징
function userListPaging(res) {
    startPage = 0;
    currentPage = res.data.number;
    endPage = res.data.totalPages;
    pageStart = (Math.floor(currentPage/10))*10;    // 1~10페이지면 0, 11~20페이지면 10, 21~30페이지면 20
    pageEnd = pageStart + 9;
    pageState = Math.floor((endPage-1-pageStart)/10);
    nextPage = currentPage + 1;
    prevPage = currentPage - 1;
    let i;
    let item= ``;
                //현재페이지와 첫번째 페이지가 같다면 이전페이지 버튼 미사용, 시작페이지가 아니라면 사용가능
                if(currentPage != (startPage)){
                item+= `
                <li class="page-item"><button class="page-link" onclick="approveList(principalId, prevPage, nameText, medicalText)">Previous</button></li>`
                } else {
                item+= `
                <li class="page-item"><button class="page-link disabled" onclick="approveList(principalId, prevPage, nameText, medicalText)">Previous</button></li>`
                }

                //현재 페이지 넘버가 11페이지 이상일때부터 1페이지로 돌아갈 수 있는 버튼 출력
                if(currentPage>=10){
                item+= `
                <li class="page-item"><button class="page-link" onclick="approveList(principalId, startPage, nameText, medicalText)">${startPage+1}</button></li>
                <li class="page-item"><span class="page-link">···</span></li>`
                }

                // 마지막 페이지 리스트가 아닐 때
                if(pageState != 0){
                    for(i = pageStart; i <= pageEnd; i++){
                        item+=`<li class="page-item"><button id="${i}" class="page-link" onclick="approveList(principalId, ${i}, nameText, medicalText)">${i+1}</button></li>`
                    }
                    //총 페이지수가 11페이지 이상일 때,  마지막페이지 이동버튼과 '''출력
                    if(endPage >= 11) {
                    item+= `
                    <li class="page-item"><span class="page-link">···</span></li>
                    <li class="page-item"><button class="page-link" onclick="approveList(principalId, endPage-1, nameText, medicalText)">${endPage}</button></li>`
                    }
                } else {    //마지막 페이지 리스트일 때
                    for(i = pageStart; i <= endPage-1; i++){
                        item+=`<li class="page-item"><button id="${i}" class="page-link" onclick="approveList(principalId, ${i}, nameText, medicalText)">${i+1}</button></li>`
                    }
                }

                //현재 페이지가 마지막 페이지 일때 다음페이지 버튼 미사용, 마지막페이지가 아니라면 사용가능
                if(currentPage == (endPage-1) || currentPage == endPage){
                item+= `
                <li class="page-item"><button class="page-link disabled" onclick="approveList(principalId, nextPage, nameText, medicalText)">Next</button></li>`
                } else {
                item+= `
                <li class="page-item"><button class="page-link" onclick="approveList(principalId, nextPage, nameText, medicalText)">Next</button></li>`
                }


    return item;
}

//(2) 환자 신청승인
function approve(id) {

    let approveState = $(`#userList-${id}`);

    $.ajax({
        type:"post",
        url:`/api/org/${id}/approve`,
        dataType:"json"
    }).done(res=>{
        console.log(res);
        console.log("신청승인 실패");
    }).fail(error=>{
        console.log(error);
        approveState.css("display", "none");
        approveList(principalId, page, nameText, medicalText);
        console.log("신청승인 성공");
    })
}


//(3) 검색 구분 이벤트
$('.medical').click(function() {
    text = $(this).text();
    $('#dropdownMenuButton1').text(text).change();
    $('#medicalText').val($(this).val());
})