<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <body>
        <h1>환율 계산</h1>

        <div>송금국가: 미국(USD)</div>
        <div>수취국가:
            <select id="localeSelect">
                <option value="">수취국가선택</option>
                <c:forEach var="item" items="${currencyType}">
                    <option value="${item}">
                        ${item.locale}(${item})
                    </option>
                </c:forEach>
            </select>
        </div>
        <div>
            환율: <span class="exchangeRate"></span>
        </div>
        <div>
            송금액: <input type="text" id="sendPrice">USD
        </div>
        <div>
            <button id="calculator">Submit</button>
        </div>
        <div class="result" style="display: none">
            수취금액은 <span id="result"></span> 입니다.
        </div>

        <script src="/resources/js/jquery-3.1.1.min.js"></script>
        <script src="/resources/js/calculator.js"></script>
    </body>
</html>