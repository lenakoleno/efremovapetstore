<#-- @ftlvariable name="data" type="io.qameta.allure.attachment.http.HttpRequestAttachment" -->
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" crossorigin="anonymous"></script>

    <link href="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>

    <link type="text/css" href="https://cdn.jsdelivr.net/npm/highlight.js@11.3.1/styles/github.min.css" rel="stylesheet"/>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/highlight.js@11.3.1/highlight.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/highlight.js@11.3.1/languages/bash.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/highlight.js@11.3.1/languages/json.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/highlight.js@11.3.1/languages/xml.min.js"></script>
    <script type="text/javascript">hljs.initHighlightingOnLoad();</script>

    <style>
        pre {
            white-space: pre-wrap;
        }
    </style>
</head>
<body>
<div>
    <pre><code><#if data.method?? && data.method?has_content>${data.method}<#else>GET</#if>: <#if data.url?? && data.url?has_content>${data.url}<#else>Unknown</#if></code></pre>
</div>

<#if data.body??>
    <h4>Body</h4>
    <div>
        <pre><code>${data.body}</code></pre>
    </div>
</#if>

<#if (data.headers)?has_content>
    <h4>Headers</h4>
    <div>
        <#list data.headers as name, value>
            <div>
                <pre><code><b>${name}</b>: ${value}</code></pre>
            </div>
        </#list>
    </div>
</#if>


<#if (data.cookies)?has_content>
    <h4>Cookies</h4>
    <div>
        <#list data.cookies as name, value>
            <div>
                <pre><code><b>${name}</b>: ${value}</code></pre>
            </div>
        </#list>
    </div>
</#if>

<#if data.curl??>
    <h4>Curl</h4>
    <div>
        <pre><code>${data.curl}</code></pre>
    </div>
</#if>
</body>
</html>