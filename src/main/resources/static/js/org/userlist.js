//(0) 현재 로그인한 사용자 아이디
let principalId = $("#principalId").val();

//(1) 승인된 환자 리스트 가져오기
let page=0;
let startPage;
let endPage;
let currentPage;
let pageStart;
let pageEnd;
let pageState;
let searchText = $("#searchText").val();
let medicalText = $("#medicalText").val();
function userList(id, page, searchText, medicalText) {
    $.ajax({
        url:`/api/org/${id}/userlist?page=${page}&searchText=${searchText}&medicalText=${medicalText}`,
        dataType:"json"
    }).done(res=>{
        console.log("승인된 환자리스트 가져오기 성공")
        console.log(res);
        let pagingButton = userListPaging(res);
        $(".page-item").remove();
        $(".pagination").append(pagingButton);
        $("#userList").empty();
        res.data.content.forEach((user) => {
            let userItem = getUserItem(user);
            $("#userList").append(userItem);
        })
        $(`#${res.data.number}`).addClass("active");
        medicalText = $("#medicalText").val("");
    }).fail(error=>{
        console.log("환자리스트 가져오기 실패")
        console.log(error);
    });
}

userList(principalId, page, searchText, medicalText);

//(1-1) 환자 리스트 아이템
function getUserItem(user) {
    let item = `<tr>
                    <td>${user.name}</td>
                    <td>${user.birth}</td>
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                    <td>${user.phone}</td>
                    <td>${user.medicalInfo}</td>
                    <td>${user.startDate}</td>
                    `;
                    if(user.activate){
                    item += `<td><button id="activateButton-${user.id}" onclick="activate(${user.id})" class="btn btn-primary">활성화</button></td>`
                    }else {
                    item += `<td><button id="activateButton-${user.id}" onclick="activate(${user.id})" class="btn btn-secondary">비활성</button></td>`
                    }

         item += `</tr>`;
    return item;
}

//(1-2) 환자 리스트 페이징
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
                <li class="page-item"><button class="page-link" onclick="userList(principalId, prevPage, searchText, medicalText)">Previous</button></li>`
                } else {
                item+= `
                <li class="page-item"><button class="page-link disabled" onclick="userList(principalId, prevPage, searchText, medicalText)">Previous</button></li>`
                }

                //현재 페이지 넘버가 11페이지 이상일때부터 1페이지로 돌아갈 수 있는 버튼 출력
                if(currentPage>=10){
                item+= `
                <li class="page-item"><button class="page-link" onclick="userList(principalId, startPage, searchText, medicalText)">${startPage+1}</button></li>
                <li class="page-item"><span class="page-link">···</span></li>`
                }

                // 마지막 페이지 리스트가 아닐 때
                if(pageState != 0){
                    for(i = pageStart; i <= pageEnd; i++){
                        item+=`<li class="page-item"><button id="${i}" class="page-link" onclick="userList(principalId, ${i}, searchText, medicalText)">${i+1}</button></li>`
                    }
                    //총 페이지수가 11페이지 이상일 때,  마지막페이지 이동버튼과 '''출력
                    if(endPage >= 11) {
                    item+= `
                    <li class="page-item"><span class="page-link">···</span></li>
                    <li class="page-item"><button class="page-link" onclick="userList(principalId, endPage-1, searchText, medicalText)">${endPage}</button></li>`
                    }
                } else {    //마지막 페이지 리스트일 때
                    for(i = pageStart; i <= endPage-1; i++){
                        item+=`<li class="page-item"><button id="${i}" class="page-link" onclick="userList(principalId, ${i}, searchText, medicalText)">${i+1}</button></li>`
                    }
                }

                //현재 페이지가 마지막 페이지 일때 다음페이지 버튼 미사용, 마지막페이지가 아니라면 사용가능
                if(currentPage == (endPage-1) || currentPage == endPage){
                item+= `
                <li class="page-item"><button class="page-link disabled" onclick="userList(principalId, nextPage, searchText, medicalText)">Next</button></li>`
                } else {
                item+= `
                <li class="page-item"><button class="page-link" onclick="userList(principalId, nextPage, searchText, medicalText)">Next</button></li>`
                }
    return item;
}


//(2) 환자 활성화/비활성화
function activate(id) {
    let activateState = $(`#activateButton-${id}`);

    if(activateState.hasClass("btn-primary")){  //현재 활성화 상태, 클릭하면 비활성화 하도록 하겠다.
        $.ajax({
            type:"post",
            url:`/api/org/${id}/unActivate`,
            dataType:"json"
        }).done(res=>{
            console.log(res);
            console.log("활성화 실패");
        }).fail(error=>{
            console.log(error);
            activateState.addClass("btn-secondary");
            activateState.removeClass("btn-primary");
            activateState.text("비활성");
            console.log("비활성화 성공");
        })
    } else {                                    //현재 비활성화 상태, 클릭하면 활성화하도록 하겠다.
        $.ajax({
            type:"post",
            url:`/api/org/${id}/activate`,
            dataType:"json"
        }).done(res=>{
            console.log(res);
            console.log("활성화 실패");
        }).fail(error=>{
            console.log(error);
            activateState.addClass("btn-primary");
            activateState.removeClass("btn-secondary");
            activateState.text("활성화");
            console.log("활성화 성공");
        })
    }
}


//(3) 검색 구분 이벤트
$('.medical').click(function() {
    text = $(this).text();
    $('#dropdownMenuButton1').text(text).change();
    $('#medicalText').val($(this).val());
})