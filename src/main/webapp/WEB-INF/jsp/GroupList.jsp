<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head><title>Список групп</title></head>
  <body>
  <h1>Список групп</h1>
  <ul>
    <c:forEach items="${parcels}" var="parcel">
      <li><a href="/spare/${parcel.id_group}"> <b>${parcel.group_name}</b></a>
    </c:forEach>
  </ul>
  </body>
</html>