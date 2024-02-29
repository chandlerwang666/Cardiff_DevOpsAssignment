function AddRow(){
    var employee, asset, availability, renewal;
    employee = document.getElementById("employee").value;
    asset = document.getElementById("asset").value;
    availability =  document.getElementById("availability").value;
    renewal =  document.getElementById("renewal").value;

    var formData = new FormData();
    formData.set('employee',employee);
    formData.set('asset',asset);
    formData.set('availability',availability);
    formData.set('renewal',renewal);

    $.ajax({
    type: "POST",
    url: '/AssetTableCreate',
    data: formData,
    dataType: 'json',
    contentType: false,
    processData: false
}).done(function(data, textStatus, xhr) {
    window.location.href =  "/AssetTable";
}).fail(function( jqXHR, textStatus ) {
    console.log(textStatus)
});

}
