
// Globals
let moneyEntered = 0.00;
var cellItemForSale = new Array();
var contentRows = $("#contentRows");

$(document).ready(function () {
   // addContact();
   //  updateContact();
   loadContacts();
   $("#addDollar").on('click', addDollar);
   $("#addQuarter").on('click', addQuarter);
   $("#addDime").on('click', addDime);
   $("#addNickel").on('click', addNickel);
   $("#changeReturn").on('click', returnChange);
   $("#makePurchase").on('click', purchaseItem);   
  });

function updateChangeBox(quarters,dimes,nickels,pennies){
    $("#changeDisplay").empty();
    $("#changeDisplay").val(quarters + ":quarters, "+dimes+":dimes, "+nickels+":nickels, "+pennies+":pennies");
}


function returnChange(){
    let temp=moneyEntered*100;
    let qrtrs=Math.floor(temp/25);
    temp-=qrtrs*25;
    let dms=Math.floor(temp/10);
    temp-=dms*10; 
    let nick=Math.floor(temp/5);
    temp-=nick*5;
    let pen=Math.floor(temp/1);
    updateChangeBox(qrtrs,dms,nick,pen);  
    moneyEntered = 0.00;
    $("#totalMoney").val("$0.00")
    updateMessage("Change Returned",false);
    }


function updateTotal() {
	let temp = $("#totalMoney");
    temp.empty();
	temp.val("$" + moneyEntered.toFixed(2));
    $("#changeDisplay").val("");
}

function updateMessage(msg,appendToMsg){
    let temp = $("#messageDisplay");
    if(appendToMsg==false)
    {
        temp.val("");
    }
	temp.val(temp.val() + msg);   
}

function addDollar() {
	moneyEntered = moneyEntered + 1.00;
	updateTotal();
    updateMessage("Added $1.00",false);
}

function addQuarter() {
	moneyEntered += 0.25;
	updateTotal();
    updateMessage("Added $0.25",false);
}

function addDime() {
	moneyEntered += 0.10;
	updateTotal();
    updateMessage("Added $0.10",false);
}

function addNickel() {
	moneyEntered += 0.05;
	updateTotal();
    updateMessage("Added $0.05",false);
}

  // clear Contact table prior to loading/updating data
function clearContactTable() {
    if( cellItemForSale.length>7){
        var tbl = document.getElementById("abc1"); 
        tbl.remove();
        tbl = document.getElementById("abc2"); 
        tbl.remove();
        tbl = document.getElementById("abc3"); 
        tbl.remove();
    }
    cellItemForSale.length=0;
  }
  
  // load contacts from REST API service to an HTML table
function loadContacts() {
    clearContactTable();
   
     // retrieve and display existing data using GET request
    $.ajax({
      type: "GET",
      url: "http://vending.us-east-1.elasticbeanstalk.com/items",
      success: function (contactArray) {
        $.each(contactArray, function (index, contact) {
          //retrieve and store the values
          var item = contact.id   
               +"<br />     "+contact.name
               +"<br />     $"+contact.price
               +"<br />    Quantity Left: "+contact.quantity;               
         cellItemForSale.push(item);
        });
            // build a table using the retrieved values
            var row = "<tr id=\'abc1\'>";
             row += "<td>" + cellItemForSale[0] + "</td>";
            row += "<td>" + cellItemForSale[1] + "</td>";
            row +="<td>" + cellItemForSale[2] + "</td>";
            row += "</tr>";
            contentRows.append(row);
             row = "<tr id=\'abc2\'>";
             row += "<td>" + cellItemForSale[3] + "</td>";
            row += "<td>" + cellItemForSale[4] + "</td>";
            row +="<td>" + cellItemForSale[5] + "</td>";
            row += "</tr>";
            contentRows.append(row);
             row = "<tr id=\'abc3\'>";
            row += "<td>" + cellItemForSale[6] + "</td>";
           row += "<td>" + cellItemForSale[7] + "</td>";
           row +="<td>" + cellItemForSale[8] + "</td>";
           row += "</tr>";
           contentRows.append(row);
      },
  
      // create error function to display API error messages
      error: function () {
        updateMessage("Error retrieving Items",false);
      },
    });
  }

  function goodPurchase(change){
    updateChangeBox(change.quarters,change.dimes,change.nickels,change.pennies);
    updateMessage("Purchase Successful",false);
   $("#totalMoney").val("$0.00")
    moneyEntered = 0.00;
    loadContacts(); 

  }
  function failedPurchase(err)
  {
	let msg = $.parseJSON(err.responseText);
	updateMessage(msg.message,false);
  }
  
  function purchaseItem() {
    $.ajax({
      type: "POST",
      url: "http://vending.us-east-1.elasticbeanstalk.com/money/"+moneyEntered.toFixed(2)+"/item/"+$("#itemSelected").val(),
      // returns change or an error msg.
      success: goodPurchase, 
      error: failedPurchase
    });
  }