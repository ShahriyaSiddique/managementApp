$(document).ready(function() {
	$("table #editBtn").click(function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicleType, status){
			$('#idEdit').val(vehicleType.id);
			$('#descriptionEdit').val(vehicleType.description);
			$('#detailsEdit').val(vehicleType.details);
		});			
		$('#editModal').modal();
	});
	
	$("table #detailsBtn").click(function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicleType, status){
			$('#idDetails').val(vehicleType.id);
			$('#descriptionDetails').val(vehicleType.description);
			$('#detailsDetails').val(vehicleType.details);
			$('#lastModifiedByDetails').val(vehicleType.lastModifiedBy);
			$('#lastModifiedDateDetails').val(vehicleType.lastModifiedDate.substr(0,19).replace("T", " "));
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