<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lựa chọn</title>
    <link rel="stylesheet" href="../Assets/css/Style.css">
    <link rel="stylesheet" href="../Assets/css/popup.css">
    <link rel="stylesheet" href="../Assets/css/choiceLession.css">
    <link rel="icon" href="../Assets/icon/favicon.png">
    <!-- link bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <style>
        .p-3{
            height: 20em;
            width: 12em;
            border-radius: 15px;
            border: 5px solid white;
            transition: all ease 0.3s;
        }
        .p-3:hover{
            transform: scale(1.1);
        }
        .custom-icon{
            font-size: 2.8em;
        }
        .box-content{
            height: 5em;
            width: 5em;
            border: 0.5rem solid white;
            border-radius: 50%;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .box-border{
            padding: 8em 2.5em;
        }
    </style>
</head>

<body>
    <div class="main">
        <!--nav bar-->
        <jsp:include page="navcourse.jsp"></jsp:include>
        <!--content-->
        <div class="content">
            <div class="container text-center choicelession">
                <div class="row row-cols-2 row-cols-lg-5 g-2 g-lg-3 choicelession-content" style="display: flex; justify-content: center; align-items: center; margin-top: 5em">
                    <div class="col">
                        <a href="./quiz?lession_id=${requestScope.lesson.lesson_id}" style="text-decoration: none; color: white;">
                            <div class="p-3" style="background-color: #7030a0;">
                                <p style="font-weight: bolder; font-size: 2rem;"> Bài tập</p>
                                <div class="box-border">
                                    <div class="box-content">
                                        <i class="custom-icon fa-solid fa-circle-question"></i>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="col">
                        <c:choose>
                            <c:when test="${sessionScope.account.classify_account eq requestScope.normal}">
                                <a href="#" style="text-decoration: none; color: white;" data-bs-toggle="modal" data-bs-target="#exampleModal">
                                    <div class="p-3" style="background-color: #ff7f27;">
                                        <p style="font-weight: bolder; font-size: 2rem;"> Game</p>
                                        <div class="box-border">
                                            <div class="box-content">
                                                <i class="custom-icon fa-solid fa-gamepad"></i>
                                            </div>
                                        </div>
                                    </div>
                                </a>
                            </c:when>
                            <c:otherwise>
                                <a href="../game/matchgame?lession_id=${requestScope.lesson.lesson_id}" style="text-decoration: none; color: white;">
                                    <div class="p-3" style="background-color: #ff7f27;">
                                        <p style="font-weight: bolder; font-size: 2rem;"> Game</p>
                                        <div class="box-border">
                                            <div class="box-content">
                                                <i class="custom-icon fa-solid fa-gamepad"></i>
                                            </div>
                                        </div>
                                    </div>
                                </a>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="col">
                        <a href="./videoLesson?lesson_id=${requestScope.lesson.lesson_id}" style="text-decoration: none; color: white;">
                            <div class="p-3" style="background-color: #00b050;">
                                <p style="font-weight: bolder; font-size: 2rem;"> Video</p>
                                <div class="box-border">
                                    <div class="box-content">
                                        <i class="custom-icon fa-solid fa-circle-play"></i>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="col">
                        <a href="./contentLesson?lesson_id=${requestScope.lesson.lesson_id}" style="text-decoration: none; color: white;">
                            <div class="p-3" style="background-color: #0081e2;">
                                <p style="font-weight: bolder; font-size: 2rem;"> Lý thuyết</p>
                                <div class="box-border">
                                    <div class="box-content">
                                        <i class="custom-icon fa-solid fa-bars"></i>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header" style="background: red; color: white">
                    <h5 class="modal-title" id="exampleModalLabel" style="align-items: center">
                        <i class="fa-sharp fa-solid fa-bell"></i> Thông báo từ hệ thống
                    </h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body" style="min-height: 200px">
                    <div style="font-size: 20px;">Không thể truy cập khi chưa đăng kí Vip,
                        bạn nên đăng kí Vip để có thể truy cập phần này
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
