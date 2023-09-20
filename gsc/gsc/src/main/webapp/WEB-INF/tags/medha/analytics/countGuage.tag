<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/medha"%>
<%@ attribute name="year"%>
<%@ attribute name="size"%>
<common:highchartsScripts></common:highchartsScripts>
<script type="text/javascript"
	src="../../asset/js/charts/enrollmentGuage.js"></script>

<div id="enrollment-chart${year}"></div>
<script>
	drawTotalEnrollmentChart('enrollment-chart'+${year}, callApi(
			'/reports/enrollment?year='+${year}, 'POST', '{}'),'${size}');
</script>