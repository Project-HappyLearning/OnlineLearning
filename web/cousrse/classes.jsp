<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--<%@page contentType="text/html" pageEncoding="UTF-8"%>--> 
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Các lớp học</title>
    <link rel="stylesheet" href="../Assets/css/Style.css">
    <link rel="stylesheet" href="../Assets/css/course.css">
    <link rel="icon" href="../Assets/icon/favicon.png">
    <!-- Link to Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" 
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <style>
        .class-items {
            margin: 1em 0;
            justify-content: center;
        }
        .class-item {
            position: relative;
            border-radius: 8px;
            width: 16em;
            height: 20em;
            margin: 1em 4em;
            background-size: cover;
            padding: 0;
            transition: all 0.3s;
        }
        .class-item:hover {
            transform: scale(1.1);
        }
        .class-title {
            position: absolute;
            background: #f1f1f1;
            text-align: center;
            width: 100%;
            height: 6em;
            bottom: 0;
            padding: 0.5em;
            border-radius: 0 0 8px 8px;
        }
        .title-item {
            font-size: 25px;
            font-weight: bold;
            text-decoration: none;
            color: black;
        }
        .title-item:hover {
            color: black;
        }
        .class-item button {
            border: none;
            width: 8em;
            height: 2em;
            border-radius: 6px;
            background: #3f47cc;
            font-weight: bold;
            font-size: 18px;
            color: white;
            transition: all ease 0.3s;
        }
        .class-item button:hover {
            background: red;
        }
        .content {
           width: 70%;
        margin-left: 5%;
          background-image: url(../Assets/images/bgt.png);
       background-size: 95vw;
    width: 100vw;
    height: 100vh;
            position: fixed;
        }
    </style>
</head>

<body>
    <div class="main">
        <!-- Nav bar -->
        <jsp:include page="navcourse.jsp"></jsp:include>
        <!-- Content -->
         <div class="content"></div>
        <div class="container-fluid">
            <div class="class-items row" >
                <!-- First Row -->
                <div class="class-item col-md-4" style="background-image: url('../Assets/images/l1.png');">
                    <div class="class-title">
                        <h4 style="text-align: center">Lớp 1</h4>
                        <a href="class_course?class_id=1"><button>Học ngay</button></a>
                    </div>
                </div>
                <div class="class-item col-md-4" style="background-image: url('../Assets/images/l2.png');">
                    <div class="class-title">
                         <h4 style="text-align: center">Lớp 2</h4>
                        <a href="class_course?class_id=2"><button>Học ngay</button></a>
                    </div>
                </div>
                <div class="class-item col-md-4" style="background-image: url('../Assets/images/l3.png');">
                    <div class="class-title">
                         <h4 style="text-align: center">Lớp 3</h4>
                        <a href="class_course?class_id=3"><button>Học ngay</button></a>
                    </div>
                </div>
                <!-- Second Row -->
                <div class="class-item col-md-4" style="background-image: url('../Assets/images/l4.png');">
                    <div class="class-title">
                         <h4 style="text-align: center">Lớp 4</h4>
                        <a href="class_course?class_id=4"><button>Học ngay</button></a>
                    </div>
                </div>
                <div class="class-item col-md-4" style="background-image: url('../Assets/images/l5.png');">
                    <div class="class-title">
                         <h4 style="text-align: center">Lớp 5</h4>
                        <a href="class_course?class_id=5"><button>Học ngay</button></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
