<!DOCTYPE html>
<html lang="en">
<head>
    <title>Welcome!</title>
</head>
<body>
<h1>Welcome ${user}<#if user == "hello">, our beloved leader</#if>!</h1>
<p>Our latest product:
    <a href="${latestProduct.url}">${latestProduct.name}</a>!
<p>We have these animals:
<table border=1>
<#list animals as animal>
<tr>
    <td>${animal}
    <td>${animal?index}
    <td>${animal?counter}
<td>${animal?item_parity}Row
</#list>
</table>
<h1>${cargo.name!"cargo.name is null"}</h1>
<h1><#if latestProduct.name??>${latestProduct.name}</#if></h1>
<#if cargo.weight < 100>Light cargo</#if>
<#include "copyright_footer.ftl">
</body>
</html>
