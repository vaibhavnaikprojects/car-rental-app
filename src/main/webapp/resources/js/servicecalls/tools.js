$('#uploadTemplate').confirmation({
	onConfirm: function(event){
		$('#message').html('');
		if($('#file').val()==null || $('#file').val()==""){
			$('#message').html('<h5>Please select file</h5>');
			return;
		}
		var data = new FormData();
		$.each($('#file')[0].files, function(i, file) {
			data.append('uploadsheet', file);
		});
		$('#message').html('<i class="fa fa-cog fa-spin fa-2x fa-fw"></i> <h5>Loading</h5>');
		$.ajax({
			url: "uploadsheet",
			type:'POST',
			contentType :false,
			data: data,
			processData: false,
			success: function(data){
				console.log(data);
				$('#message').html('<h5>Data uploaded successfully</h5>');
				$('#file').val("");
				$(".bootstrap-filestyle input-group").find("input").val('');
			},
			error: function(xhr,status,error){
				console.log(error);
			}
		});
	}
});
$('#systemdataset').confirmation({
	onConfirm: function(event){
		$('#message').html('');
		$('#message').html('<i class="fa fa-cog fa-spin fa-2x fa-fw"></i> <h5>Loading</h5>');
		$.ajax({
			url: "systemdataset",
			type:'GET',
			success: function(data){
				console.log(data);
				$('#message').html('<h5>Data uploaded successfully</h5>');
				$('#file').val("");
				$(".bootstrap-filestyle input-group").find("input").val('');
			},
			error: function(xhr,status,error){
				console.log(error);
			}
		});
	}
});