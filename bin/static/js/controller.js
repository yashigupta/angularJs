var app = angular.module('testApp', []);
app.controller('userController', function($scope, $http, $location,$window) {
	$scope.submitForm = function(){
		var url = $location.absUrl() + "post";
		
		var config = {
                headers : {
                    'Accept': 'text/plain'
                }
        }
		var data = {
            username: $scope.username,
            password: $scope.password
        };
		
		$http.post(url, data, config).then(function (response) {
			if(response.data=="Successful!")
			{
				$scope.postResultMessage = true;
				console.log($scope.username);
				myFunction();
				var s=document.getElementById("name");
				s.value="Hi"; 
			}
			else
			{
				$window.alert("Check username and password");
				$scope.postResultMessage = false;
			}
			}, function error(response) {
			$scope.postResultMessage = "Error with status: " +  response.statusText;
		});
	}
});


function myFunction() {
	
	console.log("myFunction");
	
	document.getElementById("form").style="display:none";
	document.getElementById("img").style="display:none";
	
	
}
app.controller('getcontroller', function($scope, $http, $location) {
	var s,r;
	$scope.getfunction = function(){
		console.log("getalllg")
		var url = $location.absUrl() + "getalllg";
		
		$http.get(url).then(function (response) {
			 s=response.data;
			 $scope.response =s;
		}, function error(response) {
			$scope.postResultMessage = "Error with status: " +  response.statusText;
		});
		
	}
	$scope.getSaved = function(){
		console.log("getcustomer")
		var url = $location.absUrl() + "getSaved";
		var r;
		var config = {
                headers : {
                    'Accept': '*/*'
                }
        }
		var data =$scope.username;
		
		$http.post(url, data, config).then(function (response) {
			console.log("hello");
			r=response.data;
			$scope.response1 =r;
		}, function error(response) {
			$scope.postResultMessage = "Error with status: " +  response.statusText;
		});
		
	}
	$scope.toggleSelection = function(item){
		var my_date=new Date();
		var month=parseInt(my_date.getMonth())+1;
		if(month.length()==1)
			{
				month='0'+month;
			}
		var hrs=my_date.getHours();
		if(hrs.length()==1)
		{
			hrs='0'+hrs;
		}
		var mins=my_date.getMinutes();
		if(mins.length()==1)
		{
			mins='0'+mins;
		}
		var String=my_date.getDate()+"-"+month+"-"+my_date.getFullYear();
		var str=hrs+":"+mins;
		console.log(month);
		console.log($scope.username);
		console.log(item.stockName);
		console.log(String);
		console.log(str);
		console.log(item.nsePrice);
		console.log(item.bsePrice);
		console.log(item.profit);
var url = $location.absUrl() + "saveData";
		
		var config = {
                headers : {
                    'Accept': 'text/plain'
                }
        }
		var data = {
            stockName: item.stockName,
            date: String,
            time: str,
            userId: $scope.username,
            nsePrice: item.nsePrice,
            bsePrice: item.bsePrice,
            profit: item.profit
        };
		
		$http.post(url, data, config).then(function (response) {
			if(response.data=="successful")
			{
				console.log("inserted");
			}
			else
			{
				console.log("failed")
			}
			}, function error(response) {
			$scope.postResultMessage = "Error with status: " +  response.statusText;
		});
	}
});