$(document).ready(function() {
	$('.sidenav').sidenav();
	$('.modal').modal();
	$('.tooltipped').tooltip();
	$('.carousel').carousel();
	$('.collection-item').click(function(event) {
		$('.collection-item').removeClass('active');
		$(event.currentTarget).addClass("active");
	});
	$('#auth-id').click(function() {
		var data = {};
		data['id'] = $('#loginform').find('#email').val();
		data['password'] = $('#loginform').find('#password').val();
		var resp = callApi("/auth", 'POST', JSON.stringify(data));
		//console.log(resp)
		if (resp.authStatus === 'true') {
			window.location.href = '/medhasandhan';
		} else {
			M.toast({ html: 'Incorrect Credential', completeCallback: function() { } });
		}
	});
});






function callApi(url, method, data) {
	var response;
	$.ajax({
		url: url,
		type: method,
		contentType: "application/json",
		dataType: 'json',
		data: data,
		async: false,
		success: function(result) {
			response = result;
		}, error: function(xhr) {
			response = xhr;
		}
	});
	return response;
}
function uploadAttachment(form, url) {
	var resp;
	$.ajax({
		type: "POST",
		url: url,
		data: form,
		async: false,
		contentType: false,
		processData: false,
		success: function(data) {
			/*M.toast({ html: 'File Uploaded. Please Check Preview' });*/
			resp = 'File Uploaded. Please Check Preview';

		},
		error: function(data) {
			resp = 'Something went wrong - at server. Try later';
		}
	});
	return resp;
}
function prepareFormData(form) {
	var jsonData = {};
	var formData = new FormData(form);
	formData.forEach((value, key) => jsonData[key] = value);

	return jsonData;
}

function beforeAjaxBlockUI(message) {
	$.blockUI({ message: message });

}