<#import "spring.ftl" as spring />
<@spring.bind "model" />
<html>
<head>
    <title>Finance_category</title>
    <link rel="stylesheet" type="text/css" href="category_style.css"/>
    <style type="text/css">
        TABLE {
            width: 700px; /* Ширина таблицы */
            border-collapse: collapse; /* Убираем двойные линии между ячейками */
        }
        h1 {
            font-family: 'Times New Roman', Times, serif; /* Гарнитура текста */
            font-size: 180%; /* Размер шрифта в процентах */
        }

    </style>
    <script src="myFunctions.js"></script>
</head>
<body>
<div class="finance_category" align="center">
    <h1>Таблица доходов</h1>
    <br>
    <form action="/finances/add" method="post">
        <table cellpadding="10" bgcolor="#b0e0e6" align="center" width="100%">
            <tr>
                <th height="40" width="110" align="center"><a style="color: #FFFFFF;text-decoration: none"
                                                              href="http://localhost:8081/category_income?category=SHOP" </a>
                    Магазин
                </th>
                <th height="40" width="110" align="center"><a style="color: #FFFFFF;text-decoration: none"
                                                              href="http://localhost:8081/category_income?category=AUTO" </a>
                    Авто
                </th>
                <th height="40" width="110" align="center"><a style="color: #FFFFFF;text-decoration: none"
                                                              href="http://localhost:8081/category_income?category=ENTERTAINMENT"</a>
                    Развлечения
                </th>
                <th height="40" width="110" align="center"><a style="color: #FFFFFF;text-decoration: none"
                                                              href="http://localhost:8081/category_income?category=COMMUNAL"</a>
                    Коммунальные платежи
                </th>
                <th height="40" width="110" align="center"><a style="color: #FFFFFF;text-decoration: none"
                                                              href="http://localhost:8081/category_income?category=MEDIA"</a>
                    Медиа
                </th>
                <th height="40" width="110" align="center"><a style="color: #FFFFFF;text-decoration: none"
                                                              href="http://localhost:8081/category_income?category=OTHER"</a>
                    Другое
                </th>
                <th height="40" width="110" align="center"><a style="color: #FFFFFF;text-decoration: none"
                                                              href="http://localhost:8081/add_finance"</a> Добавить
                </th>
                <th height="40" width="110" align="center"><a style="color: #FFFFFF;text-decoration: none"
                                                              href="http://localhost:8081/category_income_sort?sort=ALL" onclick="setAll()" </a>
                    Общее
                </th>
            </tr>

        </table>
        <br>
        <table cellpadding="10" bgcolor="#b0e0e6" align="center" width="100%">
            <tr>
                <th height="40" align="center">Описание</th>
                <th height="40" align="center">Доход</th>
                <th height="40" align="center">Дата</th>
            </tr>
            <#list model.income as item>
                <tr>
                    <td height="40" align="center">${item.description}</td>
                    <td height="40" align="center">${item.sum}</td>
                    <td height="40" align="center">${item.stringTime}</td>

                </tr>
            </#list>
        </table>
    </form>
</div>
</body>
</html>