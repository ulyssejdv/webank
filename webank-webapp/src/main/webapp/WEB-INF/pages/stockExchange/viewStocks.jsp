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

                    <div class="wrap">
                        <div class="search" align="right">
                            <form action="search" method="get">
                                <input type="text" name="val" class="searchTerm" placeholder="Rechercher" size="20" >
                                <button type="submit" class="btn btn-default btn-sm">
                                    <span class="glyphicon glyphicon-search"></span>
                                </button>
                            </form>
                        </div>
                    </div>

                    <thead>
                    <tr>
                        <th>Titre</th>
                        <th>Code titre</th>
                        <th></th>
                    </tr>
                    </thead>>
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
            <nav aria-label="...">
                <ul class="pagination">

                    <c:choose>
                        <c:when test="${numpage-1<1}">
                            <li class="page-item disabled">
                                <a class="page-link" href="?page=${numpage-1}" tabindex="-1">Précedent</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item">
                                <a class="page-link" href="?page=${numpage-1}" tabindex="-1">Précedent</a>
                            </li>
                            <li class="page-item"><a class="page-link" href="?page=${numpage-1}">${numpage -1}</a></li>
                        </c:otherwise>
                    </c:choose>

                    <li class="page-item active">
                        <a class="page-link" href="#">${numpage} <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="page-item"><a class="page-link" href="?page=${numpage+1}">${numpage+1}</a></li>
                    <li class="page-item">
                        <a class="page-link" href="?page=${numpage+1}">Suivant</a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</div>

<%@include file="../footer.jsp"%>
