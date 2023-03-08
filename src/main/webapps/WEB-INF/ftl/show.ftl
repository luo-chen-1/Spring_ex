<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1 style="margin: 30px">What Spring can do</h1>
<div class="row">
    <#list lists as e>
        <div class="col-lg-2 "  style="border:1px solid #c1e2b3;margin: 10px" >
            <img src="${e.url}" style="width: 150px;height: 150px" >
            <h2 class="fw-normal">${e.name}</h2>
            <p>${e.content}</p>
        </div>
    </#list>
</div><!-- /.row -->
</body>
</html>
