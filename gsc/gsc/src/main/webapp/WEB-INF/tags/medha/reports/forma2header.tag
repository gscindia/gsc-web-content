<%@ attribute name="address" type="String"%>
<h5>
	<strong>Academic Science Culture and Promotion Society</strong>
</h5>
<p><Strong>Code No. ${candidate[0].school.venue.code}</Strong></p>
<p>
	<strong class="truncate">School : ${candidate[0].school.name}</strong>
</p>
<p style="visibility:${address}">
<strong>Address : ${candidate[0].school.address}</strong>
</p>