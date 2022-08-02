<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="header.jsp"%>
<div>
<h1> Profile Page </h1>
<a href="/org/${principal.org.id}/update">변경</a>
</div>
<hr/>

<form>
  <div class="mb-3">
    <label class="form-label">아이디</label>
    <span>${principal.org.orgname}</span>
  </div>
  <div class="mb-3">
    <label class="form-label">병원</label>
    <span>${principal.org.name}</span>
  </div>
  <div class="mb-3">
    <label class="form-label">주소</label>
    <span>${principal.org.address}</span>
  </div>
  <div class="mb-3">
     <label class="form-label">전화번호</label>
     <span>${principal.org.phone}</span>
  </div>
</form>


<%@ include file="../layout/footer.jsp"%>