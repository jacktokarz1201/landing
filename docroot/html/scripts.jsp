
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
    $( "#makeAnnouncementDialog" ).dialog({
       autoOpen: false,  
    });
    $( "#opener" ).click(function() {
       $( "#makeAnnouncementDialog" ).dialog( "open" );
    });
 });

$(function() {
    $( "#adminMakeAnnouncementDialog" ).dialog({
       autoOpen: false,  
    });
    $( "#adminMakeAnnouncementOpener" ).click(function() {
       $( "#adminMakeAnnouncementDialog" ).dialog( "open" );
    });
 });

</script>
