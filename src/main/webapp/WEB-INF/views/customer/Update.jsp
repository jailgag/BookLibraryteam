<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>회원 정보 수정</title>
    <style>
        form {
            width: 80%;
            margin: 20px auto;
        }
        input[type="text"], input[type="password"], input[type="number"], select {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }
        input[type="submit"] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            margin: 5px 0;
            border: none;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <h2>회원 정보 수정</h2>
    <form action="/customer/update" method="post">
        <input type="hidden" name="userId" value="${customer.userId}">
        <label for="userPw">비밀번호</label>
        <input type="password" id="userPw" name="userPw" value="${customer.userPw}" required>

        <label for="userName">이름</label>
        <input type="text" id="userName" name="userName" value="${customer.userName}" required>

        <label for="userAge">나이</label>
        <input type="number" id="userAge" name="userAge" value="${customer.userAge}" required>

        <label for="addr">주소</label>
        <input type="text" id="addr" name="addr" value="${customer.addr}" required>

        <label for="gender">성별</label>
        <select id="gender" name="gender" required>
            <option value="M" ${customer.gender == 'M' ? 'selected' : ''}>남</option>
            <option value="F" ${customer.gender == 'F' ? 'selected' : ''}>여</option>
        </select>

        <input type="submit" value="회원 정보 수정">
    </form>
</body>
</html>