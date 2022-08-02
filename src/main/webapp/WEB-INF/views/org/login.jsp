<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="header.jsp"%>

<h1> Index Page </h1>
<button type="button" class="btn btn-link" onclick="location.href='/user/login'">환자</button>
<button type="button" class="btn btn-link" onclick="location.href='/org/login'">기관</button>
<hr/>
<div class="container">
    <form action="/org/login" method="POST">
        <input type="text" name="orgname" id="orgname" placeholder="기관아이디"/>
        <input type="password" name="password" id="password"/>
        <button>Login</button>
    </form>
</div>

<%@ include file="../layout/footer.jsp"%>
</body>
</html>