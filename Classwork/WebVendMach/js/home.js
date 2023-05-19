
// Globals
let moneyEntered = 0.00;
var cellItemForSale = new Array();
var contentRows = $("#contentRows");

$(document).ready(function () {

   loadTableCells();
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
    updateMessage("Change Returned");
    }


function updateTotal() {
    $("#totalMoney").val("$" + moneyEntered.toFixed(2));
    $("#changeDisplay").val("");
}

function updateMessage(msg){
	$("#messageDisplay").val( msg);   
}

function addDollar() {
	moneyEntered = moneyEntered + 1.00;
	updateTotal();
    updateMessage("Added $1.00");
}

function addQuarter() {
	moneyEntered += 0.25;
	updateTotal();
    updateMessage("Added $0.25");
}

function addDime() {
	moneyEntered += 0.10;
	updateTotal();
    updateMessage("Added $0.10");
}

function addNickel() {
	moneyEntered += 0.05;
	updateTotal();
    updateMessage("Added $0.05");
}

  // clear Contact table prior to loading/updating data
function clearTableCells() {
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
  
  // build a td cell string with a button in it.  
  function makeButton(buttonId){
     var cellbutton="<td><button  id=\"itemCandyButton"+buttonId+"\" ";
     cellbutton+="style=\"border: none;background: #daed0ed4;\""
     cellbutton+= ">" + cellItemForSale[buttonId] + "</button></td>";
    return cellbutton;
  }

function makeButtonCallbacks()
{
  // for each item from REST call make a button on click.
  $.each(cellItemForSale, function(index, cellText) {
		$("#itemCandyButton" + index).on('click', function() {
      var temp=cellItemForSale[index];
      var textSplit=temp.split('<')
			$("#itemSelected").val(textSplit[0]);
		});
	})   
}



  function loadCandySuccess(candyItemArray) {
    $.each(candyItemArray, function (index, candyItem) {
      //retrieve and store the values
      var item = candyItem.id   
           +"<br />     "+candyItem.name
           +"<br />     $"+candyItem.price.toFixed(2)
           +"<br />    Quantity Left: "+candyItem.quantity;               
     cellItemForSale.push(item);
    });
    var item="Sold Out!";
    for(let i = 9;i>cellItemForSale.length;i--)
    {
      cellItemForSale.push(item);
    }
        // build a table using the retrieved values
        var row = "<tr id=\'abc1\'>";
        row += makeButton(0) ;
        row += makeButton(1) ;
        row += makeButton(2) ;
        row += "</tr>";
        contentRows.append(row);
         row = "<tr id=\'abc2\'>";
         row += makeButton(3) ;
         row += makeButton(4) ;
         row += makeButton(5) ;
        row += "</tr>";
        contentRows.append(row);
         row = "<tr id=\'abc3\'>";
         row += makeButton(6) ;
         row += makeButton(7) ;
         row += makeButton(8) ;
       row += "</tr>";
       contentRows.append(row);
       makeButtonCallbacks();
  }
  function loadCandyError() {
    updateMessage("Error retrieving Items");
  }



  // load item from REST API service to an HTML table
function loadTableCells() {
    clearTableCells();
    // retrieve and display existing data using GET request
    $.ajax({
      type: "GET",
      url: "http://vending.us-east-1.elasticbeanstalk.com/items",
      success:loadCandySuccess,
        // create error function to display API error messages
      error:loadCandyError,
    });
  }

  function goodPurchase(change){
    updateChangeBox(change.quarters,change.dimes,change.nickels,change.pennies);
    updateMessage("Purchase Successful");
   $("#totalMoney").val("$0.00")
    moneyEntered = 0.00;
    loadTableCells(); 

  }
  function failedPurchase(err)
  {
	let msg = $.parseJSON(err.responseText);
	updateMessage(msg.message);
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
