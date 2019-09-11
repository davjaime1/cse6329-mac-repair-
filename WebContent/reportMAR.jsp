<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script
 src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {

		var list1 = document.getElementById('firstList');

		list1.options[0] = new Option('--Select--', '');
		list1.options[1] = new Option('MultiPurpose Room', 'MR');
		list1.options[2] = new Option('Indoor BasketBall Court', 'IBBC');
		list1.options[3] = new Option('Indoor VolleyBall Outdoor', 'IVBC');
		list1.options[4] = new Option('Indoor Soccer Gymnasium', 'SCG');
		list1.options[5] = new Option('Racquet Ball Court', 'RBC');
		list1.options[6] = new Option('Badminton Court', 'BMC');
		list1.options[7] = new Option('Tabel Tenis ', 'TT');
		list1.options[8] = new Option('Conference Rooms', 'CR');
		list1.options[9] = new Option('Outdoor  VolleyBall Court', 'OVBC');
		list1.options[10] = new Option('Outdoor Basketball Court', 'OBBC');
	});
	function getFaculty() {

		var list1 = document.getElementById('firstList');
		var list2 = document.getElementById("secondList");
		var list1SelectedValue = list1.options[list1.selectedIndex].value;

		if (list1SelectedValue == 'MR') {

			list2.options.length = 0;
			list2.options[0] = new Option('--Select--', '');
			list2.options[1] = new Option('MR1', 'MR1');
			list2.options[2] = new Option('MR2', 'MR2');
			list2.options[3] = new Option('MR3', 'MR3');

		} else if (list1SelectedValue == 'IBBC') {

			list2.options.length = 0;
			list2.options[0] = new Option('--Select--', '');
			list2.options[1] = new Option('IBBC 1', 'IBBC 1');
			list2.options[2] = new Option('IBBC 2', 'IBBC 2');
			list2.options[3] = new Option('IBBC 3', 'IBBC 3');
			list2.options[4] = new Option('IBBC 4', 'IBBC 4');
			list2.options[5] = new Option('IBBC 5', 'IBBC 5');

		} else if (list1SelectedValue == 'IVBC') {

			list2.options.length = 0;
			list2.options[0] = new Option('--Select--', '');
			list2.options[1] = new Option('IBBC 1', 'IBBC 1');
			list2.options[2] = new Option('IBBC 2', 'IBBC 2');
			list2.options[3] = new Option('IBBC 3', 'IBBC 3');
			list2.options[4] = new Option('IBBC 4', 'IBBC 4');
			list2.options[5] = new Option('IBBC 5', 'IBBC 5');
			list2.options[6] = new Option('IBBC 6', 'IBBC 6');
			list2.options[7] = new Option('IBBC 7', 'IBBC 7');
			list2.options[8] = new Option('IBBC 8', 'IBBC 8');
			list2.options[9] = new Option('IBBC 9', 'IBBC 9');
		} else if (list1SelectedValue == 'SCG') {

			list2.options.length = 0;
			list2.options[0] = new Option('--Select--', '');
			list2.options[0] = new Option('SCG', 'SCG');
		} else if (list1SelectedValue == 'RBC') {

			list2.options.length = 0;
			list2.options[0] = new Option('--Select--', '');
			list2.options[1] = new Option('RBC 1', 'RBC 1');
			list2.options[2] = new Option('RBC 2', 'RBC 2');
			list2.options[3] = new Option('RBC 3', 'RBC 3');
			list2.options[4] = new Option('RBC 4', 'RBC 4');
			list2.options[5] = new Option('RBC 5', 'RBC 5');
		} else if (list1SelectedValue == 'BMC') {

			list2.options.length = 0;
			list2.options[0] = new Option('--Select--', '');
			list2.options[1] = new Option('BMC 1', 'BMC 1');
			list2.options[2] = new Option('BMC 2', 'BMC 2');
			list2.options[3] = new Option('BMC 3', 'BMC 3');
			list2.options[4] = new Option('BMC 4', 'BMC 4');
			list2.options[5] = new Option('BMC 5', 'BMC 5');
			list2.options[6] = new Option('BMC 6', 'BMC 6');
			list2.options[7] = new Option('BMC 7', 'BMC 7');
			list2.options[8] = new Option('BMC 8', 'BMC 8');
			list2.options[9] = new Option('BMC 9', 'BMC 9');
			list2.options[10] = new Option('BMC 10', 'BMC 10');
		} else if (list1SelectedValue == 'TT') {

			list2.options.length = 0;
			list2.options[0] = new Option('--Select--', '');
			list2.options[1] = new Option('TT1', 'TT1');
		} else if (list1SelectedValue == 'CR') {

			list2.options.length = 0;
			list2.options[0] = new Option('--Select--', '');
			list2.options[1] = new Option('CR 1', 'CR 1');
			list2.options[2] = new Option('CR 2', 'CR 2');
			list2.options[3] = new Option('CR 3', 'CR 3');
			list2.options[4] = new Option('CR 4', 'CR 4');
			list2.options[5] = new Option('CR 5', 'CR 5');
		} else if (list1SelectedValue == 'OVBC') {

			list2.options.length = 0;
			list2.options[0] = new Option('--Select--', '');
			list2.options[1] = new Option('OVBC 1', 'OVBC 1');
			list2.options[2] = new Option('OVBC 2', 'OVBC 2');
		} else if (list1SelectedValue == 'OBBC') {

			list2.options.length = 0;
			list2.options[0] = new Option('--Select--', '');
			list2.options[1] = new Option('OBBC 1', 'OBBC 1');
			list2.options[2] = new Option('OBBC 2', 'OBBC 2');
		}

	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create MAR</title>
</head>
<body>
    <header>
        <h2>Create MAR</h2>
    </header>
    
    <div class="col-md-4">  
    
    <form action="/mac_repair/CreateMarController?action=listFacilitiesNameOnly" method="get">
        <table border="1" class="myTable"> 
                <tr class="myTableRow"> 
                    <th class="myTableHead" style="width: 20px; ">Select Facility</th> 
                    <th class="myTableHead" style="padding-right: 20px; text-align: left">Facility Name</th>
                </tr>
    
            <c:forEach items="${FACILITIES}" var="item" varStatus="status">
                <tr class="myTableRow">
                    <td class="myTableCell" style="width: 20px; text-align: center"><input type="radio" id="radioFacility${status.count}" name="radioFacility" value="${status.count}"></td>  
                    <td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.name}" /></td>
                </tr>
            </c:forEach>
        </table>
        
        
    <h4>Urgency</h4>
   <select name="thirdList" id="thirdList">
    <option default>---Select---</option>
    <option>Unusable</option>
    <option>Major</option>
    <option>Medium</option>
    <option>Minor</option>
   </select>

   <h4>Description</h4>
   <input type="text" id="description" name="description" size="500px">

   <input type="submit" id="submit" value="submit">    

  </form>
 </div>
</body>
</html>

