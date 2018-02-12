<%--
  Created by IntelliJ IDEA.
  User: lindabouzid
  Date: 27/11/2017
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>

<%@include file="../header.jsp"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="jumbotron">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>Titre</th>
                        <th>Cours (€)</th>
                        <th>Valeur à l'ouverture</th>
                        <th>Valeur la plus haute</th>
                        <th>Valeur la plus basse</th>
                        <th>Volume échangé</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${stockDetails.stockId}</td>
                        <td>${stockDetails.stockPrice}</td>
                        <td>${stockDetails.stockOpenPrice}</td>
                        <td>${stockDetails.stockMaxPrice}</td>
                        <td>${stockDetails.stockMinPrice}</td>
                        <td>${stockDetails.stockExchange}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<%@include file="../footer.jsp"%>