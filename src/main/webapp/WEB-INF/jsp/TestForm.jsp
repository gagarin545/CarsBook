<%@ page import="org.springframework.beans.factory.annotation.Autowired" %>
<%@ page import="ru.service.CarService" %>
<%@ page import="ru.entity.MakeCarEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.IOException" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head><title>Parcel for ${parcel.car_name}</title></head>
  <body>
  <head><title>Parcel for ${parcel.car_name}</title></head>
  <body>
  <h1>Parcel for ${parcel.car_name}}</h1>

  <%--@elvariable id="parcel" type=""--%>
  <form:form modelAttribute="parcel">
      <form:hidden path="id"/>
      <table>
          <tr>
              <td>Имя :</td>
              <td><form:input path="car_name"/></td>
          </tr>
          <tr>
              <td>Imei :</td>
              <td><form:input path="id_model"/></td>
              <td colspan="2"><input type="submit" value="Save Changes"/></td>
          </tr>
      </table>
  </form:form>
  </body>
</html>