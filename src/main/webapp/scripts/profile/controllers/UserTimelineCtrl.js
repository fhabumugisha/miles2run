'use strict';

angular.module('milestogo')
    .controller('UserTimelineCtrl', function ($scope, activeGoal, $location, $http, TimelineService, userProfile) {
        var currentPage = 1;
        TimelineService.userGoalTimeline(userProfile.username, activeGoal.id, currentPage).success(function (data, status, headers, config) {
            $scope.activities = data.timeline;
            $scope.currentPage = currentPage;
            $scope.totalItems = data.totalItems;
        }).error(function (data, status, headers, config) {
            toastr.error("Unable to fetch home timeline. Please try after sometime.");
        });

        $scope.pageChanged = function () {
            console.log('Page changed to: ' + $scope.currentPage);
            TimelineService.userGoalTimeline(userProfile.username, activeGoal.id, $scope.currentPage).success(function (data, status, headers, config) {
                $scope.activities = data.timeline;
                $scope.totalItems = data.totalItems;
            }).error(function (data, status, headers, config) {
                toastr.error("Unable to fetch home timeline. Please try after sometime.");
            });
        };

    });
