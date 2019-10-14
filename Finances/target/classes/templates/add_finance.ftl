<#--Сверстать страницу где будут html-инпуты для ввода данных о расходе
см. html form-->
<#import "spring.ftl" as spring />
<@spring.bind "model" />
<html>
<head>
    <title>Finance</title>
    <link rel="stylesheet" type="text/css" href="style.css"/>
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
</head>
<body>
<div class="finance_form" align="center">
    <form action="/finances/add" method="post">

        <input type="radio" name="financeType" id="income" value="INCOME" placeholder="Доходы" checked>
        <label for="income">Доходы</label>
        <br>
        <input type="radio" name="financeType" id="consumption" value="CONSUMPTION" placeholder="Расходы">
        <label for="consumption">Расходы</label>
        <br>
        <br>
            <label>Значение</label>
        <input type="number" id="number" name="sum" placeholder="Число" required>
        <br>
            <label>Описание</label>
        <br><br>
        <input type="text" width="200" id="text" name="description" placeholder="Текст" required>

        <p>
            <label>Категория:</label>
        </p>
        <p>

            <label>
                <input type="radio" name="categoryType" id="shop" value="SHOP" placeholder="Магазин">
                Магазин
            </label>
            <label>
                <input type="radio" name="categoryType"  id="auto" value="AUTO" placeholder="Авто">
                Авто
            </label>
            <label>
                <input type="radio" name="categoryType" id="entertainment" value="ENTERTAINMENT" placeholder="Развлечения">
                Развлечения
            </label>
            <br>
            <label>
                <input type="radio" name="categoryType" id="communal" value="COMMUNAL" placeholder="Коммуналка">
                Коммунальные платежи
            </label>
            <label>
                <input type="radio" name="categoryType" id="media" value="MEDIA" placeholder="Медиа">
                Медиа
            </label>
            <br>
            <label>
                <input type="radio" name="categoryType" id="other" value="OTHER" placeholder="Другое" checked>
                Другое
            </label>
        </p>
        <p>
            <input type="submit" id="save" value="Сохранить">
        </p>
        <a href="http://localhost:8081/category_income?category=OTHER">Общая сумма доходов: </a>
        <h1>${model.sumIncome}</h1>
        <br>
        <a href="http://localhost:8081/category_consumption?category=SHOP">Общая сумма расходов: </a>
        <h1> ${model.sumConsumption}</h1>


    </form>
</div>
</body>
</html>
