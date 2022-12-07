const app = angular.module("myApp", []);
app.controller("myCtrl", ($scope, $http) => {
    $http.get("/demo-java6-b7/api/authorities").then(resp => {
        $scope.db = resp.data;
    });
    
    $scope.indexOf  = (username, role) => {
        return $scope.db.authorities
            .findIndex(item => item.account.username == username && item.role.id == role);
    }

    $scope.update = (username, role) => {
        var index = $scope.indexOf(username, role);
        if (index >= 0) {
            var id = $scope.db.authorities[index].id;
            $http.delete("/demo-java6-b7/api/authorities/" + id).then(resp => {
                $scope.db.authorities.splice(index, 1);
            });
        } else {
            var authority = {
                account: {
                    username: username
                },
                role: {
                    id: role
                }
            };
            $http.post("/demo-java6-b7/api/authorities", authority).then(resp => {
                $scope.db.authorities.push(resp.data);
            })
        }
    }
});