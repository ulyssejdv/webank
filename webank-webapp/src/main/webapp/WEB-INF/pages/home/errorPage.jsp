<%--
  Created by IntelliJ IDEA.
  User: thiba
  Date: 21/01/2017
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../header.jsp"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="jumbotron">
                <h1 >ERREUR</h1>
                <p>
                    <em>
                        <c:choose>
                            <c:when test="${not empty errorMsg}">
                                <c:out value="${errorMsg}" />
                            </c:when>
                            <c:otherwise>
                                Un problème est survenu, veuillez nous excuser.
                                <br />
                            </c:otherwise>
                        </c:choose>
                    </em>
                </p>
                <p>
                    Merci de reessayer ultérieurment. Si le problème persiste, veuillez contacter l'administrateur (webmaster@esibank.fr)
                </p>

                <form name="backHome" method="GET" action="/" class="form-horizontal">
                    <div class="row">
                        <div class="col-xs-12">
                            <button type="submit" class="btn btn-success btn-lg pull-right">
                                Retour à l'accueil
                            </button>
                        </div>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>

<%@include file="../footer.jsp"%>
