<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="UTF-8" http-equiv="Cache-Control" content="no-cache"/>
    <title>USERS</title>
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
    <h1>New user </h1>
    <a href="/users_list"> Back to user list </a>
    <br/><br/>
    <div>
        First Name <br>
        <input type="text" id="firstNameInput" size="60">
        <br>
        <br>
        Last Name <br>
        <input type="text" id="lastNameInput" size="60">
        <br>
        <br>
        Email <br>
        <input type="text" id="emailInput" size="60">
        <br>
        <br>
        Birthday <br>
        <input type="text" id="date_of_BirthInput" size="60">
        <br>
        <br>
        Gender <br>
        <input type="text" id="genderInput" size="60">
        <br>
        <br><input class="inp" type="submit" onclick="AddUser()" value="Add">
        <script type="text/javascript">
                    function AddUser(){
                        var firstName=document.getElementById("firstNameInput").value;
                        var lastName=document.getElementById("lastNameInput").value;
                        var email=document.getElementById("emailInput").value;
                        var date_of_Birth=document.getElementById("date_of_BirthInput").value;
                        var gender=document.getElementById("genderInput").value;
                        fetch('/users', {
                                method: 'post',
                                body: JSON.stringify({Id_user:0, firstName: firstName, lastName: lastName, email: email, date_of_Birth:date_of_Birth, gender:gender}),
                                headers: {'content-type': 'application/json'}
                            }).then(result =>document.location.href = "/users_list");

                    }
         </script>
    </div>
  </body>

</html>