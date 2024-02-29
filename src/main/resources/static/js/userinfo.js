function editRow(obj) {
    var trp = obj.parentNode.parentNode;
    var tdobj = trp.cells;
    tdobj[0].innerHTML ="<input type='text' value='" + tdobj[0].innerHTML + "' size='8'/>";
    tdobj[1].innerHTML ="<input type='text' value='" + tdobj[1].innerHTML + "' size='8'/>";
    tdobj[2].innerHTML ="<input type='text' value='" + tdobj[2].innerHTML + "' size='8'/>";
    tdobj[3].innerHTML ="<input type='text' value='" + tdobj[3].innerHTML + "' size='8'/>";
    tdobj[4].innerHTML ="<input type='text' value='" + tdobj[4].innerHTML + "' size='8'/>";
    tdobj[5].innerHTML ="<input type='text' value='" + tdobj[5].innerHTML + "' size='8'/>";
    tdobj[6].innerHTML ="<input type='text' value='" + tdobj[6].innerHTML + "' size='8'/>";
    tdobj[7].innerHTML = "<div class='edit'>Confirm</div>";
    tdobj[7].childNodes[0].onclick = function() {
        tdobj[0].innerHTML = tdobj[0].childNodes[0].value;
        tdobj[1].innerHTML = tdobj[1].childNodes[0].value;
        tdobj[2].innerHTML = tdobj[2].childNodes[0].value;
        tdobj[3].innerHTML = tdobj[3].childNodes[0].value;
        tdobj[4].innerHTML = tdobj[4].childNodes[0].value;
        tdobj[5].innerHTML = tdobj[5].childNodes[0].value;
        tdobj[6].innerHTML = tdobj[6].childNodes[0].value;
        tdobj[7].innerHTML = "<div onclick='editRow(this)' class='edit'>Edit</div>";
    }


}