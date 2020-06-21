<html xmlns="http://www.w3.org/1999/html">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</head>
<body>

<#include "header.ftl">
<form action="send" method="post" >
    <table class="table table-striped table-bordered table-responsive-sm text-center">
        <tr>
            <th>ID</th>
            <th>SOURCE_NAME</th>
            <th>OWNER_NAME</th>
            <th>TABLE_NAME</th>
            <th>FIELD_NAME</th>
            <th>DOMAIN</th>
            <th>COMMENT</th>
        </tr>

        <tbody>
        <#list list as profile>
        <tr>
            <td><label for="textId"></label><input type="text" size="2" id="textId" style="text-align: center" class="form-control" name="textId" readonly value=${(profile.profileId)!"null"}></td>
            <td>${profile.sourceName}</td>
            <td>${profile.ownersName}</td>
            <td>${profile.tablesName}</td>
            <td>${profile.fieldName}</td>
            <td>${profile.nameDomain}</td>
            <#assign s = "${profile.comment}">
            <td><label for="text"></label><input type="text" size="2" id="text" style="text-align: center" class="form-control" name="text" value=${s?replace(" ", "_")}></td>
        </tr>
        </tbody>
        </#list>
    </table>
    <p style="text-align: center" size="10"><input type="submit" class="btn btn-outline-danger"   style="text-align: center; " value="Отправить"></p>
</form>
<#include "footer.ftl">
</body>
</html>
