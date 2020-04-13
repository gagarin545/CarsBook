<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head><title>Список запчастей</title></head>
  <body>
  <h1>Список запчастей</h1>
  <ul>
    <c:forEach items="${parcels}" var="parcel">
      <li><a href="/spare/${parcel.id_spare}"> <b>${parcel.spare_name}</b></a>
    </c:forEach>
  </ul>
  </body>
</html>