<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 15/11/2019
  Time: 17:51
  To change this template use File | Settings | File Templates.

--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
</head>
<body>
<br/><br/>
<form method="post" name="frm" action="eServlet">
  <table border="0" width="300" align="center" bgcolor="#e9f">

    <tr>
      <td colspan=2 style="font-size:12pt;" align="center">
        <h3>Search Product</h3></td>
    </tr>

    <tr>
      <td ><b>Product Name</b></td>
      <td>: <input  type="text" name="product" id="product">
      </td>
    </tr>

    <tr>
      <td colspan=2 align="center">
        <input  type="submit" name="submit" value="Search">
      </td>
    </tr>

  </table>
</form>
</body>
</html>
