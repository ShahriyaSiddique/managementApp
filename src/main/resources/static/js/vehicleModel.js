$(document).ready(function() {
	$("table #editBtn").click(function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicleModel, status){
			$('#idEdit').val(vehicleModel.id);
			$('#descriptionEdit').val(vehicleModel.description);
			$('#detailsEdit').val(vehicleModel.details);
		});			
		$('#editModal').modal();
	});
	
	$("table #detailsBtn").click(function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicleModel, status){
			$('#idDetails').val(vehicleModel.id);
			$('#descriptionDetails').val(vehicleModel.description);
			$('#detailsDetails').val(vehicleModel.details);
			$('#lastModifiedByDetails').val(vehicleModel.lastModifiedBy);
			$('#lastModifiedDateDetails').val(vehicleModel.lastModifiedDate.substr(0,19).replace("T", " "));
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