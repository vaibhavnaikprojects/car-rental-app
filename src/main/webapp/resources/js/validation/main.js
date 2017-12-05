$(document).ready(function(){
	$('[data-toggle="tooltip"]').tooltip();
	$('#startDatetimepicker').datetimepicker({
		format: 'MM/DD/YYYY',
		minDate:new Date()
	})
	$('#endDatetimepicker').datetimepicker({
		format: 'MM/DD/YYYY'
	});
	$('#applicationDate').datetimepicker({
		format: 'MM/DD/YYYY'
	});
	$.ajax({
		url:'customers?filter=active',
		type:'get',
		success: function(data){
			console.log(data);
			$('#customerProcessing').hide();
			for(var i=0;i<data.length;i++){
				$('#customerList').append('<a href="#" id="'+data[i].id+'" class="list-group-item customerItems"><span class="badge">'+data[i].customerType+'</span>'+data[i].name+'</a>');
			}
			$('.customerItems').on('click',function(){
				$('.customerItems').removeClass('active');
				$(this).addClass('active');
			});
		},
		error:function(){
			$('#customerProcessing').hide();
		}
	});
});
function navigation(page){
	location.href=page;
}

