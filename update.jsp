<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Update" method="POST">
	<p>Enter Your Booking id : <input type="text" name="id"></p>
	<p>Enter Number : <input type="text" name="number"></p>
	<p>Enter Date : <input type="date" name="date"></p>
	<p>Entry Time : <input type="time" name="etime"></p>
	<p>Exit Time : <input type="time" name="exittime"></p>
	<p><input type="submit" name="Book Now"></p>
</form>
</body>
</html>