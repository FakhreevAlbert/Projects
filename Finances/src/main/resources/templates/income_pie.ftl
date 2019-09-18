<#--Сверстать страницу где будут html-инпуты для ввода данных о расходе
см. html form-->
<#import "spring.ftl" as spring />
<@spring.bind "model" />
<html>
<head>
    <title>Finance</title>
<#--<link rel="stylesheet" type="text/css" href="style.css"/>-->
    <style>
        h1 {
            font-family: 'Times New Roman', Times, serif; /* Гарнитура текста */
            font-size: 100%; /* Размер шрифта в процентах */
        }

        p {
            font-family: Verdana, Arial, Helvetica, sans-serif;
            font-size: 11pt; /* Размер шрифта в пунктах */
        }


    </style>
    <script src="https://fonts.googleapis.com/css?family=Lato"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>

</head>
<body style="background-color: #3e94ec">
<table cellpadding="10" bgcolor="#b0e0e6" align="center" width="100%" style="background-color: #3e94ec">
    <tr>
        <th height="40" width="110" align="center"><a style="color: #FFFFFF;text-decoration: none"
                                                      href="http://localhost:8081/income_pie?sort=0" </a><p
                id="demo"></p></th>
        <th height="40" width="110" align="center"><a style="color: #FFFFFF;text-decoration: none"
                                                      href="http://localhost:8081/income_pie?sort=-1" </a><p
                id="demo1"></p></th>
        <th height="40" width="110" align="center"><a style="color: #FFFFFF;text-decoration: none"
                                                      href="http://localhost:8081/income_pie?sort=-2"</a><p
                id="demo2"></p></th>
        <th height="40" width="110" align="center"><a style="color: #FFFFFF;text-decoration: none"
                                                      href="http://localhost:8081/income_pie?sort=-3"</a><p
                id="demo3"></p></th>
        <th height="40" width="110" align="center"><a style="color: #FFFFFF;text-decoration: none"
                                                      href="http://localhost:8081/income_pie?sort=-4"</a><p
                id="demo4"></p></th>
        <th height="40" width="110" align="center"><a style="color: #FFFFFF;text-decoration: none"
                                                      href="http://localhost:8081/income_pie?sort=-5"</a><p
                id="demo5"></p></th>
    </tr>
</table>
<br>
<table cellpadding="10" bgcolor="#b0e0e6" align="center" width="100%" style="background-color: #3e94ec">
    <tr>
        <th height="40" width="110" align="center"><a style="color: #FFFFFF;text-decoration: none"
                                                      href="http://localhost:8081/consumption_pie?sort=1" </a><p>Все
            расходы</p></th>
        <th height="40" width="110" align="center"><a style="color: #FFFFFF;text-decoration: none"
                                                      href="http://localhost:8081/income_pie?sort=1" </a><p>Все
            доходы</p></th>
        <th height="40" width="110" align="center"><a style="color: #FFFFFF;text-decoration: none"
                                                      href="http://localhost:8081/category_income_sort?sort=ALL"</a><p>
            Назад</p></th>
    </tr>
</table>
<br>
<br>
<canvas id="oilChart" width="300" height="120" style="background-color: #3e94ec">

</canvas>
<script>
    window.onload = function myFunction() {
        var months = ["Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"];
        var d = new Date();
        var n = d.getMonth();

        document.getElementById("demo").innerHTML = months[n];
        if (n - 1 < 0) {
            document.getElementById("demo1").innerHTML = months[11];

        } else {
            document.getElementById("demo1").innerHTML = months[n - 1];
        }
        if (n - 2 < 0) {
            document.getElementById("demo2").innerHTML = months[10];

        } else {
            document.getElementById("demo2").innerHTML = months[n - 2];
        }
        if (n - 3 < 0) {
            document.getElementById("demo3").innerHTML = months[9];

        } else {
            document.getElementById("demo3").innerHTML = months[n - 3];
        }
        if (n - 4 < 0) {
            document.getElementById("demo4").innerHTML = months[8];

        } else {
            document.getElementById("demo4").innerHTML = months[n - 4];
        }
        if (n - 5 < 0) {
            document.getElementById("demo5").innerHTML = months[7];

        } else {
            document.getElementById("demo5").innerHTML = months[n - 5];
        }
    }
</script>


<script>var oilCanvas = document.getElementById("oilChart");

Chart.defaults.global.defaultFontFamily = "Lato";
Chart.defaults.global.defaultFontSize = 18;

var oilData = {
    labels: [
        "Магазин",
        "Авто",
        "Развлечения",
        "Коммунальные платежи",
        "Другое",
        "Медиа"
    ],
    datasets: [
        {
            data: [${model.sumShop?c}, ${model.sumAuto?c}, ${model.sumEntertaiment?c}, ${model.sumCommunal?c}, ${model.sumOther?c}, ${model.sumMedia?c}],
            backgroundColor: [
                "#FF6384",
                "#63FF84",
                "#84FF63",
                "#8463FF",
                "#6384FF"
            ]
        }]
};

var pieChart = new Chart(oilCanvas, {
    type: 'pie',
    data: oilData
});</script>


</body>
</html>
