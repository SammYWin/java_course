<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="UTF-8" http-equiv="Cache-Control" content="no-cache"/>
    <title>HOTELS</title>
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
    <h1>Edit Hotel </h1>
    <a href="/hotels_list"> Back to hotels list </a>
    <br/><br/>
    <div>
        Name <br>
        <input type="text" id="nameInput" size="60" value="${Hotel.name}">
        <br>
        <br>
        Description <br>
        <input type="text" id="DescriptionInput" size="60" value="${Hotel.brief_description}">
        <br>
        <br>
        Country <br>
        <input type="text" id="CountryInput" size="60" value="${Hotel.country}">
        <br>
        <br>
        City <br>
        <input type="text" id="CityInput" size="60" value="${Hotel.city}">
        <br>
        <br>
        Stars <br>
        <input type="text" id="StarsInput" size="60" value="${Hotel.number_of_stars}">
        <br>
        <br>
        Web-Site <br>
        <input type="text" id="WebInput" size="60" value="${Hotel.website}">
        <br>
        <br><input class="inp" type="submit" onclick="SaveHotel()" value="Save">
        <script type="text/javascript">
                    function SaveHotel(){
                        var name=document.getElementById("nameInput").value;
                        var brief_description=document.getElementById("DescriptionInput").value;
                        var country=document.getElementById("CountryInput").value;
                        var city=document.getElementById("CityInput").value;
                        var number_of_stars=document.getElementById("StarsInput").value;
                        var website=document.getElementById("WebInput").value;
                        fetch('/hotels', {
                            method: 'put',
                            body: JSON.stringify({id_hotel:${Hotel.id_hotel}, name: name, brief_description: brief_description, country: country, city:city, number_of_stars:number_of_stars, website: website }),
                            headers: {'content-type': 'application/json'}
                        }).then(result =>document.location.href = "/hotels_list");

                        //location.href = "..";
                    }
         </script>
    </div>
  </body>

</html>