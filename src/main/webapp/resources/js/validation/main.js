$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();
    $('#startDatetimepicker').datetimepicker({
    	format: 'MM/DD/YYYY',
    	minDate:new Date()
    }).on('dp.change', function (selected) {
    	$('#endDatetimepicker').data("DateTimePicker").minDate(selected.date);
    });
    $('#endDatetimepicker').datetimepicker({
    	format: 'MM/DD/YYYY'
    }).on('dp.change', function (selected) {
    	if($('#startDate').val()!=""){
    		var start= $('#startDatetimepicker').data('DateTimePicker').date();
    	    var end= $('#endDatetimepicker').data('DateTimePicker').date();
    	    var timeDiff = 0
    	    if (end) {
    	        timeDiff = (end - start) / 1000;
    	    }
    	    var days = Math.floor(timeDiff / (60 * 60 * 24));
    	    $('#noOfRentalType').val(days);
    	    if($('#rentalType').val()==null){
    			if(days>=7)
    				$('#rentalType').val('Weekly')
    			else
    				$('#rentalType').val('Daily')	
    		}
    		if($('#rentalType').val()=='Weekly'){
    			$('#noOfRentalType').val((days/7));
    		}
    		else{
    			$('#noOfRentalType').val(days+1);
    		}
    		
    	}
    })
});
function navigation(page){
	location.href=page;
}



function readURL(input) {

    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#imagePreview').attr('src', e.target.result);
        }

        reader.readAsDataURL(input.files[0]);
    }
}
$("#slideImage").change(function(){
    readURL(this);
});