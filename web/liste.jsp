<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="dao.entities.Produit" %><%--
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
<table width="700px" align="center"
       style="border:1px solid #000000;">
  <tr>
    <td colspan=4 align="center"
        style="background-color:teal">
      <b>Product Record</b></td>
  </tr>
  <tr style="background-color:lightgrey;">
    <td><b>Id</b></td>
    <td><b>Designation</b></td>
    <td><b>Prix</b></td>
    <td><b>Quantité</b></td>
  </tr>
  <%
    int count = 0;
    String color = "#F9EBB3";
    if (request.getAttribute("produits") != null) {
      ArrayList<Produit> al = (ArrayList) request.getAttribute("produits");
      System.out.println(al);

      for(Produit produit: al){
  %>
        <tr style="background-color:<%=color%>;">
          <td><%=produit.getId()%></td>
          <td><%=produit.getDesignation()%></td>
          <td><%=produit.getPrix()%></td>
          <td><%=produit.getQuantite()%></td>
        </tr>
  <%
    }
  %>
  <tr>
    <td colspan=4 align="center"
        style="background-color:#eeffee"><b>No Record Found..</b></td>
  </tr>
  <%            }
  %>
</table>
</body>
</html>