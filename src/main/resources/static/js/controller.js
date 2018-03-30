var app = angular.module('testApp', []);
app.controller('userController', function($scope, $http, $location,$window) {
	$scope.submitForm = function(){
		alert("In controller");
		//var url = $location.absUrl() + "postuser";
		var url="http://localhost:8089/postuser";
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
				var usr=$scope.username;
				/*document.getElementById("name").innerHTML="Hi, "+data.username;*/
				
				window.location.replace("localhost:8089/main.html"+'#'+usr);
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
app.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;

            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);
app.service('fileUpload', ['$http', function ($http) {
    this.uploadFileToUrl = function(file, uploadUrl){
        var fd = new FormData();
        fd.append('file', file);
        $http.post(uploadUrl, fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })
        .success(function(){
        })
        .error(function(){
        });
    }
}]);
app.controller('getcontroller', ['$scope', 'fileUpload', function($scope, fileUpload){
    
    $scope.uploadFile = function(){
        var file = $scope.myFile;
        console.log('file is ');
        console.dir(file);
        /*var uploadUrl = "/fileUpload";
        fileUpload.uploadFileToUrl(file, uploadUrl);*/
    };  
}]);
app.controller('getcontroller', function($scope, $http, $location) {
	var s, r;
	$scope.getfunction = function() {
		console.log("getalllg")
		var url = $location.absUrl() + "getalllg";

		$http.get(url).then(
		
				function(response) {
					s = response.data;
					$scope.response = s;
				},
				function error(response) {
					$scope.postResultMessage = "Error with status: "
							+ response.statusText;
				});

	}
	$scope.getSaved = function() {
		console.log("getcustomer")
		var url = $location.absUrl() + "getSaved";
		var r;
		var config = {
			headers : {
				'Accept' : '*'
			}
		}
		var data = $scope.username;

		$http.post(url, data, config).then(
				function(response) {
					console.log("hello");
					r = response.data;
					$scope.response1 = r;
				},
				function error(response) {
					$scope.postResultMessage = "Error with status: "
							+ response.statusText;
				});

	}
});
/*var app = angular.module('testApp', []);
app.controller('userController', function($scope, $http, $location, $window) {
	$scope.submitForm = function() {
		var url = $location.absUrl() + "post";

		var config = {
			headers : {
				'Accept' : 'text/plain'
			}
		}
		var data = {
			username : $scope.username,
			password : $scope.password
		};

		$http.post(url, data, config).then(
				function(response) {
					if (response.data == "Successful!") {
						$scope.postResultMessage = true;
						console.log($scope.username);
						myFunction();
						document.getElementById("name").innerHTML="Hi, "+data.username;
					} else {
						$window.alert("Check username and password");
						$scope.postResultMessage = false;
					}
				},
				function error(response) {
					$scope.postResultMessage = "Error with status: "
							+ response.statusText;
				});
	}
	$scope.logout=function()
	{
		console.log("logout");
		
		document.getElementById("form").style="display:block";
		document.getElementById("img").style="display:block";
		document.getElementById("logname").style="display:none";
		$scope.postResultMessage = true;
		$scope.username="";
		$scope.password="";
		$scope.showme=false;
		$scope.showme1=false;
	}
});

function myFunction() {

	console.log("myFunction");

	document.getElementById("form").style = "display:none";
	document.getElementById("img").style = "display:none";
	document.getElementById("logname").style="display:block";

}*/
/*	$scope.toggleSelection = function(item) {
		var my_date = new Date();
		var mo = parseInt(my_date.getMonth()) + 1;
		var month=mo.toString();
		if (month.length == 1) {
			month = '0' + month;
		}
		var h=my_date.getHours();
		var hrs=h.toString();
		if(hrs.length==1)
		{
			hrs='0'+hrs;
		}
		var m=my_date.getMinutes();
		var mins=m.toString();
		if(mins.length==1)
		{
			mins='0'+mins;
		}
		var String = my_date.getDate() + "-" + month + "-"+ my_date.getFullYear();
		var str = hrs + ":" + mins;
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
				'Accept' : 'text/plain'
			}
		}
		var data = {
			stockName : item.stockName,
			date : String,
			time : str,
			userId : $scope.username,
			nsePrice : item.nsePrice,
			bsePrice : item.bsePrice,
			profit : item.profit
		};

		$http.post(url, data, config).then(
				function(response) {
					if (response.data == "successful") {
						console.log("inserted");
					} else {
						console.log("failed")
					}
				},
				function error(response) {
					$scope.postResultMessage = "Error with status: "
							+ response.statusText;
				});
	}*/
