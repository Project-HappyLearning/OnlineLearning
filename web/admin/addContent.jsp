
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
            table thead td {
                border: 2px solid white;
                color: white;
            }

            td {
                border: 2px solid white;
            }
            table{
                text-align: center;
            }
            .table-quiz {
                height: 11em;
                overflow: auto;
                overflow-x: hidden;
                overflow-y: auto;
            }

            .input-quiz {
                display: flex;
                flex-direction: column;

            }

            .statis-quiz {
                display: flex;
                justify-content: space-between;
                padding: 0 3em 0;
            }

            .static-quiz-right {

                flex: 1;
                margin-left: 2em;
                /* flex: 2; */
            }

            .static-quiz-left {
                background-color: #f2f2f2;
                padding: 0 2em 2em 2em;
            }

            .input-quiz input {
                margin-top: 0.5em;
                width: 28em;
                border: white;
            }

            .text {
                padding: 1em 0 0 0;
                font-weight: bold;
            }

            .statis-quiz-text {
                padding: 1em 0 0 0;
                font-weight: bold;
            }

            .list-item label {
                min-width: 150px;
            }

            .list-item {
                list-style: none;
                display: flex;
                margin-top: 1em;
            }

            .list-item input {
                flex: 1;
                padding: 0 0.5em;
                border: 1px solid #000000;
            }
            .custom-icon{
                font-size: 1.25em;
                padding: 0.25em;
                color: #4472c4;
            }
        </style>
        <title>Content</title>
        <title>Add reading_content</title>
    </head>

    <body>
       <jsp:include page="navForAdmin.jsp"></jsp:include>

        <div class="statis-quiz container-fluid" style="height: 100%; margin-top: 2em;">
            <div class="static-quiz-left">
                <div class="text">
                    <p>Đang thêm nội dung cho</p>
                </div>
                <div class="input-quiz">
                    <input type="text" value="Lớp ${sessionScope.class_id}">
                    <input type="text" value="${sessionScope.course.course_name} lớp ${sessionScope.class_id}">
                    <input type="text" value="${sessionScope.module.module_name}">
                    <input type="text" value="${sessionScope.lesson.lesson_name}">
                </div>
                <div class="statis-quiz-text">
                    <p>Số nội dung hiện có: ${sessionScope.number_of_contents}</p>
                </div>
                <div class="table-quiz">
                    <table style="width: 28em;">
                        <thead>
                        
                        <td colspan="2" style="background-color: #4472c4; width: 5em;">Hành động</td>

                        </thead>
                        <tbody style="height: 11em;">
                            <c:forEach items="${sessionScope.contents}" var="q">
                                <tr style="background-color: #cfd5ea;">
                                    <td>
                                        <a href="./actionContent?action=edit&content_id=${q.content_id}">
                                            <i class="fa-solid fa-pen-to-square custom-icon"></i>
                                        </a>
                                    </td>
                                    <td>
                                        <a href="./actionContent?action=delete&content_id=${q.content_id}">
                                            <i class="fa-solid fa-trash custom-icon"></i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div style="margin-top: 2em;">
                    <a href="./actionContent?action=add&content_id=-1">
                        <button
                            style="width: 100%; color: #f2f2f2; font-size: large; background-color: #00de7a; padding: 0.5em 0 0.5em 0;border: white;">Thêm
                            nội dung</button>
                    </a>
                    <a href="./ChoiceClassToAddContent">
                        <button
                            style="width: 100%; color: #f2f2f2; margin-top: 1em; font-size: large; background-color: red; padding: 0.5em 0 0.5em 0;border: white;">
                            Trở lại trang chọn bài học</button>
                    </a>
                    <c:if test="${requestScope.alert ne null}">
                        <div style=" margin-top: 1em">
                            <a style="font-size: 20px; font-weight: bold; margin-right: 1em">
                                <i class="fa-solid fa-bell"></i>
                            </a> 
                            <a style="color: #00de7a; font-size: 20px; font-weight: bold;">
                                ${requestScope.alert}
                            </a>
                        </div>
                    </c:if>
                </div>
            </div>

            <c:if test="${(requestScope.action ne sessionScope.add) 
                          or (requestScope.action ne sessionScope.edit)
                          or (requestScope.action ne sessionScope.delete)}">

            </c:if>
            <c:if test="${requestScope.action eq sessionScope.delete}">
                <div class="static-quiz-right">
                    <input hidden name="action" value="edit">
                    
                   
                    <div>
                        <input hidden name="content_id" value="${requestScope.content.content_id}">
                        <textarea disabled name="content" id="textareaEdit" style="height: 28em; width: 100%; border: 1px solid #000000;"> "${requestScope.content.reading_content}"
                        </textarea>
                        <script>
                            var textare0a = document.getElementById("textareaEdit");
                            textarea.value = "${requestScope.content.reading_content}";

                        </script>
                    </div>
                    
                    <div style="padding: 2em 0 0 70%;">        
                        <!-- Button trigger modal -->
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                            Xác nhận và xóa
                        </button>
                    </div>

                    <!-- Modal -->
                    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel" style="align-items: center">
                                        <i class="fa-solid fa-triangle-exclamation custom-icon" style="color: orange"></i>
                                        Cảnh báo từ hệ thống
                                    </h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <div style="font-size: 20px;">Sau khi bạn bấm nút xóa sẽ không thể khôi phục lại</div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                    <form action="actionContent" method="POST">
                                        <input hidden name="action" value="delete">
                                        <input hidden name="content_id" value="${requestScope.content.content_id}">
                                        <input type="submit" class="btn btn-primary" value="Xác nhận">
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
                    <c:if test="${requestScope.action eq sessionScope.add}">
                        <div class="static-quiz-right">
                            <form action="actionContent" id="form1" method="POST">
                                <input hidden name="action" value="add">
                                <div>
                                    <textarea name="content" style="height: 28em; width: 100%; border: 2px solid #000000;"></textarea>
                                </div>
                                <div style="padding: 2em 0 0 70%;">
                                    <input style="width: 10em; height: 2em; background-color: #00de7a; color: #fff;border: none; font-size: large; font-weight: bold; border-radius: 10px;" type="submit" value="Hoàn tất">
                                </div>
                            </form>
                        </div>
                    </c:if> 
            <c:if test="${requestScope.action eq sessionScope.edit}">
                <div class="static-quiz-right">
                    <form action="actionContent" id="form1" method="POST">
                        <input hidden name="action" value="edit">
                        
                        <div style="padding-left: 1em;">
                            <p>Edit content</p>
                        </div>
                        <div>
                            <input hidden name="content_id" value="${requestScope.content.content_id}">
                            <textarea name="content" id="textareaEdit" style="height: 28em; width: 100%; border: 1px solid #000000;">${requestScope.content.reading_content}
                            </textarea>
                            <script>
                                var textare0a = document.getElementById("textareaEdit");
                                textarea.value = "${requestScope.content.reading_content}";

                            </script>
                        </div>
                        
                        <div style="padding: 2em 0 0 70%;">
                            <input style="width: 10em; height: 2em; background-color: #00de7a; color: #fff;border: none; font-size: large; font-weight: bold; border-radius: 10px;" type="submit" value="Hoàn tất">
                        </div>
                    </form>
                </div>
            </c:if> 
        </div>
    </body>

</html>
