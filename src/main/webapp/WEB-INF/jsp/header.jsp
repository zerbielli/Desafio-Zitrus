<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">

<head>
  <title>Desafio Zitrus</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>

<body>

  <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #00995D;">
    <div class="container-fluid">
      <a class="navbar-brand" href="/">Desafio Zitrus</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbar"
        aria-controls="navbar" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse justify-content-md-center" id="navbar">
        <ul class="navbar-nav">
          <li class="nav-item"><a href="index" ${pageContext.request.requestURI.endsWith('/index.jsp') ? 'class="nav-link active"' : 'class="nav-link"'}>Autorizar</a></li>
          <li class="nav-item"><a href="autorizacoes" ${pageContext.request.requestURI.endsWith('/autorizacoes.jsp') ? 'class="nav-link active"' : 'class="nav-link"'}>Autorizações</a></li>
        </ul>
      </div>
    </div>
  </nav>
  <br />

  <div class="container">