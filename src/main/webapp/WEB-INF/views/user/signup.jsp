<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="header.jsp"%>

<h1> SignUp Page </h1>
<button type="button" class="btn btn-link" onclick="location.href='/user/signup'">환자</button>
<button type="button" class="btn btn-link" onclick="location.href='/org/signup'">기관</button>
<hr/>

<form action="/user/signup" method="post">
  <div class="mb-3">
    <label class="form-label">아이디</label>
    <input type="text" class="form-control" id="username" name="username" aria-describedby="emailHelp">
  </div>
  <div class="mb-3">
    <label class="form-label">비밀번호</label>
    <input type="password" class="form-control" id="password" name="password">
  </div>
  <div class="mb-3">
    <label class="form-label">이름</label>
    <input type="name" class="form-control" id="name" name="name">
  </div>
  <div class="mb-3">
    <label class="form-label">생년월일</label>
    <input type="text" id="datepicker" name="birth" class="form-control datepicker" />
  </div>
  <div class="mb-3">
    <label class="form-label">성별</label>
    <div class="form-control">
    <input type="radio" name="gender" value="true">남
    <input type="radio" name="gender" value="false">여
    </div>
  </div>
  <div class="mb-3">
     <label class="form-label">Email</label>
     <input type="email" class="form-control" id="email" name="email">
  </div>
  <div class="mb-3">
    <label class="form-label">휴대전화</label>
    <input type="text" class="form-control" id="phone" name="phone">
  </div>
  <div class="mb-3">
    <label class="form-label">주소</label>
    <input type="text" class="form-control" id="address" name="address">
  </div>
  <div class="mb-3">
    <label class="form-label">담당기관</label>
    <select class="form-control" id="orgName" name="orgName">
      <option value="삼성병원">삼성병원</option>
      <option value="엘지병원">엘지병원</option>
      <option value="라이징크래프트병원">라이징크래프트병원</option>
    </select>
  </div>
  <div class="mb-3">
      <label class="form-label">통증부위</label>
      <select class="form-control" id="medicalInfo" name="medicalInfo">
        <option value="1">좌상지</option>
        <option value="2">우상지</option>
        <option value="3">좌족</option>
        <option value="4">우족</option>
      </select>
    </div>
  <button class="btn btn-primary">회원가입</button>
</form>


<!--날짜 캘린더 스크립트 -->

<script>
    $('#datepicker').datepicker({
        dateFormat: 'yy-mm-dd',
        prevText: '이전 달',
        nextText: '다음 달',
        monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        dayNames: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
        showMonthAfterYear: true,
        yearSuffix: '년'
    })
    .on('changeDate', function(e) {
        console.log(e);
    });
</script>

<%@ include file="../layout/footer.jsp"%>