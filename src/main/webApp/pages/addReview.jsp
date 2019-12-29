<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="UTF-8" http-equiv="Cache-Control" content="no-cache"/>
    <title>REVIEWS</title>
    <style type = "text/css" media = "all">
           body
           {
             text-align: center;
           }
           .inp{
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
    <h1>New Review </h1>
    <a href="/reviews_list"> Back to reviews list </a>
    <br/><br/>
    <div>
        Visit Date <br>
        <input type="text" id="visitDateInput" size="60">
        <br>
        <br>
        Rating <br>
        <input type="text" id="ratingInput" size="60">
        <br>
        <br>
        Text <br>
        <input type="text" id="textInput" size="60">
        <br>
        <br>
        User ID <br>
        <input type="text" id="user_id_Input" size="60">
        <br>
        <br>
        Hotel ID <br>
        <input type="text" id="hotel_id_Input" size="60">
        <br>
        <br><input class="inp" type="submit" onclick="AddReview()" value="Add">
        <script type="text/javascript">
                    function AddReview(){
                        var date_of_user_visit=document.getElementById("visitDateInput").value;
                        var rating=document.getElementById("ratingInput").value;
                        var review_text=document.getElementById("textInput").value;
                        var user_id=document.getElementById("user_id_Input").value;
                        var hotel_id=document.getElementById("hotel_id_Input").value;
                        fetch('/reviews', {
                                method: 'post',
                                body: JSON.stringify({Id_user:0, firstName: firstName, lastName: lastName, email: email, date_of_Birth:date_of_Birth, gender:gender}),
                                headers: {'content-type': 'application/json'}
                            }).then(result =>document.location.href = "/reviews_list");

                    }
         </script>
    </div>
  </body>

</html>