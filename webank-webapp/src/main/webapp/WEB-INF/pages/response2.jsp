<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<%@include file="header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="page-header">
                <h1>Affichage client</h1>
            </div>
      

                <div class="jumbotron">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>Type</th>
                            <th>Numéro de compte</th>
                        </tr>
                        </thead>
                        <tbody>
                                <tr>
                                    <td>${account.getType()}</td>
                                    <td>${account.getAccountNumber()}</td>
                                </tr>
                        </tbody>
                    </table>
                </div>
        </div>
    </div>
       
    
</div>


<%@include file="footer.jsp"%>