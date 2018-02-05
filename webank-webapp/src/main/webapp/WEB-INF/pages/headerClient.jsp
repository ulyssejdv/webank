<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Webank</title>

    <link rel="icon" type="image/ico" href="/favicon.ico" />

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="/theme.min.css">
</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="/"><img src="/img/logoWebank_navbar.png" class="img-responsive" alt="Logo Webank"></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="font-size:22px;">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="/webank/account/id/monCompte" role="button" aria-haspopup="true" aria-expanded="false">Mon compte<span class="caret"></span></a>
                </li>
                <li class="dropdown">
                    <a href="/webank/account/id/Notif#myModal" role="button" aria-haspopup="true" aria-expanded="false" type="submit" data-toggle="modal"> Mes notifications    ( ${fn:length(notification)} ) <span class="caret"></span></a>
                </li>
            </ul>
             <!-- Modal -->
                <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade" style="display: none;">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                                <h4 class="modal-title">Voici vos notifications</h4>
                            </div>
                            <div class="modal-body">


              <div class="jumbotron">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                           <th>Type de transaction</th>
                           <th>Montant transaction</th>
                        </tr>
                        </thead>
                        <tbody>
					<c:forEach var="n" items="${notification}">
                            <tr>
                            	<td>${n.transactionType}</td>
                                <td>${n.amount} €</td>
                            </tr>
                        </c:forEach>
                                
                        </tbody>
                    </table>
                </div>


							</div>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
