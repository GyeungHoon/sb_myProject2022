<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>알림</title>
</head>
<body>

  <script>
			const msg = '${msg}';

			if (msg.trim().length > 0) {
				alert(msg);
			}

			const historyBack = '${historyBack}';

			if (historyBack) {
				history.back();
			}

			const replaceUri = '${replaceUri}';

			if (replaceUri) {
				location.replace(replaceUri);
			}
		</script>

</body>
</html>