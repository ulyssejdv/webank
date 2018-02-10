<%--
  Created by IntelliJ IDEA.
  User: ayda
  Date: 10/02/18
  Time: 00:54
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../header.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/jquery.jqplot.min.css"/>


<div class="container">
    <div class="row">
        <div class="col-md-d">
            <div class="jumbotron">
                <h3>Historique des soldes</h3>
                <div id="char-historique-solde"></div>
                <br>
                <br>
                <h3>Prédiction des soldes</h3>

                <div>
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <c:forEach var="item" items="${listHistoryPrediction}">
                                <th>${item.month}/${item.year}</th>
                            </c:forEach>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <c:forEach var="item" items="${listHistoryPrediction}">
                                <td>${item.solde}</td>
                            </c:forEach>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <br>
                <br>
                <h3>Représenation graphique des prédictions</h3>
                <div id="char-prediction-solde"></div>
            </div>
        </div>
    </div>
</div>

<%@include file="../footer.jsp" %>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/jquery.jqplot.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.dateAxisRenderer.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.canvasAxisLabelRenderer.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.canvasAxisTickRenderer.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.canvasTextRenderer.min.js"></script>

<script type="application/javascript">
    $(document).ready(function(){
        var dataHistorique = ${tabDateHistorique};

        var charHistoriqueSolde = $.jqplot('char-historique-solde', [dataHistorique], {
            axes: {
                xaxis: {
                    renderer: $.jqplot.DateAxisRenderer,
                    label: 'Date',
                    labelRenderer: $.jqplot.CanvasAxisLabelRenderer,
                    tickRenderer: $.jqplot.CanvasAxisTickRenderer,
                    tickOptions: {
                        // labelPosition: 'middle',
                        angle: 15
                    }

                },
                yaxis: {
                    label: 'Solde',
                    labelRenderer: $.jqplot.CanvasAxisLabelRenderer
                }
            }
        });

        var dataPrediction = ${tabDatePrediction};

        var charPredictionSolde = $.jqplot('char-prediction-solde', [dataPrediction], {
            axes: {
                xaxis: {
                    renderer: $.jqplot.DateAxisRenderer,
                    label: 'Date',
                    labelRenderer: $.jqplot.CanvasAxisLabelRenderer,
                    tickRenderer: $.jqplot.CanvasAxisTickRenderer,
                    tickOptions: {
                        // labelPosition: 'middle',
                        angle: 15
                    }

                },
                yaxis: {
                    label: 'Solde',
                    labelRenderer: $.jqplot.CanvasAxisLabelRenderer
                }
            }
        });

    });
</script>
