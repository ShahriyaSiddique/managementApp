$(document).ready(function() {
	$("table #editBtn").click(function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicleMake, status){
			$('#idEdit').val(vehicleMake.id);
			$('#descriptionEdit').val(vehicleMake.description);
			$('#detailsEdit').val(vehicleMake.details);
		});			
		$('#editModal').modal();
	});
	
	$("table #detailsBtn").click(function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicleMake, status){
			$('#idDetails').val(vehicleMake.id);
			$('#descriptionDetails').val(vehicleMake.description);
			$('#detailsDetails').val(vehicleMake.details);
			$('#lastModifiedByDetails').val(vehicleMake.lastModifiedBy);
			$('#lastModifiedDateDetails').val(vehicleMake.lastModifiedDate.substr(0,19).replace("T", " "));
		});			
		$('#detailsModal').modal();		
	});

	$("table #deleteBtn").click(function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$("#cofirmDelete").attr("href", href);
		$("#deleteModal").modal();
	});


});