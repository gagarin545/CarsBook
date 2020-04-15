<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <body>
  <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
  <h1>Марка машины</h1>

  <%--@elvariable id="car" type=""--%>
  <form:form modelAttribute="car" id="id_spare">
  <table id="id_spare">
    <tr>
      <td>Номер авто :</td>
      <td><form:input path="carNum"/></td>
    </tr>
    <tr>
      <td>Модель :</td>
      <td><form:input path="carModel"/></td>
    </tr>
    <tr>
      <td>Год выпуска :</td>
      <td><form:input path="carYear"/></td>
    </tr>
    <tr>
      <td>Цвет :</td>
      <td><form:input path="carColor"/></td>
    </tr>
      <td colspan="4"><input type="submit" value="Save Changes"/></td>
    </tr>
  </table>
  </form:form>
  <div id="id_parts" class="block" >
    <span></span>
  </div>
  <script>
    $(document).ready(function()
    {
      $('#id_spare').change(function() { newOptions( 'spare', 'parts'); });
    });
    function newOptions(parentId, ddId) {
      var jsonURL = '/id_' + ddId + "/" + $('#' + parentId + ' :selected').val() + '&' + model ;
      var dd = $('#id_' + ddId);
      dd.text(' '); //remove(); // Clean old options first.
      dd.append($('<span />').text("Please select parent"));

    }
  </script>

  </body>
</html>