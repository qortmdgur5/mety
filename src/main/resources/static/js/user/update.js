//(1) 유저회원정보 수정
function update(userId) {
    let data = $("#profileUpdate").serialize();

    $.ajax({
        type:"put",
        url:`/api/user/${userId}`,
        data:data,
        contentType:"application/x-www-form-urlencoded; charset=utf-8",
        dataType:"json"
    }).done(res=>{
        console.log("update성공");
    }).fail(error=>{
        console.log("update실패");
    });
}