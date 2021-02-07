$(document).ready(function() {
	$("table #editCountry").click(function(event) {
		event.preventDefault();

		var href = $(this).attr('href');

		$.get(href, function(country, status) {
			$("#editId").val(country.id);
			$("#editDescription").val(country.description);
			$("#editCapital").val(country.capital);
			$("#editCode").val(country.code);
			$("#editContinent").val(country.continent);
			$("#editNationality").val(country.nationality);
		});

		$("#editModal").modal();
	});
	
	$("table #detailsCountry").click(function(event) {
		event.preventDefault();

		var href = $(this).attr('href');

		$.get(href, function(country, status) {
			$("#idDetails").val(country.id);
			$("#descriptionDetails").val(country.description);
			$("#codeDetails").val(country.code);
		});

		$("#detailsModal").modal();
	});

	$("table #deleteCountry").click(function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$("#cofirmDelete").attr("href", href);
		$("#deleteModal").modal();
	});


});