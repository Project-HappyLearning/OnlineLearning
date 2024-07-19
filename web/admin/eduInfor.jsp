<%-- 
    Document   : eduInfor
    Created on : Jul 15, 2024, 9:48:01 AM
    Author     : admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../Assets/css/action.css">
    <link rel="icon" href="../Assets/icon/favicon.png"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
    crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
          integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>Quản lý tin tức</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }
        .container {
            display: flex;
            justify-content: center;
            align-items: start;
            min-height: 100vh;
            background-color: #f0f0f0;
            padding: 20px;
        }
        .form-container, .list-container {
            margin-right: 20px;
            padding: 20px;
            background-color: #ffffff;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .form-container {
            width: 400px;
        }
        .list-container {
            width: 1000px;
        }
        .form-container input[type="text"], .form-container input[type="url"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        .form-container input[type="submit"], .form-container input[type="button"] {
            width: 100%;
            padding: 10px;
            margin-top: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            color: #fff;
        }
        .form-container input[type="submit"] {
            background-color: #5cb85c;
        }
        .form-container input[type="button"] {
            background-color: #d9534f;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .action-links a {
            text-decoration: none;
            color: #337ab7;
        }
        .action-links a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    
    <div class="container">
        <div class="form-container">
            <form action="ManageEduinfor" method="post">
                <label for="title">Title</label>
                <input type="text" id="title" name="title" required>
                
                <label for="link">Link</label>
                <input type="url" id="link" name="link" required>
                
                <input type="submit" value="Thêm">
                <input type="button" value="Trở lại" onclick="window.location.href='http://localhost:8080/SWP_p/admin/action.jsp';">
            </form>
        </div>
        <div class="list-container">
            <table>
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Link ${sessionScope.idStr}</th>
                        <th>Thao tác </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="l" items="${sessionScope.list}">
                    <tr>
                        <td>${l.title}</td>
                        <td><a href="${l.linkInfor}">${l.linkInfor}</a></td>
                        <td>
                            <form action="ManageEduinfor" method="POST">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="${l.id}">
                    <button type="submit">Xóa</button>
                </form>
                        </td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
        </div>
    </div>
</body>
</html>