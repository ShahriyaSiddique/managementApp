$(document).ready(function() {
	$("table #editBtn").click(function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(jobTitle, status){
			$('#idEdit').val(jobTitle.id);
			$('#descriptionEdit').val(jobTitle.description);
			$('#detailsEdit').val(jobTitle.details);
		});			
		$('#editModal').modal();
	});
	
	$("table #detailsBtn").click(function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(jobTitle, status){
			$('#idDetails').val(jobTitle.id);
			$('#descriptionDetails').val(jobTitle.description);
			$('#detailsDetails').val(jobTitle.details);
			$('#lastModifiedByDetails').val(jobTitle.lastModifiedBy);
			$('#lastModifiedDateDetails').val(jobTitle.lastModifiedDate.substr(0,19).replace("T", " "));
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