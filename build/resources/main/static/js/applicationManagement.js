function approveApplication(obj){
    var trp = obj.parentNode.parentNode;
    var tdobj = trp.cells;
    tdobj[4].innerHTML = "<span class='badge bg-success'>Approved</span>";
    tdobj[5].innerHTML = "";
}

function rejectApplication(obj){
    var trp = obj.parentNode.parentNode;
    var tdobj = trp.cells;
    tdobj[4].innerHTML = "<span class='rejectedStatus'>Rejected</span>";
    tdobj[5].innerHTML = "";
}

function AddRow(id,employee,asset,date,status){
    var formData = new FormData();
    formData.set('employee',employee);
    formData.set('asset',asset);
    formData.set('renewal',date);
    formData.set('availability',"Yes");


    $.ajax({
        type: "POST",
        url: '/InsertAsset',
        data: formData,
        dataType: 'json',
        contentType: false,
        processData: false
    }).done(function(data, textStatus, xhr) {
        window.location.href =  "/Application";
    }).fail(function( jqXHR, textStatus ) {
        console.log(textStatus)
    });

    var formData2 = new FormData();
    formData2.set('id',id);
    formData2.set('status',"Approved");


    $.ajax({
        type: "POST",
        url: '/ApplicationUpdate',
        data: formData2,
        dataType: 'json',
        contentType: false,
        processData: false
    }).done(function(data, textStatus, xhr) {
        window.location.href =  "/Application";
    }).fail(function( jqXHR, textStatus ) {
        console.log(textStatus)
    });
}

function deleteRow(id) {
    var formData = new FormData();
    formData.set('id',id);
    $.ajax({
        type: "POST",
        url: '/ApplicationDelete',
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
