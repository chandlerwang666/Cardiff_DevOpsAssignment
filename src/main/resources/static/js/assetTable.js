function myFunction0() {

    var input, filter, table, tr, td, i;
    input = document.getElementById("myInput0");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");


    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[0];
        if (td) {
            if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}

function myFunction1() {

    var input, filter, table, tr, td, i;
    input = document.getElementById("myInput1");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");


    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[1];
        if (td) {
            if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}

function myFunction2() {

    var input, filter, table, tr, td, i;
    input = document.getElementById("myInput2");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");


    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[2];
        if (td) {
            if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}

function myFunction3() {

    var input, filter, table, tr, td, i;
    input = document.getElementById("myInput3");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");


    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[3];
        if (td) {
            if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}

function myFunction4() {

    var input, filter, table, tr, td, i;
    input = document.getElementById("myInput4");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");


    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[4];
        if (td) {
            if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}



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
        tdobj[5].innerHTML = "<div onclick='editRow(this)' class='edit'>Edit</div>";
        var formData = new FormData();
        formData.set('serialNumber',tdobj[0].innerHTML);
        formData.set('employee',tdobj[1].innerHTML);
        formData.set('asset',tdobj[2].innerHTML);
        formData.set('availability',tdobj[3].innerHTML);
        formData.set('renewal',tdobj[4].innerHTML);
        $.ajax({
            type: "POST",
            url: '/AssetTableUpdate',
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
    formData.set('serialNumber',obj);
    $.ajax({
        type: "POST",
        url: '/AssetTableDelete',
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