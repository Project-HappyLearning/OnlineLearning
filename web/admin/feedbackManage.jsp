
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
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
        <style>
            .custom-icon{
                font-size: 3em;
            }
            .element-part{
                padding: 0.5em;
                border: 1px solid #ccc;
                border-radius: 10px;
                color: white;
            }
            .part{
                margin-top: 1em;
                text-align: center;
            }
            .part a{
                text-decoration: none;
            }
            table {
                width: 100%;
                border-collapse: collapse;
            }
            th, td {
                padding: 8px;
                text-align: left;
                border-bottom: 1px solid #ddd;
            }
            th {
                background-color: #f2f2f2;
                position: sticky;
                top: 0;
            }
            /* Căn giữa nội dung bảng */
            .table-container {
                overflow-x: auto;
            }
        </style>
        <title>Quản lý người dùng</title>
    </head>

    <body>
       <jsp:include page="navForAdmin.jsp"></jsp:include>
            <div>
                <div class="container part">
                    <div class="row">
                     <c:set var="total" value="${listAll.size()}" />
                     <div class="col-md-3">
                            <a href="?service=filter&typeId=-1">
                                <div class="element-part" style="background: #00ed7a">
                                    <img height="62px" src="https://em-content.zobj.net/source/apple/81/up-pointing-red-triangle_1f53a.png" alt="alt"/>
                                    <span style=" margin-left: 1em">
                                        Tổng số đánh giá
                                    </span>
                                    <br>
                                    <h4 class="element-title" style="text-align: center;">${total}</h4>
                                </div>
                            </a>
                     </div>
                     
                    <c:forEach var="type" items="${febTypes}">
                         <div class="col-md-3">
                            <a href="?service=filter&typeId=${type.getFeedbackTypeID()}">
                                <div class="element-part" style="background: #00ed7a">
                                    <img src="${type.getFeedbackIcon()}" alt="alt"/>
                                    <span style="margin-left: 1em">
                                        ${type.getFeedbackType()}
                                    </span>
                                    <br>
                                     <c:set var="count" value="${0}" />
                                     <c:forEach var="feb" items="${listAll}">
                                         <c:if test="${feb.getType().equals(type.getFeedbackType())}">
                                              <c:set var="count" value="${count+1}" />
                                         </c:if>
                                     </c:forEach>
                                    <h4 class="element-title"style="text-align: center;">${count}</h4>
                                </div>
                            </a>
                        </div>
                    </c:forEach>
                    </div>
                </div>
            </div>
         <div class="container" style="margin-top: 1em;">
                <div class="table-container" style="overflow: auto; height: 70vh; border-radius: 10px;">
                    <table>
                        <thead>
                            <tr>
                                <th>STT</th>
                                <th>Họ và tên</th>
                                <th>Đánh Giá</th>
                                <th>Date</th>
                                <th>Lớp</th>
                                <th>Chương</th>
                                <th>Bài học</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:set var="index" value="${0}" />
                        <c:forEach var="feb" items="${list}">
                            <c:set var="index" value="${index+1}" />
                            <tr>
                                <td>${index}</td>
                                <td>${feb.getCusName()}</td>
                                <td>${feb.getType()}</td>
                                <td>${feb.getDate()}</td>
                                <td>${feb.getClasses()}</td>
                                <td>${feb.getModule()}</td>
                                <td>${feb.getCourseTitle()}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>

</html>