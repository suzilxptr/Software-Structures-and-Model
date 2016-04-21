<%-- 
    Document   : reponse
    Created on : Jan 14, 2016, 12:56:02 PM
    Author     : The BigBang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <div><h1>Coffee Machine</h1></div>
        <h3> Press Start Button for brewing coffee.....</h3>
        
           <form name="CoffeeMaker" action="" method="GET">
               <input type="submit" name="Start" value="Start" />
            </form>
        <jsp:useBean id="water_amount" scope="application" class="coffee.maker.CoffeeMaker" />
        <h3>The amount of Water in the machine is: <jsp:getProperty name="water_amount"  property="water_amount" /> ml<br>
            The amount of Coffee the machine is: <jsp:getProperty name="water_amount"  property="coffee_amount" /> gm </h3>
    </body>
</html>
