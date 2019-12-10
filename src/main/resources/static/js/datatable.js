$(document).ready( function () {
	 var table = $('#wordsTable').DataTable({
			"sAjaxSource": "/word",
			"sAjaxDataProp": "",
			"order": [[ 0, "desc" ]],
		 	"paging":   false,
			"aoColumns": [
			      { "mData": "id"},
		          { "mData": "eng1" },
				  { "mData": "eng2" },
				  { "mData": "eng3" },
				  { "mData": "rus" },
			],
			 "columnDefs": [
				 {
					 "targets": [ 0 ],
					 "visible": true,
					 "searchable": false
				 }
			 ]
	 });
	$(".alert").fadeTo(2000, 0).slideUp(500, function(){
		$(this).remove();
	});
});