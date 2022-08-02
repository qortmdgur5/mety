<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="header.jsp"%>


<div class="container">
      <h2>환자목록 페이지</h2>
      <form class="d-flex" role="search" id="userSearch" method="GET" action="/org/${id}/userlist">
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
        <input class="form-control me-2" name="searchText" value="${param.searchText}" id="searchText" placeholder="이름">
        <button type="submit" class="btn btn-outline-success">Search</button>
      </form>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>이름</th>
        <th>생일</th>
        <th>아이디</th>
        <th>이메일</th>
        <th>핸드폰</th>
        <th>절단부위</th>
        <th>시작날짜</th>
        <th>활성화</th>
      </tr>
    </thead>

    <tbody id="userList">
        <!-- 승인된 환자 리스트 출력 -->
    </tbody>
  </table>
  <ul class="pagination justify-content-center" id="userListPaging">
    <!-- 페이징 버튼 출력 -->
  </ul>
</div>

<script src="/js/org/userlist.js"></script>
<%@ include file="../layout/footer.jsp"%>