<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="header.jsp"%>
<h1> MyRecord 페이지 </h1>

    <div class="container">
        <div class="row">
            <div class="col-md-12 myChartWrap">
                <canvas id="myChart"></canvas>
            </div>
        </div>
    </div>
    <div class="weekWrapBox container">
        <button type="button" class="btn btn-light">종합</button>
        <div class="container">
            <button class="record"  type="button" class="btn btn-light">1주차</button>
            <button class="record"  type="button" value="0" class="btn btn-light">1회차</button>
            <button class="record"  type="button" value="3" class="btn btn-light">2회차</button>
            <button class="record"  type="button" value="6" class="btn btn-light">3회차</button>
        </div>
        <div class="container">
            <button class="record"  type="button" type="button" class="btn btn-light">2주차</button>
            <button class="record"  type="button" value="9" class="btn btn-light">1회차</button>
            <button class="record"  type="button" value="12" class="btn btn-light">2회차</button>
            <button class="record"  type="button" value="15" class="btn btn-light">3회차</button>
        </div>
        <div class="container">
            <button class="record"  type="button" type="button" class="btn btn-light">3주차</button>
            <button class="record"  type="button" value="18" class="btn btn-light">1회차</button>
            <button class="record"  type="button" value="21" class="btn btn-light">2회차</button>
            <button class="record"  type="button" value="24" class="btn btn-light">3회차</button>
        </div>
        <div class="container">
            <button class="record"  type="button" class="btn btn-light">4주차</button>
            <button class="record"  type="button" value="27" class="btn btn-light">1회차</button>
            <button class="record"  type="button" value="30" class="btn btn-light">2회차</button>
            <button class="record"  type="button" value="33" class="btn btn-light">3회차</button>
        </div>
    </div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.8.2/chart.min.js"></script>
<script src="/js/user/myRecord.js"></script>
<%@ include file="../layout/footer.jsp"%>