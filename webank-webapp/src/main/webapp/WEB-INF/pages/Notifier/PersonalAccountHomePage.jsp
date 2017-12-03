<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<%@include file="../headerClient.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="page-header">
                <h1>Bonjour ${account.customer.getFirstname()},</h1>
            </div>
            
      <p>Vous êtes actuellement sur votre page d'acceuil.
      Si vous le souhaitez vous pouvez consulter le solde actuel de votre compte courant ainsi que vos notifications.</p>

               
        </div>
    </div>
    
</div>


<%@include file="../footer.jsp"%>