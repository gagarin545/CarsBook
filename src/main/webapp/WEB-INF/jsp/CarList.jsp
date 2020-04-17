<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <meta charset="UTF-8"/>
      <link rel="profile"href="http://gmpg.org/xfn/11"/>
  </head>
  <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
  <body>
  <br>
  <ul>
      <label id="id_list">
          <c:forEach items="${cars}" var="car">
              <li><a href="/delete/${car.id}"> <b>${car.carNum}</b>    <b>${car.carModel}</b>  <b>${car.carYear}</b>   <b>${car.carColor}</b> </a>
          </c:forEach>
      </label>

  </ul>

  <li><a href="/CarForm"> Добавить авто</a></li><br>
  Сортировка по
  <label for="id_sort" class="name-stat">
      <select id="id_sort">
          <option value="1" selected> Номеру авто </option>
          <option value="2" selected> Модели </option>
          <option value="3" selected> Цвету </option>
          <option value="4" selected> Году выпуска </option>
          <option value="5" selected> Дате регистрации </option>
      </select>
  </label><br><br>

  <div id="id_stat">
      <input type="button" value=" статистика " name="a" OnClick="newstat('stat', 'parts');">
  </div>

  <div id="id_parts" class="block" >
      <span></span>
  </div>

  <script>
      $(document).ready(function()
      {
          $('#id_sort').change(function() { newMess( 'sort', 'list'); });
      });
      function newMess(parentId, ddId) {
          var jsonURL = parentId + "/" + $('#id_' + parentId + ' :selected').val();
          var dd = $('#id_' + ddId);
          dd.text(" "); //remove(); // Clean old options first.
          $.getJSON(jsonURL, function(opts) {
              if (opts) {
                  $.each(opts, function(key, value) {
                      dd.append(
                          $('<li>').append(
                              $('<a>').attr('href', "delete/" + value.id)
                                  .append(value.carNum)
                                  .append(" ").append(value.carModel)
                                  .append(" ").append(value.carYear)
                                  .append(" ").append(value.carColor)
                          ));
                  });
              }
          });
      }
      function newstat(parentId, ddId) {
          var jsonURL = parentId;
          var dd = $('#id_' + ddId);
          dd.text(" "); //remove(); // Clean old options first.
          $.getJSON(jsonURL, function(opts) {
              if (opts) {
                  $.each(opts, function(key, value) {
                      dd.append(
                          $('<li>').append(  new Date(parseInt( value.dateRecord)))
                              .append(" ").append(value.carNum)
                              .append(" ").append(value.carModel)
                              .append(" ").append(value.carYear)
                              .append(" ").append(value.carColor)
                          );
                  });
              }
          });
      }
  </script>
  </body>
</html>