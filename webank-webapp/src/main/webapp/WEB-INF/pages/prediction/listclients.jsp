<%--
  Created by IntelliJ IDEA.
  User: lindabouzid
  Date: 27/11/2017
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../header.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>


<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="jumbotron">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>Nom</th>
                        <th>Nombre d'enfant</th>
                        <th>Situation</th>
                        <th>Solde</th>
                        <th>Prédiction</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="clientDto" items="${listClientDto}">
                        <tr>
                            <td>${clientDto.name}</td>
                            <td>${clientDto.nbChildren}</td>
                            <td>${clientDto.categorieDesc}</td>
                            <td>${clientDto.solde}</td>
                            <td>
                                <a href="/webank/prediction/${clientDto.idClient}">
                                    <span class="glyphicon glyphicon-chevron-right">Consulter</span>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
                <nav aria-label="...">
                    <ul class="pagination justify-content-end">
                        <c:forEach var="i" begin="0" end="${totalpages-1}">
                            <li class="page-item ${currentpage == i ? "active" : ""}">
                                <a class="page-link" href="/webank/prediction?page=${i}">${i + 1}
                                    <c:if test="${currentpage == i}">
                                        <span class="sr-only">(current)</span>
                                    </c:if>
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </nav>

            </div>
        </div>
    </div>
</div>

<%@include file="../footer.jsp" %>
