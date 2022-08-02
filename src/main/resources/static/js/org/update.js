//(1) 유저회원정보 수정
function update(orgId) {
    let data = $("#profileUpdate").serialize();

    $.ajax({
        type:"put",
        url:`/api/org/${orgId}`,
        data:data,
        contentType:"application/x-www-form-urlencoded; charset=utf-8",
        dataType:"json"
    }).done(res=>{
        console.log("update성공");
        console.log(res);
    }).fail(error=>{
        console.log("update실패");
    });
}