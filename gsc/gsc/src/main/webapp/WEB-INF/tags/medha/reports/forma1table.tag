<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ attribute name="dataList" type="java.util.List"%>
<div class="row">
				<div class="col s12">
					<table id="forma-1-list" class="centered responsive-table">
						<thead>
							<tr>
								<th colspan="2">To be filled by School</th>
								<th style="word-wrap: break-word;">For Office Use</th>
								<th colspan="2"></th>
							</tr>
							<tr>
								<th>Name</th>
								<th>Class</th>
								<th>Roll No.</th>
								<th>Marks</th>
								<th>Grade</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach items="${dataList}" var="entry">
								<tr>
									<td><strong>${fn:toUpperCase(entry.name)}</strong></td>
									<td>${entry.cls }</td>
									<td><c:if test="${entry.gender eq 'F'}">${entry.gender}</c:if>${entry.roll }</td>
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