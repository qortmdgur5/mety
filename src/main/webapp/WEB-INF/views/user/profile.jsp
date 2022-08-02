<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="header.jsp"%>
<div>
<h1> Profile Page </h1>
<a href="/user/${principal.user.id}/update">변경</a>
</div>
<hr/>

<form>
  <div class="mb-3">
    <label class="form-label">번호</label>
    <span>${principal.user.id}</span>
  </div>
  <div class="mb-3">
    <label class="form-label">이름</label>
    <span>${principal.user.name}</span>
  </div>
  <div class="mb-3">
    <label class="form-label">나이</label>
    <span>${principal.user.birth}</span>
  </div>
  <div class="mb-3">
    <label class="form-label">성별</label>
    <span>${principal.user.gender}</span>
  </div>
  <div class="mb-3">
    <label class="form-label">주소</label>
    <span>${principal.user.address}</span>
  </div>
  <div class="mb-3">
     <label class="form-label">전화번호</label>
     <span>${principal.user.phone}</span>
  </div>
  <div class="mb-3">
    <label class="form-label">Email</label>
    <span>${principal.user.email}</span>
  </div>
  <div class="mb-3">
    <label class="form-label">아이디</label>
    <span>${principal.user.username}</span>
  </div>
  <div class="mb-3">
    <label class="form-label">담당기관</label>
    <span>${principal.user.orgName}</span>
  </div>
  <div class="mb-3">
    <label class="form-label">통증부위</label>
    <span>${principal.user.medicalInfo}</span>
  </div>
</form>


<%@ include file="../layout/footer.jsp"%>