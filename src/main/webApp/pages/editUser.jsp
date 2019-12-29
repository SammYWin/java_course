<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="UTF-8" http-equiv="Cache-Control" content="no-cache"/>
    <title>USERS LIST</title>
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
    <h1>Edit user </h1>
    <a href="/users_list"> Back to user list </a>
    <br/><br/>
    <div>
        First Name <br>
        <input type="text" id="firstNameInput" value="${User.firstName}" size="60">
        <br>
        <br>
        Last Name <br>
        <input type="text" id="lastNameInput" value="${User.lastName}" size="60">
        <br>
        <br>
        Email <br>
        <input type="text" id="emailInput" value="${User.email}" size="60">
        <br>
        <br>
        Birthday <br>
        <input type="text" id="date_of_BirthInput" value="${User.date_of_Birth}" size="60">
        <br>
        <br>
        Gender <br>
        <input type="text" id="genderInput" value="${User.gender}" size="60">
        <br>
        <br><input class="inp" type="submit" onclick="SaveUser()" value="Save">
        <script type="text/javascript">
                    function SaveUser(){
                        var firstName=document.getElementById("firstNameInput").value;
                        var lastName=document.getElementById("lastNameInput").value;
                        var email=document.getElementById("emailInput").value;
                        var date_of_Birth=document.getElementById("date_of_BirthInput").value;
                        var gender=document.getElementById("genderInput").value;
                        fetch('/users', {
                                method: 'put',
                                body: JSON.stringify({id_user:${User.id_user}, firstName: firstName, lastName: lastName, email: email, date_of_Birth:date_of_Birth, gender:gender}),
                                headers: {'content-type': 'application/json'}
                            }).then(result =>document.location.href = "/users_list");

                        //location.href = "..";
                    }
         </script>
    </div>
  </body>

</html>