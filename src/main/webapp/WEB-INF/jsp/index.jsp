<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

      <jsp:include page="header.jsp"></jsp:include>

      <h3>Autorizar Procedimento</h3>
      <br>

      <form:form method="POST" action="/add" modelAttribute="addAutorizacao">
        <div class="row g-3">

          <div class="col-md-5">
            <label class="form-label">Procedimento</label>
            <select class="form-control" id="procedimento" name="procedimento" required>
              <option value="">Selecione</option>
              <c:forEach items="${procedimentos}" var="item">
                <option value="${item.id}">${item.nome}</option>
              </c:forEach>
            </select>
          </div>

          <div class="col-md-4">
            <label class="form-label">Idade</label>
            <input type="number" class="form-control" id="idade" name="idade" min="1" max="120" required>
          </div>

          <div class="col-md-3">
            <label for="sexo" class="form-label">Sexo</label>
            <select class="form-control" id="sexo" name="sexo" required>
              <option value="">Selecione</option>
              <c:forEach items="${sexos}" var="sx">
                <option value="${sx}">${sx.descricao}</option>
              </c:forEach>
            </select>
          </div>

        </div>
        <hr class="my-4">
        <button class="btn btn-primary btn-lg" type="submit">Aurorizar</button>
      </form:form>

      <hr class="my-4">
      <h3>Lista de autorizações</h3>
      <br>
      <table class="table table-striped">

        <thead>
          <tr>
            <th><b>Procedimento</b></th>
            <th><b>Idade</b></th>
            <th><b>Sexo</b></th>
            <th><b>Situação</b></th>
            <th><b>Ações</b></th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${listAutorizacoes}" var="aut">
            <tr>
              <td>
                <c:out value="${aut.procedimento.nome}"></c:out>
              </td>
              <td>
                <c:out value="${aut.idade}"></c:out>
              </td>

              <td>
                <c:out value="${aut.sexo.descricao}"></c:out>
              </td>

              <td>
                <c:out value="${aut.situacao.descricao}"></c:out>
              </td>

              <td>
                <div class="btn-group " role="group">
                  <a href="/${aut.id}/edit" class="btn btn-info btn-sm">Editar</a>
                  <a href="/${aut.id}/cancel" class="btn btn-warning btn-sm">Cancelar</a>
                  <a href="/${aut.id}/delete" class="btn btn-danger btn-sm">Excluir</a>
                </div>
              </td>
            </tr>

          </c:forEach>
        </tbody>
      </table>
      </div>

      <jsp:include page="footer.jsp"></jsp:include>