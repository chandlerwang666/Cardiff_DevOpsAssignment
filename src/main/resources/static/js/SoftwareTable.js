function editRow(obj) {
    var trp = obj.parentNode.parentNode;
    var tdobj = trp.cells;
    tdobj[1].innerHTML ="<input type='text' value='" + tdobj[1].innerHTML + "' size='8'/>";
    tdobj[2].innerHTML ="<input type='text' value='" + tdobj[2].innerHTML + "' size='8'/>";
    tdobj[3].innerHTML ="<input type='text' value='" + tdobj[3].innerHTML + "' size='8'/>";
    tdobj[4].innerHTML ="<input type='text' value='" + tdobj[4].innerHTML + "' size='8'/>";
    tdobj[5].innerHTML = "<div class='edit'>Confirm</div>";
    tdobj[5].childNodes[0].onclick = function() {
        tdobj[1].innerHTML = tdobj[1].childNodes[0].value;
        tdobj[2].innerHTML = tdobj[2].childNodes[0].value;
        tdobj[3].innerHTML = tdobj[3].childNodes[0].value;
        tdobj[4].innerHTML = tdobj[4].childNodes[0].value;
        tdobj[5].innerHTML = "<a class='edit' title='Edit' data-toggle='tooltip' onclick='editRow(this)'><i class=\"material-icons\">&#xE254;</i></a>\n" +
            "                      <a class='delete' title='Delete' data-toggle='tooltip' th:attr='onclick=|deleteRow('${hardware.id}')|\"><i class='material-icons'>&#xE872;</i></a>";


        var formData = new FormData();
        formData.set('id',tdobj[0].innerHTML);
        formData.set('employee',tdobj[1].innerHTML);
        formData.set('software',tdobj[2].innerHTML);
        formData.set('availability',tdobj[3].innerHTML);
        formData.set('renewal',tdobj[4].innerHTML);
        $.ajax({
            type: "POST",
            url: '/SoftwareUpdate',
            data: formData,
            dataType: 'json',
            contentType: false,
            processData: false
        }).done(function(data, textStatus, xhr) {
            location.reload();
        }).fail(function( jqXHR, textStatus ) {
            console.log(textStatus)
        });
    }

}
//
function deleteRow(obj) {
    var formData = new FormData();
    formData.set('id',obj);
    $.ajax({
        type: "POST",
        url: '/SoftwareDelete',
        data: formData,
        dataType: 'json',
        contentType: false,
        processData: false
    }).done(function(data, textStatus, xhr) {
        location.reload();
    }).fail(function( jqXHR, textStatus ) {
        console.log(textStatus)
    });
}

function AddRow(){
    var  employee, software, available,renewal;
    employee = document.getElementById("employee").value;
    software = document.getElementById("software").value;
    available =  document.getElementById("available").value;
    renewal =  document.getElementById("renewal").value;


    var formData = new FormData();
    formData.set('employee',employee);
    formData.set('software',software);
    formData.set('available',available);
    formData.set('renewal',renewal);


    $.ajax({
        type: "POST",
        url: '/SoftwareCreate',
        data: formData,
        dataType: 'json',
        contentType: false,
        processData: false
    }).done(function(data, textStatus, xhr) {
        window.location.href =  "/SoftwareTable";
    }).fail(function( jqXHR, textStatus ) {
        console.log(textStatus)
    });




}
