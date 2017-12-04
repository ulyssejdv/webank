<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<SCRIPT LANGUAGE="JavaScript">
Today = new Date;
Jour = Today.getDate();
Mois = (Today.getMonth())+1;
Annee = Today.getFullYear();
Message = ": " + Jour + "/" + Mois + "/" + Annee;
</SCRIPT>

<%@include file="../headerClient2.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="page-header">
                <h1>Bonjour ${account.customer.getFirstname()},</h1>
            </div>
            
      <p>Voici votre solde.</p>

                <div class="jumbotron">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>Solde au <SCRIPT LANGUAGE="JavaScript">document.write(Message);</SCRIPT></th>
                        </tr>
                        </thead>
                        <tbody>
                                <tr>
                                    <td>${account.balance.getBalance()} €</td>
                                </tr>
                        </tbody>
                    </table>
                </div>
        </div>
    </div>
    
</div>


<%@include file="../footer.jsp"%>