<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

      <jsp:include page="header.jsp"></jsp:include>

      <div class="container">

        <h3>Editar Autorização</h3>
        <form:form method="POST" action="/update" modelAttribute="editAutorizacao">
          <input type='hidden' id='id' rows='5' class='form-control' name='id' value="${editAutorizacao.id}" />
          <div class="row g-3">
            <div class="col-md-5">
              <label class="form-label">Procedimento</label>
              <select class="form-control" id="procedimento" name="procedimento" required>
                <option value="">Selecione</option>
                <c:forEach items="${procedimentos}" var="item">
                  <option value="${item.id}" <c:if test="${item.id == editAutorizacao.procedimento.id}"> selected
                    </c:if>>${item.nome}</option>
                </c:forEach>
              </select>
            </div>

            <div class="col-md-4">
              <label class="form-label">Idade</label>
              <input type="text" class="form-control" id="idade" name="idade" value="${editAutorizacao.idade}" required>
            </div>

            <div class="col-md-3">
              <label for="sexo" class="form-label">Sexo</label>
              <select class="form-control" id="sexo" name="sexo" required>
                <option value="">Selecione</option>
                <c:forEach items="${sexos}" var="sx">
                  <option value="${sx}" <c:if test="${sx == editAutorizacao.sexo}"> selected </c:if>>${sx.descricao}
                  </option>
                </c:forEach>
              </select>
            </div>

          </div>
          <hr class="my-4">
          <button class="btn btn-primary btn-lg" type="submit">Aurorizar</button>
        </form:form>
      </div>

      <jsp:include page="footer.jsp"></jsp:include>