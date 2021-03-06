<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="UTF-8" http-equiv="Cache-Control" content="no-cache" />
    <title>REVIEWS</title>

   <style type = "text/css" media = "all">
                 body
                 {
                   text-align: center;
                 }
                 .center
                 {
                   text-align: center;
                 }
                 table {
                   border-collapse: collapse;
                   border: 3px solid #9c4757;
                   margin-left:auto;
                   margin-right:auto;
                  }
                 table caption {
                   background: #F79361;
                   border-top-left-radius: 10px;
                   border-top-right-radius: 10px;
                   padding: 10px;
                   box-shadow: 0 2px  4px 0 rgba(0,0,0,.3);
                   color: white;
                   font-style: normal;
                   font-size: 26px;
                   text-align: center;
                   margin: 0;
                 }
                 table td, table th {
                   padding: 10px;
                 }
                 table th {
                   text-align: left;
                   font-size: 18px;
                 }
                 table tr:nth-child(2n) {
                   background: #E5E5E5;
                 }
                 table td:last-of-type {
                   text-align: center;
                 }
                 table input{
                    display: inline-block;
                    padding: 5px 10px;
                    background: #a2defa;
                    box-shadow: 2px 2px 0 0 #215bc7;
                    position: relative;
                 }
                 h1{
                   background: slateblue;
                 }
           </style>
  </head>
  <body>
    <h1>REVIEWS LIST</h1>
    <a href="/"> Back to Main Page </a>
    <br/><br/>
    <a href="add_review"> Add new review</a>
    <br/><br/>
    <div class="center">
      <table >
        <tr>
          <th>Date of Visit</th>
          <th>Rating Name</th>
          <th>Review Text</th>
          <th></th>
        </tr>
        <c:forEach  var ="hr" items="${HotelReview}" >
        <tr>
          <td><c:out value="${hr.date_of_user_visit}"/></td>
          <td><c:out value="${hr.rating}"/></td>
          <td><c:out value="${hr.review_text}"/></td>
          <td><a href="edit_review?id=${hr.id_hotel_review}">edit</a>
            <input type="submit" onclick="deleteReview(${hr.id_hotel_review})" value="x"></td>
          <script type="text/javascript">
                function deleteReview(index){
                    fetch('/reviews?id='+index, {
                        method: 'delete'
                     }).then(result =>document.location.href = "/reviews_list");
                }
           </script>
        </tr>
        </c:forEach>
      </table>
    </div>
  </body>

</html>