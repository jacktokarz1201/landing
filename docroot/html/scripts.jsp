
<script>

$(document).ready(function() {
	$('table').each(function(){
		$(this).addClass('defaultTable display cell-border compact');
	    $(this).DataTable({
	    	"pageLength": 5
	    });
	});
} );

$(function() {
    $( "#makeAssignmentDialog" ).dialog({
       autoOpen: false,  
    });
    $( "#opener" ).click(function() {
       $( "#makeAssignmentDialog" ).dialog( "open" );
    });
 });


</script>
