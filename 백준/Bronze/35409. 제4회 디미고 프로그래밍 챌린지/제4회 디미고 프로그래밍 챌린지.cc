#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>
#include <unordered_map>


bool isInTime(std::string timeRange, int timeMin) {
	std::string startTime = timeRange.substr(0, 5);
	std::string endTime = timeRange.substr(6, 5);

	int startSec = std::stoi(startTime.substr(0, 2)) * 60 + std::stoi(startTime.substr(3, 2));
	int endSec = std::stoi(endTime.substr(0, 2)) * 60 + std::stoi(endTime.substr(3, 2));

	return (startSec <= timeMin && timeMin <= endSec);
}

void solve() {
	
	std::string times[] = {
		"06:30-09:00"
		, "09:50-10:00"
		, "10:50-11:00"
		, "11:50-12:00"
		, "12:50-13:50"
		, "14:40-14:50"
		, "15:40-15:50"
		, "16:40-22:50"
	};

	int hour, minute;
	std::cin >> hour >> minute;

	int timeMin = hour * 60 + minute;

	for (std::string s : times) {
		if (isInTime(s, timeMin)) {
			std::cout << "Yes";
			return;
		}
	}

	std::cout << "No";
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}