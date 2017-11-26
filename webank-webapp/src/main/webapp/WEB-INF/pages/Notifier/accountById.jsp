<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<%@include file="../header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="page-header">
                <h1>Simuler un mouvement</h1>
            </div>
            
      <p>Vous êtes actuellement sur la page permettant de simuler un mouvement sur le compte du client ci-arpès 
            pour cela cliquer sur le bouton ci-dessous.</p>

                <div class="jumbotron">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>Nom</th>
                            <th>Prénom</th>
                            <th>Numéro de compte</th>
                            <th>Solde</th>
                        </tr>
                        </thead>
                        <tbody>
                                <tr>
                                	<td>${account.customer.getFirstname()}</td>
                                	<td>${account.customer.getLastname()}</td>
                                    <td>${account.getAccountNumber()}</td>
                                    <td>${account.balance.getBalance()}</td>
                                </tr>
                        </tbody>
                    </table>
                </div>
        </div>
    </div>
     <form:form method="post" modelAttribute="" action="" cssClass="form-horizontal">
            <table class="table table-bordered">
                <tr>
                    <th style="text-align:center; vertical-align:middle;">

                        <button type="submit" class="btn btn-primary">
                            <h5 style="color:white;">
                                <strong>Simuler mouvement</strong>
                            </h5>
                        </button>
                    </th>
                </tr>
            </table>
            </form:form>   
    
</div>


<%@include file="../footer.jsp"%>