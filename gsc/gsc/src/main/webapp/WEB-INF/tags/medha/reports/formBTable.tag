<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ attribute name="dataList" type="java.util.List"%>
<div class="row">
				<div class="col s12">
					<table  class="centered responsive-table">
						<thead>							
							<tr>
							    <th>Roll No.</th>
								<th>Name</th>
								<th>Signature of the Examinee</th>
								<th style="white-space: normal">Marks Obtained</th>
								<th>GRADE</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${dataList}" var="entry">
								<tr>
									<td><c:if test="${entry.gender eq 'F'}">${entry.gender}</c:if>${entry.roll }</td>
									<td><strong>${fn:toUpperCase(entry.name)}</strong></td>
									<td></td>									
									<td></td>
									<td></td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>

						</tfoot>
					</table>

				</div>
			</div>