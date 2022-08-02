<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="header.jsp"%>

<h1> Update Page </h1>

<form id="profileUpdate">
  <div class="mb-3">
    <label class="form-label">아이디</label>
    <input type="text" name="orgname" placeholder="아이디" value="${principal.org.orgname}" required="required"/>
  </div>
  <div class="mb-3">
    <label class="form-label">병원</label>
    <input type="text" name="name" placeholder="이름" value="${principal.org.name}" readonly="readonly"/>
  </div>
  <div class="mb-3">
    <label class="form-label">주소</label>
    <input type="text" name="address" placeholder="주소" value="${principal.org.address}" required="required"/>
  </div>
  <div class="mb-3">
     <label class="form-label">전화번호</label>
     <input type="text" name="phone" placeholder="전화번호" value="${principal.org.phone}" required="required"/>
  </div>
  <button type="button" onclick="update(${principal.org.id})" class="btn btn-primary">변경완료</button>
</form>

<script src="/js/org/update.js"></script>

<%@ include file="../layout/footer.jsp"%>
</body>
</html>