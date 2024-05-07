<#-- @ftlvariable name="data" type="io.qameta.allure.attachment.http.HttpResponseAttachment" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HTTP Response Details</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" crossorigin="anonymous"></script>

    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" crossorigin="anonymous"></script>

    <link type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/10.7.2/styles/github.min.css" rel="stylesheet"/>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/10.7.2/highlight.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/10.7.2/languages/bash.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/10.7.2/languages/json.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/10.7.2/languages/xml.min.js"></script>
    <script type="text/javascript">hljs.initHighlightingOnLoad();</script>

    <style>
        pre {
            white-space: pre-wrap;
        }
    </style>
</head>
<body>
<div><h4>Response Status Code</h4> <#if data.responseCode??>
        <pre><code><b>${data.responseCode}</b></code></pre>
    <#else>Unknown</#if></div>
<#if data.url??>

    <div>
    <pre><code>${data.url}</code></pre>
    </div></#if>

<#if (data.headers)?has_content>
    <h4>Response Headers</h4>
    <div>
        <#list data.headers as name, value>
            <div>
                <pre><code><b>${name}</b>: ${value}</code></pre>
            </div>
        </#list>
    </div>
</#if>

<#if data.body??>
    <h4>Response Body</h4>
    <div>
        <pre><code>${data.body}</code></pre>
    </div>
</#if>

<#if (data.cookies)?has_content>
    <h4>Response Cookies</h4>
    <div>
        <#list data.cookies as name, value>
            <div>
                <pre><code><b>${name}</b>: ${value}</code></pre>
            </div>
        </#list>
    </div>
</#if>
</body>
</html>
