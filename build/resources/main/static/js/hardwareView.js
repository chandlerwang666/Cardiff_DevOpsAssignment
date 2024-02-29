// $(document).ready(function(){
//     $('[data-toggle="tooltip"]').tooltip();
//     var actions = $("table td:last-child").html();
//     // Append table with add row form on add new button click
//     $(".add-new").click(function(){
//         $(this).attr("disabled", "disabled");
//         var index = $("table tbody tr:last-child").index();
//         var row = '<tr>' +
//             '<td><input type="text" class="form-control" name="id" id="id"></td>' +
//             '<td><input type="text" class="form-control" name="employee" id="employee"></td>' +
//             '<td><input type="text" class="form-control" name="hardware" id="hardware"></td>' +
//             '<td><input type="text" class="form-control" name="available" id="available"></td>'+
//             '<td><input type="text" class="form-control" name="checkin" id="checkin"></td>' +
//             '<td>' + actions + '</td>' +
//             '</tr>';
//         $("table").append(row);
//         $("table tbody tr").eq(index + 1).find(".add, .edit").toggle();
//         $('[data-toggle="tooltip"]').tooltip();
//     });
//     // Add row on add button click
//     $(document).on("click", ".add", function(){
//         var empty = false;
//         var input = $(this).parents("tr").find('input[type="text"]');
//         input.each(function(){
//             if(!$(this).val()){
//                 $(this).addClass("error");
//                 empty = true;
//             } else{
//                 $(this).removeClass("error");
//             }
//         });
//         $(this).parents("tr").find(".error").first().focus();
//         if(!empty){
//             input.each(function(){
//                 $(this).parent("td").html($(this).val());
//             });
//             $(this).parents("tr").find(".add, .edit").toggle();
//             $(".add-new").removeAttr("disabled");
//         }
//     });
//     // Edit row on edit button click
//     $(document).on("click", ".edit", function(){
//         $(this).parents("tr").find("td:not(:last-child)").each(function(){
//             $(this).html('<input type="text" class="form-control" value="' + $(this).text() + '">');
//         });
//         $(this).parents("tr").find(".add, .edit").toggle();
//         $(".add-new").attr("disabled", "disabled");
//     });
//     // Delete row on delete button click
//     $(document).on("click", ".delete", function(){
//         $(this).parents("tr").remove();
//         $(".add-new").removeAttr("disabled");
//     });
// });

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
        formData.set('name',tdobj[1].innerHTML);
        formData.set('hardware',tdobj[2].innerHTML);
        formData.set('availability',tdobj[3].innerHTML);
        formData.set('checkin',tdobj[4].innerHTML);
        $.ajax({
            type: "POST",
            url: '/HardwareUpdate',
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

function deleteRow(obj) {
    var formData = new FormData();
    formData.set('id',obj);
    $.ajax({
        type: "POST",
        url: '/HardwareDelete',
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
    var name, hardware, availability, checkin;
    name = document.getElementById("name").value;
    hardware = document.getElementById("hardware").value;
    availability =  document.getElementById("availability").value;
    checkin =  document.getElementById("checkin").value;

    var formData = new FormData();
    formData.set('name',name);
    formData.set('hardware',hardware);
    formData.set('availability',availability);
    formData.set('checkin',checkin);

    $.ajax({
        type: "POST",
        url: '/HardwareCreate',
        data: formData,
        dataType: 'json',
        contentType: false,
        processData: false
    }).done(function(data, textStatus, xhr) {
        window.location.href =  "/HardwareView";
    }).fail(function( jqXHR, textStatus ) {
        console.log(textStatus)
    });

}