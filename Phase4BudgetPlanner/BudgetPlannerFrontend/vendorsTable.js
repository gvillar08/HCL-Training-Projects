var myData = [
    {"ID" : 0, "Client" : "Microsoft", "Project" : "Apollo Project", "Manager" : "Mary", "Cost" : 1000},
    {"ID" : 1, "Client" : "Intel", "Project" : "Hermes Project", "Manager" : "Bob", "Cost" : 10000},
    {"ID" : 2, "Client" : "Apple", "Project" : "Zeus Project", "Manager" : "Jane", "Cost" : 100000}
]

var currentID = myData.length;

// localstorage allows us to persist key value pairs in a way that would survive page refreshes, navigation, and user closing/reopening browser.
// localstorage has limits to the size of each object stored.   

localStorage.setItem("myData", "test")

var myDataTest = localStorage.getItem("myData")

function VendorTable() {    

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
        tr.insertCell(-1).innerHTML = '<a class="btn btn-warning" onclick="EditVendor('+myData[i].ID+')" role="button">Edit</a>';
        tr.insertCell(-1).innerHTML = '<a class="btn btn-danger" onclick="DeleteVendor('+myData[i].ID+')" role="button">Delete</a>';
    }

    // FINALLY ADD THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER.
    var divContainer = document.getElementById("showVendors");
    divContainer.innerHTML = "";
    divContainer.appendChild(table);
}

//For editing
function EditVendor(ID) {
    var divContainer = document.getElementById("editData");
    var table = document.createElement("table");

    //Print the form for editing
    tr = table.insertRow(-1);
    tr.insertCell(-1).innerHTML = ('<h3>Edit Vendor</h3>');
    tr.insertCell(-1).innerHTML = ('<h3>ID: '+ID+'</h3>');
    tr = table.insertRow(-1);    
    tr.insertCell(-1).innerHTML = ('<label>Client Name</label>');
    tr.insertCell(-1).innerHTML = ('<input type="text" id="clientInput">');
    tr = table.insertRow(-1);    
    tr.insertCell(-1).innerHTML = ('<label>Project Name</label>');
    tr.insertCell(-1).innerHTML = ('<input type="text" id="projectInput">');
    tr = table.insertRow(-1);    
    tr.insertCell(-1).innerHTML = ('<label>Project Manager</label>');
    tr.insertCell(-1).innerHTML = ('<input type="text" id="managerInput">');
    tr = table.insertRow(-1);    
    tr.insertCell(-1).innerHTML = ('<label>Project Cost</label>');
    tr.insertCell(-1).innerHTML = ('<input type="number" id="costInput">');
    tr = table.insertRow(-1);    
    tr.insertCell(-1).innerHTML = ('<a class="btn btn-success" onclick="AppendEdit('+ID+')" role="button">Submit</a>');

    divContainer.innerHTML = "";
    divContainer.appendChild(table);

    //Fill the form with the respective data from the table
    document.getElementById("clientInput").value = myData[ID].Client;
    document.getElementById("projectInput").value = myData[ID].Project;
    document.getElementById("managerInput").value = myData[ID].Manager;
    document.getElementById("costInput").value = myData[ID].Cost;
}

//For appending the edit once it is submitted
function AppendEdit(ID) {
    var clientName = document.getElementById("clientInput").value;
    var projectName = document.getElementById("projectInput").value;
    var projectManager = document.getElementById("managerInput").value;
    var projectCost = document.getElementById("costInput").value;

    //If the user confirms their submission, append the changes, remove the editing form, and print the updated table
    if(confirm("Ready to commit your changes?")==true) {
        myData[ID] = ({"ID": ID, "Client" : clientName, "Project" : projectName, "Manager" : projectManager, "Cost" : projectCost});
        document.getElementById("editData").innerHTML = "";
        VendorTable();
    }
}

//For adding to the table
function NewVendor() {
    var clientName = document.getElementById("clientNameInput").value;
    var projectName = document.getElementById("projectNameInput").value;
    var projectManager = document.getElementById("projectManagerInput").value;
    var projectCost = document.getElementById("projectCostInput").value;

    myData.push({"ID": currentID, "Client" : clientName, "Project" : projectName, "Manager" : projectManager, "Cost" : projectCost});
    currentID++;

    document.getElementById("clientNameInput").value = "";
    document.getElementById("projectNameInput").value = "";
    document.getElementById("projectManagerInput").value = "";
    document.getElementById("projectCostInput").value = "";

    VendorTable();
}

//for removing a row item from the table
function DeleteVendor(ID) {
    if(confirm("Are you sure?")==true)
    {
        for(var i = 0; i < myData.length; i++) { 
            if(myData[i].ID === ID) { 
                myData.splice(i, 1); 
            }
        }
        VendorTable();
    }
}