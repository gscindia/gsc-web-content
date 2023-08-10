<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="exam" tagdir="/WEB-INF/tags/venue"%>
<%@ attribute name="mediaUrl"%>
<c:set var="venueList" value="${venues}"></c:set>
<div class="col s12 m12 l12">
						<h4>List of Venues</h4>
						<div class="col s7 m57 s7">
							<ul class="collection">
								<c:forEach items="${venueList}" varStatus="pos" var="venue">
									<li class="collection-item venue-list" data-row="${pos.index}"><div>
											${venue.name}<a href="#!" class="secondary-content"><span class="collection-icon"><i
												class="material-icons tiny">send</i></span></a>
										</div></li>
								</c:forEach>
							</ul>
							<a class="btn-floating btn-large cyan pulse"><i
								class="material-icons" >add</i></a>
						</div>
						<div class="col s5 m5 l5">
						<c:forEach items="${venueList}" varStatus="pos" var="venue">
							<exam:venueDetails venueItem="${venues[pos.index]}" index="${pos.index}" mediaUrl="${mediaUrl}"/>
						</c:forEach>
						
							
						</div>
					</div>
