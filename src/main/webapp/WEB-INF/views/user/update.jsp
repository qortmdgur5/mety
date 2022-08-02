<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="header.jsp"%>

<h1> Update Page </h1>

<form id="profileUpdate">
  <div class="mb-3">
    <label class="form-label">아이디</label>
    <input type="text" name="username" placeholder="아이디" value="${principal.user.username}" required="required"/>
  </div>
  <div class="mb-3">
    <label class="form-label">이름</label>
    <input type="text" name="name" placeholder="이름" value="${principal.user.name}" readonly="readonly"/>
  </div>
  <div class="mb-3">
    <label class="form-label">나이</label>
    <input type="text" name="birth" placeholder="나이" value="${principal.user.birth}" required="required"/>
  </div>
  <div class="mb-3">
    <label class="form-label">성별</label>
    <input type="text" name="gender" placeholder="성별" value="${principal.user.gender}" required="required"/>
  </div>
  <div class="mb-3">
    <label class="form-label">주소</label>
    <input type="text" name="address" placeholder="주소" value="${principal.user.address}" required="required"/>
  </div>
  <div class="mb-3">
     <label class="form-label">전화번호</label>
     <input type="text" name="phone" placeholder="전화번호" value="${principal.user.phone}" required="required"/>
  </div>
  <div class="mb-3">
    <label class="form-label">Email</label>
    <input type="text" name="email" placeholder="Email" value="${principal.user.email}" required="required"/>
  </div>
  <div class="mb-3">
    <label class="form-label">담당기관</label>
    <input type="text" name="orgName" placeholder="담당기관" value="${principal.user.orgName}" required="required"/>
  </div>
  <div class="mb-3">
    <label class="form-label">통증부위</label>
    <input type="text" name="medicalInfo" placeholder="통증부위" value="${principal.user.medicalInfo}" required="required"/>
  </div>

  <button type="button" onclick="update(${principal.user.id})" class="btn btn-primary">변경완료</button>
</form>

<script src="/js/user/update.js"></script>

<%@ include file="../layout/footer.jsp"%>
</body>
</html>