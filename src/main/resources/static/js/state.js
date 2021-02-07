$('document').ready(function() {

	$('table #editState').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(state, status) {
			$('#idEdit').val(state.id);
			$('#ddlCountryEdit').val(state.countryid);
			$('#nameEdit').val(state.name);
			$('#capitalEdit').val(state.capital);
			$('#codeEdit').val(state.code);
			$('#detailsEdit').val(state.details);
		});
		$('#editModal').modal();
	});

	$('table #detailsState').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		console.log(href);
		$.get(href, function(state, status) {
			$('#idDetails').val(state.id);
			$('#ddlCountryDetails').val(state.countryid);
			$('#nameDetails').val(state.name);
			$('#detailsDetails').val(state.details);
			$('#codeDetails').val(state.code);
			$('#capitalDetails').val(state.capital);
			$('#lastModifiedByDetails').val(state.lastModifiedBy);
			/*$('#lastModifiedDateDetails').val(state.lastModifiedDate.substr(0,19).replace("T", " "));*/
		});
		$('#detailsModal').modal();
	});

	$('.table #deleteState').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();
	});
});