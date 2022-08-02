<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="header.jsp"%>

<div class="container">
  <h2>신청승인 페이지</h2>
  <form class="d-flex" role="search" id="userSearch" method="GET" action="/org/${id}/approve">
    <div class="medicalDropdown">
      <button class="btn btn-secondary dropdown-toggle" type="button" name="medicalDropdownMenu" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">부위</button>
      <ul class="dropdown-menu" id="medicalTextMenu">
        <li class="medical dropdown-item" value="1">좌상지</li>
        <li class="medical dropdown-item" value="2">우상지</li>
        <li class="medical dropdown-item" value="3">좌족</li>
        <li class="medical dropdown-item" value="4">우족</li>
      </ul>
    </div>
    <input type="hidden" name="medicalText" id="medicalText" value="${param.medicalText}"/>
    <input class="form-control me-2" name="nameText" value="${param.nameText}" id="nameText" placeholder="이름">
    <button type="submit" class="btn btn-outline-success">search</button>
  </form>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>이름</th>
        <th>생일</th>
        <th>전화번호</th>
        <th>부위</th>
        <th>승인</th>
      </tr>
    </thead>

    <tbody id="approveList">
    <!-- 환자 승인대기 리스트 출력 -->
    </tbody>
  </table>
  <ul class="pagination justify-content-center">
    <!-- 페이징 버튼 출력 -->
  </ul>
</div>
<script src="/js/org/approve.js"></script>
<%@ include file="../layout/footer.jsp"%>