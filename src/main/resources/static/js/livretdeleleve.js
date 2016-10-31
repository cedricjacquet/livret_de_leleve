
$(document).ready(function () {
	
	$.get("/lde/cycles", function(data) {
	    var $this = $("#cycles-menu").empty();
	    var items = [];
	    $.each(data, function(i, item) {
	           items.push('<li><a class="link" href="/cycles/' + item.id + '">' + item.nom + '</a></li>');
	    });
	    $this.append( items.join('') );
	});
	
	$.get("/lde/cycles/" + cycleId + "/niveaux", function(data) {
	    var $this = $("#niveaux-menu").empty();
	    var items = [];
	    $.each(data, function(i, item) {
	           items.push('<li><a class="link" href="/cycles/'+ cycleId+ '/niveaux/' + item.id + '">' + item.nom + '</a></li>');
	    });
	    $this.append( items.join('') );
	});
	
	
});