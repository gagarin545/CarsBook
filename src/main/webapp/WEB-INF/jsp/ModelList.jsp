<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head><title>Список автомобилей</title></head>
  <body>
  <h1>Список моделей автомобилей</h1>
  <ul>
    <c:forEach items="${parcels}" var="parcel">
      <li><a href="/group/${parcel.id_model}"> <b>${parcel.model_name}</b></a>
    </c:forEach>
  </ul>
  </body>
</html>