

$('document').ready(function() {

	$('table #editBtn').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(supplier, status) {
			$('#txtAddressEdit').val(supplier.address);
			$('#txtCityEdit').val(supplier.city);
			$('#ddlCountryEdit').val(supplier.countryid);
			$('#txtDetailsEdit').val(supplier.details);
			$('#txtEmailEdit').val(supplier.email);
			$('#txtIdEdit').val(supplier.id);
			$('#txtMobileEdit').val(supplier.mobile);
			$('#txtNameEdit').val(supplier.name);
			$('#txtPhoneEdit').val(supplier.phone);
			$('#ddlStateEdit').val(supplier.stateid);
			$('#txtWebsiteEdit').val(supplier.website);
		});
		$('#editModal').modal();
	});

	$('table #detailsBtn').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		console.log(href)
		$.get(href, function(supplier, status) {
			$('#txtAddressDetails').val(supplier.address);
			$('#txtCityDetails').val(supplier.city);
			$('#ddlCountryDetails').val(supplier.countryid);
			$('#txtDetailsDetails').val(supplier.details);
			$('#txtEmailDetails').val(supplier.email);
			$('#txtIdDetails').val(supplier.id);
			$('#txtMobileDetails').val(supplier.mobile);
			$('#txtNameDetails').val(supplier.name);
			$('#txtPhoneDetails').val(supplier.phone);
			$('#ddlStateDetails').val(supplier.stateid);
			$('#txtWebsiteDetails').val(supplier.website);
			$('#lastModifiedByDetails').val(country.lastModifiedBy);
			$('#lastModifiedDateDetails').val(country.lastModifiedDate.substr(0, 19).replace("T", " "));
		});
		$('#detailsModal').modal();
	});

	$('table #deleteBtn').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();
	});
});