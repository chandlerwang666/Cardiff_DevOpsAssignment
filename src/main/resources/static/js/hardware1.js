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

function myfunction5(){
    var department, softwareLicense, price, expiryDate;
    department = document.getElementById("department").value;
    softwareLicense = document.getElementById("licence").value;
    price =  document.getElementById("price").value;
    expiryDate =  document.getElementById("date").value;

    console.log(department);

}


function editRow(obj) {
    var trp = obj.parentNode.parentNode;
    var tdobj = trp.cells;
    tdobj[0].innerHTML ="<input type='text' value='" + tdobj[0].innerHTML + "' size='8'/>";
    tdobj[1].innerHTML ="<input type='text' value='" + tdobj[1].innerHTML + "' size='8'/>";
    tdobj[2].innerHTML ="<input type='text' value='" + tdobj[2].innerHTML + "' size='8'/>";
    tdobj[3].innerHTML ="<input type='text' value='" + tdobj[3].innerHTML + "' size='8'/>";
    tdobj[4].innerHTML = "<div class='edit'>Confirm</div>";
    tdobj[4].childNodes[0].onclick = function() {
        tdobj[0].innerHTML = tdobj[0].childNodes[0].value;
        tdobj[1].innerHTML = tdobj[1].childNodes[0].value;
        tdobj[2].innerHTML = tdobj[2].childNodes[0].value;
        tdobj[3].innerHTML = tdobj[3].childNodes[0].value;
        console.log(tdobj[0].innerHTML)

        tdobj[4].innerHTML = "<div onclick='editRow(this)' class='edit'>Edit</div>";
    }


}
