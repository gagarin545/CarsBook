<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head><title>Список автомобилей</title></head>

  <head>
      <meta charset="UTF-8"/>
      <title>Page Title</title>
      <link rel="profile"href="http://gmpg.org/xfn/11"/>
      <style type="text/css">
          body {font: 92.5%/1.6 Verdana, Tahoma, sans-serif;color: #333333;}
          h1,h2{color: #ff6600;}
          #id_part.block{margin:30px auto;width: 600px;}.block{border:1px solid #ccc;border-radius:4px;box-shadow:0 0 2px #ccc;}
      </style>
  </head>
  <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
  <body>


  <ul>
      <c:forEach items="${cars}" var="car">
      <li><a href="/delete/${car.id}"> <b>${car.carNum}</b>    <b>${car.carModel}</b>  <b>${car.carYear}</b>   <b>${car.carColor}</b> </a>
          </c:forEach>
  </ul>
  <li><a href="/CarForm"> Добавить авто</a></li>
  </body>
</html>