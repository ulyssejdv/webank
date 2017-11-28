<%--
  Created by IntelliJ IDEA.
  User: lindabouzid
  Date: 27/11/2017
  Time: 15:38
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
                        <th>Code titre</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="myList" items="${listStock}">
                            <tr>
                                <td>${myList.stockId}</td>
                                <td>${myList.stockDescription}</td>
                                <td>
                                    <a href="/webank/stockExchange/${myList.stockId}">
                                        <span class="glyphicon glyphicon-chevron-right"></span>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<%@include file="../footer.jsp"%>
