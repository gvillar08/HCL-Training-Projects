var myData = [
    {"ID" : 0, "Quantity" : 3, "Item" : "Toilet", "Units" : "Each", "Cost" : 125},
    {"ID" : 1, "Quantity" : 1, "Item" : "Printer", "Units" : "Each", "Cost" : 250},
    {"ID" : 2, "Quantity" : 45, "Item" : "Steel Tubing", "Units" : "Feet", "Cost" : 5.87}
]

var currentID = myData.length;

// localstorage allows us to persist key value pairs in a way that would survive page refreshes, navigation, and user closing/reopening browser.
// localstorage has limits to the size of each object stored.   

localStorage.setItem("myData", "test")

var myDataTest = localStorage.getItem("myData")

function FinanceTable() {    

    // EXTRACT VALUE FOR HTML HEADER. 
    var col = [];
    for (var i = 0; i < myData.length; i++) {
        for (var key in myData[i]) {
            if (col.indexOf(key) === -1) {
                col.push(key);
            }
        }
    }

    col.push("Edit");
    col.push("Delete");

    // CREATE DYNAMIC TABLE.
    var table = document.createElement("table");

    // CREATE HTML TABLE HEADER ROW USING THE EXTRACTED HEADERS ABOVE.
    var tr = table.insertRow(-1);                   // TABLE ROW.

    for (var i = 0; i < col.length; i++) {
        var th = document.createElement("th");      // TABLE HEADER.
        th.innerHTML = col[i];
        tr.appendChild(th);
    }

    // ADD JSON DATA TO THE TABLE AS ROWS.
    for (var i = 0; i < myData.length; i++) {

        tr = table.insertRow(-1);

        for (var j = 0; j < col.length-2; j++) {
            tr.insertCell(-1).innerHTML = myData[i][col[j]];
        }
        tr.insertCell(-1).innerHTML = '<a class="btn btn-warning" onclick="EditItem('+myData[i].ID+')" role="button">Edit</a>';
        tr.insertCell(-1).innerHTML = '<a class="btn btn-danger" onclick="DeleteItem('+myData[i].ID+')" role="button">Delete</a>';
    }

    // FINALLY ADD THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER.
    var divContainer = document.getElementById("showFinance");
    divContainer.innerHTML = "";
    document.getElementById("showFinance").appendChild(table);
}

//For editing
function EditItem(ID) {
    var divContainer = document.getElementById("editData");
    var table = document.createElement("table");

    //Print the form for editing
    tr = table.insertRow(-1);
    tr.insertCell(-1).innerHTML = ('<h3>Edit Item</h3>');
    tr.insertCell(-1).innerHTML = ('<h3>ID: '+ID+'</h3>');
    tr = table.insertRow(-1);    
    tr.insertCell(-1).innerHTML = ('<label>Quantity</label>');
    tr.insertCell(-1).innerHTML = ('<input type="number" id="quantityInput">');
    tr = table.insertRow(-1);    
    tr.insertCell(-1).innerHTML = ('<label>Item Name</label>');
    tr.insertCell(-1).innerHTML = ('<input type="text" id="itemInput">');
    tr = table.insertRow(-1);    
    tr.insertCell(-1).innerHTML = ('<label>Unit of Measure</label>');
    tr.insertCell(-1).innerHTML = ('<input type="text" id="unitsInput">');
    tr = table.insertRow(-1);    
    tr.insertCell(-1).innerHTML = ('<label>Unit Cost</label>');
    tr.insertCell(-1).innerHTML = ('<input type="number" id="costInput">');
    tr = table.insertRow(-1);    
    tr.insertCell(-1).innerHTML = ('<a class="btn btn-success" onclick="AppendEdit('+ID+')" role="button">Submit</a>');

    divContainer.innerHTML = "";
    divContainer.appendChild(table);

    //Fill the form with the respective data from the table
    document.getElementById("quantityInput").value = myData[ID].Quantity;
    document.getElementById("itemInput").value = myData[ID].Item;
    document.getElementById("unitsInput").value = myData[ID].Units;
    document.getElementById("costInput").value = myData[ID].Cost;
}

//For appending the edit once it is submitted
function AppendEdit(ID) {
    var quantity = document.getElementById("quantityInput").value;
    var item = document.getElementById("itemInput").value;
    var units = document.getElementById("unitsInput").value;
    var cost = document.getElementById("costInput").value;

    //If the user confirms their submission, append the changes, remove the editing form, and print the updated table
    if(confirm("Ready to commit your changes?")==true) {
        myData[ID] = ({"ID": ID, "Quantity" : quantity, "Item" : item, "Units" : units, "Cost" : cost});
        document.getElementById("editData").innerHTML = "";
        FinanceTable();
    }
}

//For adding to the table
function NewItem() {
    var quantity = document.getElementById("quantityInput").value;
    var item = document.getElementById("itemInput").value;
    var units = document.getElementById("unitsInput").value;
    var cost = document.getElementById("costInput").value;

    myData.push({"ID": currentID, "Quantity" : quantity, "Item" : item, "Units" : units, "Cost" : cost});
    currentID++;

    document.getElementById("quantityInput").value = "";
    document.getElementById("itemInput").value = "";
    document.getElementById("unitsInput").value = "";
    document.getElementById("costInput").value = "";

    FinanceTable();
}

//for removing a row item from the table
function DeleteItem(ID) {
    if(confirm("Are you sure?")==true)
    {
        for(var i = 0; i < myData.length; i++) { 
            if(myData[i].ID === ID) { 
                myData.splice(i, 1); 
            }
        }
        FinanceTable();
    }
}