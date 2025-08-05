<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Available Courses</title>
</head>
<body>
    <h2>Welcome, ${sessionScope.student.name}</h2>
    <h3>Available Courses</h3>

    <table border="1" cellpadding="10">
        <tr>
            <th>Course Name</th>
            <th>Instructor</th>
            <th>Credits</th>
            <th>Action</th>
        </tr>
        <c:forEach var="course" items="${courses}">
            <tr>
                <td>${course.name}</td>
                <td>${course.instructor}</td>
                <td>${course.credits}</td>
                <td>
                    <form action="register/${course.courseId}" method="post">
                        <input type="submit" value="Register" />
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <br/>
    <form action="logout" method="post">
        <input type="submit" value="Logout" />
    </form>
</body>
</html>
