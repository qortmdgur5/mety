<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<h1> SignUp Page </h1>
<button type="button" class="btn btn-link" onclick="location.href='/user/signup'">환자</button>
<button type="button" class="btn btn-link" onclick="location.href='/org/signup'">기관</button>
<hr/>

<form action="/org/signup" method="post">
  <div class="mb-3">
    <label class="form-label">아이디</label>
    <input type="text" class="form-control" id="orgname" name="orgname">
  </div>
  <div class="mb-3">
    <label class="form-label">비밀번호</label>
    <input type="password" class="form-control" id="password" name="password">
  </div>
  <div class="mb-3">
    <label class="form-label">병원이름</label>
    <input type="name" class="form-control" id="name" name="name">
  </div>
  <div class="mb-3">
    <label class="form-label">Phone</label>
    <input type="text" class="form-control" id="phone" name="phone">
  </div>
  <div class="mb-3">
    <label class="form-label">주소</label>
    <input type="text" class="form-control" id="address" name="address">
  </div>
  <button class="btn btn-primary">회원가입</button>
</form>


<%@ include file="../layout/footer.jsp"%>