#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>

std::vector<int> split_to_int(std::string str, char delimiter) {
	std::istringstream ss(str);
	std::string buffer;

	std::vector<int> result;

	while (std::getline(ss, buffer, delimiter)) {
		result.push_back(std::stoi(buffer));
	}

	return result;
}

void solve() {

	int n;
	std::cin >> n;
	std::cin.ignore();

	int arr[5] = { 0 };
	

	while (n--) {
		std::string input;
		std::getline(std::cin, input);
		std::vector<int> point = split_to_int(input, ' ');
		
		if (!point[0] || !point[1]) {
			arr[4]++;
		} else {
			if (point[0] > 0) {
				if (point[1] > 0) {
					arr[0]++;
				}
				else {
					arr[3]++;
				}
			}
			else {
				if (point[1] > 0) {
					arr[1]++;
				}
				else {
					arr[2]++;
				}
			}
		}
	}

	std::cout << "Q1: " << arr[0] << '\n' << "Q2: " << arr[1] << '\n'
			  << "Q3: " << arr[2] << '\n' << "Q4: " << arr[3] << '\n'
		<< "AXIS: " << arr[4] << '\n';
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}