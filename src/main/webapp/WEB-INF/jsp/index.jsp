<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Cloud Libs</title>
</head>
<body>
    <div>
        <h3>GCS</h3>
        <ul>
            <c:forEach items="${buckets}" var="bucket">
                <li>${bucket}</li>
            </c:forEach>
        </ul>
    </div>

    <div>
        <h3>Datastore</h3>
        <ul>
            <c:forEach items="${datastoreProps}" var="entry">
                <li>${entry.key} : ${entry.value}</li>
            </c:forEach>
        </ul>
    </div>

    <div>
        <h3>Translate</h3>
        <ul>
            <li>Input: ${translationInput}, Spanish: ${translationOutput}</li>
        </ul>
    </div>
</body>
</html>
